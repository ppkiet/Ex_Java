/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

import java.io.IOException;

/**
 *
 * @author PC
 */
public class HighlightFile {

    public static void main(String[] args) throws IOException {
//        Process p = new ProcessBuilder("explorer.exe", "/select,E:\\PS04803 - LAB 1 - LAB 8 + Assignment SOF203.rar").start();
        Runtime.getRuntime().exec("explorer.exe /select, E:\\PS04803 - LAB 1 - LAB 8 + Assignment SOF203.rar");
    }
}
