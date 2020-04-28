/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Scanner;

/**
 *
 * @author Anika Tanzim
 * 3 Sums - Brute Force algorithm
 */
public class brute_force_alogorithm {
    public static int count(int[] a){
        
        int N = a.length;
        int count = 0;
        for(int i =0; i<N;i++){
            for(int j=i+1;j<N;j++){
                for(int k=j+1;k<N;k++){
                    if(a[i]+a[j]+a[k]==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int[] a =new int[N];
        for(int i=0;i<N;i++){
            int m = reader.nextInt();
            a[i]=m;
        }
        System.out.println(count(a));
    }
}
