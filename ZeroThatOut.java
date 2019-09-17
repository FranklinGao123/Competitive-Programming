/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zero.that.out;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Franklin
 */
public class ZeroThatOut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        int sum=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i<length; i++){
            
            int a = s.nextInt();
            if(a==0){
                
                list.remove(i-1);
                i-=2;
                length-=2;

            }else
                list.add(a);
        }
        for (int i=0; i<list.size();i++){
            sum+=list.get(i);
        }
        System.out.println(sum);
    }
    
}
