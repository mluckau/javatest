/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mluckau.konsole;

import java.util.Scanner;

/**
 *
 * @author michael
 */
public class Konsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        
        while (true) {
            
            String in = sc.nextLine();
            String[] ain = in.split(" ");
            String cmd = ain[0];
            
            if (cmd.equalsIgnoreCase("exit")){
                System.exit(0);
            } else if (cmd.equalsIgnoreCase("echo")){
                if (ain.length > 1){
                    for (int i = 1; i < ain.length; i++){
                        System.out.print(ain[i] + " ");
                    }
                    System.out.println();
                } else {
                    System.err.println("Error: 'echo' needs 1 or more arguments.");
                }
            } 
            
            else {
                System.err.println("Err: Command not found!");
            }
            
        }
    }
    
}
