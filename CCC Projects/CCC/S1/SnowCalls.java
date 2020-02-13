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
public class SnowCalls {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i = 0; i<n; i++){
            int count = 0;
            int c2 = 0;
            String temp = s.next();
            char[] b = new char[10];
            while(c2<temp.length()){
                if(count >9)
                    break;
                else{
                    char a = temp.charAt(c2);
                    if((int)a>47 && (int)a<58){
                        b[count]=a;
                        count++;
                    }else if((int)a>64 && (int)a<91){
                        int c = (int)a - 65;
                        if(c>14){
                            c-=15;
                            if(c<4){
                                c=55;
                            }else if(c<7){
                                c=56;
                            }else{
                                c=57;
                            }
                        }else{
                            c/=3;
                            c+=50;
                        }
                        b[count]=(char)c;
                        count++;
                    }
                    c2++;
                }
                
            }
            System.out.print(b[0]);
            System.out.print(b[1]);
            System.out.print(b[2]);
            System.out.print('-');
            System.out.print(b[3]);
            System.out.print(b[4]);
            System.out.print(b[5]);
            System.out.print('-');
            System.out.print(b[6]);
            System.out.print(b[7]);
            System.out.print(b[8]);
            System.out.println(b[9]);
        }
    }
}
