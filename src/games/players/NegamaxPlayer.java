package games.players;

import games.genericgames.Game;

/*
 * author: @roberto_houngbo
 * fil rouge 6: Algorithme Négamax
 * 
 */

public class NegamaxPlayer implements Player{

    /**
     * Constructeur de la classe
     */
    public NegamaxPlayer(){

    }


    /**
     * Méthode evaluate
     *
     * @param currentGame : La situation courante du jeu joué.
     * 
     * @return La valeur de la situation courante du jeu une fois évaluée.
     * 
     * La méthode évalue récursivemnt le jeu selon que le joueur courant soit le gagnant ou non ou que la partie soit nulle.
     * Un entier résultant de cette évaluation est ensuite renvoyée.
     */
    public int evaluate(Game currentGame){
        if(currentGame.getWinner() == currentGame.getCurrentPlayer()){
            return +1;
        }

        else if(currentGame.getWinner() != null && currentGame.getWinner() != currentGame.getCurrentPlayer()){
            return -1;
        }

        else if(currentGame.isOver() && currentGame.getWinner() == null){
            return 0;
        }

        else{
            Integer res = null;
            
            
            for(int moove: currentGame.validMoves()){
                Game currentGame_1 = currentGame.copy();
                
                currentGame_1.execute(moove);

                Integer v = -1 * evaluate(currentGame_1);

                if(res == null || v > res){
                    res = v;
                }
            }

            return res;
            }
        }
    

    /**
     * Redéfinition de la méthode chooseMove
     *
     * @param currentGame : La situation courante du jeu joué.
     * 
     * @return Le meilleur coup pouvant être joué dans la situation courante du jeu.
     * 
     * La méthode évalue récursivemnt le jeu selon que le joueur courant soit le gagnant ou non ou que la partie soit nulle.
     * En fonction du résultat de l'évaluation, le meilleur coup à jouer est choisi et renvoyé.
     */
    @Override
    public int chooseMove(Game currentGame){
        System.out.println("Au tour de Joueur Négamax n°" + this.hashCode());

        Integer meilleureValeur = null;
        Integer meilleurCoup = null;
       
        for(int moove: currentGame.validMoves()){
            Game currentGame_1 = currentGame.copy();
            currentGame_1.execute(moove);

            int v = (-1) * evaluate(currentGame_1);

            if(meilleureValeur == null || v > meilleureValeur ){
                meilleureValeur = v;
                meilleurCoup = moove;
            }
 
        }

        return meilleurCoup;
    }

    /**
     * Redéfinition de la méthode toString
     *
     * @return Le nom (hashcode) du joeur Négamax qui appelle la méthode.
     * 
     */
    @Override
    public String toString() {
        return "Joueur Négamax n° " + this.hashCode() + ".";
    }

    
}
