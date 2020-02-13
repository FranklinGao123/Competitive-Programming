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
public class Squares {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        System.out.println("The largest square has side length " + (int)Math.sqrt(i)+".");
    }
}
