// Reference: An algorithm to generate all topological sorting arrangement
// Y.L Varol and D.Rotem
// github link: https://github.com/herohunfer/topsort 
// For output, check output.txt
// Writtern by Yan Wang, Oct 2012

import java.util.*;
public class topsort {
    public static void main (String [] args) {
        final int s = 12;
        // {row1, row2, row3}
        // m: map for the relationship. only need set part of the total orders
        // like if 1 < 2 and 2 < 3, that means 1R2=1 and 2R3=1. dont bother set 1R3. 
        // for nRn, set it equal to 0 or 1. both correct.
        // for end marker n, 1Rn = 1. dont bother set nR1. 
                     //  0  1  2  3  4  5  6  7  8  9 10 11
        int [][] m = {  //0
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1}, 
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                        // 5
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        //10
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int [] p = {0, 1, 2, 3, 4, 5, 6, 7 ,8, 9, 10, 11};
        int counter = 1;
        int i = 0, k = 0, k1 = 0, obj_k, obj_k1;
        int [] loc = {0, 1, 2, 3, 4, 5 ,6, 7, 8, 9, 10, 11};
        //initiate
        System.out.println(Arrays.toString(p));
        //System.out.println(m[0][2]);
        while (i < s-1) {
            k = loc[i];
            k1 = k + 1;
            obj_k = p[k];
            obj_k1 = p[k1];
            if (m[i][obj_k1] == 1) {
                for (int l = k; l >= i+1; l--) 
                    p[l] = p[l-1];
                p[i] = obj_k;
                loc[i] = i; 
                i = i+1;
            } else {
                p[k] = obj_k1;
                p[k1] = obj_k;
                loc[i] = k1;
                i = 0;
                counter++;
                System.out.println(Arrays.toString(p));
            }
        }
        System.out.println("counter = " + counter);
    }
}
