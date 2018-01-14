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
import java.util.*;
public class Sort_Arraylist  {

//	public static void main(String args[]){
//	   ArrayList<String> listofcountries = new ArrayList<String>();
//	   listofcountries.add("India");
//	   listofcountries.add("US");
//	   listofcountries.add("China");
//	   listofcountries.add("Denmark");
//
//	   /*Unsorted List*/
//	   System.out.println("-----Before Sorting:-----");
//	   for(String counter: listofcountries){
//			System.out.println(counter);
//		}
//
//	   /* Sort statement*/
//	   Collections.sort(listofcountries);
//
//	   /* Sorted List*/
//	   System.out.println("-----After Sorting:-----");
//	   for(String counter: listofcountries){
//			System.out.println(counter);
//		}     
//	}
     public static void main(String a[]){
         
        List<Empl> list = new ArrayList<Empl>();
        list.add(new Empl("Ram",3000));
        list.add(new Empl("John",6000));
        list.add(new Empl("Crish",2000));
        list.add(new Empl("Tom",2400));
        Collections.sort(list,new MySalaryComp());
        System.out.println("Sorted list entries: ");
        for(Empl e:list){
            System.out.println(e);
        }
    }
}
 
class MySalaryComp implements Comparator<Empl>{
 
    @Override
    public int compare(Empl e1, Empl e2) {
        if( Integer.parseInt(e1.getName()) < Integer.parseInt(e2.getName()) ){
            return 1;
        } else {
            return -1;
        }
    }
}
 
class Empl{
     
    private String name;
    private int salary;
     
    public Empl(String n, int s){
        this.name = n;
        this.salary = s;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String toString(){
        return "Name: "+this.name+"-- Salary: "+this.salary;
    }

}
