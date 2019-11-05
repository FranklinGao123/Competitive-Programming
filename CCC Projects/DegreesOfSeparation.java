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
public class DegreesOfSeparation {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        boolean[][] map = new boolean[50][50];
        map[0][5] = true;
        map[5][0] = true;
        map[1][5] = true;
        map[5][1] = true;
        map[5][6] = true;
        map[6][5] = true;
        map[4][5] = true;
        map[5][4] = true;
        map[3][5] = true;
        map[5][3] = true;
        map[2][5] = true;
        map[5][2] = true;
        map[14][2] = true;
        map[2][14] = true;
        map[14][12] = true;
        map[12][14] = true;
        map[11][12] = true;
        map[12][11] = true;
        map[2][4] = true;
        map[4][2] = true;
        map[13][12] = true;
        map[12][13] = true;
        map[11][10] = true;
        map[10][11] = true;
        map[11][8] = true;
        map[8][11] = true;
        map[10][9] = true;
        map[9][10] = true;
        map[9][8] = true;
        map[8][9] = true;
        map[8][7] = true;
        map[7][8] = true;
        map[7][6] = true;
        map[6][7] = true;
        map[17][16] = true;
        map[16][17] = true;
        map[16][15] = true;
        map[15][16] = true;
        map[17][15] = true;
        map[15][17] = true;
        map[2][3] = true;
        map[3][2] = true;
        map[4][3] = true;
        map[3][4] = true;
        
        while (true){
            char decision = s.next().charAt(0);
            if(decision == 'q'){
                break;
            }else if (decision == 'i'){
                int x = s.nextInt()-1;
                int y = s.nextInt()-1;
                map[x][y] = true;
                map[y][x] = true;
            }else if (decision == 'd'){
                int x = s.nextInt()-1;
                int y = s.nextInt()-1;
                map[x][y] = false;
                map[y][x] = false;
            }else if (decision == 'n'){
                int person = s.nextInt()-1;
                int count = 0;
                for(int i = 0; i<50; i++){
                    if (map[person][i]==true){
                        count++;
                    }
                }
                System.out.println(count);
            }else if(decision == 'f'){
                int count = 0;
                int[] step = new int[50];
                Arrays.fill(step, Integer.MAX_VALUE);
                int person = s.nextInt()-1;
                LinkedList<Integer> queue = new LinkedList<Integer>();
                queue.add(person);
                step[person] = 0;
                while (!queue.isEmpty()){
                    int curP = queue.pop();
                    for(int i = 0; i<50; i++){
                        if(map[curP][i]==true){
                            if(step[i]>step[curP]+1){
                                step[i]=step[curP]+1;
                                queue.add(i);
                            }
                        }
                    }
                }
                
                for(int i = 0; i<50; i++){
                    if(step[i]==2)
                        count++;
                }
                System.out.println(count);
            }else if(decision == 's'){
                int[] step = new int[50];
                Arrays.fill(step, Integer.MAX_VALUE);
                int person = s.nextInt()-1;
                LinkedList<Integer> queue = new LinkedList<Integer>();
                queue.add(person);
                step[person] = 0;
                while (!queue.isEmpty()){
                    int curP = queue.pop();
                    for(int i = 0; i<50; i++){
                        if(map[curP][i]==true){
                            if(step[i]>step[curP]+1){
                                step[i]=step[curP]+1;
                                queue.add(i);
                            }
                        }
                    }
                }
                int y = s.nextInt()-1;
                if(step[y]!=Integer.MAX_VALUE){
                    System.out.println(step[y]);
                }else{
                    System.out.println("Not connected");
                }
            }
        }
        
    }
}
