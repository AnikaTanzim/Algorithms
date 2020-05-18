/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import javafx.scene.Node;

/**
 *
 * @author User
 */
public class LinkedLIst {
    private Node first = null;
    private class Node
    {
        String item;
        Node next;
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    
    public void push(String item)
    {
        Node oldfirst = new Node();
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        
    }
    
    public String pop()
    {
        String item = first.item;
        first = first.next;
        return item;
    }
}
