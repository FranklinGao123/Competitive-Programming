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
public class BodyMassIndex {
     public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        float w = s.nextFloat();
        float h = s.nextFloat();
        if(w/(h*h)<18.5)
            System.out.println("Underweight");
        else if(w/(h*h)>=18.5 && w/(h*h)<=25.0)
            System.out.println("Normal weight");
        else
            System.out.println("Overweight");
    }
}
