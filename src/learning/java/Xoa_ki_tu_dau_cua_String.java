/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

/**
 *
 * @author PC
 */
public class Xoa_ki_tu_dau_cua_String {

    public static void main(String[] args) {
        String a = "TrinhVietVana";
        String b = "ad-index";
        System.out.println("Last : "+a.substring(0, a.length() - 1));
        System.out.println("Last : "+b.substring(0, 3));
        System.out.println("First : "+a.substring(1, a.length()));

    }
}
