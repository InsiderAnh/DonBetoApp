package io.github.InsiderAnh.DonBetoApp;

import javax.swing.JPanel;

import io.github.InsiderAnh.DonBetoApp.listeners.ButtonListener;
import io.github.InsiderAnh.DonBetoApp.panels.ImagePanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int boundX, boundY, boundWidth, boundHeight;

	public MainPanel() {		
		this.boundX = 200;
		this.boundY = 200;
		this.boundWidth = 550;
		this.boundHeight = 400;
		
		setBounds(200, 200, 550, 400);
		
		contentPane = new ImagePanel("/background.png");
	    contentPane.setLayout(null);
	    
	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setBounds(0, 0, 550, 22);
	    contentPane.add(menuBar);
	    
	    JMenu jmProductos = new JMenu("Productos");
	    menuBar.add(jmProductos);
	    
	    ButtonListener buttonListener = new ButtonListener();
	    
	    JMenuItem mbtnAddProducto = new JMenuItem("Agregar");
	    mbtnAddProducto.setName("AddProducto");
	    mbtnAddProducto.addActionListener(buttonListener);
	    jmProductos.add(mbtnAddProducto);
	    
	    JMenuItem mbtnDelProducto = new JMenuItem("Remover");
	    mbtnDelProducto.setName("DelProducto");
	    mbtnDelProducto.addActionListener(buttonListener);
	    jmProductos.add(mbtnDelProducto);
	    
	    JMenuItem mbtnListProducto = new JMenuItem("Listar");
	    mbtnListProducto.setName("ListProducto");
	    mbtnListProducto.addActionListener(buttonListener);
	    jmProductos.add(mbtnListProducto);
	    
	    JMenu jmClientes = new JMenu("Clientes");
	    menuBar.add(jmClientes);
	    
	    JMenuItem mbtnAddCliente = new JMenuItem("Agregar");
	    mbtnAddCliente.setName("AddCliente");
	    jmClientes.add(mbtnAddCliente);
	    
	    JMenuItem mbtnDelCliente = new JMenuItem("Remover");
	    mbtnDelCliente.setName("DelCliente");
	    jmClientes.add(mbtnDelCliente);
	    
	    JMenuItem mbtnListCliente = new JMenuItem("Listar");
	    mbtnListCliente.setName("ListCliente");
	    jmClientes.add(mbtnListCliente);
	    
	    JMenu jmEstadisticas = new JMenu("Estadisticas");
	    menuBar.add(jmEstadisticas);
	    
	    JMenu jmSession = new JMenu("Sesión");
	    menuBar.add(jmSession);
	    
	    JMenuItem mbtnSalir = new JMenuItem("Salir");
	    jmSession.add(mbtnSalir);
	}
	
	public JPanel getJPanel() {
		return contentPane;
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
}