/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boimetrixauthentication.Model;

import java.util.ArrayList;

/**
 *
 * @author Isham
 */
public class ConvertToBit {
    public static int readings = 3;
    public static String toBinary(int[] readings){
        return convertAll(readings);
    }
    private static String convertToBinary(int x){
        String bits =Integer.toBinaryString(x);
        int length = 8-bits.length();
        String prefix="";
        for (int i=0; i<length;++i){
            prefix=prefix+"0";
        }
        return prefix+bits;
    }
    private static String convertAll(int[] readings){
        String output="";
        for (int reading : readings) {
            output+=convertToBinary(reading);
        }
        return output;
    }
    
    
    public static int[] toDecimal(String wholeBinary){
        String[] individual= new String[readings];
        for (int i=0;i<readings;++i){
            individual[i]=wholeBinary.substring(i*8,i*8+8 );
            
        }
       return convertBinary(individual);
    }
    private static int[] convertBinary(String[] individual){
        int[] vals = new int[readings];
        for (int i=0;i<readings;++i) {
            vals[i] = Integer.parseInt(individual[i], 2);
        }
        return vals;
    }
    
}
