/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphe;

/**
 *
 * @author jordan
 */
public class Arete {
    protected Sommet x;
    protected Sommet y;
    protected int poid;

    public Arete(Sommet x, Sommet y, int poid) {
        this.x = x;
        this.y = y;
        this.poid = poid;
    }
    

    public Arete(Sommet x, Sommet y) {
        this.x = x;
        this.y = y;
    }

    public Sommet getX() {
        return x;
    }

    public void setX(Sommet x) {
        this.x = x;
    }

    public Sommet getY() {
        return y;
    }

    public void setY(Sommet y) {
        this.y = y;
    }

    public int getPoid() {
        return poid;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }
    
    public Arete getArete(Sommet x, Sommet y){
        if(this.x.getName()!=x.getName()){
            return null;
        }
        
        if(this.y.getName()!=y.getName()){
            return null;
        }
        return this;
    }
    
     @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.x.hashCode();
        result = 31 * result + this.y.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(Object obj){
        Arete a=(Arete)obj;
        if(this.getX().getName()!= a.getX().getName()){
           return false ;
        }
        if(this.getY().getName()!= a.getY().getName()){
           return false ;
        }
        return true;
    }
    
  
     @Override
 
    
    public String toString(){
        return this.x.name+"----------"+this.y.name; 
    }
}
