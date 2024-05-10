package io.github.InsiderAnh.DonBetoApp.panels.productos;

import javax.swing.JPanel;

import io.github.InsiderAnh.DonBetoApp.listeners.ButtonListener;
import io.github.InsiderAnh.DonBetoApp.panels.ImagePanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class AddProductoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int boundX, boundY, boundWidth, boundHeight;
	private JTextField txtNombre;
	private JTextField txtDescription;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTextField txtId;

	public AddProductoPanel() {		
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
	    
	    JLabel lblName = new JLabel("Nombre:");
	    lblName.setForeground(new Color(255, 255, 255));
	    lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	    lblName.setBounds(166, 98, 69, 14);
	    contentPane.add(lblName);
	    
	    JLabel lblDescripcion = new JLabel("Descripción:");
	    lblDescripcion.setForeground(new Color(255, 255, 255));
	    lblDescripcion.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	    lblDescripcion.setBounds(166, 130, 88, 14);
	    contentPane.add(lblDescripcion);
	    
	    JLabel lblPrecio = new JLabel("Precio:");
	    lblPrecio.setForeground(new Color(255, 255, 255));
	    lblPrecio.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	    lblPrecio.setBounds(166, 165, 88, 14);
	    contentPane.add(lblPrecio);
	    
	    JLabel lblStock = new JLabel("Stock:");
	    lblStock.setForeground(new Color(255, 255, 255));
	    lblStock.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	    lblStock.setBounds(166, 201, 88, 14);
	    contentPane.add(lblStock);
	    
	    txtNombre = new JTextField();
	    txtNombre.setBounds(279, 97, 86, 20);
	    contentPane.add(txtNombre);
	    txtNombre.setColumns(10);
	    
	    txtDescription = new JTextField();
	    txtDescription.setColumns(10);
	    txtDescription.setBounds(279, 129, 86, 20);
	    contentPane.add(txtDescription);
	    
	    txtPrecio = new JTextField();
	    txtPrecio.setColumns(10);
	    txtPrecio.setBounds(279, 164, 86, 20);
	    contentPane.add(txtPrecio);
	    
	    txtStock = new JTextField();
	    txtStock.setColumns(10);
	    txtStock.setBounds(279, 200, 86, 20);
	    contentPane.add(txtStock);
	    
	    JButton btnAgregar = new JButton("Agregar");
	    btnAgregar.setBounds(211, 247, 89, 23);
	    contentPane.add(btnAgregar);
	    
	    JLabel lblId = new JLabel("ID:");
	    lblId.setForeground(Color.WHITE);
	    lblId.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	    lblId.setBounds(166, 68, 69, 14);
	    contentPane.add(lblId);
	    
	    txtId = new JTextField();
	    txtId.setEditable(false);
	    txtId.setColumns(10);
	    txtId.setBounds(279, 67, 86, 20);
	    contentPane.add(txtId);
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