package games.genericgames;

import games.players.Player;

/*
 * author: @roberto_houngbo
 * fil rouge 5: Abstraction des jeux
 * 
 */

 // Classe abstraite AbstracteGame qui implémente l'interface Game
public abstract class AbstractGame implements Game{
    protected Player joueur1;
    protected Player joueur2;
    protected Player joueurCourant; 

    /**
     * Constructeur de la classe
     *
     * @param joueur1 : Le premier joueur.
     * @param joueur2 :  Le second joueur.
     * 
     */

    public AbstractGame(Player joueur1, Player joueur2){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;

        this.joueurCourant = joueur1;
    }

    // Méthode abstraite doExecute pour exécuter le coup passé en paramètre
    protected abstract void doExecute(int coupAJouer);


    /**
     * Méthode doExecute
     *
     * @param coupAJouer : l'entier correspondant au coup à jouer. Il est sous la forme 3r + c (r=row, c= column)
     * 
     * La méthode exécute le coup passé en paramètre et donne la main à l'adversaire.
     * 
     */
    public void execute(int coupAJouer){
        this.doExecute(coupAJouer);

        if(this.joueurCourant.equals(this.joueur1)){
            this.joueurCourant = this.joueur2;
        }

        else if(this.joueurCourant.equals(this.joueur2)){
            this.joueurCourant = this.joueur1;
        }
    }

    /**
     * Méthode getCurrentPlayer
     *
     * @return Le joueur courant
     * 
     * La méthode retourne le joueur courant
     * 
     */
    public Player getCurrentPlayer(){
        return this.joueurCourant;
    }


}
