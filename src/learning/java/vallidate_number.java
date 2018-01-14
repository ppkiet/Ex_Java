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
public class vallidate_number {

    public static void main(String[] args) {
        System.out.println(vallidate_number.isValidName("0.2"));
        
//cat chuoi
//        String a = "012342";
//        System.out.println(a.substring(1));
    }

    public static boolean isValidName(String str) {
//        return str.matches("-?\\d+(\\.\\d+)?");  //kiem tra so thap phan
        return str.matches("-?\\d+?");  //kiem tra so nguyen
    }
}
