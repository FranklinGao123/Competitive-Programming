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
public class MinimumCostFlow {
     public static int[] parent;
    public static class Edge implements Comparable<Edge> {
        int bv;
        int ev;
        int cost;
        int active;     //0 represent active     1 represent inactive
        public Edge(int bv, int ev, int cost, int active) {
            this.bv = bv;
            this.ev = ev;
            this.cost = cost;
            this.active = active;
        }
        @Override
        public int compareTo(Edge o) {
            if (this.cost>o.cost) {
                return 1;
            } else if (this.cost<o.cost) {
                return -1;
            } else {
                if (this.active<o.active) {
                    return -1;
                } else if (this.active>o.active) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //      5 6 2     N is vertice amount       M is Edge amount     D enhancer
        //      1 2 5
        //      2 3 5
        //      1 4 5
        //      4 5 5
        //      1 3 1
        //      1 5 1
 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //V
        int M = sc.nextInt();   //E
        int D = sc.nextInt();   //enhancer
        Edge[] edges = new Edge[M];
        //input M edges
        for (int i=0; i<M; i++) {
            int bv = sc.nextInt()-1;
            int ev = sc.nextInt()-1;
            int cost = sc.nextInt();
            int active = 1;
            if (i<N-1) {
                active = 0;
            }
            edges[i] = new Edge(bv,ev,cost,active);
        }
        Arrays.sort(edges);
        //sort the edge array
 
        parent = new int[N];
        Arrays.fill(parent, -1);
 
        int day = 0;
        int lastActive = 0;    //check the last pipe active mode
        int lastCost = 0;
        int index = 0;
        //Read edge one by one from edges array
        for (int i=0; i<M; i++) {
            int pb = find(edges[i].bv);
            int pe = find(edges[i].ev);
            if (pb!=pe) {
                //Add into tree
                union(pb,pe);
                day += edges[i].active;   //how many inactive pipe
                index++;
                if (index==N-1) {
                    lastActive = edges[i].active;
                    lastCost = edges[i].cost;
                    break;
                }
            }  
        }
        if (lastActive==1) {
            Arrays.fill(parent, -1);
            for (int i=0; i<M; i++) {
                int pb = find(edges[i].bv);
                int pe = find(edges[i].ev);
                if (pb!=pe) {
                    //Add into tree
                    if (edges[i].cost<lastCost || (edges[i].cost==lastCost && edges[i].active==0)) {
                        union(pb,pe);
                        index++;
                    } else if (edges[i].cost>lastCost && edges[i].active==0 && edges[i].cost<=D){  
                        //replace this one with last one
                        day--;
                        break;
                    }
                }  
            }
        }
        System.out.println(day);
        //if lastActive equals to inactive
        //we can enhance an edge which using enhancer to
        //reduce to cost to 0 to replace the last pipe
 
        //1 2 3 4 5              10      6
 
        //1 2 3 4    6           10
    }
 
    public static int find(int v) {
        if (parent[v]==-1) {
            return v;
        } else {
            return parent[v] = find(parent[v]);
        }
    }
    public static void union(int pb, int pe) {
        parent[pb] = pe;
    }
}
