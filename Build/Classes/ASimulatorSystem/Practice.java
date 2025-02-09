// Source code is decompiled from a .class file using FernFlower decompiler.
package ASimulatorSystem;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;

public final class Practice {
    boolean negative;

    public Practice() {
        this(false);
    }

    public Practice(boolean negative) {
        this.negative = negative;
    }

    public String convert(BufferedImage image) {
        StringBuilder sb = new StringBuilder((image.getWidth() + 1) * image.getHeight());

        for(int y = 0; y < image.getHeight(); ++y) {
            if (sb.length() != 0) {
                sb.append("\n");
            }

            for(int x = 0; x < image.getWidth(); ++x) {
                Color pixelColor = new Color(image.getRGB(x, y));
                double gValue = (double)pixelColor.getRed() * 0.2989 + (double)pixelColor.getBlue() * 0.587 + (double)pixelColor.getGreen() * 0.114;
                char s = this.negative ? this.returnStrNeg(gValue) : this.returnStrPos(gValue);
                sb.append(s);
            }
        }

        return sb.toString();
    }

    private char returnStrPos(double g) {
        char str;
        if (g >= 230.0) {
            str = ' ';
        } else if (g >= 200.0) {
            str = '.';
        } else if (g >= 180.0) {
            str = '*';
        } else if (g >= 160.0) {
            str = ':';
        } else if (g >= 130.0) {
            str = 'o';
        } else if (g >= 100.0) {
            str = '&';
        } else if (g >= 70.0) {
            str = '8';
        } else if (g >= 50.0) {
            str = '#';
        } else {
            str = '@';
        }

        return str;
    }

    private char returnStrNeg(double g) {
        char str;
        if (g >= 230.0) {
            str = '@';
        } else if (g >= 200.0) {
            str = '#';
        } else if (g >= 180.0) {
            str = '8';
        } else if (g >= 160.0) {
            str = '&';
        } else if (g >= 130.0) {
            str = 'o';
        } else if (g >= 100.0) {
            str = ':';
        } else if (g >= 70.0) {
            str = '*';
        } else if (g >= 50.0) {
            str = '.';
        } else {
            str = ' ';
        }

        return str;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Code to execute on the Event Dispatch Thread
                System.out.println("Swing application started.");
            }
        });
    }

}
