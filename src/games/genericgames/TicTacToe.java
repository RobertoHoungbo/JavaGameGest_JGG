package games.genericgames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import games.players.Player;

/*
 * author: @roberto_houngbo
 * game: generic games - tictactoe
 * fil rouge 5: Jeu du morpion abstrait
 * 
 */

public class TicTacToe extends AbstractGame{

    // Implémentation de la classe TicTacToe qui étend la classe AbstractGame

    protected String[][] grilleCoupsJoues;

    public TicTacToe(Player joueur1, Player joueur2) {

        super(joueur1, joueur2);

        // nom du plateau : grilleCoupsJoues
        this.grilleCoupsJoues = new String[3][3];

        // remplissage du plateau avec des caractères "." à la place de null
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.grilleCoupsJoues[i][j] = ".";
            }
        }

    }


    /**
     * Redéfinition de la méthode doExecute
     *
     * @param coupAJouer : l'entier correspondant au coup à jouer. Il est sous la forme 3r + c (r=row, c= column)
     * 
     * La méthode met à jour le plateau en placeant l'identifiant dujoueur dans la case spécifiée 
     * par le joueur courant 
     */
    @Override
    protected void doExecute(int coupAJouer) {

        // si c'est au tour du joueur1, son identifiant est placé dans la case
        // correspondante
        // et le joueur2 reprend la main
        if (this.joueurCourant.equals(this.joueur1)) {
            this.grilleCoupsJoues[coupAJouer / 3][coupAJouer % 3] = String.valueOf(this.joueur1);
        }

        // si c'est au tour du joueur2, son identifiant est placé dans la case
        // correspondante
        // et le joueur1 reprend la main
        else if (this.joueurCourant.equals(this.joueur2)) {
            this.grilleCoupsJoues[coupAJouer / 3][coupAJouer % 3] = String.valueOf(this.joueur2);
        }
        
         
        
    }

    /**
     * Méthode isValid
     *
     * @param coupAJouer : l'entier correspondant au coup à jouer. Il est sous la forme 3r + c (r=row, c= column)
     * 
     * @return Le booléen True ou False selon que le coup passé en paramètre 
     * respecte les conditions de validité ou non
     */
    public boolean isValid(int coupAJouer) {

        if (coupAJouer/3 < 0 || coupAJouer/3 > 2 || coupAJouer%3 < 0 || coupAJouer%3 > 2
                || this.grilleCoupsJoues[coupAJouer/3][coupAJouer%3] != ".") {
            return false;
        }

        else
            return true;
    }

    // méthode wins qui prend en paramètre une case et vérifie si les deux
    // prochaines cases
    // contiennent le même identifiant correspondant au joueur courant

    // les prochaines cases à vérifier sont définies en fonction de deltaRow et
    // deltaColumn
    // qui désignent respctivement la direction (1, 0, -1) suivant la ligne et
    // suivant la colonne dans
    // laquelle la vérification sera faite
    // 1 -> (vers l'avant), 0 . (sur place), -1 <- (vers l'arrière)

    public boolean wins(Player identifiantJoueurCourant, int rowNumber, int columnNumber, int deltaRow,
            int deltaColumn) {

        // parcours du plateau pour la vérification
        for (int i = 0; i < 3; i++) {
            // si une des trois cases dans la direction spécifiée ne contient pas le même
            // identifiant que
            // la case précédente, on retourne false
            if (!this.grilleCoupsJoues[rowNumber + deltaRow * i][columnNumber + deltaColumn * i]
                    .equals(String.valueOf(identifiantJoueurCourant))) {
                return false;
            }

        }
        // si les cases ont le même idntifiant comme valeur, on retourne true
        return true;

    }

    // methode getWinner() qui retourne le gagnant de la partie

    public Player getWinner() {

        // Vérification du gagnant sur les positions horizontales

        for (int i = 0; i < 3; i++) {
            if (wins(this.joueur1, i, 0, 0, 1)) {
                return this.joueur1;
            }

            if (wins(this.joueur2, i, 0, 0, 1)) {
                return this.joueur2;
            }
        }

        // Vérification du gagnant sur les positions verticales

        for (int j = 0; j < 3; j++) {
            if (wins(this.joueur1, 0, j, 1, 0)) {
                return this.joueur1;
            }

            if (wins(this.joueur2, 0, j, 1, 0)) {
                return this.joueur2;
            }
        }

        // Vérification du gagnant sur les deux diagonales

        if (wins(this.joueur1, 0, 0, 1, 1)) {
            return this.joueur1;
        }

        if (wins(this.joueur2, 0, 0, 1, 1)) {
            return this.joueur2;
        }

        if (wins(this.joueur1, 0, 2, 1, -1)) {
            return this.joueur1;
        }

        if (wins(this.joueur2, 0, 2, 1, -1)) {
            return this.joueur2;
        }

        return null;

    }

    // méthode tableauRempli() qui vérifie s'il reste des cases vides sur le plateau

    public boolean tableauRempli() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.grilleCoupsJoues[i][j].equals(".")) {
                    return false;
                }
            }
        }

        return true;
    }
    
    // méthode isOver() : permet de savoir si la partie est finie ou non en vérifiant s'il y a un gagnant 
    // ou s'il ne reste plus de cases vides sur le plateau 

    public boolean isOver() {
        if (getWinner() != null) {
            return true;
        }

        if (this.tableauRempli()) {
            return true;
        }

        return false;

    }

    // méthode situationToString()  : affiche l'état actuel du plateau

    public String situationToString() {

        String chaine = " " + " 0 " + "1 " + "2 ";
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

        return chaine;

    }


    /**
     * Redéfinition de la méthode validMoves
     *
     * @return La liste des coups valides
     * 
     * La méthode parcours la liste des coups restants et vérifie ceux qui sont valides.
     * Les coups valides sont ensuite ajoutés dans une liste et cette liste est renvoyée à la fin.
     * 
     */
    @Override
    public List<Integer> validMoves() {
        List<Integer> coupsValides = new ArrayList<Integer>();

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(isValid(3*i+j)){
                    coupsValides.add(3*i+j);
                }
            }
        }
        return coupsValides;
    }


    /**
     * Redéfinition de la méthode copy
     *
     * @return Une instance du jeu.
     * 
     * La méthode permet de créer une copie avec la même situation, du jeu sur lequel elle est appelée.
     * 
     */
    @Override
    public Game copy() {
        TicTacToe res = new TicTacToe(this.joueur1, this.joueur2); 
        res.joueurCourant = super.joueurCourant;
        
        String[][] copieGrilleCoupsJoues = new String[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                copieGrilleCoupsJoues[i][j] = this.grilleCoupsJoues[i][j];
            }
        }

        res.grilleCoupsJoues = copieGrilleCoupsJoues;

        return res;
    }


    /**
     * Redéfinition de la méthode moveToString
     *
     * @return Une représentation naturelle du coup passé en paramètre
     * 
     */
    @Override
    public String moveToString(int coup) {
        return "[" + coup/3 + "," + coup%3 + "]";
    }

    /**
     * Redéfinition de la méthode equals
     *@param other : Objet sur lequel  l'égalité sera vérifiée
     * 
     * @return Le booléen True ou False selon que l'objet passé en paramètre soit égal à l'objet 
     * qui appelle la méthode
     * 
     */
    @Override
    public boolean equals(Object other){
         if (other == null || !(other instanceof TicTacToe)) {
			return false;
		}

        TicTacToe otherAsTicTacToe = (TicTacToe) other;

        return this.joueurCourant.equals(otherAsTicTacToe.joueurCourant) && Arrays.deepEquals(this.grilleCoupsJoues , otherAsTicTacToe.grilleCoupsJoues);
    }


    /**
     * Redéfinition de la méthode hashCode
     * 
     * @return Le hashCode correspondant à l'objet.
     * 
     */
    @Override
    public int hashCode(){
        return Objects.hash(this.getCurrentPlayer(), Arrays.deepHashCode(this.grilleCoupsJoues));
    }

}