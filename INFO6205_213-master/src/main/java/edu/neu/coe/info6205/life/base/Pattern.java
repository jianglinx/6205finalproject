/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.life.base;

import java.util.HashSet;

/**
 *
 * @author xinyuan
 */
public class Pattern {
    private int[] x = new int[10];
    private int[] y = new int[10];
    private long fitness;
    private HashSet<Point> points;
    public Pattern(){
        points = new HashSet<>();
    }
     public Pattern(Pattern copy){
        points = new HashSet<>();
        for(int i = 0; i < 10; i++){
            x[i] = copy.getX(i);
            y[i] = copy.getY(i);
        }
    }
      public int getX(int i){
        return x[i];
    }
    public void setX(int i, int value){
        this.x[i] = value;
    }
    public int getY(int i){
        return y[i];
    }
    public void setY(int i, int value){
        this.y[i] = value;
    }
    public void setFitness(long fitness){
        this.fitness = fitness;
    }
    public long getFitness(){
        return fitness;
    }
}
