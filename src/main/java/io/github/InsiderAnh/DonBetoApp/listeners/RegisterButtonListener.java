package io.github.InsiderAnh.DonBetoApp.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import io.github.InsiderAnh.DonBetoApp.RegisterPanel;
import io.github.InsiderAnh.DonBetoApp.api.DonBetoAPI;

public class RegisterButtonListener implements ActionListener {

	private final RegisterPanel register;
	
	public RegisterButtonListener(RegisterPanel register) {
		this.register = register;
	}
	
	@Override
    public void actionPerformed(ActionEvent event) {
		String user = register.getTxtUsuario().getText();
		String password = register.getTxtContra().getText();
		String role = register.getComboRole().getItemAt(register.getComboRole().getSelectedIndex());
		String authorization = register.getTxtAutorization().getText();

		if (user.isEmpty() || user.isBlank()) {
			JOptionPane.showMessageDialog(null, "El usuario no puede estar vacio.");
			return;
		}
		
		if (user.contains(" ")) {
			JOptionPane.showMessageDialog(null, "El usuario no puede contener espacios.");
			return;
		}
		
		if (password.isEmpty() || password.isBlank()) {
			JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacia.");
			return;
		}

		
		if (password.contains(" ")) {
			JOptionPane.showMessageDialog(null, "La contraseña no puede contener espacios.");
			return;
		}
		
		register.getBtnRegister().setEnabled(false);
		DonBetoAPI.registerUser(user, password, role, authorization).thenAccept(document -> {
			String result = document.getString("data");
			if (result.equals("UNAUTHORISED")) {
				JOptionPane.showMessageDialog(null, "No estas autorizado para crear usuarios.");
				register.getBtnRegister().setEnabled(true);
				return;
			}
			if (result.equals("ALREADY_REGISTERED")) {
				JOptionPane.showMessageDialog(null, "Este usuario ya esta registrado.");
				register.getBtnRegister().setEnabled(true);
				return;
			}
			if (result.equals("REGISTERED")) {
				register.getMainApp().showLoginPanel();
			}
		});
    }
    
}
