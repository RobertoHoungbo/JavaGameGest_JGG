package games.players;

import games.genericgames.Game;

/*
 * author: @roberto_houngbo
 * fil rouge 5: Abstraction des joueurs
 * 
 */

public interface Player {

    /*
    * Définition des méthodes abstraites qui seront utilisées dans les classes des joueurs.
    */

    public int chooseMove(Game myGame);


}
