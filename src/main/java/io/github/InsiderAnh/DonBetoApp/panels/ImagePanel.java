package io.github.InsiderAnh.DonBetoApp.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private static final long serialVersionUID = -4010134637441559652L;
	private Image backgroundImage;

    public ImagePanel(String imagePath) {
    	try {
            backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
    	} catch (Exception exception) {
            backgroundImage = new ImageIcon(getClass().getResource("/resources" + imagePath)).getImage();
    	}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
    }
    
}