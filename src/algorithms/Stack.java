/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Stack {
    
    public String pop(){
        String s = null;
        return s;
    }
    public void push(String s){
        
    }
    public static void main(String arg[]){
        
        Scanner reader = new Scanner(System.in);
        //Stack stack = new Stack();
        LinkedLIst li = new LinkedLIst();
        while(reader.hasNext()){
            
            String st = reader.next();
            if (st.equals("-")){
                System.out.println(li.pop());
            }
            else{
                li.push(st);
            }
            
        }
    }
    
}
