package games.genericgames;


import java.util.ArrayList;
import java.util.List;

import games.players.Player;

public class TicTacToeWithHints extends TicTacToe {

    public TicTacToeWithHints(Player joueur1, Player joueur2) {
        super(joueur1, joueur2);

    }

    public List<Integer> hints() {

        List<Integer> hints = new ArrayList<Integer>();

        if (this.joueurCourant.toString().equals(joueur1.toString())) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (this.grilleCoupsJoues[i][j].equals(".")) {

                        this.joueurCourant = joueur2;
                        this.execute(3 * i + j);

                        if (getWinner() != null && getWinner().toString().equals(joueur2.toString())) {
                            hints.add(3 * i + j);
                        }

                        this.grilleCoupsJoues[i][j] = ".";
                        this.joueurCourant = joueur1;

                    }
                }
            }
        }

        if (this.joueurCourant.toString().equals(joueur2.toString())) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (this.grilleCoupsJoues[i][j].equals(".")) {

                        this.joueurCourant = joueur1;
                        this.execute(3 * i + j);

                        if (getWinner() != null && getWinner().toString().equals(joueur1.toString())) {
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
            chaine = " " + " 0 " + "1 " + "2 ";
            chaine += System.lineSeparator();

            for (int i = 0; i < 3; i++) {
                
                chaine += String.valueOf(i) + " "; 
                

                for (int j = 0; j < 3; j++) {
                    boolean hintFound = false;
        
                    
                    for (int k = 0; k < this.hints().size(); k++) {
                        positionHint = this.hints().get(k);
                        
                        if ((positionHint - positionHint % 3) / 3 == i && (positionHint % 3 == j)
                                && this.grilleCoupsJoues[i][j].equals(".") && !this.isOver()) {
                            chaine += "! ";  
                            hintFound = true;
                            break;  
                        }
                    }
        
                    if (!hintFound) {

                        if(this.grilleCoupsJoues[i][j].equals(this.joueur1.toString())){
                            chaine += "X ";
                        }
        
                        else if(this.grilleCoupsJoues[i][j].equals(this.joueur2.toString())){
                            chaine += "O ";
                        }

                        else{
                            chaine += ". ";
                        }
                    }
                }

                    chaine += System.lineSeparator();
                }

            }
            
        


        else {
            chaine = " " + " 0 " + "1 " + "2 ";
            chaine += System.lineSeparator();
            for (int i = 0; i < 3; i++) {
                chaine += String.valueOf(i) + " ";

                for (int j = 0; j < 3; j++) {

                    if(this.grilleCoupsJoues[i][j].equals(this.joueur1.toString())){
                        chaine += "X ";
                    }
    
                    else if(this.grilleCoupsJoues[i][j].equals(this.joueur2.toString())){
                        chaine += "O ";
                    }

                    else{
                        chaine += ". ";
                    }
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
