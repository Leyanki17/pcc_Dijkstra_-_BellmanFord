/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author jordan
 */
public class GenerateGraphe {
    
      
    public static GrapheStructure  withPositiveWeight(){
        String name;
        Map<String, Sommet> noeuds = new HashMap();
        ArrayList<Arete> relation =new ArrayList();
        ArrayList<String> couleur;
        int ordre=6;
        name = "G1";
        noeuds.put("A",new Sommet("A"));
        noeuds.put("B",new Sommet("B"));
        noeuds.put("C",new Sommet("C"));
        noeuds.put("D",new Sommet("D"));
        noeuds.put("E",new Sommet("E"));
        noeuds.put("F",new Sommet("F"));
        Arete newRelation;
       /*********************** A***************************/
        noeuds.get("A").getSuccesseur().add(noeuds.get("B"));
        newRelation=new Arete(noeuds.get("A"),noeuds.get("B"),2);
        relation.add(newRelation);
        
        noeuds.get("A").getSuccesseur().add(noeuds.get("C"));
        newRelation=new Arete(noeuds.get("A"),noeuds.get("C"),3);
        relation.add(newRelation);
        noeuds.get("A").setDegre();
        /***********************Fin A************************/
        
        /*********************** B***************************/
        noeuds.get("B").getSuccesseur().add(noeuds.get("E"));
        newRelation=new Arete(noeuds.get("B"),noeuds.get("E"),6);
        relation.add(newRelation);
        
        noeuds.get("B").getSuccesseur().add(noeuds.get("C"));
        newRelation=new Arete(noeuds.get("B"),noeuds.get("C"),4);
        relation.add(newRelation);
        
        noeuds.get("B").getSuccesseur().add(noeuds.get("D"));
        newRelation=new Arete(noeuds.get("B"),noeuds.get("D"),5);
        relation.add(newRelation);
        noeuds.get("B").setDegre();
        /***********************Fin B************************/
        
         /*********************** C***************************/
        noeuds.get("C").getSuccesseur().add(noeuds.get("F"));
        newRelation=new Arete(noeuds.get("C"),noeuds.get("F"),10);
        relation.add(newRelation);
        
        noeuds.get("C").getSuccesseur().add(noeuds.get("D"));
        newRelation=new Arete(noeuds.get("C"),noeuds.get("D"),7);
        relation.add(newRelation);
        noeuds.get("C").setDegre();
        /***********************Fin C************************/
         /*********************** D***************************/
        noeuds.get("D").getSuccesseur().add(noeuds.get("F"));
        newRelation=new Arete(noeuds.get("D"),noeuds.get("F"),9);
        relation.add(newRelation);
        
        noeuds.get("D").getSuccesseur().add(noeuds.get("E"));
        newRelation=new Arete(noeuds.get("D"),noeuds.get("E"),7);
        relation.add(newRelation);
        noeuds.get("D").setDegre();
        /***********************Fin D************************/
         /*********************** E***************************/
        noeuds.get("E").getSuccesseur().add(noeuds.get("F"));
        newRelation=new Arete(noeuds.get("E"),noeuds.get("F"),8);
        relation.add(newRelation);
        noeuds.get("E").setDegre();
        /***********************Fin E************************/
        
        return new GrapheStructure(name,noeuds,relation,ordre);
    }

     public static GrapheStructure  withSomeNegativeWeight(){
        String name;
        Map<String, Sommet> noeuds = new HashMap();
        ArrayList<Arete> relation =new ArrayList();
        ArrayList<String> couleur;
        int ordre=5;
        name = "G2";
        noeuds.put("Z",new Sommet("Z"));
        noeuds.put("X",new Sommet("X"));
        noeuds.put("U",new Sommet("U"));
        noeuds.put("V",new Sommet("V"));
        noeuds.put("Y",new Sommet("Y"));
        Arete newRelation;
       /*********************** Z***************************/
        noeuds.get("Z").getSuccesseur().add(noeuds.get("U"));
        newRelation=new Arete(noeuds.get("Z"),noeuds.get("U"),6);
        relation.add(newRelation);
        
        noeuds.get("Z").getSuccesseur().add(noeuds.get("X"));
        newRelation=new Arete(noeuds.get("Z"),noeuds.get("X"),7);
        relation.add(newRelation);
        noeuds.get("Z").setDegre();
        /***********************Fin Z************************/
        
        /*********************** U***************************/
        noeuds.get("U").getSuccesseur().add(noeuds.get("V"));
        newRelation=new Arete(noeuds.get("U"),noeuds.get("V"),5);
        relation.add(newRelation);
        
        noeuds.get("U").getSuccesseur().add(noeuds.get("Y"));
        newRelation=new Arete(noeuds.get("U"),noeuds.get("Y"),-4);
        relation.add(newRelation);
        
        noeuds.get("U").getSuccesseur().add(noeuds.get("X"));
        newRelation=new Arete(noeuds.get("U"),noeuds.get("X"),8);
        relation.add(newRelation);
        noeuds.get("U").setDegre();
        /***********************Fin U************************/
        
         /*********************** X***************************/
        noeuds.get("X").getSuccesseur().add(noeuds.get("V"));
        newRelation=new Arete(noeuds.get("X"),noeuds.get("V"),-3);
        relation.add(newRelation);
        
        noeuds.get("X").getSuccesseur().add(noeuds.get("Y"));
        newRelation=new Arete(noeuds.get("X"),noeuds.get("Y"),9);
        relation.add(newRelation);
        noeuds.get("X").setDegre();
        /***********************Fin X************************/
         /*********************** V***************************/
        noeuds.get("V").getSuccesseur().add(noeuds.get("U"));
        newRelation=new Arete(noeuds.get("V"),noeuds.get("U"),-2);
        relation.add(newRelation);
        
        /***********************Fin V************************/
         /*********************** Y***************************/
        noeuds.get("Y").getSuccesseur().add(noeuds.get("V"));
        newRelation=new Arete(noeuds.get("Y"),noeuds.get("V"),7);
        relation.add(newRelation);
     
        noeuds.get("Y").getSuccesseur().add(noeuds.get("Z"));
        newRelation=new Arete(noeuds.get("Y"),noeuds.get("Z"),2);
        relation.add(newRelation);
        noeuds.get("Y").setDegre();
        /***********************Fin Y************************/
        
        return new GrapheStructure(name,noeuds,relation,ordre);
    }
     
     
     public static GrapheStructure  withCycleAbsorbant(){
        String name;
        Map<String, Sommet> noeuds = new HashMap();
        ArrayList<Arete> relation =new ArrayList();
        ArrayList<String> couleur;
        int ordre=5;
        name = "G2";
        noeuds.put("Z",new Sommet("Z"));
        noeuds.put("X",new Sommet("X"));
        noeuds.put("U",new Sommet("U"));
        noeuds.put("V",new Sommet("V"));
        noeuds.put("Y",new Sommet("Y"));
        Arete newRelation;
       /*********************** Z***************************/
        noeuds.get("Z").getSuccesseur().add(noeuds.get("U"));
        newRelation=new Arete(noeuds.get("Z"),noeuds.get("U"),6);
        relation.add(newRelation);
        
        noeuds.get("Z").getSuccesseur().add(noeuds.get("X"));
        newRelation=new Arete(noeuds.get("Z"),noeuds.get("X"),7);
        relation.add(newRelation);
        noeuds.get("Z").setDegre();
        /***********************Fin Z************************/
        
        /*********************** U***************************/
        noeuds.get("U").getSuccesseur().add(noeuds.get("V"));
        newRelation=new Arete(noeuds.get("U"),noeuds.get("V"),5);
        relation.add(newRelation);
        
        noeuds.get("U").getSuccesseur().add(noeuds.get("Y"));
        newRelation=new Arete(noeuds.get("U"),noeuds.get("Y"),-4);
        relation.add(newRelation);
        
        noeuds.get("U").getSuccesseur().add(noeuds.get("X"));
        newRelation=new Arete(noeuds.get("U"),noeuds.get("X"),8);
        relation.add(newRelation);
        noeuds.get("U").setDegre();
        /***********************Fin U************************/
        
         /*********************** X***************************/
        noeuds.get("X").getSuccesseur().add(noeuds.get("V"));
        newRelation=new Arete(noeuds.get("X"),noeuds.get("V"),-3);
        relation.add(newRelation);
        
        noeuds.get("X").getSuccesseur().add(noeuds.get("Y"));
        newRelation=new Arete(noeuds.get("X"),noeuds.get("Y"),9);
        relation.add(newRelation);
        noeuds.get("X").setDegre();
        /***********************Fin X************************/
         /*********************** V***************************/
        noeuds.get("V").getSuccesseur().add(noeuds.get("U"));
        newRelation=new Arete(noeuds.get("V"),noeuds.get("U"),-2);
        relation.add(newRelation);
        
        /***********************Fin V************************/
         /*********************** Y***************************/
        noeuds.get("Y").getSuccesseur().add(noeuds.get("V"));
        newRelation=new Arete(noeuds.get("Y"),noeuds.get("V"),1);
        relation.add(newRelation);
        
        noeuds.get("Y").getSuccesseur().add(noeuds.get("Z"));
        newRelation=new Arete(noeuds.get("Y"),noeuds.get("Z"),2);
        relation.add(newRelation);
        noeuds.get("Y").setDegre();
        /***********************Fin Y************************/
        
        return new GrapheStructure(name,noeuds,relation,ordre);
    }
    
      public static GrapheStructure chooseGraphe(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Veuiller choisir un Graphe");
        System.out.println("1- choisir un graphe de degree positif");
        System.out.println("2- choisir un graphe avec certains  degrees négatif");
        System.out.println("3- choisir un graphe avec certains  degrees négatif (Idem au choix deux mais avec cycle absorbant)");
        System.out.println("4- appuyer sur m'importe quel touche pour construire son graphe");
        String dec;
        dec= sc.next();
        GrapheStructure G;
        sc.nextLine();
        switch (dec){
            case "1":
                G=GenerateGraphe.withPositiveWeight();
            break;
            case "2":
               G=GenerateGraphe.withSomeNegativeWeight();
            break;
            case "3":
               G=GenerateGraphe.withCycleAbsorbant();
            break;
            default:
                G= new GrapheStructure("G1");
                 G.constructGraphe();
            break;
        }
        
        return G;
    }

}
