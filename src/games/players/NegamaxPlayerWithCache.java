package games.players;

import java.util.HashMap;
import java.util.Map;

import games.genericgames.Game;

public class NegamaxPlayerWithCache extends NegamaxPlayer{

    private Map<Game, Integer> foundValuesMap = new HashMap<Game, Integer>() ;

    public NegamaxPlayerWithCache(){

    }

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
