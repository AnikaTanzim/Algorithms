
package algorithms;

import java.util.Scanner;

/**
 *
 * @author Anika Tanzim
 * Quick Find [ Eager Approach ]
 */
public class QuickFindUF {
    private int[] id;
    
    //set id each other to itself
    public QuickFindUF(int N)
    {
        id = new int[N];
        for(int i=0;i<N;i++)
        {
            id[i]=i;
        }
    }
    
    //check if same component
    public boolean connected(int p, int q)
    {
        return id[p] == id[q];
    }
    
    //check all entries
    public void union(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];
        for(int  i=0; i<id.length;i++)
        {
            if(id[i] == pid)
            {
                id[i] = qid;
            }
        }
    }
  
    public static void main(String[] args) 
           {

               Scanner reader = new Scanner(System.in);
               int N = reader.nextInt();
               
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

