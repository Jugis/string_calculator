/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pipacorp.stringcalculator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pali
 */
public class Main {
    public static void main(String... args){
        String as = "aj21333;é34\n2s";
        try{
        metodus(as);
        //probametodus();
        }
        catch(Exception e){
           System.out.println(e.getMessage()); 
        }
    }

    private static void metodus(String as) throws Exception{
        char c;
        String helyi = as;
        Character constans = ';';
        
        
        for (int i = 0; i <= (helyi.length())-1; i++) {
            c = helyi.charAt(i);
            if (teszt(helyi, i) == false) {
                helyi = helyi.replace(helyi.charAt(i), constans);
            }
        }
        System.out.println(helyi);
        osszeadas(helyi);
    }



    private static boolean teszt(String helyi, int i) {
        Character[] karaktertomb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-'};
        boolean lokalis = false;
        for (int j = 0; j < karaktertomb.length; j++) {
            if (helyi.charAt(i) == karaktertomb[j]) {
                lokalis = true;
            }
        }
        return lokalis;
        
    }

    private static void osszeadas(String helyi) throws Exception{
        String[] tomb;
        tomb = helyi.split(";");
        int osszeg= 0;
        boolean csicskaMegoldas = false;
        
        for (int i = 0; i < tomb.length; i++) {
            
            if (!tomb[i].isEmpty() && Integer.parseInt(tomb[i]) < 0) {    
                csicskaMegoldas = true;   
                throw new Exception("negativs not allowed" + szamol(tomb));
            }
        }
        if(csicskaMegoldas == false){
        for (int i = 0; i < tomb.length; i++) {
            if (!tomb[i].isEmpty()){
                osszeg += Integer.parseInt( tomb[i]);
            }           
        }
        System.out.print(osszeg);
        }
    }

    private static String szamol(String[] tomb) {
        String cuccli = null;
        for (int i = 0; i < tomb.length; i++) {
            if(!tomb[i].isEmpty()){
                if (Integer.parseInt(tomb[i]) < 0) {
                    cuccli = cuccli + tomb[i];
                }
            }
        }
        return cuccli;
    }

   
}
