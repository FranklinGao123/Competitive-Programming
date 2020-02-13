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
public class BridgeTransport {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int max = s.nextInt();
        int num = s.nextInt();
        int[] cars = new int[num];
        int size = 0;
        int maxCar = 0;
        for(int i = 0; i<num; i++){
            cars[i]=s.nextInt();
        }
        for(int i = 0; i<num; i++){
            if(i>3){
                size-=cars[i-4];
            }
            size+=cars[i];
            if(size<=max){
                maxCar++;
            }else{
                break;
            }
        }
            System.out.println(maxCar);
    }
}
