package games.genericgames;

import java.util.List;

import games.players.Player;

public interface Game{
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
