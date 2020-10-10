/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author batoul
 */
public class Expert__System {
 public static Scanner input;
 public static char goal;
 public static ArrayList<Character> Listfacts;
 public static ArrayList<String> Listrule;
 //public static int countBackwardchaining=0;
 //public static int countForwardchaining=0;

    public Expert__System() {
        Listfacts  = new ArrayList<Character>();
        Listrule=new ArrayList<String>();
    }
  
  public void openfile(){
  try{
        input =new Scanner(new File("KB3.txt")); 
  }
   catch(Exception ex){
        System.out.println("Error:the input file dose not exist");
    } 
}

public void readfile(){
    //Read the line
while(input.hasNext()){
    String a= input.nextLine();
    
    proof(a);
}
    // System.out.println("factlist:"+ Listfacts);
     //System.out.println("goal:"+ goal);
     //System.out.println( "rulelist:"+Listrule);
    // System.out.println( " ");
}
//Interpretation of input
public static void proof(String st){
        if(st.length()==1){
      char[] ch =st.toCharArray();
        Listfacts.add(ch[0]);
        }
        else if(st.length()==7){
        String u = st.substring(6,7);
         goal=u.charAt(0);
      }
        else {
          Listrule.add(st);
      }
        
    }

  public static  boolean Backwardchaining(){
      
          checkBackwardchaining( goal);
          if(Listfacts.contains(goal))
              return true;
          else return false;

    
  }



     public static void checkBackwardchaining( char g){
         for (int i = 0; i <Listrule.size(); i++) {
             String st= Listrule.get(i);
             char[] ch =st.toCharArray();
             
             if(ch.length>=5){
             if (ch[4] == g){ // example A.B-->C
                
            System.out.println("First case income : "+ch[4]);
                //His right side fact
             if(Listfacts.contains(ch[0]) && Listfacts.contains(ch[2])){
                          Listfacts.add(g);
                          Listrule.remove(st);
                          updetBackwardchaining(st); }
                 
                 else if (!Listfacts.contains(ch[0])&& Listfacts.contains(ch[2])){  
                      System.out.println("1 not fact 2 fact" );
                      checkBackwardchaining(ch[0]);
                      updetBackwardchaining(st);
                      
                 }
                 else if(Listfacts.contains(ch[0]) &&!Listfacts.contains(ch[2])) {
                      System.out.println("1 fact 2 not fact" );
                      checkBackwardchaining(ch[2]);
                      updetBackwardchaining(st);
                    }
                 else if (!Listfacts.contains(ch[0])&&!Listfacts.contains(ch[2])){
                      System.out.println("both not fact" );
                      checkBackwardchaining(ch[0]);
                      checkBackwardchaining(ch[2]);
                      updetBackwardchaining(st);   
                 }
             }}//end if (ch[4] == g)
              else if(ch.length==4){  
              if (ch[3] == g){ // example A-->C
                 
                  System.out.println("second case income :"+ ch[3]); 
                  if(Listfacts.contains(ch[0])){
                  Listfacts.add(ch[3]);
                   Listrule.remove(st);}
             else{
              checkBackwardchaining(ch[0]);
              updetBackwardchaining(st);
             }}
         } }//end for 
     
     }// end chekBackwardchaining
     public static void updetBackwardchaining(String st){
          char[] ch =st.toCharArray();
          if(Listfacts.contains(ch[0]) && Listfacts.contains(ch[2])){
              if(!Listfacts.contains(ch[4])){// check it does not exist in fact
                     Listfacts.add(ch[4]);
                     Listrule.remove(st);
              }   
          }
     }  //end  updetBackwardchaining    
     
     public static  boolean Forwardchaining(){
      
          Forwardchaining(goal);
           if(Listfacts.contains(goal))
              return true;
          else return false;
          

    
  }
 

public static void Forwardchaining (char g){
    for (int i = 0; i <Listrule.size(); i++) {
             String st= Listrule.get(i);
             char[] ch =st.toCharArray();
             if(ch.length>=5){// example A.B-->C
               
          if(Listfacts.contains(ch[0]) && Listfacts.contains(ch[2])&&!Listfacts.contains(ch[4])){
              Listfacts.add(ch[4]);
              System.out.println("add fact:"+ ch[4]);
              Listrule.remove(st);
              System.out.println("remove rule: "+ st);
              
             if(Listfacts.contains(g))
                break;
             else
               Forwardchaining( g) ; }}
             if(ch.length==4){// example A-->C
     if(Listfacts.contains(ch[0]) &&!Listfacts.contains(ch[3])){ 
         Listfacts.add(ch[3]);
           System.out.println("add fact: "+ ch[3]);
              Listrule.remove(st);
              System.out.println("remove rule: "+ st);
             if(Listfacts.contains(g))
                break;
             else
               Forwardchaining( g) ;
        
    }} }//end for
}//end Forwardchaining


       
     
      public static void print(){  
     System.out.println("factlist:"+ Listfacts);
     System.out.println( "rulelist:"+Listrule);
     System.out.println("goal:"+ goal);
     System.out.println( " ");
      //System.out.println( c);
      //System.out.println( j);
      }
  public void closefile (){
        input.close();
       
   } //end closefile 

}//end class  
