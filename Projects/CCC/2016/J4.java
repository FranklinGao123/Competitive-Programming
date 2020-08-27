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
public class ArrivalTime {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String time = s.nextLine();
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]); // 004
        int min = Integer.parseInt(parts[1]); // 034556
        for(int i = 0; i<120; i++){
            min++;
            if((hour>=7 && hour<10)||(hour>=15&&hour<19)){
                min++;
            }
            if(min>=60){
                hour++;
                min=0;
            }
            if(hour>=24){
                hour-=24;
            }
        }
        if(hour>=10){
            if(min>=10){
                System.out.println(hour+":"+min);
            }else{
                System.out.println(hour+":"+"0"+min);
            }
        }else{
            if(min>=10){
                System.out.println("0"+hour+":"+min);
            }else{
                System.out.println("0"+hour+":"+"0"+min);
            }
            
        }
    }
}
