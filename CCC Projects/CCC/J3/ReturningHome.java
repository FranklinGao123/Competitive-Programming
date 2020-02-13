/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package returning.home;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author frank
 */
public class ReturningHome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        ArrayList<String> direction = new ArrayList<String>(5);
        ArrayList<String> street = new ArrayList<String>(5);
        for(int i = 0; i<10000; i++){
            direction.add(s.nextLine());
            street.add(s.nextLine());
            if("SCHOOL".equals(street.get(i)))
                break;
        }
        Collections.reverse(street);
        Collections.reverse(direction);
        street.remove(0);
        for(int i=0; i<street.size()+1; i++){
            if("R".equals(direction.get(i)))
                direction.set(i, "LEFT");
            else if("L".equals(direction.get(i)))
                direction.set(i, "RIGHT");
            if(i<street.size()){
            System.out.println("Turn " + direction.get(i) + " onto " + street.get(i) + " street.");
            }else{
                System.out.println("Turn " + direction.get(i) + " into your HOME.");
            }
        }
    }
    
}
