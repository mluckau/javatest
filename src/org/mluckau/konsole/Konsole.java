/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mluckau.konsole;

import java.util.Scanner;
import org.mluckau.konsole.console.Console;
import org.mluckau.konsole.console.ConsoleCommand;
import org.mluckau.konsole.console.ConsoleListener;
import org.mluckau.konsole.console.commands.Echo;


/**
 *
 * @author michael
 */

public class Konsole {

    /**
     * @param args the command line arguments
     */
    public static final Console c = new Console();
    
    public static void main(String[] args) {
        
        final Scanner s = new Scanner(System.in);
        
        c.registerCommand(new Echo());
        
        c.addListener(new ConsoleListener() {

            @Override
            public void onCommand(ConsoleCommand cmd, String cmdname, String[] args) {
               Konsole.c.writeInfo("Command executed: " + cmdname);
            }
            
        });
        
        while (true) {
            System.out.print("# ");
            
            String in = s.nextLine();
            if (in.isEmpty() == false) {
                String[] scmd = in.split(" ");
                String cmdname = scmd[0];
                String[] cmdargs = new String[scmd.length - 1];
                
                for (int i = 1; i < scmd.length; i++) {
                    cmdargs[i - 1] = scmd[i];
                }
                
                c.executeCommand(cmdname, cmdargs);
            } else {
                continue;
            }
        }
        
    }
    
}
