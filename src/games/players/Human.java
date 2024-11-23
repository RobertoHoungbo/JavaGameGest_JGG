package games.players;

import java.util.Scanner;

import games.genericgames.Game;

/*
 * author: @roberto_houngbo
 * fil rouge 5: Abstraction des joueurs
 * 
 */

public class Human implements Player{

    private String nom;
    private Scanner scanner;


    /**
     * Constructeur de la classe
     *
     * @param nom : Le nom du joueur.
     * @param scanner :  Le scanner pour récupérer les entrées du joueur.
     * 
     */
    public Human(String nom, Scanner scanner){
        this.nom = nom;
        this.scanner = scanner;
    }

    /**
     * Redéfinition de la méthode chooseMove
     *
     * @param myGame : L'instance du jeu joué.
     * 
     * @return Le coup choisi  par le joueur.
     * 
     * La méthode affiche la lsite des coups valides de l'instance du jeu passé en paramètre.
     * Elle demande ensuite au joueur de choisir un coup et si le coup choisi est valide, ce coup est retourné.
     */
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

    /**
     * Redéfinition de la méthode toString
     *
     * @return Le nom du joeur qui appelle la méthode.
     * 
     */
    @Override
    public String toString() {
        return this.nom;
    }
}
