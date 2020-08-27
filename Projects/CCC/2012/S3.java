/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.*;
/**
 *
 * @author frank
 */
public class AbsolutelyAcidic {
     public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
        int[] c = new int[1001];
        int[] a = new int[1001];
        for(int i = 0; i<n; i++){
            int temp = s.nextInt();
            a[temp]++;
            c[temp]++;
        }
        int max = 0;
        int smax = 0;
        
        for(int i = 0; i<1001; i++){
            if(a[i]>max){
                max=a[i];
                c[i]=0;
            }
        }
        for(int i = 0; i<1001; i++){
            if(c[i]>smax){
                smax=c[i];
            }
        }
        for(int i = 0; i<1001; i++){
            if(a[i]==max){
                first.add(i);
            }
        }
        int indexMin = 0;
        for(int i = 0; i<1001; i++){
            if(a[i]==smax){
                second.add(i);
            }
        }
        int difference = -1;
        for (int r:first){
            for(int k:second){
                if(difference<Math.abs(k-r)){
                    difference = Math.abs(k-r);
                }
            }
        }
        System.out.println(difference);
    }
}
