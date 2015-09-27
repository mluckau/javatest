/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mluckau.konsole;

/**
 *
 * @author michael
 */
public class Main {
    
    public static void main(String[] args) {
        Thread t = new Thread(new Konsole());
        t.start();
        
        
    }
    
}
