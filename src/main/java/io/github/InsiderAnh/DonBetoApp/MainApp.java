package io.github.InsiderAnh.DonBetoApp;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import io.github.InsiderAnh.DonBetoApp.commands.CommandExecutor;
import io.github.InsiderAnh.DonBetoApp.managers.DBManager;
import io.github.InsiderAnh.DonBetoApp.panels.productos.AddProductoPanel;
import io.github.InsiderAnh.DonBetoApp.panels.productos.UpdateProductoPanel;
import io.github.InsiderAnh.DonBetoApp.settings.ConfigLoader;
import io.github.InsiderAnh.DonBetoApp.utils.ConsoleCommandCompleter;
import io.github.InsiderAnh.DonBetoApp.utils.log.BungeeLogger;
import jline.console.ConsoleReader;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class MainApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private static MainApp instance;
    private File localFolder;
    private final ConfigLoader configLoader;
    private final Logger logger;
    private final ConsoleReader consoleReader;
    private final CommandExecutor commandExecutor;
    private DBManager dbManager;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setTitle("Licoreria - Don Beto");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    @SneakyThrows
    public MainApp() {
		setTitle("Licoreria - Don Beto");
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        
		setBounds((550 - screenWidth) / 2, (400 - screenHeight) / 2, 550, 400);
		
        setLocationRelativeTo(null);
		setResizable(false);

		showLoginPanel();
		
		instance = this;
		
        this.localFolder = new File("./");
        this.consoleReader = new ConsoleReader();
        consoleReader.setExpandEvents(false);
        consoleReader.addCompleter(new ConsoleCommandCompleter(this));
        this.logger = new BungeeLogger("DonBetoApp", "latest.log", consoleReader);
        
        this.commandExecutor = new CommandExecutor();
        this.configLoader = new ConfigLoader(this).init();
        
        this.dbManager = new DBManager();
        this.dbManager.load();
	}
	
    public void showLoginPanel() {
        LoginPanel loginPanel = new LoginPanel(this);
        setCurrentPanel(loginPanel.getJPanel(), loginPanel.getBoundX(), loginPanel.getBoundY(), loginPanel.getBoundWidth(), loginPanel.getBoundHeight());
    }
    
    public void showRegisterPanel() {
    	RegisterPanel registerPanel = new RegisterPanel(this);
        setCurrentPanel(registerPanel.getJPanel(), registerPanel.getBoundX(), registerPanel.getBoundY(), registerPanel.getBoundWidth(), registerPanel.getBoundHeight());
    }

    public void showMainPanel() {
    	MainPanel mainPanel = new MainPanel();
        setCurrentPanel(mainPanel.getJPanel(), mainPanel.getBoundX(), mainPanel.getBoundY(), mainPanel.getBoundWidth(), mainPanel.getBoundHeight());
    }
    
    public void showAddProductoPanel() {
    	AddProductoPanel addProductoPanel = new AddProductoPanel();
        setCurrentPanel(addProductoPanel.getJPanel(), addProductoPanel.getBoundX(), addProductoPanel.getBoundY(), addProductoPanel.getBoundWidth(), addProductoPanel.getBoundHeight());
    }
    
    public void showUpdateProductoPanel() {
    	UpdateProductoPanel updateProductoPanel = new UpdateProductoPanel();
        setCurrentPanel(updateProductoPanel.getJPanel(), updateProductoPanel.getBoundX(), updateProductoPanel.getBoundY(), updateProductoPanel.getBoundWidth(), updateProductoPanel.getBoundHeight());
    }
    
    public void setCurrentPanel(JPanel panel, int x, int y, int width, int height) {
        
        getContentPane().removeAll();
        getContentPane().add(panel);
                
        setBounds(x, y, width, height);
        revalidate();
        repaint();
    }
    
    
    public static MainApp getInstance() {
    	return instance;
    }

	public File getLocalFolder() {
		return localFolder;
	}

	public Logger getLogger() {
		return logger;
	}
	
    public void stop() {
        this.logger.info("Saved tournaments data correctly.");
    }
    
}