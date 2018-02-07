package javaapplication1.imagem;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ThresholdingGlobal {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Image files", "png",
                "jpg", "bmp"));
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        try {
            String thre = JOptionPane.showInputDialog("Valor de Threshold:"); //Fornece a opcao do usuario definir o valor de threshold
            int t = Integer.valueOf(thre);
            // Carrega a imagem do disco
            File img = chooser.getSelectedFile();
            BufferedImage image = ImageIO.read(img);
            // Gera uma versão em escala de cinza
            BufferedImage gray = toGrayscale(image);
            ImageIO.write(gray, "png", newFile(img, "gray"));
            // Geramos uma versão binária a partir da versão em escala de cinza.
            BufferedImage binary = toBinary(gray, t);
            ImageIO.write(binary, "png", newFile(img, "binary"));
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro");
            e.printStackTrace();
        }
    }

    
    private static BufferedImage toGrayscale(BufferedImage image)
            throws IOException {
        BufferedImage output = new BufferedImage(image.getWidth(),
                image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d = output.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return output;
    }

    /**
     * Converte a imagem para binário usando um algorítmo de threshold simples.
     * Tudo que estiver abaixo do threshold será convertido para preto. Acima ou
     * igual ao threshold será convertido para branco.
     *
     * Parametros:
     *
     * image Imagem a ser convertida (apenas o canal r será considerado). t
     * Valor do threshold.
     */

    private static BufferedImage toBinary(BufferedImage image, int t) {
        int BLACK = Color.BLACK.getRGB();
        int WHITE = Color.WHITE.getRGB();
        BufferedImage output = new BufferedImage(image.getWidth(),
                image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		// Percorre a imagem definindo na saída o pixel como branco se o valor
        // for menor que o threshold, ou como preto se for maior.
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color pixel = new Color(image.getRGB(x, y));
                output.setRGB(x, y, pixel.getRed() < t ? BLACK : WHITE);
            }
        }
        return output;
    }

    /**
     * Gera um nome de arquivo baseado no nome fornecido.
     *
     * A extensão e png.
     *
     * Parametros: file Arquivo original
     *             detail String da definicao da imagem
     */
    private static File newFile(File file, String detail) {
        return new File(file.getParentFile(), file.getName().substring(0,
                file.getName().indexOf("."))
                + "-" + detail + ".png");
    }
}
