/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canadian.calorie.counting;
import java.util.Scanner;
/**
 *
 * @author Franklin
 */
public class CanadianCalorieCounting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int total = 0;
        int first = s.nextInt();
        switch(first){
            case 1: first = 1;
                total+=461;
                break;
            case 2: first = 2;
                total+=431;
                break;
            case 3: first = 3;
                total+=420;
                break;
        }
        int second = s.nextInt();
        int third = s.nextInt();
        switch(third){
            case 1: third = 1;
                total+=130;
                break;
            case 2: third = 2;
                total+=160;
                break;
            case 3: third = 3;
                total+=118;
                break;
        }
        switch(second){
            case 1: second = 1;
                total+=100;
                break;
            case 2: second = 2;
                total+=57;
                break;
            case 3: second = 3;
                total+=70;
                break;
        }
        int fourth = s.nextInt();
        switch(fourth){
            case 1: fourth = 1;
                total+=167;
                break;
            case 2: fourth = 2;
                total+=266;
                break;
            case 3: fourth = 3;
                total+=75;
                break;
        }
        System.out.println("Your total Calorie count is "+total+".");
        
    }
    
}
