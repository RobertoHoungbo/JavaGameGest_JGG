package games.players;

import games.genericgames.Game;

public class NegamaxPlayer implements Player{
    
    public NegamaxPlayer(){

    }

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

    @Override
    public int chooseMove(Game currentGame){
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

    @Override
    public String toString() {
        return "Joueur Négamax n° " + this.hashCode() + ".";
    }

    
}
