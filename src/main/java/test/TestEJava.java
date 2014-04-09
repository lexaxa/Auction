/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author akuzin
 */
public class TestEJava {
    public static void main(String[] args){
        Programmer a = new Programmer();
        a.print();
        //Author b = new Author();
        //Programmer b = new Author();
        Author b = ((Author)new Programmer());
        
        b.print();
    }
}
