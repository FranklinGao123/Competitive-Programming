/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occupied.parking;
import java.util.Scanner;
/**
 *
 * @author Franklin
 */
public class OccupiedParking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int spots = Integer.valueOf(s.nextLine());
        String yesterday = s.nextLine();
        String today = s.nextLine();
        int answer =0;
        for(int i = 0; i<spots; i++){
            if('C'==yesterday.charAt(i) && 'C'==(today.charAt(i)) && today.charAt(i)==yesterday.charAt(i))
                answer++;
        }
        System.out.println(answer);
        
    }
    
}
