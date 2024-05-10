package io.github.InsiderAnh.DonBetoApp;

import javax.swing.JPanel;

import io.github.InsiderAnh.DonBetoApp.panels.ImagePanel;
import lombok.Getter;
import io.github.InsiderAnh.DonBetoApp.listeners.*;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@Getter
public class RegisterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JLabel lblContraseña;
	private final MainApp mainApp;
	private int boundX, boundY, boundWidth, boundHeight;
	private JPasswordField txtContra;
	private JPasswordField txtAutorization;
	private JComboBox<String> comboRole;
	private JButton btnRegister;

	public RegisterPanel(MainApp mainApp) {
		this.mainApp = mainApp;
		
		this.boundX = 200;
		this.boundY = 200;
		this.boundWidth = 550;
		this.boundHeight = 400;
		
		setBounds(200, 200, 550, 400);
		
		contentPane = new ImagePanel("/background.png");
	    contentPane.setLayout(null);
	    
	    JLabel lblUsuario = new JLabel("Usuario:");
	    lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblUsuario.setForeground(new Color(255, 255, 255));
	    lblUsuario.setBounds(132, 79, 99, 55);
	    contentPane.add(lblUsuario);
	    
	    txtUsuario = new JTextField();
	    txtUsuario.setBounds(266, 100, 116, 20);
	    contentPane.add(txtUsuario);
	    txtUsuario.setColumns(10);
	    
	    lblContraseña = new JLabel("Contraseña");
	    lblContraseña.setForeground(new Color(255, 255, 255));
	    lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblContraseña.setBounds(132, 122, 124, 55);
	    contentPane.add(lblContraseña);
	    
	    btnRegister = new JButton("Registrar usuario");
	    btnRegister.addActionListener(new RegisterButtonListener(this));
	    btnRegister.setBounds(132, 286, 250, 23);
	    contentPane.add(btnRegister);
	    
	    txtContra = new JPasswordField();
	    txtContra.setBounds(266, 142, 116, 20);
	    contentPane.add(txtContra);
	    
	    JLabel lblRol = new JLabel("Rol");
	    lblRol.setForeground(Color.WHITE);
	    lblRol.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblRol.setBounds(132, 166, 124, 55);
	    contentPane.add(lblRol);
	    
	    JLabel lblAutorizacin = new JLabel("Autorización");
	    lblAutorizacin.setForeground(Color.WHITE);
	    lblAutorizacin.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblAutorizacin.setBounds(132, 210, 124, 55);
	    contentPane.add(lblAutorizacin);
	    
	    txtAutorization = new JPasswordField();
	    txtAutorization.setBounds(266, 230, 116, 20);
	    contentPane.add(txtAutorization);
	    
	    JLabel lblRegistrarUsuario = new JLabel("Registrar usuario");
	    lblRegistrarUsuario.setForeground(Color.WHITE);
	    lblRegistrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblRegistrarUsuario.setBounds(176, 34, 220, 55);
	    contentPane.add(lblRegistrarUsuario);
	    
	    comboRole = new JComboBox<>();
	    comboRole.setModel(new DefaultComboBoxModel<>(new String[] {"Vendedor", "Administrador", "Dueño"}));
	    comboRole.setBounds(266, 185, 116, 22);
	    contentPane.add(comboRole);
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