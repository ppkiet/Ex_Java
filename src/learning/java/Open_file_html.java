/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

import java.awt.Desktop;
import java.io.File;

/**
 *
 * @author PC
 */
public class Open_file_html {

    public static void main(String[] args) {
        try {
            String htmlFilePath = "E:\\netbean\\Email\\html\\Message 1.html"; // path to your new file
            File htmlFile = new File(htmlFilePath);

// open the default web browser for the HTML page
            Desktop.getDesktop().browse(htmlFile.toURI());

// if a web browser is the default HTML handler, this might work too
            Desktop.getDesktop().open(htmlFile);
        } catch (Exception e) {
        }
    }
}
