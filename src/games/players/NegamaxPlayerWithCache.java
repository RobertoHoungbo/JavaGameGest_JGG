package games.players;

import java.util.HashMap;
import java.util.Map;

import games.genericgames.Game;

/*
 * author: @roberto_houngbo
 * fil rouge 7: Algorithme Négamax avec cache
 * 
 */

public class NegamaxPlayerWithCache extends NegamaxPlayer{

    private Map<Game, Integer> foundValuesMap = new HashMap<Game, Integer>() ;

    /**
     * Constructeur de la classe
     */
    public NegamaxPlayerWithCache(){

    }


    /**
     * Méthode evaluate
     *
     * @param currentGame : La situation courante du jeu joué.
     * 
     * @return La valeur de la situation courante du jeu une fois évaluée.
     * 
     * La méthode évalue récursivemnt le jeu selon que le joueur courant soit le gagnant ou non ou que la partie soit nulle.
     * Un entier résultant de cette évaluation est avant d'être renvoyée, placé dans un dictionnaire dont la clé est la 
     * situation courante et la valeur est celle de la situation une fois évaluée.
     * Une sorte de mémoire est donc créée pour éviter la réévaluation des situations déjà évaluées.
     */
    @Override
    public int evaluate(Game currentGame){
        if(foundValuesMap.containsKey(currentGame)){
            return foundValuesMap.get(currentGame);
        }

        else {
            if(currentGame.getWinner() == currentGame.getCurrentPlayer()){
                foundValuesMap.put(currentGame, +1);
                return +1;
            }
    
            else if(currentGame.getWinner() != null && currentGame.getWinner() != currentGame.getCurrentPlayer()){
                foundValuesMap.put(currentGame, -1);
                return -1;
            }
    
            else if(currentGame.isOver() && currentGame.getWinner() == null){
                foundValuesMap.put(currentGame, 0);
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

                foundValuesMap.put(currentGame, res);
                return res;
            }
        }

        
    }
    
}
