package edu.neu.coe.info6205.life.base;


import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionTest {

    @Test
    public void test0(){
        final int[] x = new int[]{1, 3, 6, 7, 9, -5, -3, -1, 2, 7};
        final int[] y = new int[]{2, 4, 5, 8, 0, -5, 3, -6, 5, -3};
        Pattern pattern = new Pattern();
        for(int i = 0; i < 10; i++){
            pattern.setX(i, x[i]);
            pattern.setY(i, y[i]);
        }
        String target = Chromosome.Expression(pattern);
        assertEquals("1 2, 3 4, 6 5, 7 8, 9 0, -5 -5, -3 3, -1 -6, 2 5, 7 -3", target);
    }

    @Test
    public void test1(){
        final int[] x = new int[]{5, 3, 8, 7, 0, -4, -8, 9, 3, 0};
        final int[] y = new int[]{0, 9, -7, 4, -4, 7, 4, 1, 1, -5};
        Pattern pattern = new Pattern();
        for(int i = 0; i < 10; i++){
            pattern.setX(i, x[i]);
            pattern.setY(i, y[i]);
        }
        String target = Chromosome.Expression(pattern);
        assertEquals("5 0, 3 9, 8 -7, 7 4, 0 -4, -4 7, -8 4, 9 1, 3 1, 0 -5", target);
    }

    
}
