/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

import java.util.*;
import java.text.*;
  
public class Tim_thu {

   public static void main(String args[]) {
      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
      
//      String input = args.length == 0 ? "2016-12-26" : args[0]; 
      String input ="2016-12-26"; 

      System.out.println(input); 
      SimpleDateFormat Format = new SimpleDateFormat ("EEE,yyyy-MMMM-dd");
      Date t; 

      try { 
          t = ft.parse(input); 
          System.out.println(Format.format(t)); 
      } catch (ParseException e) { 
          System.out.println("Unparseable using " + ft); 
      }
   }
}
