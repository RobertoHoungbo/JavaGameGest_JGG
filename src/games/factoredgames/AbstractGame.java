package games.factoredgames;

public abstract class AbstractGame {
    protected String joueur1;
    protected String joueur2;
    protected String joueurCourant; 

    public AbstractGame(String joueur1, String joueur2){
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

    public String getCurrentPlayer(){
        return this.joueurCourant;
    }



}
