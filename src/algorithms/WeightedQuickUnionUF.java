package algorithms;

import java.util.Scanner;


/**
 *
 * @author Anika Tanzim
 * Quick Union Improvements
 * Weighted quick Union
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz; 
    //set id of each id to itself
    public WeightedQuickUnionUF(int N)
    {
        id = new int[N];
        sz = new int[N];
        for (int i=0; i<N;i++){
            id[i]=i;
            sz[i] = 1;
        }
        
    }
    
    //chase parent pointers until reach root
    private int root(int i)
    {
        while(i != id[i])
        {
            id[i]= id[id[i]];   //path copression
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
        if(i==j) return;
        if(sz[i]<sz[j])
        {
            id[i]=j;
            sz[j]+=sz[i];
        }
        else
        {
            id[j]=i;
            sz[i]+=sz[j];
        }
    }
    
    public static void main(String[] args) 
           {

               Scanner reader = new Scanner(System.in);
               int N = reader.nextInt();
               
               WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
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
