package games.players;

import java.util.Scanner;

import games.genericgames.Game;

public class Human implements Player{

    private String nom;
    private Scanner scanner;

    public Human(String nom, Scanner scanner){
        this.nom = nom;
        this.scanner = scanner;
    }
    @Override
    public int chooseMove(Game myGame) {

        System.out.println("Au tour de " + this.nom);
        System.out.print("Liste des coups valides : [");
        for(int i=0; i<myGame.validMoves().size();i++){
            System.out.print(myGame.validMoves().get(i) + ",");
        }
        System.out.println("]");

        System.out.println("Choisissez votre coup dans la liste affichée : ");
        int coupChoisi = Integer.parseInt(this.scanner.next());
        
        while(!myGame.validMoves().contains(coupChoisi)){
            System.out.println("Veuillez choisir un coup valide");
            coupChoisi = Integer.parseInt(this.scanner.next());
        }
        

        return coupChoisi;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
