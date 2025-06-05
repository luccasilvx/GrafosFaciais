package edu.algebra.Reconhecimento.Util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ImageUtil {

    public static double[] imageToVector(byte[] imageData) throws IOException {
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
        int width = img.getWidth();
        int height = img.getHeight();
        double[] vector = new double[width * height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = img.getRGB(x, y);
                int gray = (rgb >> 16 & 0xff + rgb >> 8 & 0xff + rgb & 0xff) / 3;
                vector[y * width + x] = gray;
            }
        }
        return vector;
    }
}
