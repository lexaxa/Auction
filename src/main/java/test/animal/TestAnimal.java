package test.animal;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akuzin
 */
public class TestAnimal {
    public static void main(String[] args){
//        ArrayList<Dog> dogs1 = new ArrayList<Animal>();
//        ArrayList<Animal> animals1 = new ArrayList<Dog>();
        List<Animal> list = new ArrayList<Animal>();
        ArrayList<Dog> dogs = new ArrayList<Dog>();
//        ArrayList<Animal> animals = dogs;
        List<Dog> dogList = dogs;
        ArrayList<Object> objects = new ArrayList<Object>();
        List<Object> objList = objects;
//        ArrayList<Object> objs = new ArrayList<Dog>();
        
        
    }
}
