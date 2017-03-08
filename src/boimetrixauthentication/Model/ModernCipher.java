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
public class ModernCipher {
    private static String key="10110101";
    public static String encrypt(String bytes){
        String generatedKey = generateKey(key);
        return XOR(bytes, generatedKey);
    }
    public static String decrypt(String bytes){
        String generatedKey = generateKey(key);
        return XOR(bytes, generatedKey);
    }
    private static String XOR(String x, String y){
        String[] lx = x.split("");
        String[] ly = y.split("");
        String result="";
        for (int i=0;i<lx.length;i++){
            result+= ((lx[i]).equalsIgnoreCase(ly[i])) ? "0" : "1";
        }
        return result; 
    }
    private static String generateKey(String privateKey){
        privateKey=(privateKey+"10011101").substring(0,8);
        String generatedKey = "";
        for(int i=0;i<8;i++){
            generatedKey+=shift(privateKey, i);
        }
        return generatedKey;
        
    }
    
    private static String shift(String binary,int iterattion){
        return binary.substring(0,iterattion )+binary.substring(iterattion,8 );
    }
    
}
