package Java.Projet;

import java.util.Scanner;
import java.util.ArrayList;


public class Armee {
    public String nom; 
    public String faction;
    private int total_point;
    private int max_point = 2000; //2000 par défauts
    private ArrayList<Groupe> Groupes = new ArrayList<Groupe>();

    Armee(String nom, String faction){
        this.nom = nom;
        this.faction = faction;
    }
    
    public void ajoutGroupe(){
        boolean fini = false;
        int cpt = 1;
        Groupe grp_tmp = new Groupe();

        //nom du groupe 
        @SuppressWarnings("resource")
        Scanner myObj = new Scanner(System.in);
        System.out.println("\nQuel est le nom du groupe : ");
        String nomGroupe = myObj.nextLine();
        grp_tmp.nom = nomGroupe;
        System.out.println("initialisation du groupe " + grp_tmp.nom);
        

        //ajout des unités au groupe
        while (!fini){
            //compteur d'unité dans ce groupe
            if (cpt == 1){
                System.out.println("\n\n " + cpt + "-ère unité");
            }
            else {
                System.out.println("\n\n " + cpt + "-ième unité");
            }

            //ajout de l'unité
            // System.out.println("Quel est le type de l'unité ? (1 ou 2) \n 1 - Infanterie \n 2 - Vehicule"); //completer si types supplémentaires
            // int type = myObj.nextInt();
            
            // switch (type) {
            //     case 1:
            //         //Infenterie
            //         Infanterie newInf = new Infanterie();
            //         if (total_point + grp_tmp.coutGroupe + newInf.cout <= max_point){
            //             grp_tmp.grp_Unites_infanterie.add(newInf);
            //             grp_tmp.coutGroupe += newInf.cout;
            //             cpt++;
            //         }
            //         else{
            //             System.out.println("\n\n/!\\Le cout dépasse la limite, ajout impossible.\n\n");
            //         }
            //         break;
            //     case 2:
            //         //Vehicule
            //         Vehicule newVehi = new Vehicule();
            //         if (total_point + grp_tmp.coutGroupe + newVehi.cout <= max_point){
            //             grp_tmp.grp_Unites_vehicule.add(newVehi);
            //             grp_tmp.coutGroupe += newVehi.cout;
            //             cpt++;
            //         }
            //         else{
            //             System.out.println("Le cout dépasse la limite, ajout impossible.");
            //         }
            //         break;
            //     // completer si types supplémentaire
            //     /* exemple : 
            //         * case x : 
            //         *      Nouvtype newType = new Nouvtype();
            //         *      if (....){
            //         *          grp_tmp.grp_Unites_NouvType.add(newType);
            //         *          cpt++
            //         *          ...
            //         *      }
            //         *      ...
            //         * 
            //         * 
            //         *      /!\ avoir fait au préhalable la classe, ainsi que mis a jours la classe groupe.
            //         */
            //     default: 
            //         //Erreur
            //         System.out.println("réponse non valable.");
            //         break;
            // }
            
            if (grp_tmp.ajoutUnité(total_point, max_point)){
                cpt++;
            }
            else{

            }



            //Continue ?
            System.out.println("Le cout actuel du groupe est à : " + grp_tmp.coutGroupe + ", et le cout de l'armée est à : " + (total_point + grp_tmp.coutGroupe) + "/" + max_point + "(en comptant le cout du groupe).");
            System.out.println("\n\nSouhaite-tu toujours completer le groupe ?\n 1 - oui\n 2 - non");
            int tmp = myObj.nextInt();
            if (tmp == 2){
                fini = true;
            }
        
        }

        //ajout du groupe à l'armée
        Groupes.add(grp_tmp);

        //update du cout de l'armée
        this.total_point += grp_tmp.coutGroupe;
    }

    public void modifGroupe(){
        @SuppressWarnings("resource")
        Scanner myObj = new Scanner(System.in);

        System.out.println("Voici la liste des groupes");
        for (int i = 0; i < Groupes.size() ; i++){
            System.out.println( i + " - " + Groupes.get(i).nom);
        }
        System.out.println("Quel groupe souhaite-tu modifier ?");
        int grpSelect = myObj.nextInt();
        myObj.nextLine();

        Groupes.get(grpSelect).print();

        System.out.println("\nQue souhaite-tu réaliser avec ce groupe ?\n1 - ajouter une unité\n2 - supprimer une unité\n3 - renomer une unité\n4 - renomer le groupe\n5 - supprimer le groupe\n6 - annuler");
        int action = myObj.nextInt();
        switch (action) {
            case 1:
                //Ajouter une unité
                Groupes.get(grpSelect).ajoutUnité(total_point, max_point);
                break;
            case 2: 
                //Supprimer une unité
                Groupes.get(grpSelect).supUnité();
                break;
            case 3: 
                //renomer une unité
                Groupes.get(grpSelect).renameUnité();
                break;
            case 4: 
                //renomer le groupe
                Groupes.get(grpSelect).setNomgrp();
                break;
            case 5: 
                //Supprimer le groupe
                Groupes.remove(grpSelect);
                break;
            default:
                break;
        }
    }

    public void print(){
        System.out.println("\n\nFaction : " + this.faction);
        System.out.println("Armée : " + this.nom);
        System.out.println("Points max : " + this.max_point);
        System.out.println("Point utilisés : " + this.total_point + "\n");
        System.out.println("Groupes :");
        for (int i = 0 ; i < Groupes.size(); i++){
            System.out.println(" - " + Groupes.get(i).nom);
            for (int j = 0; j < Groupes.get(i).grp_Unites.size(); j++){
                if (Groupes.get(i).grp_Unites.get(j).type == "Véhicule"){
                    System.out.println("    - " + Groupes.get(i).grp_Unites.get(j).type + " : " + Groupes.get(i).grp_Unites.get(j).typeSpe + " - " + Groupes.get(i).grp_Unites.get(j).nomUnit + " (" + Groupes.get(i).grp_Unites.get(j).cout + "pts, capacité " + Groupes.get(i).grp_Unites.get(j).capacite + ")");
                }
                else {
                    System.out.println("    - " + Groupes.get(i).grp_Unites.get(j).type + " : " + Groupes.get(i).grp_Unites.get(j).typeSpe + " - " + Groupes.get(i).grp_Unites.get(j).nomUnit + " (" + Groupes.get(i).grp_Unites.get(j).cout + "pts" + ((Groupes.get(i).grp_Unites.get(j).capacite != 0) ? (", capacité " + Groupes.get(i).grp_Unites.get(j).capacite) :  "") + ")");
                }
            }
        }
    }

    public void rename(){
        @SuppressWarnings("resource")
        Scanner myObj = new Scanner(System.in);
        System.out.println("Veut tu renomer (1) l'armée, renomer la faction (2), ou annuler (3) ?");
        int rep = myObj.nextInt();
        switch (rep) {
            case 1:
                this.setNom();
                break;
            case 2:
                this.setFaction();
                break;
            default:
                break;
        }

    }

    public void setNom() {
        @SuppressWarnings("resource")
        Scanner myObj = new Scanner(System.in);
        System.out.println("Changer le nom de l'armée (" + this.nom + ")(a vide pour annuler) : ");
        String nouvNom = myObj.nextLine();
        if (nouvNom != ""){
            this.nom = nouvNom;
        }
        
    }
    public void setFaction() {
        @SuppressWarnings("resource")
        Scanner myObj = new Scanner(System.in);
        System.out.println("Changer le max de point (actuel : " + this.max_point + "): ");
        int nouvMax = myObj.nextInt();
        this.max_point = nouvMax;
    }
}
