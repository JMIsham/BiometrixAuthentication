/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boimetrixauthentication.Model;

import static boimetrixauthentication.Model.ConvertToBit.readings;

/**
 *
 * @author Isham
 */
public class Cipher {
    
    //Encoding section
    public static int readings=ConvertToBit.readings;
    public static String encrypt(String bites){
        String sufl=shuffle(bites);
        String result="";
        for(int i=0;i<sufl.length();i=i+2){
            result+=encode(sufl.substring(i,i+2));
        }
        return result;
    } 
    
    private static String shuffle(String bites){
        String[] individual= new String[readings*2];
        String result = "";
        for (int i=0;i<readings*2;++i){
            individual[i]=bites.substring(i*4,i*4+4);
            
        }
        for (int j=0;j<4;j++){
            for (String string : individual) {
                result+=string.substring(3-j,3-j+1);
            }
        }
        return result;
    }
    
    private static String encode(String bites){
        switch(bites){
            case "00": 
                return "A";
            case "01":
                return "B";
            case "10":
                return "C";
            case "11":
                return "D";     
            default:
                return "E";
        } 
    }
    
    
    
    
    //decoding Section
    public static String decrypt(String code){
        String result="";
        for(int i=0;i<code.length();++i){
            result+=decode(code.substring(i,i+1));
        }
        return reverceShuffle(result);
    } 
    
    
    private static String reverceShuffle(String bites){
        String[] individual= new String[readings/2];
        String result = "";
        for (int i=0;i<readings/2;++i){
            individual[i]=bites.substring(i*16,i*16+16);
            
        }
        for (int j=0;j<16;j++){
            for (int k=0;k<4;++k) {
                result+=individual[3-k].substring(j,j+1);
            }
        }
        return result;
    }
    
    private static String decode(String bites){
        switch(bites){
            case "A": 
                return "00";
            case "B":
                return "01";
            case "C":
                return "10";
            case "D":
                return "11";     
            default:
                return "E";
        } 
    }
}
    
