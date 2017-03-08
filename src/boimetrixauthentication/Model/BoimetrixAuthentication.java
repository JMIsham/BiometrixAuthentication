/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boimetrixauthentication.Model;

/**
 *
 * @author Isham
 */
public class BoimetrixAuthentication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] ints={150,90,62,56,12,89,15};
        ConvertToBit.readings=ints.length;
        System.out.println(ConvertToBit.toBinary(ints));
        
        int vals[] = ConvertToBit.toDecimal(ConvertToBit.toBinary(ints));
        for (int val : vals) {
            System.out.println(val);
        }
        
        
    }
    
}
