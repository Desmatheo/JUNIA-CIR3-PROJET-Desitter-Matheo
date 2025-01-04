package Projet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //début du programme : 
        //création de l'armée 
        System.out.println("____Création de l'Armée,\n\n ");
        
        //Constructeur de l'armée
        Armee armee;
        Scanner myObj = new Scanner(System.in); 
        System.out.println("Nom de l'armée : ");
        String nomArmée = myObj.nextLine();

        System.out.println("Faction de l'armée : ");
        String nomFaction = myObj.nextLine();

        armee = new Armee(nomArmée, nomFaction);


        //interface utilisateur, création groupe, suppression unité, affichage récapitulatif, ....
        boolean quit = false;
        while(!quit){
            System.out.println("\n\n______________Menu de l'armée______________\n1 - Créer un groupe\n2 - Modifier un groupe\n3 - Récapitulatif de l'armée\n4 - Changer le nom ou la faction de l'armée\n5 - Quitter");
            int choix = myObj.nextInt();

            switch (choix) {
                //Créer un groupe
                case 1:
                    armee.ajoutGroupe();
                    break;
                case 2:
                    armee.modifGroupe();
                    break;
                case 3:
                    armee.print();
                    break;
                case 4:
                    armee.rename();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    break;
            }

        }
        
        myObj.close();
    }
}
