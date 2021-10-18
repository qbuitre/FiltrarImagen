/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filtrarimagen;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Jorge Santana
 */
public class Lienzo extends JPanel {
    private BufferedImage imgOriginal = null;
    private BufferedImage imgModified = null;
    private BufferedImage logo = null;
    private int logoPos = 2;

    public Lienzo() throws MalformedURLException {
        try {
        logo =  ImageIO.read(new URL("https://www.valenzueladelarze.cl/themes/valenzuela_0km_v1/assets/img/marcas/logo-volkswagen.jpg"));
        imgOriginal =  ImageIO.read(new URL("https://www.masralyoum.net/temp/thumb/900x450_uploads,2020,11,07,c62934e8a4.jpg"));
        this.setPreferredSize(new Dimension(imgOriginal.getWidth(), imgOriginal.getHeight()));
        
        } catch(IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
        imgModified = UtilsPractica5.seleccionarComponentes(imgOriginal, true, true, true);
    }
    
    public void changeColorFilter(boolean red, boolean green, boolean blue) {
        imgModified = UtilsPractica5.seleccionarComponentes(imgOriginal, red, green, blue);
        this.repaint();
    }
    
    public void changeLogoPos (int logoPos) {
        this.logoPos = logoPos;
        this.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgModified, 0, 0, null);
        switch(logoPos) {
            case 1:
                g.drawImage(logo, 0,0, null);
                break;
            case 2:
                g.drawImage(logo, imgOriginal.getWidth()-logo.getWidth(),0, null);
                break;
            case 3:
                g.drawImage(logo, 0, imgOriginal.getHeight()-logo.getHeight(), null);
                break;
            case 4:
                g.drawImage(logo, imgOriginal.getWidth()-logo.getWidth(), imgOriginal.getHeight()-logo.getHeight(), null);
                break;
        }
    }
    
    
}
