package games.nim;

public class Nim {

    private int tailleInitiale;
    private int nbreMaxDallumettesRetirableParUnJoueur;

    private String joueur1;
    private String joueur2;

    private int nbreCourantDallumettes;
    private String joueurCourant;

    public Nim(int tailleInitiale, int nbreMaxDallumettesRetirableParUnJoueur, String j1, String j2) {

        this.tailleInitiale = tailleInitiale;
        this.nbreMaxDallumettesRetirableParUnJoueur = nbreMaxDallumettesRetirableParUnJoueur;
        this.nbreCourantDallumettes = tailleInitiale;

        this.joueur1 = j1;
        this.joueur2 = j2;
        this.joueurCourant = j1;
    }

    public int getInitialNbMatches() {
        return this.tailleInitiale;
    }

    public int getCurrentNbMatches() {
        return this.nbreCourantDallumettes;
    }

    public String getCurrentPlayer() {
        return this.joueurCourant;
    }

    public String situationToString() {
        return "Il reste " + getCurrentNbMatches() + " allumettes.";
    }

    public void removeMatches(int nbreDallumettesARetirer) {
        if (isValid(nbreDallumettesARetirer)) {

            this.nbreCourantDallumettes = this.nbreCourantDallumettes - nbreDallumettesARetirer;
            
            if (this.joueurCourant.equals(this.joueur1)) {
                this.joueurCourant = this.joueur2;
            }

            else
                this.joueurCourant = this.joueur1;
        }

        else
            System.out.println("Veuillez choisir un nombre compris entre 1 et " +
                    getCurrentNbMatches() + " inclus, et pas plus de " + this.nbreMaxDallumettesRetirableParUnJoueur
                    + ".");
    }

    public boolean isValid(int nbreDallumettesARetirer) {
        if (nbreDallumettesARetirer < 1 || nbreDallumettesARetirer > getCurrentNbMatches()
                || nbreDallumettesARetirer > nbreMaxDallumettesRetirableParUnJoueur) {
            return false;
        }

        else
            return true;
    }

    public boolean isOver() {
        if (getCurrentNbMatches() != 0) {
            return false;
        }

        else
            return true;
    }

    public String getWinner() {
        if (isOver() && this.joueurCourant.equals(this.joueur1)) {
            return this.joueur1;
        } else if (isOver() && this.joueurCourant.equals(this.joueur2)) {
            return this.joueur2;
        }

        else
            return null;
    }

}