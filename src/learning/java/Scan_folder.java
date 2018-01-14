/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static org.apache.commons.io.FilenameUtils.removeExtension;

/**
 *
 * @author PC
 */
public class Scan_folder {

    private static ArrayList<Class_> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        printFnames("E:\\Project Video\\New folder");
        System.out.println("----------------------");
        for (int i = 0; i < list.size(); i++) {
            Class_ l = list.get(i);
            System.out.println(l.getName());
        }
    }

    public static void printFnames(String sDir) throws IOException {
        File[] faFiles = new File(sDir).listFiles();
        for (File file : faFiles) {
            if (file.getName().matches("^(.*?)")) {
//                System.out.println(file.getAbsolutePath());
//                System.out.println(file.getParentFile());
//                System.out.println(file.getName());
                
                String a = removeExtension(file.getName().trim());
                String arr[] = a.split(" ");
                Class_ l = new Class_();
                String length = arr[arr.length - 1];
                if (null != length) {
                    switch (length.trim()) {
                        case "1":
                        case "2":
                        case "4":
                        case "3":
                        case "5":
                        case "6":
                            String name = a.substring(0, a.length() - 1).trim();
                            l.setName(name);
                            list.add(l);
                            break;
                        default:
                            l.setName(a.trim());
                            list.add(l);
                            break;
                    }

                }
            }
            if (file.isDirectory()) {
                printFnames(file.getAbsolutePath());
            }
        }
    }

}
