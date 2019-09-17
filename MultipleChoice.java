/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.choice;
import java.util.Scanner;

/**
 *
 * @author Franklin
 */
public class MultipleChoice {

    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int number = s.nextInt();
    char[] answers;
    int poop=0;
    answers= new char[10000];
    for(int i =0; i<number; i++){
    answers [i]=s.next().charAt(0);
    }
    char[] canswers;
    canswers= new char[10000];
    for(int i =0; i<number; i++){
    canswers [i]=s.next().charAt(0);
    }
    for (int k=0; k<number; k++){
    if(answers[k]==canswers[k]){
    poop++;
    }
    }
    System.out.println(poop);
    }
    
}
