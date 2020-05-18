/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author User
 */
public class FixedCapacity {
    private String[] s;
    private int N = 0;
    public FixedCapacity(int capacity){
        s = new String[capacity];
    }
    public boolean isEmpty(){
        return N ==0;
    }
    public void push(String item){
        s[N++] = item;
    }
    public String pop(){
        return s[--N];
    }
}
