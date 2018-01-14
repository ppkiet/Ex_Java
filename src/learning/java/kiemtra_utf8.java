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
public class kiemtra_utf8 {

    public static void main(String[] args) {
        String test = "toi yeu viet nam";
        String test2 = "tôi yêu việt nam";
        System.out.println(Method.isUTF8MisInterpreted(test)); //true
        System.out.println(Method.isUTF8MisInterpreted(test2)); //false
    }
}
