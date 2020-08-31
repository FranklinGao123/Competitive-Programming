/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author frank
 */
public class SurmisingASprintersSpeed {
    public static class position implements Comparable<position>{
        double position;
        double time;
        
        position(double time, double position){
            this.position=position;
            this.time = time;
        }
        
        @Override
        public int compareTo(position o){
            if(this.time>o.time){
                return 1;
            }else if(this.time<o.time){
                return -1;
            }else{
                return 0;
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        double n = s.nextInt();
        ArrayList<position> values = new ArrayList<position>();
        //position[] values = new position[n]; 
        for (long i = 0; i<n; i++ ){
            double time = s.nextInt();
            double position = s.nextInt();
            values.add( new position(time,position));
        }
        values.sort(null);
        double min = Integer.MIN_VALUE;
        for(int i = 1; i<n; i++){
            min = Math.max(min, Math.abs(values.get(i).position-values.get(i-1).position)/(values.get(i).time-values.get(i-1).time));
        }
        System.out.println(min);
    }
}
