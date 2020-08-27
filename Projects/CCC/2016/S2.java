/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tandem.bicycle;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author Franklin
 */
public class TandemBicycle {

    /**
     * @param args the command line arguments
     */ 
   public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        String question = s.nextLine();
        int n = Integer.valueOf(s.nextLine());
        int[] dparts = new int[n];
        int[] pparts = new int[n];
        String[] partsd = new String[n];
        String[] partsp = new String[n];
        int total=0;
        String d= s.nextLine();
        String p = s.nextLine();
        partsd = d.split("\\s+");
        partsp = p.split("\\s+");
        for (int k = 0; k<n; k++){
            dparts[k] = Integer.valueOf(partsd[k]);
            pparts[k] = Integer.valueOf(partsp[k]);
        }
        Arrays.sort(dparts);
        Arrays.sort(pparts);
        if ("1".equals(question)){
            for (int i = 0; i<n; i++){
                if (dparts[i]<pparts[i])
                    total+=pparts[i];
                else if (pparts[i]<dparts[i])
                    total+=dparts[i];
                else
                total += dparts[i];
            }
        }
        else{
            for (int i = 0; i<n; i++){
                if (dparts[i]<pparts[(n-i-1)])
                    total+=pparts[n-i-1];
                else if (pparts[(n-i-1)]<dparts[i])
                    total+=dparts[i];
                else
                    total += dparts[i];
            }
            
        }
        System.out.println(total);
    }
    
}
