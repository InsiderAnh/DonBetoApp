package io.github.InsiderAnh.DonBetoApp.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import io.github.InsiderAnh.DonBetoApp.MainApp;
import io.github.InsiderAnh.DonBetoApp.api.DonBetoAPI;
import io.github.InsiderAnh.DonBetoApp.panels.productos.AddProductoPanel;

public class AddProductoListener implements ActionListener {
	
	private AddProductoPanel panel;
	
	public AddProductoListener(AddProductoPanel panel) {
		this.panel = panel;
	}
	
	@Override
    public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JMenuItem) {
			JMenuItem button = ((JMenuItem)event.getSource());
			switch (button.getName()) {
				case "AddProducto":
					MainApp.getInstance().showAddProductoPanel();
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
		if (event.getSource() instanceof JButton) {
			JButton button = ((JButton)event.getSource());
			switch (button.getName()) {
				case "AddProducto":
					addProduct();
					break;
			}
		}
	}
	
	void addProduct() {
		String id = panel.getTxtId().getText();
		String name = panel.getTxtNombre().getText();
		String description = panel.getTxtDescription().getText();
		String category = panel.getComboCategory().getItemAt(panel.getComboCategory().getSelectedIndex());
		if (id.isEmpty() || id.isBlank()) {
			JOptionPane.showMessageDialog(null, "El ID no puede estar vacio.");
			return;
		}
		if (name.isEmpty() || name.isBlank()) {
			JOptionPane.showMessageDialog(null, "El Nombre no puede estar vacio.");
			return;
		}
		if (description.isEmpty() || description.isBlank()) {
			JOptionPane.showMessageDialog(null, "El Descripción no puede estar vacio.");
			return;
		}
		double price;
		try {
			price = Double.parseDouble(panel.getTxtPrecio().getText());
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, "El Precio debe ser un numero.");
			return;
		}
		int stock;
		try {
			stock = Integer.parseInt(panel.getTxtStock().getText());
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, "El Stock debe ser un numero.");
			return;
		}
		if (price <= 0.0) {
			JOptionPane.showMessageDialog(null, "El Precio no puede ser menor o igual a 0.0.");
			return;
		}
		if (stock < 0) {
			JOptionPane.showMessageDialog(null, "El Stock no puede ser menor a 0.");
			return;
		}
		DonBetoAPI.addProduct(id, name, description, category, price, stock).thenAccept(document -> {
			String result = document.getString("data");
			if (result.equals("ALREADY_EXISTS")) {
				JOptionPane.showMessageDialog(null, "Ya existe un producto con esta id en tu tienda.");
				return;
			}
			
			JOptionPane.showMessageDialog(null, "El producto se agrego correctamente.");
			
			panel.getTxtId().setText("");
			panel.getTxtNombre().setText("");
			panel.getTxtDescription().setText("");
			panel.getComboCategory().setSelectedIndex(0);
			panel.getTxtPrecio().setText("");
			panel.getTxtStock().setText("");
		});
	}
	
}