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
public class TruckingTroubles {
    //Within 64M
    public static boolean[] mstSet;
    public static int[] MaxCost;
    public static int[] parent;
    public static int V;

    public static class Edge {

        int ev;
        int cost;

        public Edge(int ev, int cost) {
            this.ev = ev;
            this.cost = cost;

        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        V = s.nextInt();
        int E = s.nextInt();
        int d = s.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < E; i++) {
            int bv = s.nextInt() - 1;
            int ev = s.nextInt() - 1;
            int cost = s.nextInt();
            graph[bv].add(new Edge(ev, cost));
            graph[ev].add(new Edge(bv, cost));
        }
        int[] dest = new int[V];
        for (int i = 0; i < d; i++) {
            dest[i] = s.nextInt() - 1;
        }

        parent = new int[V];
        mstSet = new boolean[V];
        MaxCost = new int[V];

        //Set Parents to no parent, mstSet is false, and MaxCost is at max cost
        Arrays.fill(parent, -1);
        Arrays.fill(MaxCost, Integer.MIN_VALUE);

        //starting value
        MaxCost[0] = Integer.MAX_VALUE;

        while (true) {
            int next = findNext();
            //no next vertex
            if (next == -1) {
                break;
            }
            mstSet[next] = true;

            //find neighbor edge and update MaxCost and parent table
            for (Edge e : graph[next]) {
                if (mstSet[e.ev] == false && MaxCost[e.ev] < e.cost) {
                    MaxCost[e.ev] = e.cost;
                    parent[e.ev] = next;
                }
            }

        }

        int smallest = 100000;
        boolean vis[] = new boolean[V];
        vis[0] = true;
        for (int i = 0; i < d; i++) {
            int crnt = dest[i];
            while (!vis[crnt]) {
                smallest = Math.min(smallest, MaxCost[crnt]);
                vis[crnt] = true;
                crnt = parent[crnt];
            }

        }
        System.out.println(smallest);

    }

    public static int findNext() {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < V; i++) {
            if (mstSet[i] == false && MaxCost[i] > max) {
                max = MaxCost[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    
    /* Memory Out of Bounds Error
    public static boolean[] mstSet;
    public static int[] MaxCost;
    public static int[] parent;
    public static int V;
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        V = s.nextInt();
        int E = s.nextInt();
        int d = s.nextInt();
        int[][] graph = new int[V][V];
        for(int i = 0; i<E; i++){
            int bv = s.nextInt()-1;
            int ev = s.nextInt()-1;
            int cost = s.nextInt();
            graph[bv][ev]=cost;
            graph[ev][bv]=cost;
        }
        
        int[] dest = new int[V];
        for(int i = 0; i<d; i++){
            dest[i]=s.nextInt()-1;
        }
        
        parent = new int[V];
        mstSet = new boolean[V];
        MaxCost = new int[V];
        
        //Set Parents to no parent, mstSet is false, and MaxCost is at max cost
        Arrays.fill(parent, -1);
        Arrays.fill(MaxCost, Integer.MIN_VALUE);
        
        //starting value
        MaxCost[0]=Integer.MAX_VALUE;
        
        while(true){
            int next = findNext();
            //no next vertex
            if(next==-1){
                break;
            }
            mstSet[next] = true;
            
            //find neighbor edge and update MaxCost and parent table
            for (int i = 0; i<V; i++){
                if(mstSet[i]==false && graph[next][i]!=0 && MaxCost[i]<graph[next][i]){
                    MaxCost[i]=graph[next][i];
                    parent[i]=next;
                }
            }
            
        }
        int smallest = 100000;
        boolean vis[] = new boolean[V];
        vis[0]=true;
        for(int i = 0; i<d; i++){
            int crnt = dest[i];
            while(!vis[crnt]){
                smallest = Math.min(smallest, MaxCost[crnt]);
                vis[crnt]=true;
                crnt = parent[crnt];
            }
            
        }
        System.out.println(smallest);
        
    }
    
    public static int findNext(){
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i<V; i++){
            if(mstSet[i]==false && MaxCost[i]>max){
                max = MaxCost[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    } 
     */
}
