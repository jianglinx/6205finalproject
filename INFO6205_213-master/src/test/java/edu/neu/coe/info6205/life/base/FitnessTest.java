package edu.neu.coe.info6205.life.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FitnessTest {

    @Test
    public void test_pattern0(){
        final int[] x = new int[]{5, 3, 8, 7, 0, -4, -8, 9, 3, 0};
        final int[] y = new int[]{0, 9, -7, 4, -4, 7, 4, 1, 1, -5};
        List<Pattern> patterns = new ArrayList<>();
        Pattern pattern = new Pattern();
        for(int i = 0; i < 5; i++) {
            pattern.setX(i, x[i]);
            pattern.setY(i, y[i]);
        }
        patterns.add(pattern);
        Chromosome.Fitness(patterns);
        assertEquals(6, (int)patterns.get(0).getFitness());
    }

    @Test
    public void test_pattern1(){
   
        final int[] x = new int[]{1, 3, 6, 7, 9, -5, -3, -1, 2, 7};
        final int[] y = new int[]{2, 4, 5, 8, 0, -5, 3, -6, 5, -3};
        List<Pattern> patterns = new ArrayList<>();
        Pattern pattern = new Pattern();
        for(int i = 0; i < 3; i++) {
            pattern.setX(i, x[i]);
            pattern.setY(i, y[i]);
        }
        patterns.add(pattern);
        Chromosome.Fitness(patterns);
        assertEquals(8, (int)patterns.get(0).getFitness());
    }

    

    
}
