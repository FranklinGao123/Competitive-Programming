/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;

import java.util.*;
import java.io.*;

/**
 *
 * @author frank
 */
public class SlotMachines {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int Number = s.nextInt();
        int Slot1 = s.nextInt();
        int Slot2 = s.nextInt();
        int Slot3 = s.nextInt();
        int poop = 0;
        while (Number > 0) {
            Number--;
            Slot1++;
            if (Slot1 % 35 == 0) {
                Slot1 = 0;
                Number = Number + 30;
                poop++;
            } else {

                poop++;
            }
            if (Number == 0) {
                break;
            }
            Number--;
            Slot2++;
            if (Slot2 % 100 == 0) {
                Slot2 = 0;
                Number = Number + 60;
                poop++;
            } else {

                poop++;
            }
            if (Number == 0) {
                break;
            }
            Number--;
            Slot3++;
            if (Slot3 % 10 == 0) {
                Slot3 = 0;
                Number = Number + 9;
                poop++;
            } else {

                poop++;
            }
        }
        System.out.println("Martha plays " + poop + " times before going broke.");
    }
}
