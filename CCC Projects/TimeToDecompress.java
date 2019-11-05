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
public class TimeToDecompress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int times = Integer.valueOf(s.nextLine());
        String[] parts;
        String[] c = new String[times];
        String[] ca = new String[times];
        int[] na = new int[times];
        for(int i = 0; i<times; i++){
            c[i] = s.nextLine();
            parts = c[i].split("\\s+");
            na[i] = Integer.valueOf(parts[0]);
            ca[i] = parts[1];
            
        }
        for(int l = 0; l<times; l++){
            for(int o = 0; o<na[l]; o++){
                System.out.print(ca[l]);
            }
            System.out.println();
        }
    }
    
}
