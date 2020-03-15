/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphe;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jordan
 */
public class Sommet {
     protected  String name;
     protected  String color;
     protected  int degre;
     protected  Set<Sommet> succ;

    public Sommet(String name) {
        this.name = name;
        this.succ=new HashSet();
        this.degre=0;
        this.color="none"; 
    }

    public Sommet(String name, String color) {
        this.name = name;
        this.degre=0;
        this.color = color;
        this.succ=new HashSet();
    }
//
//    public Sommet(String name, String color, Sommet succ) {
//        this.name = name;
//        this.color = color;
//        this.degre=0;
//        this.succ.add(name)succ;
//    }
//    

    Sommet() {
       this.succ=new HashSet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Sommet>  getSuccesseur() {
        return succ;
    }

//    public void setSuivant(Sommet succ) {
//        this.succ = succ;
//    }
    
    public void setDegre(){
        this.degre=this.succ.size();
    }
    
    public int getDegre(){
        
        return 0;
    }
    public String toString(){
       String text="je suis le noued "+this.name+" de degrée"+
                this.getDegre()+"j'ai "+this.getSuccesseur().size()+" succs de couleur"+
               this.getColor();
       return text;
    }
    
      @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(Object obj){
        Sommet a=(Sommet)obj;
        if(this.getName()!= a.getName()){
           return false ;
        }
     
        return true;
    }
   
}
