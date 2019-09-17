/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author frank
 */
public class TheGenevaConfection {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   //How many test case
        //repeat T times
        for (int j=0; j<T; j++) {
            int N = sc.nextInt();   //How many cars
            Stack<Integer> top = new Stack<Integer>();
            for (int i=0; i<N; i++) {
                top.add(sc.nextInt());
            }
 
            Stack<Integer> branch = new Stack<Integer>();
 
            int lake = 0;
            while (!top.isEmpty()) {
                int nextTop = top.pop();   //read one from top
                if (nextTop==lake+1) {
                    lake++;     //dump the car into lake
                } else {
                    while (!branch.isEmpty()) {
                        int nextBranch = branch.peek();  //not remove
                        if (nextBranch==lake+1) {
                            //start to slide car from branch to lake
                            branch.pop();  //remove
                            lake++;
                        } else {
                            break;
                        }
                    }
                    branch.add(nextTop);
                }
            }
 
            while (!branch.isEmpty()) {
                int nextBranch = branch.peek();  //not remove
                if (nextBranch==lake+1) {
                    //start to slide car from branch to lake
                    branch.pop();  //remove
                    lake++;
                } else {
                    break;
                }
            }
 
            if (branch.isEmpty()) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
    }
}
