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
public class Validation {
    
    public static void main(String[] args) {
        Method m = new Method();
        System.out.println( m.isValidEmailAddress("a@gmail.com") );       
        System.out.println( m.isValidName("nguyễn văn á") );       
    }
}
