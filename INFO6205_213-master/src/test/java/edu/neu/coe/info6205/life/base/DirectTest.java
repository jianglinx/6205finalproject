/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.life.base;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;
public class DirectTest {
    @Test
    public void test0(){
        final List<Integer> gene1=new ArrayList<>();
        gene1.add(1);
        gene1.add(0);
        gene1.add(1);
        Point point=new Point(1, 1);
        Point target=Chromosome.direct(point, gene1);
        assertEquals(new Point(0,0), target);
    }
    @Test
    public void test1(){
        final List<Integer> gene=new ArrayList<>();
        gene.add(0);
        gene.add(0);
        gene.add(1);
        Point point=new Point(1, 2);
        Point target=Chromosome.direct(point, gene);
        assertEquals(new Point(1,3), target);
    }
}
