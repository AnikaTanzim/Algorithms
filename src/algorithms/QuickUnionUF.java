
package algorithms;

import java.util.Scanner;

/**
 *
 * @author Anika Tanzim
 * Quick Union [Lazy Approach]
 */
public class QuickUnionUF {
    private int[] id;
    
    //set id of each id to itself
    public QuickUnionUF(int N)
    {
        id = new int[N];
        for (int i=0; i<N;i++){
            id[i]=i;
        }
    }
    
    //chase parent pointers until reach root
    private int root(int i)
    {
        while(i != id[i])
        {
            i=id[i];
        }
        return i;
    }
    
    //check if p and q has same root
    public boolean connected(int p, int q)
    {
        return root(p)== root(q);
    }
    
    //change root of p to pointto root of q
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
    
    public static void main(String[] args) 
           {

               Scanner reader = new Scanner(System.in);
               int N = reader.nextInt();
               
               QuickUnionUF uf = new QuickUnionUF(N);
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
