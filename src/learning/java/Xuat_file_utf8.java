/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 *
 * @author PC
 */
public class Xuat_file_utf8 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
            String line = "Tôi yêu việt nam";
    OutputStream os = new FileOutputStream("D:\\j.csv");
    os.write(239);
    os.write(187);
    os.write(191);

    PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));

    w.print(line);
    w.flush();
    w.close();
    }
}
