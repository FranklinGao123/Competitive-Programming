/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keeping.score;
import java.util.Scanner;
/**
 *
 * @author frank
 */
public class KeepingScore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        String clubs = line.substring(1, line.indexOf('D'));
        System.out.println("Cards Dealt              Points");
        String diamonds = line.substring(line.indexOf('D')+1,line.indexOf('H'));
        String hearts = line.substring(line.indexOf('H')+1,line.indexOf('S'));
        String spades = line.substring(line.indexOf('S')+1);
        String[] hand = {clubs,diamonds,hearts,spades};
        int count = 0;
        int total = 0;
        for(int i = 0; i<4; i++){
            if(hand[i].length()==0)
                count+=3;
            else if (hand[i].length()==1)
                count+=2;
            else if (hand[i].length() == 2)
                count+=1;
            for(int p = 0; p < hand[i].length(); p++){
                if(hand[i].charAt(p)=='K')
                    count+=3;
                else if(hand[i].charAt(p)=='A')
                    count+=4;
                else if(hand[i].charAt(p)=='Q')
                    count+=2;
                else if(hand[i].charAt(p)=='J')
                    count+=1;
            }
            if(i==0)
                System.out.print("Clubs ");
            else if(i==1)
                System.out.print("Diamonds ");
            else if(i==2)
                System.out.print("Hearts ");
            else if(i==3)
                System.out.print("Spades ");
            for(int p = 0; p < hand[i].length(); p++){
                System.out.print(hand[i].charAt(p) + " ");
            }
            System.out.println("          " +count);
            total += count;
            count = 0;
        }
        System.out.println("Total " + total);
    }
    
}
