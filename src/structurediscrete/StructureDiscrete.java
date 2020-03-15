/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structurediscrete;

import Graphe.GenerateGraphe;
import Graphe.GrapheStructure;
import java.util.Scanner;

/**
 *
 * @author jordan
 */
public class StructureDiscrete {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        String dec;
        do{
            GrapheStructure G =GenerateGraphe.chooseGraphe();
            System.out.println("Veuiller choisir le sommet de depart parmi la liste ci-dessous");
            for(String name : G.getNoeuds().keySet()){
                System.out.println(" Sommet "+ name);
            }
            String choice = sc.next();
            sc.nextLine();

            try{
                System.out.println("\n/********************** Resultat de Dijktsra***************************/\n");
                int costD=G.Dijkstra("A");
                System.out.println("\n/********************** Fin Resultat de Dijktsra***********************/ \n");

                System.out.println("\n/********************** Resultat de Bellmanford***************************/\n");
                int costB=G.Bellmanford(choice);
                System.out.println("\n/********************** Fin Resultat de Bellmanford**************************/ \n");
                //)
                System.out.println("|-----------------------|------------------------------|");
                System.out.println("|Dijkstra               |      "+costD+" coups                |");
                System.out.println("|-----------------------|------------------------------|");
                System.out.println("|BellmanFord            |      "+costB+" coups                | ");                    
                System.out.println("|-----------------------|------------------------------|");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
            System.out.println("Voulez vous effectuer une autre opération O/N");
            dec=sc.next();
            sc.nextLine();
        }while(dec!="N" || dec!="n");
    }
   
    
}
