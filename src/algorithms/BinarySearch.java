/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import static algorithms.brute_force_alogorithm.count;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class BinarySearch {
    public static int binarySearch(int[] a, int key){
        int lo =0;
        int hi =a.length-1;
        while(lo<=hi){
            int mid=lo+ (hi-lo)/2;
            if(key<a[mid]){
                hi =mid-1;
                
            }
            else if(key>a[mid]){
                lo=mid+1;
                
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int[] a =new int[N];
        for(int i=0;i<N;i++){
            int m = reader.nextInt();
            a[i]=m;
        }
        System.out.println("enter key: ");
        int key = reader.nextInt();
        System.out.println(binarySearch(a,key));
    }
}
