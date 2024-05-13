package io.github.InsiderAnh.DonBetoApp.panels.clients;

import javax.swing.JPanel;

import io.github.InsiderAnh.DonBetoApp.listeners.ButtonListener;
import io.github.InsiderAnh.DonBetoApp.panels.ImagePanel;
import lombok.Getter;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

@Getter
public class AddClientePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int boundX, boundY, boundWidth, boundHeight;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtCorreo;
	private JTextField txtCompra;
	private JTextField txtDNI;
	private JTextField txtNumero;

	public AddClientePanel() {		
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
	    
	    JMenuItem mbtnUpdateProducto = new JMenuItem("Actualizar");
	    mbtnUpdateProducto.setName("UpdateProducto");
	    mbtnUpdateProducto.addActionListener(buttonListener);
	    jmProductos.add(mbtnUpdateProducto);
	    
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
	    
	    JLabel lblName = new JLabel("Nombres:");
	    lblName.setForeground(new Color(255, 255, 255));
	    lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	    lblName.setBounds(116, 98, 69, 14);
	    contentPane.add(lblName);
	    
	    JLabel lblApellidos = new JLabel("Apellidos");
	    lblApellidos.setForeground(new Color(255, 255, 255));
	    lblApellidos.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	    lblApellidos.setBounds(116, 130, 88, 14);
	    contentPane.add(lblApellidos);
	    
	    JLabel lblCorreo = new JLabel("Correo:");
	    lblCorreo.setForeground(new Color(255, 255, 255));
	    lblCorreo.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	    lblCorreo.setBounds(116, 196, 88, 14);
	    contentPane.add(lblCorreo);
	    
	    JLabel lblStock = new JLabel("Ult. Compra");
	    lblStock.setForeground(new Color(255, 255, 255));
	    lblStock.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	    lblStock.setBounds(116, 232, 88, 14);
	    contentPane.add(lblStock);
	    
	    txtNombres = new JTextField();
	    txtNombres.setBounds(229, 97, 170, 20);
	    contentPane.add(txtNombres);
	    txtNombres.setColumns(10);
	    
	    txtApellidos = new JTextField();
	    txtApellidos.setColumns(10);
	    txtApellidos.setBounds(229, 129, 170, 20);
	    contentPane.add(txtApellidos);
	    
	    txtCorreo = new JTextField();
	    txtCorreo.setColumns(10);
	    txtCorreo.setBounds(229, 195, 170, 20);
	    contentPane.add(txtCorreo);
	    
	    txtCompra = new JTextField();
	    txtCompra.setColumns(10);
	    txtCompra.setBounds(229, 231, 170, 20);
	    contentPane.add(txtCompra);
	    
	    JButton btnAgregar = new JButton("Agregar");
	    btnAgregar.setName("AddProducto");
	    btnAgregar.setBounds(226, 276, 89, 23);
	    contentPane.add(btnAgregar);
	    
	    JLabel lblId = new JLabel("DNI:");
	    lblId.setForeground(Color.WHITE);
	    lblId.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	    lblId.setBounds(116, 68, 69, 14);
	    contentPane.add(lblId);
	    
	    txtDNI = new JTextField();
	    txtDNI.setColumns(10);
	    txtDNI.setBounds(229, 67, 170, 20);
	    contentPane.add(txtDNI);
	    
	    JLabel lblNumero = new JLabel("Número:");
	    lblNumero.setForeground(Color.WHITE);
	    lblNumero.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	    lblNumero.setBounds(116, 165, 88, 14);
	    contentPane.add(lblNumero);
	    
	    txtNumero = new JTextField();
	    txtNumero.setColumns(10);
	    txtNumero.setBounds(229, 160, 170, 20);
	    contentPane.add(txtNumero);
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