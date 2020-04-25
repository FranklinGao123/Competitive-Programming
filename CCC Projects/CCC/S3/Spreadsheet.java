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
public class Spreadsheet {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine().trim());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static String nextLine() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine().trim());
        }
        return st.nextToken();
    }

    static int[][] graph = new int[10][9];
    static String[][] com = new String[10][9];

    static int solve(int i, int c) { // -2 == N/A
        if (graph[i][c] >= 0) {
            return graph[i][c];
        }
        if (graph[i][c] == -2) {
            return -2;
        }
        String[] commands = com[i][c].split("\\+");
        int answer = 0;
        graph[i][c] = -2;
        for (int j = 0; j < commands.length; j++) {
            int nextX = commands[j].charAt(0) - 'A';
            int nextY = commands[j].charAt(1) - '1';
            int temp = solve(nextX, nextY);
            if (temp == -2) {
                return -2;
            }
            answer += temp;
        }
        graph[i][c] = answer;
        return answer;

    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            for (int c = 0; c < 9; c++) {
                String A = nextLine();
                char a = A.charAt(0);
                if (a >= 48 && a <= 57) {
                    graph[i][c] = Integer.parseInt(A);
                } else {
                    graph[i][c] = -1;
                    com[i][c] = A;

                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int c = 0; c < 9; c++) {
                if (graph[i][c] >= 0) {
                    System.out.print(graph[i][c]);
                } else {
                    graph[i][c] = solve(i, c);
                    if (graph[i][c] == -2) {
                        System.out.print("*");
                    }else{
                        System.out.print(graph[i][c]);
                    }
                }
                if (c != 8) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
