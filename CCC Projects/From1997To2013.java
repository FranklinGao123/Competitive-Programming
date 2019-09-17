/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from1997to2013;
import java.util.Scanner;
/**
 *
 * @author frank
 */
public class From1997To2013 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int year = s.nextInt();
        boolean end = false;
        while (end==false){
            year++;
            int length = String.valueOf(year).length();
            if (length == 4){
                String number = String.valueOf(year);
                if(number.charAt(1) != number.charAt(0) && number.charAt(2) != number.charAt(1) && number.charAt(3) != number.charAt(2)  && number.charAt(3) != number.charAt(1)  && number.charAt(3) != number.charAt(0)  && number.charAt(2) != number.charAt(0))
                    break;
            } else if (length == 3){
                String number = String.valueOf(year);
                if(number.charAt(1) != number.charAt(0) && number.charAt(2) != number.charAt(1)  && number.charAt(2) != number.charAt(0))
                    break;
            } else if (length == 2){
                String number = String.valueOf(year);
                if(number.charAt(1) != number.charAt(0))
                    break;
            } else if (length == 5){
                String number = String.valueOf(year);
                if(number.charAt(1) != number.charAt(0) && number.charAt(2) != number.charAt(1) && number.charAt(3) != number.charAt(2)  && number.charAt(3) != number.charAt(1)  && number.charAt(3) != number.charAt(0)  && number.charAt(2) != number.charAt(0) && number.charAt(4) != number.charAt(3) && number.charAt(4) != number.charAt(2) && number.charAt(4) != number.charAt(1)&& number.charAt(4) != number.charAt(0))
                    break;            
            }else{
                    break;
            }
        }
        System.out.println(year);
        
        
    }
    
}
