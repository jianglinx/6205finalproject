/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.life.base;

import java.util.List;

/**
 *
 * @author xinyuan
 */
public class GA {
    private boolean[] gene;

    public GA(){
        gene = new boolean[3];
        for (int i = 0; i < 3; i++) {
            gene[i] = Math.random() >= 0.5;
        }
    }


    public void mutation(){
        int size = gene.length;
        for (int i = 0; i < size; i++) {
            if (Math.random() < 0.1) {
                boolean b = !gene[i];
                gene[i] = b;
            }
        }
    }
    public boolean[] getGene(){
        return gene;
    }

    public void setGene(boolean[] b){
        this.gene = b;
    }
    
}
