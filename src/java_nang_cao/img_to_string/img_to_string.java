/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_nang_cao.img_to_string;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author PC
 */
public class img_to_string {

    //tu anh sang byte 
    public static byte[] extractBytes(String path) {
        try {
            byte[] imageInByte;
            BufferedImage originalImage = ImageIO.read(new File(path));
            // convert BufferedImage to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpg", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (Exception e) {
        }
        return null;
    }

    //byte sang chuoi
    public static String encodeImage(byte[] imageByteArray) {
        return Base64.encodeBase64URLSafeString(imageByteArray);
    }

    //chuoi sang byte
    public static byte[] decodeImage(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
    }

    //byte sang anh
    public static void Image(byte[] imageInByte) {
        try {
            // convert byte array back to BufferedImage
            InputStream in = new ByteArrayInputStream(imageInByte);
            BufferedImage bImageFromConvert = ImageIO.read(in);
            ImageIO.write(bImageFromConvert, "jpg", new File("C:\\Users\\PC\\Documents\\201511221_183149_new.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    

    public static void main(String[] args) {
        try {
            String chuoi = encodeImage(extractBytes("C:\\Users\\PC\\Documents\\201511221_183149.jpg"));
            System.out.println(chuoi.length());
//            Image(decodeImage(chuoi));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
