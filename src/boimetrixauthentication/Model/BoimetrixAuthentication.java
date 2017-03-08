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
//    public static void main(String[] args) {
//        
//        int[] ints={100,100,100,100,100,100,100,100};
//        int[] ints2={150,90,62,56,12,87,15,42};
//        int[] ints3={150,90,62,56,12,89,15,44};
////        System.out.println((IOManager.Read("user2")));
//        System.out.println(authenticate("isham2",ints ));
//        System.out.println(authenticate("140236", ints2));
//        System.out.println(authenticate("140236", ints3));
//        System.out.println(authenticate("140233", ints2));
//   
//    }
    public static String register(String username,int[] handFeaters){
        if(username.length()<1) return "INVALID USERNAME!";
        String inputStatus = checkFeatures(handFeaters);
        String usernameStatus = checkUsername(username);
        if(!"OK".equals(inputStatus)) return inputStatus;
        if(!"OK".equals(usernameStatus)) return usernameStatus;
        String code = EncryptionEngine.encrypt(handFeaters);
        String data = (username+" : "+code);
        String response = IOManager.Write(data);
        return response;
    }
    public static String authenticate(String username,int[] handFeaters){
        if(username.length()<1) return "INVALID USERNAME!";
        String inputStatus = checkFeatures(handFeaters);
        if(!"OK".equals(inputStatus)) return inputStatus;
        String response = IOManager.Read(username);
        if ("USER_NOT_AVILABLE".equals(response) || "LOGIN_FAILED".equals(response) )return response;
        int[] data = EncryptionEngine.decrypt(response);
        return validate(data, handFeaters);
    }
    private static String validate(int[] a , int[] b){
        for(int i=0;i<a.length;++i){
            if((Math.abs(a[i]-b[i]))>3){
                return "AUTHENTICATION_FAILED";
            }
        }
        
        return "SUCCEEDED!";
    }
    public static boolean checkUsernameFromStore(String username){
        String response = IOManager.Read(username);
        if ("USER_NOT_AVILABLE".equals(response)) return true;
        return false;
    }
    private static String checkUsername(String username){
        String usernamestriped = username.replaceAll("\\s+","");
        usernamestriped = usernamestriped.replaceAll("[-+.^:,]","");
        if(!username.equalsIgnoreCase(usernamestriped)) return "INVALID USERNAME";
        if (!BoimetrixAuthentication.checkUsernameFromStore(username)) return "USERNAME AlREADY EXISTS!";
        return "OK";
    }
    private static String checkFeatures(int[] values){
        if(values.length!=8) return "INVALID_INPUT";
        for (int value : values) {
            if(value<3 || value>250){
                return "INVALID_INPUT";
            }
        }
        return "OK";
    }
    
}
