package games.tictactoe;

/*
 * author: @roberto_houngbo
 * game: tictactoe
 * fil rouge 2: Jeu du morpion
 * 
 */

public class TicTacToe {

    // Implémentation de la classe TicTacToe avec ses attributs

    protected String joueur1;
    protected String joueur2;

    protected String joueurCourant;

    protected String[][] grilleCoupsJoues;

    public TicTacToe(String joueur1, String joueur2) {

        // initialisation des joueurs selon l'ordre d'entrée
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;

        // nom du plateau : grilleCoupsJoues
        this.grilleCoupsJoues = new String[3][3];

        // remplissage du plateau avec des caractères "." à la place de null
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.grilleCoupsJoues[i][j] = ".";
            }
        }

        // initialisation du joueur courant à joueur1 en début de partie
        this.joueurCourant = joueur1;

    }

    // méthode getCurrentPlayer qui retourne le nom du joueur courant
    public String getCurrentPlayer() {
        return this.joueurCourant;
    }

    // méthode execute qui met à jour le plateau en placeant l'identifiant X ou O du
    // joueur
    // dans la case spécifiée par le joueur courant

    // L'identifiant du joueur1 est: X
    // L'identifiant du joueur2 est: O
    public void execute(int ligneCoupAJouer, int colonneCoupAJouer) {

        // vérification de la validité de la case spécifiée avec la fonction isValid
        if (isValid(ligneCoupAJouer, colonneCoupAJouer)) {

            // si c'est au tour du joueur1, l'identifiant X est placé dans la case
            // correspondante
            // et le joueur2 reprend la main
            if (this.joueurCourant.equals(this.joueur1)) {
                this.grilleCoupsJoues[ligneCoupAJouer][colonneCoupAJouer] = "X";
                this.joueurCourant = this.joueur2;
            }

            // si c'est au tour du joueur2, l'identifiant O est placé dans la case
            // correspondante
            // et le joueur1 reprend la main
            else if (this.joueurCourant.equals(this.joueur2)) {
                this.grilleCoupsJoues[ligneCoupAJouer][colonneCoupAJouer] = "O";
                this.joueurCourant = this.joueur1;
            }

        }

        // si la case spécifiée n'est pas valide, un message d'erreur est affiché
        else {
            System.out.println("La case que vous avez choisie contient déjà une valeur ou n'existe pas !");
        }

    }

    // méthode isValid qui vérifie la validité de la case spécifiée par le joueur
    // courant
    // vérification 1: valeur de la ligne comprise entre 0 et 2
    // vérification 2: valeur de la colonne comprise entre 0 et 2
    // vérification 3: valeur de la case corresponde est "." donc vide

    // si une des trois vérifications échoue, isValid retourne false
    // sinon la case est valide et on retourne true
    public boolean isValid(int ligneCoupAJouer, int colonneCoupAJouer) {

        if (ligneCoupAJouer < 0 || ligneCoupAJouer > 2 || colonneCoupAJouer < 0 || colonneCoupAJouer > 2
                || this.grilleCoupsJoues[ligneCoupAJouer][colonneCoupAJouer] != ".") {
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

    public boolean wins(String identifiantJoueurCourant, int rowNumber, int columnNumber, int deltaRow,
            int deltaColumn) {

        // parcours du plateau pour la vérification
        for (int i = 0; i < 3; i++) {
            // si une des trois cases dans la direction spécifiée ne contient pas le même
            // identifiant que
            // la case précédente, on retourne false
            if (!this.grilleCoupsJoues[rowNumber + deltaRow * i][columnNumber + deltaColumn * i]
                    .equals(identifiantJoueurCourant)) {
                return false;
            }

        }
        // si les cases ont le même idntifiant comme valeur, on retourne true
        return true;

    }

    public String getWinner() {

        for (int i = 0; i < 3; i++) {
            if (wins("X", i, 0, 0, 1)) {
                return this.joueur1;
            }

            if (wins("O", i, 0, 0, 1)) {
                return this.joueur2;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (wins("X", 0, j, 1, 0)) {
                return this.joueur1;
            }

            if (wins("O", 0, j, 1, 0)) {
                return this.joueur2;
            }
        }

        if (wins("X", 0, 0, 1, 1)) {
            return this.joueur1;
        }

        if (wins("O", 0, 0, 1, 1)) {
            return this.joueur2;
        }

        if (wins("X", 0, 2, 1, -1)) {
            return this.joueur1;
        }

        if (wins("O", 0, 2, 1, -1)) {
            return this.joueur2;
        }

        return null;

    }

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

    public boolean isOver() {
        if (getWinner() != null) {
            return true;
        }

        if (this.tableauRempli()) {
            return true;
        }

        return false;

    }

    public String grilleCase(int ligne, int colonne) {

        if (this.grilleCoupsJoues[ligne][colonne] == ".") {
            return ".";
        }

        else
            return String.valueOf(this.grilleCoupsJoues[ligne][colonne]);
    }

    public String situationToString() {

        String chaine = " " + " 0 " + "1 " + "2 ";
        chaine += System.lineSeparator();

        for (int i = 0; i < 3; i++) {
            chaine += String.valueOf(i) + " ";

            for (int j = 0; j < 3; j++) {
                chaine += String.valueOf(this.grilleCoupsJoues[i][j]) + " ";
            }

            chaine += System.lineSeparator();
        }

        return chaine;

    }

}