/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;

/**
 *
 * @author Anika tanzim
 */
public class UnionFind_DynamicConnectivity {
        public static void main(String[] args) 
        {
            //Scanner reader = new Scanner(System.in);
            /*int N = StdIn.readInt();
            UF uf = new UF(N);
            while(!StdIn.isEmpty())
            {
                int p = StdIn.readInt();
                int q = StdIn.readnt();
                if(!uf.connected(p,q))
                {
                    uf.union(p,q);
                    StdOut.println(p + " " + q);
                }
            }
            */
            
            Scanner reader = new Scanner(System.in);
            int N = reader.nextInt();
            //UF uf = new UF(N);
            QuickFindUF uf = new QuickFindUF(N);
            while(reader.hasNext())
            {
                int p = reader.nextInt();;
                int q = reader.nextInt();;
                if(!uf.connected(p,q))
                {
                    
                    System.out.println(p + " " + q+ " are not connected");
                    uf.union(p,q);
                }
                else{
                    System.out.println(p + " " + q+ " are connected");
                }
                
            }
        
    }
}
