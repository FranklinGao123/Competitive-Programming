/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;

import java.io.*;
import java.util.*;

/**
 *
 * @author frank
 */
public class TinCanTelephone {

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

    public static class Vector {

        int x;
        int y;

        public Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int crossProduct(Vector v1, Vector v2, Vector v3) {
        /* 
        0 means v1 v2 v3 are parallel
        <0 means v1v2 are counterclockwise
        >0 means v1v3 are clockwise
         */

        return (v2.x - v1.x) * (v3.y - v1.y) - (v3.x - v1.x) * (v2.y - v1.y);
    }

    static boolean Intersect(Vector start, Vector end, Vector left, Vector right) {
        if (start.equals(left) || start.equals(right) || end.equals(left) || end.equals(right)) {
            return false;
        }
        boolean cross = false;
        int a = crossProduct(start, end, left);

        int b = crossProduct(start, end, right);
        if (a * b < 0 || a == 0 || b == 0) {
            cross = true;
        }

        a = crossProduct(left, right, end);
        b = crossProduct(left, right, start);
        if (a * b < 0) {
            if (cross) {
                return false;
            }

        }

        Vector rand = new Vector((int) ((Math.random() * 2000) - 1000), (int) ((Math.random() * 2000) - 1000));
        while (crossProduct(start, end, rand) == 0) {
            rand = new Vector((int) ((Math.random() * 2000) - 1000), (int) ((Math.random() * 2000) - 1000));
        }
        if ((a == 0 && crossProduct(rand, left, end) * crossProduct(rand, right, end) < 0) || (b == 0 && crossProduct(rand, left, start) * crossProduct(rand, right, start) < 0)) {
            return false;
        }

        return true;
    }

    static boolean Cross(Vector start, Vector end, Vector[] next) {

        Vector[] points = next;
        if (!Intersect(start, end, points[0], points[points.length - 1])) {
            return false;
        }
        for (int count = 0; count < points.length - 1; count++) {
            if (!Intersect(start, end, points[count], points[count + 1])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        int startX = nextInt();
        int startY = nextInt();
        int endX = nextInt();
        int endY = nextInt();
        int buildings = nextInt();
        Vector start = new Vector(startX, startY);
        Vector end = new Vector(endX, endY);
        int answer = 0;
        for (int i = 0; i < buildings; i++) {
            int corners = nextInt();
            Vector[] arr = new Vector[corners];
            for (int c = 0; c < corners; c++) {
                int x = nextInt();
                int y = nextInt();
                arr[c] = new Vector(x, y);
            }
            if (!Cross(start, end, arr)) {
                answer++;
            }

        }
        System.out.println(answer);
    }
}
