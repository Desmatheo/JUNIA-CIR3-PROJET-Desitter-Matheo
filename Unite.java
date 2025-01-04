package Java.Projet;

import java.util.Scanner;

public class Unite {
    public String nomUnit;
    public String typeSpe; 
    protected int cout;
    public String type;
    public int capacite;

    public void setNomUnit(){
        @SuppressWarnings("resource")
        Scanner myObj = new Scanner(System.in);
        System.out.println("Nom de l'unité : ");
        String rep = myObj.nextLine();
        this.nomUnit = rep;
    }
}
