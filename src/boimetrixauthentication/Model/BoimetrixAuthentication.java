/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boimetrixauthentication.Model;

import com.sun.org.apache.xml.internal.security.encryption.EncryptedData;

/**
 *
 * @author Isham
 */
public class BoimetrixAuthentication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] ints={150,90,62,56,12,89,15,40};
        int[] ints2={150,90,62,56,12,87,15,42};
        int[] ints3={150,90,62,56,12,89,15,44};
//        System.out.println((IOManager.Read("user2")));
        System.out.println(register("140236",ints ));
        System.out.println(authenticate("140236", ints2));
        System.out.println(authenticate("140236", ints3));
        System.out.println(authenticate("140233", ints2));
   
    }
    public static String register(String username,int[] handFeaters){
        if(handFeaters.length!=8)return "INVALID!";
        String code = EncryptionEngine.encrypt(handFeaters);
        String data = (username+" : "+code);
        String response = IOManager.Write(data);
        return response;
    }
    public static String authenticate(String username,int[] handFeaters){
        String response = IOManager.Read(username);
        if ("USER_NOT_AVILABLE".equals(response) || "LOGIN_FAILED".equals(response) )return response;
        int[] data = EncryptionEngine.decrypt(response);
        return validate(data, handFeaters);
    }
    private static String validate(int[] a , int[] b){
       int fails = 0;
        for(int i=0;i<a.length;++i){
            if((Math.abs(a[i]-b[i]))>3){
                fails++;
            }
        }
        if (fails>3)return "AUTHENTICATION_FAILED";
        return "SUCCEEDED!";
    }
    
}
