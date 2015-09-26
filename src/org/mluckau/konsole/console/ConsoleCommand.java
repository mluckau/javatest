/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mluckau.konsole.console;

/**
 *
 * @author michael
 */
public interface ConsoleCommand {
    public String getName();
    public String getCommand();
    public void execute(String[] args);
}
