package games.genericgames;

import games.players.Player;

public abstract class AbstractGame implements Player{
    protected Player joueur1;
    protected Player joueur2;
    protected Player joueurCourant; 

    public AbstractGame(Player joueur1, Player joueur2){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;

        this.joueurCourant = joueur1;
    }

    protected abstract void doExecute(int coupAJouer);

    public void execute(int coupAJouer){
        this.doExecute(coupAJouer);

        if(this.joueurCourant.equals(this.joueur1)){
            this.joueurCourant = this.joueur2;
        }

        else if(this.joueurCourant.equals(this.joueur2)){
            this.joueurCourant = this.joueur1;
        }
    }

    public Player getCurrentPlayer(){
        return this.joueurCourant;
    }

    @Override
    public int chooseMove(Game myGame) {
        
        return 0;
    }


}
