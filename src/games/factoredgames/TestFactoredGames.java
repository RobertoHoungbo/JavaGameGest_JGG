package games.factoredgames;

import gamestests.factoredgames.NimTests; 
import gamestests.factoredgames.TicTacToeTests;
import gamestests.factoredgames.TicTacToeWithHintsTests;

public class TestFactoredGames {

    public static void main(String[] args){

        boolean ok = true;
        NimTests nimTester = new NimTests();
        ok = ok && nimTester.testExtends();
        ok = ok && nimTester.testGetCurrentPlayer(); ok = ok && nimTester.testExecute();
        ok = ok && nimTester.testIsValid();
        ok = ok && nimTester.testIsOver();
        ok = ok && nimTester.testGetWinner();
        TicTacToeTests ticTacToeTester = new TicTacToeTests(); ok = ok && ticTacToeTester.testExtends();
        ok = ok && ticTacToeTester.testGetCurrentPlayer();
        ok = ok && ticTacToeTester.testExecuteAndIsValid();
        ok = ok && ticTacToeTester.testWins(); // si wins() est implementee
        ok = ok && ticTacToeTester.testGetWinner();
        ok = ok && ticTacToeTester.testIsOver();
        TicTacToeWithHintsTests tester = new TicTacToeWithHintsTests(); ok = ok && tester.testGetCurrentPlayer();
        ok = ok && tester.testExecuteAndIsValid();
        ok = ok && tester.testWins(); // si wins() est implementee
        ok = ok && tester.testGetWinner();
        ok = ok && tester.testIsOver();
        ok = ok && tester.testHints();
        System.out.println(ok ? "All tests OK" : "At least one test KO");

    }
    
}