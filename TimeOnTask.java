/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeontask;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author Franklin
 */
public class TimeOnTask {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int time = s.nextInt();
        int number = s.nextInt();
        int[] pee;
        int number4=0;
        pee = new int [number];
        for (int poop = 0; poop<number; poop++){
            int number2 = s.nextInt();
            pee[poop]=number2;
        }
        Arrays.sort(pee);
        int hi=0;
        for (int fart=0; fart<number; fart++){
            int barf = pee[fart];
            if (barf+number4<=time){
                hi++;
                number4=barf+number4;
            }
        }
        System.out.println(hi);
    }
}
