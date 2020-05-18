/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Anika Tanzim
 * 3 sum in a quadratic time
 */
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

class ThreeSum {

public static void main(String[] args) {

// initialize array
ArrayList<Integer> data = new ArrayList<Integer>();
Scanner scan = new Scanner(System.in);
while (scan.hasNextInt()) {
data.add(scan.nextInt());
}

// sort array
Collections.sort(data);

// compute all 3-sum combinations
for (int i = 0; i < data.size()-2; ++i) {
int j = i+1;
int k = data.size()-1;

while (j < k) {
int sum = data.get(i)+data.get(j)+data.get(k);
if (sum == 0) {
System.out.println(i+":"+data.get(i)+", "+j+":"+data.get(j)+", "+k+":"+data.get(k));
}
if (sum >= 0) {
--k;
} else {
++j;
}
}
}

}

}
