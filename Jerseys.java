/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author frank
 */
public class Jerseys {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int jersey = s.nextInt();
        int athletes = s.nextInt();
        char[] jerseys = new char[jersey];
        int answer = 0;
        ArrayList<Integer> number = new ArrayList<Integer>();
        for(int i = 0; i<jersey; i++){
            jerseys[i]=s.next().charAt(0);
        }
        for(int i = 0; i<athletes; i++){
            char size = s.next().charAt(0);
            int index = s.nextInt();
            if(size=='L'){
                if(jerseys[index-1]=='L'){
                    answer++;
                    jerseys[index-1]='N';
                    
                }
            }else if(size=='M'){
                if(jerseys[index-1]=='L' || jerseys[index-1]=='M'){
                    answer++;
                    jerseys[index-1]='N';
                }
            }else{
                if(jerseys[index-1]!='N'){
                    answer++;
                    jerseys[index-1]='N';
                    
                }
            }
            
        }
        System.out.println(answer);
    }
}
