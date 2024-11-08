package games.players;

import java.util.Random;

import games.genericgames.Game;

public class RandomPlayer implements Player{
    private Random randomPlayer;

    public RandomPlayer(Random randomPlayer){
        this.randomPlayer = randomPlayer;
    }

    @Override
    public int chooseMove(Game myGame) {
        System.out.println("Au tour de Joueur Aléatoire n°" + this.hashCode());
        int coupAleatoire = this.randomPlayer.nextInt(myGame.validMoves().size());

        return myGame.validMoves().get(coupAleatoire);
    }

    @Override
    public String toString() {
        return "Joueur aléatoire n° " + this.hashCode() + ".";
    }

}
