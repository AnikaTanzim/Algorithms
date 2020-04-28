/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Anika tanzim
 * interview question 02
 */

public class FindLargestUF  {
    private int id[]; // id[i] = parent of node i
    private int sz[]; // sz[i] = size of node i
    private int large[]; // large[i] = largest element in component
    
    public FindLargestUF (int N) {
        id = new int[N];
        sz = new int[N];
        large = new int[N];
        for (int i = 0; i < N; ++i) {
            id[i] = i;
            sz[i] = 1;
            large[i] = i;
        }
    }
    
    private int root(int p) {
        while (id[p] != p) {
            id[p] = id[id[p]]; // path compression
            p = id[p];
        }
        return p;
    }
    
    // return the largest element in the connected component containing p
    public int find(int p) { 
        return large[root(p)];
    }
    
    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (rootp == rootq) return;
        int largestP = large[rootp];
        int largestQ = large[rootq];
        if (sz[rootp] < sz[rootq]) {
            id[rootp] = rootq;
            sz[rootq] += sz[rootp];
            
            if (largestP > largestQ)
                large[rootq] = largestP;
        } else {
            id[rootq] = rootp;
            sz[rootp] += sz[rootq];
            
            if (largestQ > largestP)
                large[rootp] = largestQ;
        }
    }
    
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    
    public static void main(String[] args) {
        FindLargestUF  uf = new FindLargestUF (10);
        uf.union(0, 2);
        uf.union(8, 4);
        System.out.println(uf.find(0) == 2);
        System.out.println(uf.find(4) == 8);
        uf.union(0, 4);
        System.out.println(uf.find(0) == 8);
        System.out.println(uf.find(2) == 8);
        uf.union(0, 6);
        System.out.println(uf.find(6) == 8);
        uf.union(1, 9);
        uf.union(1, 2);
        System.out.println(uf.find(4) == 9);
    }
    
}