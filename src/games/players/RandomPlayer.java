package games.players;

import java.util.Random;

import games.genericgames.Game;

/*
 * author: @roberto_houngbo
 * fil rouge 5: Abstraction des joueurs
 * 
 */

public class RandomPlayer implements Player{
    private Random randomPlayer;

    /**
     * Constructeur de la classe
     *
     * @param randomPlayer : Un joueur aléatoire.
     * 
     */
    public RandomPlayer(Random randomPlayer){
        this.randomPlayer = randomPlayer;
    }


    /**
     * Redéfinition de la méthode chooseMove
     *
     * @param myGame : L'instance du jeu joué.
     * 
     * @return Le coup choisi  par le joueur aléatoire.
     * 
     * La méthode retourne un coup choisi aléatoirement parmi les coups valides de l'instance du jeu.
     */
    @Override
    public int chooseMove(Game myGame) {
        System.out.println("Au tour de Joueur Aléatoire n°" + this.hashCode());
        int coupAleatoire = this.randomPlayer.nextInt(myGame.validMoves().size());

        return myGame.validMoves().get(coupAleatoire);
    }


    /**
     * Redéfinition de la méthode toString
     *
     * @return Le nom (hashcode) du joeur aléatoire qui appelle la méthode.
     * 
     */
    @Override
    public String toString() {
        return "Joueur aléatoire n° " + this.hashCode() + ".";
    }

}
