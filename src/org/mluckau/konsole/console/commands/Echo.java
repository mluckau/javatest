/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mluckau.konsole.console.commands;

import org.mluckau.konsole.Konsole;
import org.mluckau.konsole.console.ConsoleCommand;

/**
 *
 * @author michael
 */
public class Echo implements ConsoleCommand {

    @Override
    public String getName() {
        return "Echo";
    }

    @Override
    public String getCommand() {
        return "echo";
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String a : args) {
                sb.append(a + " ");
            }
            
            Konsole.c.writeLine(sb.toString());
        } else {
            Konsole.c.writeError(String.format("%s benötigt mindestens 1 Argument, um ausgeführt zu werden.", getCommand()));
        }
    }
    
}
