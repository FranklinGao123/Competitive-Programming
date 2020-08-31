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
public class WaitTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int[] r = new int[101];
        int[] s = new int[101];
        int[] wait = new int[101];
        int time = 0;
        for (int i = 0; i<n; i++){
            String letter = sc.next();
            if(letter.equals("R")){
                time++;
                int person = sc.nextInt()-1;
                r[person] = time;
                s[person] = -1;
                
            }else if(letter.equals("W")){
                time+=sc.nextInt()-1;
            }else{
                time++;
                int person = sc.nextInt()-1;
                s[person] = time;
                wait[person] += time-r[person];
                
                
            }
            
        }
        for(int i = 0; i<101; i++){
            if(wait[i]!=0 && s[i]>0)
                System.out.println(i+1 + " " + wait[i]);
            else if (s[i]<r[i]&&r[i]>0){
                System.out.println(i+1 + " " + -1);
            }
        }
    }
}
