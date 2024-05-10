package io.github.InsiderAnh.DonBetoApp.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import io.github.InsiderAnh.DonBetoApp.LoginPanel;
import io.github.InsiderAnh.DonBetoApp.MainApp;
import io.github.InsiderAnh.DonBetoApp.api.DonBetoAPI;

public class AuthButtonListener implements ActionListener {

	private final LoginPanel login;
	
	public AuthButtonListener(LoginPanel login) {
		this.login = login;
	}
	
	@Override
    public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JButton) {
			JButton button = ((JButton)event.getSource());
			switch (button.getName()) {
				case "Login":
					login();
					break;
				case "Register":
					MainApp.getInstance().showRegisterPanel();
					break;
			}
		}
		
    }
	
	private void login() {
		String user = login.getTxtUsuario().getText();
		String password = login.getTxtContra().getText();
		
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
		
		login.getBtnSession().setEnabled(false);
		DonBetoAPI.loginUser(user, password).thenAccept(document -> {
			String result = document.getString("data");
			if (result.equals("CORRECT")) {
				login.getMainApp().showMainPanel();
			} else {
				login.getBtnSession().setEnabled(true);
				JOptionPane.showMessageDialog(null, "El usuario o la contraseña son incorrectos.");
			}
		});
	}
    
}
