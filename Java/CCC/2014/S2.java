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
public class AssigningPartners {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int students = s.nextInt();
        ArrayList<String> p1 = new ArrayList<String>();
        ArrayList<String> p2 = new ArrayList<String>();
        for (int i = 0; i < students; i++) {
            p1.add(s.next());
        }
        for (int i = 0; i < students; i++) {
            p2.add(s.next());
        }
        for (int i = 0; i < students; i++) {
            if(!p1.get(i).equals(p2.get(i))){
                
                if(!p2.get(p1.indexOf(p2.get(i))).equals(p1.get(i))){
                    System.out.println("bad");
                    return;
                }
            }else{
                System.out.println("bad");
                return;
            }
        }
        System.out.println("good");
    }
}
