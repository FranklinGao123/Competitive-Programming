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
public class AliceThroughTheLookingGlass {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i = 0; i<n; i++){
            int mag = s.nextInt();
            long x = s.nextInt();
            long y = s.nextInt();
            if(find(x,y,mag))
                System.out.println("crystal");
            else
                System.out.println("empty");
        }
    }
    public static boolean find(long x, long y, int mag){
        int c = (int) Math.pow(5, mag-1);
        if(x/c==0 ||x/c==4 || ((y/c>=1)&&(x/c==1 ||x/c==3)&& mag==1) || ((x/c==2)&&(y/c>2)&&mag!=1) || ((y/c>1)&&(x/c==1 ||x/c==3)&& mag!=1) || ((x/c==2)&&(y/c>=2)&&mag==1)){
            return false;
        }else if ((y/c==0 && (x/c>0 && x/c<4))||(y/c==1 && x/c==2)){
            return true;
        }else{
           return find(x%c,y%c,mag-1); 
        }
    }
}
