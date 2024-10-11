package games.tictactoe;

import java.util.ArrayList;

public class TicTacToeWithHints extends TicTacToe {

    public TicTacToeWithHints(String joueur1, String joueur2) {
        super(joueur1, joueur2);

    }

    public ArrayList<Integer> hints() {

        ArrayList<Integer> hints = new ArrayList<Integer>();

        if (this.joueurCourant == joueur1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (this.grilleCoupsJoues[i][j].equals(".")) {

                        this.joueurCourant = joueur2;
                        this.execute(i, j);

                        if (getWinner() != null && getWinner() == joueur2) {
                            hints.add(3 * i + j);
                        }

                        this.grilleCoupsJoues[i][j] = ".";
                        this.joueurCourant = joueur1;

                    }
                }
            }
        }

        if (this.joueurCourant == joueur2) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (this.grilleCoupsJoues[i][j].equals(".")) {

                        this.joueurCourant = joueur1;
                        this.execute(i, j);

                        if (getWinner() != null && getWinner() == joueur1) {
                            hints.add(3 * i + j);
                        }

                        this.grilleCoupsJoues[i][j] = ".";
                        this.joueurCourant = joueur2;

                    }
                }
            }
        }

        return hints;
    }

    public String situationToString() {
        int positionHint;
        String chaine = "";

        if (this.hints().size() > 0) {
            for (int k = 0; k < this.hints().size(); k++) {
                positionHint = this.hints().get(k);
    
                chaine = " " + " 0 " + "1 " + "2 ";
                chaine += System.lineSeparator();

                for (int i = 0; i < 3; i++) {
                    chaine += String.valueOf(i) + " ";

                    for (int j = 0; j < 3; j++) {
                        
                        if ((positionHint - positionHint % 3) / 3 == i && positionHint % 3 == j
                                && this.grilleCoupsJoues[i][j].equals(".")) {
                            this.grilleCoupsJoues[i][j] = "! ";

                            chaine += String
                                    .valueOf(this.grilleCoupsJoues[i][j]);

                            this.grilleCoupsJoues[i][j] = ".";

                        } else
                            chaine += String.valueOf(this.grilleCoupsJoues[i][j]) + " ";
                    }

                    chaine += System.lineSeparator();
                }

            }
        }


        else {
            chaine = " " + " 0 " + "1 " + "2 ";
            chaine += System.lineSeparator();
            for (int i = 0; i < 3; i++) {
                chaine += String.valueOf(i) + " ";

                for (int j = 0; j < 3; j++) {
                    chaine += String.valueOf(this.grilleCoupsJoues[i][j]) + " ";
                }

                chaine += System.lineSeparator();
            }
        }

        if (this.hints().size() > 0 && !this.isOver()) {

            for (int i = 0; i < this.hints().size(); i++) {
                chaine += System.lineSeparator();
                chaine += "Hint: Attention " + this.joueurCourant
                        + ", ton adversaire peut gagner au prochain tour s'il joue dans la case ["
                        + String.valueOf((this.hints().get(i) - this.hints().get(i) % 3) / 3) + ", "
                        + String.valueOf(this.hints().get(i) % 3) + "]";
            }
        }

        return chaine;
    }

}
