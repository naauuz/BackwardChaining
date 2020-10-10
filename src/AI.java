/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author batoul
 */

public class AI {
    
 public static void main(String[] args){
    
   Expert__System i=new  Expert__System();
   i.openfile();
   i.readfile();
   i.print();
   
  System.out.println("------------------------");
  boolean f=  i.Forwardchaining();
  System.out.println(" ");
  System.out.println("Result of Forwardchaining: "+f);
  
  System.out.println(" ");
  i.print();
      
 System.out.println("------------------------");
 boolean b=i.Backwardchaining();
 System.out.println("Result of Backwardchaining: "+b);
 System.out.println(" ");
i.print();
 i.closefile();
   } 
    
}
