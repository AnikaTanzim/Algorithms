
package algorithms;

import java.util.Scanner;

/**
 *
 * @author Anika tanzim
 * interview question 01 
 */
public class SocialNetworkConnectivity {


    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        String date, time;
        //timestamps are sorted ascending
        while (reader.hasNext()) {

            int p = reader.nextInt();
            int q = reader.nextInt();
            date = reader.nextLine();
            time = reader.nextLine();


            uf.union(p, q);

            System.out.println("["+p+","+q+"]");

            if(uf.connected(p, q)){
                System.out.println("All members were connected at: " + date + time);
                break;
            }

        }
    }
}
