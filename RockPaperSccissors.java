/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpapersccissors;
import java.util.Scanner;
/**
 *
 * @author frank
 */
public class RockPaperSccissors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int rounds = Integer.parseInt(s.nextLine());
        int Alice = 0;
        int Bob = 0;
        String alice = s.nextLine();
        String bob = s.nextLine();
        String[] parts;
        parts = alice.split("\\s+");
        String[] parts1;
        parts1 = bob.split("\\s+");
        for(int i = 0; i<rounds; i++){
            if("rock".equals(parts[i])){
                if("scissors".equals(parts1[i])){
                    Alice++;
                }else if ("paper".equals(parts1[i])){
                    Bob++;
                }
                
            }else if("scissors".equals(parts[i])){
                if("rock".equals(parts1[i])){
                    Bob++;
                }else if ("paper".equals(parts1[i])){
                    Alice++;
                }
            }else{
                if("rock".equals(parts1[i])){
                    Alice++;
                }else if ("scissors".equals(parts1[i])){
                    Bob++;
                }
            }
                
        }
        System.out.println(Alice + " " + Bob);
        
    }
    
}
