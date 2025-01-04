package Projet;

import java.util.Scanner;

public class Vehicule extends Unite {
    
    Vehicule(){
        this.type = "Véhicule";
        @SuppressWarnings("resource")
        Scanner myObj = new Scanner(System.in);

        //type unité d'infanterie

        System.out.println("Quel type de vehicule ? (1 ... 1) \n 1 - Transport"); //completer si types supplémentaires
        int typeVeh = myObj.nextInt();
        String typeVehicule = " ";

        //nom de l'unité 
        System.out.println("\nQuel est le nom de cette unité ?"); //completer si types supplémentaires
        myObj.nextLine();
        String nomVehicule = myObj.nextLine();
        this.nomUnit = nomVehicule;

        switch (typeVeh) {
            case 1:
                typeVehicule = "Transport"; 
                this.cout = 50;
                this.capacite = 10;
                break;
            //completer si types supplémentaires

            default:
                //Erreur
                System.out.println("réponse non valable.");
                break;
        }
        this.typeSpe = typeVehicule;

    }

    //completer si actions spéciales


}
