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
public class EncryptionEngine {
    public static String encrypt(int[] readings){
//        ConvertToBit.readings=ints.length;
        return Cipher.encrypt(ModernCipher.encrypt(ConvertToBit.toBinary(readings)));
    }
    public static int[] decrypt(String code){
        return ConvertToBit.toDecimal(ModernCipher.decrypt(Cipher.decrypt(code)));
    }
    
}
