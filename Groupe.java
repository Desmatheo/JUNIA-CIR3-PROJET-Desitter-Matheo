package Java.Projet;

import java.util.ArrayList;
import java.util.Scanner;

public class Groupe {
    public String nom;
    public int coutGroupe;
    public ArrayList<Unite> grp_Unites= new ArrayList<Unite>();
    public ArrayList<Vehicule> grp_Unites_vehicule= new ArrayList<Vehicule>();

    public boolean ajoutUnité(int pointActuel, int maxPoint){
        @SuppressWarnings("resource")
        Scanner myObj = new Scanner(System.in);
        //ajout de l'unité
        System.out.println("Quel est le type de l'unité ? (1 ou 2) \n 1 - Infanterie \n 2 - Vehicule\n"); //completer si types supplémentaires
        int type = myObj.nextInt();
        switch (type) {
            case 1:
                //Infanterie
                Infanterie newInf = new Infanterie();
                if (pointActuel + this.coutGroupe + newInf.cout <= maxPoint){
                    this.grp_Unites.add(newInf);
                    this.coutGroupe += newInf.cout;
                }
                else{
                    System.out.println("\n\n/!\\Le cout dépasse la limite, ajout impossible.\n\n");
                    return false;
                }
                return true;
        
            case 2:
                //Vehicule
                Vehicule newVehi = new Vehicule();
                if (pointActuel + this.coutGroupe + newVehi.cout <= maxPoint){
                    this.grp_Unites.add(newVehi);
                    this.coutGroupe += newVehi.cout;
                }
                else{
                    System.out.println("\n\n/!\\Le cout dépasse la limite, ajout impossible.\n\n");
                    return false;
                }
                return true;
            // completer si types supplémentaire
            /* exemple : 
                * case x : 
                *      Nouvtype newType = new Nouvtype();
                *      if (....){
                *          grp_tmp.grp_Unites_NouvType.add(newType);
                *          cpt++
                *          ...
                *      }
                *      ...
                * 
                * 
                *      /!\ avoir fait au préhalable la classe, ainsi que mis a jours la classe groupe.
                */


            default: 
                //Erreur
                System.out.println("réponse non valable.");
                return false;
        }
    }

    public void supUnité(){
        this.print();
        @SuppressWarnings("resource")
        Scanner myObj = new Scanner(System.in);
        System.out.println(this.grp_Unites.size() + " - Annuler");
        System.out.println("Quelle unité veut tu supprimer ?");
        int rep = myObj.nextInt();

        if (rep != this.grp_Unites.size()){
            this.grp_Unites.remove(rep);
        }
    }

    public void renameUnité(){
        this.print();
        @SuppressWarnings("resource")
        Scanner myObj = new Scanner(System.in);
        System.out.println(this.grp_Unites.size() + " - Annuler");
        System.out.println("Quelle unité veut tu renomer ?");
        int rep = myObj.nextInt();

        if (rep != this.grp_Unites.size()){
            this.grp_Unites.get(rep).setNomUnit();
        }
    }

    public void print(){
        //affichage des unités : 
        System.out.println("\nListe des unités dans ce groupe : ");
        for (int i = 0 ; i < grp_Unites.size() ; i++){
            System.out.println( i + " - " + grp_Unites.get(i).type + " - " + grp_Unites.get(i).typeSpe + " - " + grp_Unites.get(i).nomUnit);
        }
    }

    public void setNomgrp(){
        @SuppressWarnings("resource")
        Scanner myObj = new Scanner(System.in);
        System.out.println("Nom du groupe : ");
        String rep = myObj.nextLine();
        this.nom = rep;
    }
}
