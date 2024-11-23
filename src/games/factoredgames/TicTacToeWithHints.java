package games.factoredgames;


import java.util.ArrayList;

/*
 * author: @roberto_houngbo
 * game: factored games - tictactoewithhints
 * fil rouge 4: Jeu du morpion avec indices factorisé
 * 
 */

public class TicTacToeWithHints extends TicTacToe {

    /**
     * Constructeur de la classe
     *
     * @param joueur1 : Le premier joueur.
     * @param joueur2 :  Le second joueur.
     * 
     */
    public TicTacToeWithHints(String joueur1, String joueur2) {
        super(joueur1, joueur2);

    }


    /**
     * Méthode hints, sans argument, qui retourne les hints pour le joueur courant
     * sous la forme d’une liste d’entiers représentant des coups
     * 
     * Chaque entier étant sous la forme i = 3r + c (r=row, c=column)
     * 
     * @return La liste des hints(menaces) pour le joueur courant
     * 
     * La méthode simule le prochain coup de l'adversaire en testant plusieurs coups possibles. 
     * Si un coup testé permet à l'adversaire de gagner, ce coup est ajoué à la liste des hints.
     */

    public ArrayList<Integer> hints() {

        ArrayList<Integer> hints = new ArrayList<Integer>();

        if (this.joueurCourant == joueur1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (this.grilleCoupsJoues[i][j].equals(".")) {

                        this.joueurCourant = joueur2;
                        this.execute(3 * i + j);

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
                        this.execute(3 * i + j);

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


    /**
     * Méthode situationToString qui affiche la situation courante du jeu en ajoutant un affichage pour les hints
     * s'il y en a.
     *
     * @return Un string de la situation courante.
     * 
     * La méthode vérifie si la liste des hints est vide, si c'est le cas elle affiche 
     * la situation normale de la partie.
     * 
     * Sinon elle parcours la liste des hints, et pour chaque hint trouvé elle affiche un
     * message de mise en garde avec au passage un caractère  "!" dans la case du coup gagnant 
     * pour l'adversaire au prochain tour. 
     */

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

                        if(this.grilleCoupsJoues[i][j].equals(this.joueur1)){
                            chaine += "X ";
                        }
        
                        else if(this.grilleCoupsJoues[i][j].equals(this.joueur2)){
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

                    if(this.grilleCoupsJoues[i][j].equals(this.joueur1)){
                        chaine += "X ";
                    }
    
                    else if(this.grilleCoupsJoues[i][j].equals(this.joueur2)){
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
