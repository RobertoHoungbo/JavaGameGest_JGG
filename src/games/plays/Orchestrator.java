package games.plays;

import games.genericgames.Game;

public class Orchestrator{
    private Game myGame;


    public Orchestrator(Game myGame){
        this.myGame = myGame;
    }

    public void play(){
        while (!this.myGame.isOver()) {
            System.out.println(this.myGame.situationToString()); 

            int coupAJouer = this.myGame.getCurrentPlayer().chooseMove(this.myGame);

            this.myGame.execute(coupAJouer);
        }

        System.out.println(this.myGame.situationToString());
        System.out.println("Le joueur gagnant est:  " + myGame.getWinner());
    }
}
