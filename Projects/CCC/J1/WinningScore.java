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
public class WinningScore {
    public static void main(String[] main){
        Scanner s = new Scanner(System.in);
        int suma = 0;
        int sumb = 0;
        suma += s.nextInt()*3;
        suma += s.nextInt()*2;
        suma += s.nextInt();
    sumb += s.nextInt()*3;
    sumb += s.nextInt()*2;
    sumb += s.nextInt();
    if(suma>sumb)
        System.out.println("A");
    else if (suma<sumb)
        System.out.println("B");
    else
        System.out.println("T");
    }
}
