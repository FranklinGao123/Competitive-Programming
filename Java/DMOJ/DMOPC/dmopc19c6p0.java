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
public class dmopc19c6p0 {

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

    public static void main(String[] args) throws IOException {
        int sides[] = new int[3];
        for (int i = 0; i < 3; i++) {
            sides[i] = nextInt();
        }
        Arrays.sort(sides);
        if (sides[2] < sides[1] + sides[0]) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
