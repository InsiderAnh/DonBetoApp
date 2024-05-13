package io.github.InsiderAnh.DonBetoApp.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.bson.Document;

import io.github.InsiderAnh.DonBetoApp.MainApp;
import io.github.InsiderAnh.DonBetoApp.api.DonBetoAPI;
import io.github.InsiderAnh.DonBetoApp.panels.productos.UpdateProductoPanel;

public class UpdateProductoListener implements ActionListener {
	
	private UpdateProductoPanel panel;
	private String productId, productName;
	
	public UpdateProductoListener(UpdateProductoPanel panel) {
		this.panel = panel;
	}
	
	@Override
    public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JComboBox) {
			String selected = panel.getComboProducts().getItemAt(panel.getComboProducts().getSelectedIndex());
			boolean select = !selected.equals("Seleccionar producto");
			panel.getTxtDescription().setEnabled(select);
			panel.getTxtStock().setEnabled(select);
			panel.getTxtPrecio().setEnabled(select);
			panel.getComboCategory().setEnabled(select);
			if (select) {
				updateProduct(selected);
			} else {
				panel.getTxtDescription().setText("");
				panel.getTxtStock().setText("");
				panel.getTxtPrecio().setText("");
			}
		}
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
		if (event.getSource() instanceof JButton) {
			JButton button = ((JButton)event.getSource());
			switch (button.getName()) {
				case "UpdateProducto":
					updateProduct();
					break;
			}
		}
	}
	
	void updateProduct(String name) {
		DonBetoAPI.getProduct(null, name).thenAccept(document -> {
			Document doc = document.get("data", Document.class);
			productId = doc.getString("id");
			productName = doc.getString("name");
			String category = doc.getString("category");
			for (int index = 0; index < panel.getComboCategory().getItemCount(); index++) {
				String check = panel.getComboCategory().getItemAt(index);
				if (check.equals(category)) {
					panel.getComboCategory().setSelectedItem(index);
				}
			}
			panel.getTxtDescription().setText(doc.getString("description"));
			panel.getTxtPrecio().setText(String.valueOf(doc.getDouble("price")));
			panel.getTxtStock().setText(String.valueOf(doc.getInteger("stock")));
	});
	}
	
	void updateProduct() {
		String description = panel.getTxtDescription().getText();
		String category = panel.getComboCategory().getItemAt(panel.getComboCategory().getSelectedIndex());
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
		DonBetoAPI.updateProduct(productId, productName, description, category, price, stock).thenAccept(document -> {
			String result = document.getString("data");
			if (result.equals("ALREADY_EXISTS")) {
				JOptionPane.showMessageDialog(null, "Ya existe un producto con esta id en tu tienda.");
				return;
			}
			
			JOptionPane.showMessageDialog(null, "El producto se agrego correctamente.");
			
			panel.getTxtDescription().setText("");
			panel.getComboCategory().setSelectedIndex(0);
			panel.getTxtPrecio().setText("");
			panel.getTxtStock().setText("");
		});
	}
	
}