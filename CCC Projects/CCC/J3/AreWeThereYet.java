/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package are.we.there.yet;
import java.util.Scanner;
/**
 *
 * @author frank
 */
public class AreWeThereYet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int d1 = s.nextInt();
        int d2 = s.nextInt();
        int d3 = s.nextInt();
        int d4 = s.nextInt();
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int c5 = 0;
        for(int i = 0; i<5;i++){
            if(i==0){
                c1=0;
                c2=d1;
                c3=d1+d2;
                c4=d1+d2+d3;
                c5=d1+d2+d3+d4;
            }else if(i==1){
                c2=0;
                c1=d1;
                c3=d2;
                c4=d2+d3;
                c5=d2+d3+d4;
            }else if(i==2){
                c3=0;
                c2=d2;
                c1=d1+d2;
                c4=d3;
                c5=d3+d4;
            }else if (i==3){
                c4=0;
                c5=d4;
                c1=d1+d2+d3;
                c3=d3;
                c2=d3+d2;
            }else{
                c3=d4+d3;
                c2=d4+d2+d3;
                c1=d1+d2+d3+d4;
                c4=d4;
                c5=0;
            }
            System.out.println(c1 + " " + c2 + " " + c3 + " " + c4 + " " + c5);
        }
        
        
    }
    
}
