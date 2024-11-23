package games.genericgames;

import java.util.List;

import games.players.Player;

/*
 * author: @roberto_houngbo
 * fil rouge 5: Abstraction des jeux
 * 
 */

public interface Game{

    /*
    * Définition des méthodes abstraites qui seront utilisées dans les classes des jeux.
    */

    public Player getCurrentPlayer();

    public boolean isValid(int coupAJouer);

    public void execute(int coupAJouer);

    public boolean isOver();

    public Player getWinner();

    public List<Integer> validMoves();

    public String moveToString(int coup);

    public String situationToString();

    public Game copy();


}
