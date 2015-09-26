/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mluckau.konsole.console;

import java.util.ArrayList;

/**
 *
 * @author michael
 */
public class Console {
    public static final String INFO_MSG  = "[INFO]  ";
    public static final String WARN_MSG  = "[WARN]  ";
    public static final String ERROR_MSG = "[ERROR] ";
    
    private ArrayList<ConsoleCommand> commands = new ArrayList<ConsoleCommand>();
    
    
    public void writeLine(final String msg){
        System.out.println(msg);
    }
    
    public void writeInfo(final String msg) {
        writeLine(INFO_MSG + msg);
    }
    
    public void writeWarn(final String msg) {
        writeLine(WARN_MSG + msg);
    }
    
    public void writeError(final String msg) {
        writeLine(ERROR_MSG + msg);
    }
    
    public void registerCommand(final ConsoleCommand cmd){
        if (cmd != null) {
            if (cmd.getCommand().isEmpty() == false) {
                this.commands.add(cmd);
            }
        }
    }
    
    public void unregisterCommand(final String cmdname) {
        if (cmdname.isEmpty() == false) {
            for (int i = 0; i < this.commands.size(); i++) {
                final ConsoleCommand cmd = this.commands.get(i);
                if (cmd.getCommand().equalsIgnoreCase(cmdname)) {
                    this.commands.remove(i);
                }
            }
        }
    }
    
    public boolean isCommandRegistered(final String cmdname) {
        if (cmdname.isEmpty() == false) {
            for (ConsoleCommand cmd : this.commands){
                if (cmd.getCommand().equalsIgnoreCase(cmdname)){
                    return true;
                }
            }
            
            return false;
        } else {
            return false;
        }
    }
    
    public ConsoleCommand getCommand(final String cmdname) {
        if (isCommandRegistered(cmdname)){
            for (ConsoleCommand cmd : this.commands) {
                if (cmd.getCommand().equalsIgnoreCase(cmdname)) {
                    return cmd;
                }
            }
            
            return null;
        } else {
            return null;
        }
    }
    
    public void executeCommand(final String cmdname, final String[] args) {
        if (isCommandRegistered(cmdname)){
            final ConsoleCommand cmd = getCommand(cmdname);
            if(cmd != null) {
                cmd.execute(args);
            } else {
                writeError(String.format("Command not found: %s", cmdname));
            }
        }
    }
    
}
