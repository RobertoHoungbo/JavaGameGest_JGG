package games.tictactoe;

import java.util.Scanner;

public class MainTicTacToe {
    
    public static void main(String[] args){
        String nomJoueur1;
        String nomJoueur2;

        int ligneCoup;
        int colonneCoup;


        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom du joueur 1: ");
        nomJoueur1 = scanner.next();
        System.out.print("\n");

        System.out.print("Entrez le nom du joueur 2: ");
        nomJoueur2 = scanner.next();
        System.out.print("\n");

        TicTacToe nouvellePartieTicTacToe = new TicTacToe(nomJoueur1, nomJoueur2);

        System.out.println("La partie débute !");

        System.out.println(nouvellePartieTicTacToe.situationToString()); 

        while (!nouvellePartieTicTacToe.isOver()) {
            System.out.print("\n");
            System.out.println("C'est à " + nouvellePartieTicTacToe.getCurrentPlayer() + " de jouer ");
            System.out.println("Votre coup : ");

            System.out.print("- rangée ? ");
            String inputStr = scanner.next();
            ligneCoup = Integer.parseInt(inputStr);

            System.out.print("- colonne ? ");
            inputStr = scanner.next();
            colonneCoup = Integer.parseInt(inputStr);
            System.out.print("\n");

            nouvellePartieTicTacToe.execute(ligneCoup, colonneCoup);

            System.out.println(nouvellePartieTicTacToe.situationToString());   
            
        }

        scanner.close();

        if(nouvellePartieTicTacToe.getWinner() != null){
            System.out.println("Le gagnant est " + nouvellePartieTicTacToe.getWinner());
        }
         
    
        else if(nouvellePartieTicTacToe.tableauRempli()){
            System.out.println("Match Nul !");
        }

        
    }
}
