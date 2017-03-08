/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boimetrixauthentication.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isham
 */
public class IOManager {
    public static void Write(String Message){
        try(FileWriter fw = new FileWriter("test.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(Message); 
            } catch (IOException e) {
                System.out.println(e);
            }
    }
    
    public static String Read(String username){
        String passcode="USER_NOT_AVILABLE";
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
        while ((line = br.readLine()) != null) {
          String[] test = line.split(":");
          if (((test[0]).replaceAll("\\s+","")).equalsIgnoreCase(username)){
            return (test[1]).replaceAll("\\s+","");  
          }
        }
        } catch (IOException ex) {
            Logger.getLogger(IOManager.class.getName()).log(Level.SEVERE, null, ex);
            return "LOGIN_FAILED";
        }
        return passcode;
    }
    
    
}
