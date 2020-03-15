/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author jordan
 */
public class GrapheStructure implements Graphe{
    protected String name;
    protected Map<String, Sommet> noeuds;
    protected ArrayList<Arete> relation;
    protected ArrayList<String> couleur;
    protected int ordre;

    public GrapheStructure(String name) {
        this.name=name;
        this.noeuds = new HashMap();
        this.relation = new ArrayList();
        this.couleur =  new ArrayList();
        this.ordre= 0;
    }

    public GrapheStructure(String name, Map<String, Sommet> noeuds, ArrayList<Arete> relation, ArrayList<String> couleur, int ordre) {
        this.name = name;
        this.noeuds = noeuds;
        this.relation = relation;
        this.couleur = couleur;
        this.ordre = ordre;
    }
    
    public GrapheStructure(String name, Map<String, Sommet> noeuds, ArrayList<Arete> relation, int ordre) {
        this.name = name;
        this.noeuds = noeuds;
        this.relation = relation;
        this.couleur = new ArrayList();
        this.ordre = ordre;
    }

    public String getName() {
        return name;
    }

    public Map<String, Sommet> getNoeuds() {
        return noeuds;
    }

    public ArrayList<Arete> getRelation() {
        return relation;
    }
    
    
    
    
    @Override
    public void constructGraphe(){
        System.out.println("Bienvenu à la construction de votre graphe");
        Scanner sc=new Scanner(System.in);
        int ordre;
         System.out.println("Quel est le nombre de noeud appartenant au graphe");
        this.ordre= sc.nextInt();
        sc.nextLine();
        for(int i=0; i<this.ordre; i++){
            System.out.println("entrer le nom du noeud "+i);
            String name= sc.nextLine();
            this.noeuds.put(name,new Sommet(name));
        }
        
        for(String noeudName: this.noeuds.keySet()){
            Sommet currentNode=this.noeuds.get(noeudName);
            System.out.println("enter le nombre de successeur du noeud "+noeudName);
            int succ= sc.nextInt();
            sc.nextLine();
            for(int j=0; j<succ;j++){
                boolean repeat;
                Sommet neighbordNode=null;
               do{
                   repeat=false;
                    System.out.println("entre le nom de son successeur n°"+j);
                    String succName= sc.next();
                    sc.nextLine();
                    if(this.noeuds.containsKey(succName)){
                        neighbordNode=this.noeuds.get(succName);
                        currentNode.getSuccesseur().add(neighbordNode);
                    }else{
                        System.out.println("Veillez entrer le nom d'un noeud present dans la liste de noued");
                        for(Sommet s: this.noeuds.values()){
                           System.out.print(s.getName()+"\t");
                        }
                       repeat=true; 
                    }
               }while(repeat==true);
               System.out.println("entre le poid de l'arete formé");
               int poid= sc.nextInt();
               Arete newRelation=new Arete(currentNode,neighbordNode,poid);
               if(!relation.contains(newRelation)){
                   relation.add(newRelation);
               }
            }  
            currentNode.setDegre();
        }
        System.out.println("Creation de votre graphe ok");
    }
    

    /**
     * Retourne la nature d'un graphe;
     */
    public String getNature(){
        return " ";
    }
    
    public void description(){
        String description="Je suis le graphe "+this.name;
        description+="\n je suis d'order"+this.ordre;
        description+="\n *****************Voisi la liste de  mes noeuds**********************\n\n";
        for(Sommet s:this.noeuds.values()){
            description+="\n"+s.toString();
        }
          description+="\n\n *****************Voisi la liste de  mes noeuds**********************\n\n";
        for(Arete a:this.relation){
            description+="\n"+a.toString();
        }
        System.out.println(description);
    }
    public int Dijkstra(String s) throws Exception{
        int cost=0;
       System.out.println("debut de l'algo de dijkstra");
       // Liste des predecesseur
      for(Arete a: relation){
          if(a.getPoid()<0){
               System.out.println("Impossible d'appliquer dijkstra avec des poid negatif");
               return 0;
          }
      }
      
       Sommet sommet=this.getSommet(s);
       if(sommet==null){
           System.out.println("on est à null ici");
           throw new Exception(" Sommet "+s+ " non definir dans le graphe");
       }else{
          Sommet currentNode;
          Map<Sommet,Sommet> pred= new HashMap();
          Map<Sommet,Integer> distance= new HashMap();  
          Set<Sommet> marque = new HashSet();
          Set<Sommet> nonMarque = this.getListeDesNonMarquer(noeuds);
          for(Sommet to: this.noeuds.values()){
              pred.put(to,null);
          }
          for(Sommet to: this.noeuds.values()){
              // Pour chaque noued oon mais sa distance par rapport au sommet à l'infini
              distance.put(to,999999999);
          }
          // pour le sommet on met une distance de 0;
          distance.put(sommet, 0);
          
       
          while(!nonMarque.isEmpty()){
              
              // on recupere le noeud non marquer ayan la distance 
              // minimale avec le sommet
              currentNode= this.getNextNode(distance, nonMarque);
              //on recupere la distance du noeud courant    
              int distanteCurrentNode= distance.get(currentNode);            
              // On marque le noeud
              marque.add(currentNode);   
              // on retire le sommet de la liste des sommet non marqué 
              nonMarque.remove(currentNode);  
              // on parcourt ses succecceur;
             if(currentNode.succ.size()!=0){
                for(Sommet u : currentNode.getSuccesseur()){
                    cost+=1;
                    if(u!=null){
                       Arete ar=this.getArete(relation,currentNode,u );
                       if(ar!=null){
                            this.relacher(distanteCurrentNode,ar, distance, pred);
                       }
                    }
                 
                }
             }
              
          }
          
          for(Sommet a: pred.keySet()){
               String previous= pred.get(a)!=null ? pred.get(a).getName() : null ;
               System.out.println("prédécesseur de "+ a.getName()+" est "+ previous);
          }
          
       }
       return cost;
    }
    
    
    public Sommet getNextNode(Map<Sommet,Integer> distance,Set<Sommet> nonMarque){
        int min=Integer.MAX_VALUE;
        Sommet next=null;
        for(Sommet s:nonMarque){
           int d=distance.get(s);
          if(d<= min){
              min=d;
              next=s;
          } 
        }
//       System.exit(0);
        return next;
    }
    
    public Sommet getSommet(String name){
       return this.noeuds.get(name);
    }

    @Override
    public void generateGraphe(int sommet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean relacher(int distanceCurrentNode, Arete a, Map<Sommet,Integer> distance,Map<Sommet,Sommet> pred) {
        int distanceSucc=distance.get(a.getY());
        if(distanceSucc> distanceCurrentNode+a.getPoid()){
           distance.replace(a.getY(),distanceCurrentNode+a.getPoid());
           pred.replace(a.getY(),a.getX());
           return true;
        }
        return false;
    }
    
    public Arete getArete(ArrayList<Arete> aretes,Sommet x,Sommet y){
       Arete a= new Arete(x,y);
       for(int i=0;i <aretes.size();i++){
           Arete arete= aretes.get(i);
           Arete current= arete.getArete(x, y);
          
           if(current !=null){
               return current;
           }
            if(arete.equals(a)){
                return arete;
            }
       }
       return null;
    }
    
    public Set<Sommet> getListeDesNonMarquer(Map<String, Sommet> noeuds){
        Set<Sommet> nonMarquer= new HashSet();
        for(String s : noeuds.keySet()){
            nonMarquer.add(noeuds.get(s));
        }
        
        return  nonMarquer;
    }
    
    
    public int Bellmanford(String s ) throws Exception{
        int cost=0;
        
       System.out.println("debut de l'algo de BellmanFord");
       // Liste des predecesseur3
      
       Sommet sommet=this.getSommet(s);
       if(sommet==null){
           throw new Exception(" Sommet "+s+ " non definir dans le graphe");
       }else{
            Sommet currentNode;
            Map<Sommet,Sommet> pred= new HashMap();
            Map<Sommet,Integer> distance= new HashMap();  
    //          Set<Sommet> marque = new HashSet();
    //          Set<Sommet> nonMarque = this.getListeDesNonMarquer(noeuds);
            for(Sommet to: this.noeuds.values()){
                pred.put(to,null);
            }
            for(Sommet to: this.noeuds.values()){
                // Pour chaque noued oon mais sa distance par rapport au sommet à l'infini
                distance.put(to,99999999);
            }
            // pour le sommet on met une distance de 0;
            System.out.println(sommet.getName());
            distance.put(sommet,0);
            System.out.println(distance.get(sommet));
            for(int i=1; i<=this.ordre-1;i++){
                for(String key : this.noeuds.keySet()){
                    
                    currentNode= this.noeuds.get(key);                   
                    if(currentNode.succ.size()!=0){
                        int distanteCurrentNode= distance.get(currentNode);    
                        for(Sommet v : currentNode.getSuccesseur()){
                            cost+=1;
                            if(v!=null){
                               Arete ar=this.getArete(relation,currentNode,v );
                               if(ar!=null){
                                    this.relacher(distanteCurrentNode,ar, distance, pred);                                
                               }
                            }
                        }
                    }
                }            
           }
            
            if(this.hasCycleAbsobant(pred, distance)){
               System.out.println("Existance d'un cycle absorbant donc il y'a pas de plus court chemin");
               return cost;
            }

            for(Sommet a: pred.keySet()){
                 String previous= pred.get(a)!=null ? pred.get(a).getName() : null ;
                System.out.println("prédécesseur de "+ a.getName()+" est "+ previous);
            }   
       }
       System.out.println("Fin de BellManFord");
       return cost;
    
    }
    
    public boolean hasCycleAbsobant(Map<Sommet,Sommet> pred,Map<Sommet,Integer> distance){
        boolean stop = false;
        for(String key : this.noeuds.keySet()){
            Sommet currentNode= this.noeuds.get(key);
            if(currentNode.succ.size()!=0){
                int distanteCurrentNode= distance.get(currentNode);    
                for(Sommet v : currentNode.getSuccesseur()){
                    if(v!=null){
                       Arete ar=this.getArete(relation,currentNode,v );
                       if(ar!=null){
                            stop=this.relacher(distanteCurrentNode,ar, distance, pred);
                       }
                       
                       if(stop==true){
                           return stop;
                       }
                    }
                }
            }
        } 
        return false;
    }
  
}
