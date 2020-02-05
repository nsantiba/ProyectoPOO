/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

/**
 * Clase para generar #orden aleatorio
 * @author user
 */
public class Randomizer {
    public static int generar(int min,int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}

