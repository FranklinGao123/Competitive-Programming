/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetodecompress;
import java.util.Scanner;
/**
 *
 * @author 665937
 */
public class ColdCompress {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int times = Integer.valueOf(s.nextLine());
        String line;
        String[] answer = new String[times];
        for(int i = 0; i<times; i++){
            answer[i] = "";
            int counter = 1;
            line = s.nextLine();
            for(int p = 1; p<line.length(); p++){
                if(p!=line.length()-1){
                if(line.charAt(p)==line.charAt(p-1)){
                    counter++;
                }
                else{
                    answer[i] += counter  + " " + line.charAt(p-1) + " ";
                    counter = 1;
                    
                }
                }else{
                    if(line.charAt(p)==line.charAt(p-1)){
                        counter++;
                        answer[i] += counter  + " " + line.charAt(p-1);
                    counter = 1;
                    }else{
                    answer[i] += counter  + " " + line.charAt(p-1) + " ";
                    counter = 1;
                    answer[i] += counter  + " " + line.charAt(p);
                    counter = 1;
                    
                    }
                    
                }
                
            }
            
        }
        for(int i = 0; i<times; i++){
            System.out.println(answer[i]);
        }
    }
}
