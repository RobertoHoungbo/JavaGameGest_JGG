package games.factoredgames;

import java.util.Scanner;

public class MainNim {

    public static void main(String[] args) {

        String nomJoueur1;
        String nomJoueur2;

        int nbreDallumetes;
        int nbreMaxDallumettesARetirer;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom du joueur 1: ");
        nomJoueur1 = scanner.next();
        System.out.print("\n");

        System.out.print("Entrez le nom du joueur 2: ");
        nomJoueur2 = scanner.next();
        System.out.print("\n");

        
        System.out.print("Entrez le nombre initial d'allumettes: ");
        String inputStr = scanner.next();
        nbreDallumetes = Integer.parseInt(inputStr);
        System.out.print("\n");

        while (nbreDallumetes <= 0) {
            if(nbreDallumetes <= 0){
                System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                System.out.print("Entrez le nombre initial d'allumettes: ");
                inputStr = scanner.next();
                nbreDallumetes = Integer.parseInt(inputStr);
                System.out.print("\n");
            }

            else break;
        }
 

        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
        inputStr = scanner.next();
        nbreMaxDallumettesARetirer = Integer.parseInt(inputStr);
        System.out.print("\n");

        while (nbreMaxDallumettesARetirer > nbreDallumetes) {
            if(nbreMaxDallumettesARetirer > nbreDallumetes){
                System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                inputStr = scanner.next();
                nbreMaxDallumettesARetirer = Integer.parseInt(inputStr);
                System.out.print("\n");
            }

            else break;
        
            
        }

        

        Nim nouvellePartieNim = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, nomJoueur1, nomJoueur2);

        while(!nouvellePartieNim.isOver()){

            System.out.println("============= Jeu du Nim =============");
            // System.out.println("    Nombre initial d'allumettes: " + nouvellePartieNim.getInitialNbMatches());
            // System.out.println("    Nombre maximum d'allumettes retirable: " + nbreMaxDallumettesARetirer);   
            
            System.out.print("\n" + //
                                "");

            System.out.println("======= Au tour du joueur " + nouvellePartieNim.getCurrentPlayer() + " =======");
            System.out.print("  Nombre d'allumettes à retirer: ");
            inputStr = scanner.next();
            nouvellePartieNim.execute(Integer.parseInt(inputStr));
            System.out.println("  " + nouvellePartieNim.situationToString());
            System.out.print("\n" + //
                                "");

        }

        scanner.close();

        System.out.println("Le joueur gagnant est:  " + nouvellePartieNim.getWinner());

    }
}