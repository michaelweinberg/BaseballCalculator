package com.baseballavgs;

import java.util.Scanner;


public class BaseballAverageCalc {

    

    double battingAvg;
    double onbaseAvg;
    double plateApps;
    double walks;
    double atbats;
    double hits;
    

    
    public double calculateBA(double hits, double atbats){
       
        
         
         return battingAvg = hits/atbats;      

    }
    
    
    public double calculateOBA(double hits, double atbats, double walks){
      
         
         return onbaseAvg = (hits+walks)/atbats;      

    }
    
    
    
}