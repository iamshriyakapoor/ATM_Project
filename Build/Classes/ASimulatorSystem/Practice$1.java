// Source code is decompiled from a .class file using FernFlower decompiler.
package ASimulatorSystem;

import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

final class Practice$1 implements Runnable {
    Practice$1() {
    }

    public void run() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Images", new String[]{"jpg", "gif", "png"}));

        while(fileChooser.showOpenDialog((Component)null) == 0) {
            try {
                File f = fileChooser.getSelectedFile();
                BufferedImage image = ImageIO.read(f);
                if (image == null) {
                    throw new IllegalArgumentException(f + " is not a valid image.");
                }

                String ascii = (new Practice()).convert(image);
                JTextArea textArea = new JTextArea(ascii, image.getHeight(), image.getWidth());
                textArea.setFont(new Font("Monospaced", 1, 5));
                textArea.setEditable(false);
                JDialog dialog = (new JOptionPane(new JScrollPane(textArea), -1)).createDialog(Practice.class.getName());
                dialog.setResizable(true);
                dialog.setVisible(true);
            } catch (Exception var7) {
                JOptionPane.showMessageDialog((Component)null, var7.toString(), "Error", 0);
            }
        }

        System.exit(0);
    }
}
