/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.Scanner;
/**
 *
 * @author frank
 */
public class SpeedFinesAreNotFine {
    public static void main(String[] args){
        Scanner s = new Scanner (System.in);
        int limit = s.nextInt();
        int speed = s.nextInt();
        if(speed>limit){
            if(speed-limit>=31){
                System.out.println("You are speeding and your fine is $500.");
            }else if (speed-limit<31&&speed-limit>20){
                System.out.println("You are speeding and your fine is $270.");
            }else{
                System.out.println("You are speeding and your fine is $100.");
            }
        }else{
            System.out.println("Congratulations, you are within the speed limit!");
        }
    }
}
