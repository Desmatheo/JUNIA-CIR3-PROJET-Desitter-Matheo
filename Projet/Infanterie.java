package Projet;
import java.util.Scanner;

public class Infanterie extends Unite {

    Infanterie(){
        this.type = "Infanterie";
        @SuppressWarnings("resource")
        Scanner myObj = new Scanner(System.in);

        //type unité d'infanterie

        System.out.println("Quel type d'infanterie ? (1 ... 4) \n 1 - Soldat \n 2 - Lourd\n 3 - Spécial\n 4 - Chef"); //completer si types supplémentaires
        int typeInf = myObj.nextInt();

        //nom de l'unité 
        System.out.println("Quel est le nom de cette unité ?"); //completer si types supplémentaires
        myObj.nextLine();
        String nomInf = myObj.nextLine();
        this.nomUnit = nomInf;

        String typeInfanterie = " ";
        switch (typeInf) {
            case 1:
                typeInfanterie = "Soldat"; 
                this.cout = 10;
                break;
            case 2:
                typeInfanterie = "Lourd";
                this.cout = 30;
                break;
            case 3:
                typeInfanterie = "Spécial";
                this.cout = 50;
                break;
            case 4:
                typeInfanterie = "Chef";
                this.cout = 100;
                break;
            //completer si types supplémentaires

            default:
                //Erreur
                System.out.println("réponse non valable.");
                break;
        }
        this.typeSpe = typeInfanterie;
    }

    //completer si actions spéciales

    
}
