package games.plays;

import games.genericgames.Game;

/*
 * author: @roberto_houngbo
 * fil rouge 5: Abstraction des jeux
 * 
 */
public class Orchestrator{
    private Game myGame;

    /**
     * Constructeur de la classe
     *
     * @param myGame : L'instance du jeu joué.
     * 
     */
    public Orchestrator(Game myGame){
        this.myGame = myGame;
    }

    /**
     * Méthode play
     *
     * La méthode gère une partie du jeu passé en paramètre. 
     * Elle effectue une boucle de jeu en affichant la situation, en récupérant le coup retourné par
     * la méthode chooseMove du joueur courant, et en exécutant ce coup puis, une fois la partie terminée,
     * affichage du résultat.
     * 
     */
    public void play(){
        while (!this.myGame.isOver()) {
            System.out.println(this.myGame.situationToString()); 

            int coupAJouer = this.myGame.getCurrentPlayer().chooseMove(this.myGame);

            this.myGame.execute(coupAJouer);
        }

        System.out.println(this.myGame.situationToString());
        if(myGame.getWinner() != null){
            System.out.println("Le joueur gagnant est:  " + myGame.getWinner());
        }

        else{
            System.out.println("Partie nulle");
        }
        
    }
}
