/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.life.base;

import edu.neu.coe.info6205.life.library.Library;
import io.jenetics.Gene;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author xinyuan
 */
public class Chromosome {
    
    private Gene[] gens;
    public static Map<Point, List<Integer>> createCase()
    {
        Map<Point, List<Integer>> chromosome  = new HashMap<>();
        List<Integer> Gene=new ArrayList<>();
        Random random = new Random();
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){ 
                if (random.nextInt(2) == 0)
                {                  
                    Gene=createGene();
                    chromosome.put(new Point(i,j),Gene );
                    
                }                               
                                }    
                            }
      return chromosome;
        
}
    
    public static List<Point> createPoints( Map<Point, List<Integer>> chromosome){
        List<Point> result = new ArrayList<>();
        for (Point point : chromosome.keySet())
            result.add(point);
        return result;
    }
    public static void evolution(Map<Point, List<Integer>> chromosome,Game g,GA ga){
        for (Point point : chromosome.keySet()) {
            if(g.growthRate()<0||g.getCount()<20){
                ga.mutation();
            }
}
    }
    public static List<Integer> createGene()
    {
        Random random = new Random();
        int num1=random.nextInt(2);
        int num2=random.nextInt(2);
        int num3=random.nextInt(2);
        int num4=random.nextInt(2);
        int num5=random.nextInt(2);
        int num6=random.nextInt(2);
        int num7=random.nextInt(2);
        int num8=random.nextInt(2);
        List<Integer> Gene = new ArrayList<>();
        Gene.add(num1);
        Gene.add(num2);
        Gene.add(num3);
        Gene.add(num4);
        Gene.add(num5);
        Gene.add(num6);
        Gene.add(num7);
        Gene.add(num8);
        return Gene;
        
    }
    
    public static Point direct(Point p, List<Integer> gene){
        int x=p.getX();
        int y=p.getY();
        int num0=gene.get(0);
        int num1=gene.get(1);
        int num2=gene.get(2);
        Point  result=new Point(x, y);
        String s=String.valueOf(num0)+String.valueOf(num1)+String.valueOf(num2);
        switch(s){
            case "000":
                result = new Point(x-1, y+1);
                break;
            case "001":
                result = new Point(x, y+1);
                break;
            case "010":
                result = new Point(x+1, y+1);
                break;
            case "011":
                result = new Point(x-1, y);
                break;
            case "100":
                result = new Point(x+1, y);
                break;
            case "101":
                result = new Point(x-1, y-1);
                break;
            case "110":
                result = new Point(x, y-1);
                break;
            case "111":
                result = new Point(x+1, y-1);
                break;
        }
        
        return result;
    }
    
    public Chromosome(int size){
        gens=(Gene[]) new GA[size];
        for(int i = 0; i < size; i++){
            GA gene = new GA();
            gens[i] = (Gene) gene;
        }

    }
    public static void Fitness(List<Pattern> patterns)
    {

        for(Pattern pattern : patterns){
            Game.Behavior generation = Game.run(0L, Expression(pattern));
            pattern.setFitness(generation.generation);
        }
    }
    
    public static String Expression(Pattern pattern){
        String result = "";
        for(int i = 0; i < 10; i++){
            if(i == 9){
                result = result + pattern.getX(i) + " " + pattern.getY(i);
            }
            else{
                result = result + pattern.getX(i) + " " + pattern.getY(i) + ", ";
            }
        }
        return result;
    }
    
    
}
