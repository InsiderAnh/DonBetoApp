package io.github.InsiderAnh.DonBetoApp;

import javax.swing.JPanel;

import io.github.InsiderAnh.DonBetoApp.panels.ImagePanel;
import lombok.Getter;
import io.github.InsiderAnh.DonBetoApp.listeners.*;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

@Getter
public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JLabel lblContraseña;
	private final MainApp mainApp;
	private int boundX, boundY, boundWidth, boundHeight;
	private JPasswordField txtContra;
	private JLabel lblEntrar;
	private JButton btnSession;

	public LoginPanel(MainApp mainApp) {
		this.mainApp = mainApp;
		
		this.boundX = 200;
		this.boundY = 200;
		this.boundWidth = 550;
		this.boundHeight = 400;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        
		setBounds((boundWidth - screenWidth) / 2, (boundHeight - screenHeight) / 2, 550, 400);
		
		contentPane = new ImagePanel("/background.png");
	    contentPane.setLayout(null);
	    
	    JLabel lblUsuario = new JLabel("Usuario:");
	    lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblUsuario.setForeground(new Color(255, 255, 255));
	    lblUsuario.setBounds(127, 91, 99, 55);
	    contentPane.add(lblUsuario);
	    
	    txtUsuario = new JTextField();
	    txtUsuario.setBounds(261, 111, 116, 20);
	    contentPane.add(txtUsuario);
	    txtUsuario.setColumns(10);
	    
	    lblContraseña = new JLabel("Contraseña");
	    lblContraseña.setForeground(new Color(255, 255, 255));
	    lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblContraseña.setBounds(127, 152, 124, 55);
	    contentPane.add(lblContraseña);
	    
	    txtContra = new JPasswordField();
	    txtContra.setBounds(261, 173, 116, 20);
	    contentPane.add(txtContra);
	    
	    AuthButtonListener authButton = new AuthButtonListener(this);
	    
	    btnSession = new JButton("Iniciar sessión");
	    btnSession.setName("Login");
	    btnSession.addActionListener(authButton);
	    btnSession.setBounds(127, 242, 250, 23);
	    contentPane.add(btnSession);
	    
	    JButton btnRegistrar = new JButton("Registrar");
	    btnRegistrar.setName("Register");
	    btnRegistrar.addActionListener(authButton);
	    btnRegistrar.setBounds(127, 276, 250, 23);
	    contentPane.add(btnRegistrar);
	    
	    lblEntrar = new JLabel("Entrar a sistema");
	    lblEntrar.setForeground(Color.WHITE);
	    lblEntrar.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblEntrar.setBounds(170, 31, 220, 55);
	    contentPane.add(lblEntrar);
	}

	public int getBoundX() {
		return boundX;
	}

	public int getBoundY() {
		return boundY;
	}

	public int getBoundWidth() {
		return boundWidth;
	}

	public int getBoundHeight() {
		return boundHeight;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public JTextField getTxtContra() {
		return txtContra;
	}
	
	public MainApp getMainApp() {
		return mainApp;
	}
	
	public JPanel getJPanel() {
		return contentPane;
	}
}