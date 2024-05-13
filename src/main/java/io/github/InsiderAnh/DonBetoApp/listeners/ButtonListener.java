package io.github.InsiderAnh.DonBetoApp.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import io.github.InsiderAnh.DonBetoApp.MainApp;

public class ButtonListener implements ActionListener {
	
	@Override
    public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JMenuItem) {
			JMenuItem button = ((JMenuItem)event.getSource());
			switch (button.getName()) {
				case "AddProducto":
					MainApp.getInstance().showAddProductoPanel();
					break;
				case "UpdateProducto":
					MainApp.getInstance().showUpdateProductoPanel();
					break;
				case "DelProduto":
					
					break;
				case "ListProducto":
					
					break;
				case "AddCliente":
					
					break;
				case "DelCliente":
					
					break;
				case "ListCliente":
					
					break;
			}
		}
	}
	
}
