package games.factoredgames;


/*
 * author: @roberto_houngbo
 * game: factored games - nim
 * fil rouge 4: Jeu du Nim factorisé
 * 
 */


public class Nim extends AbstractGame{

    // Implémentation de la classe Nim qui étend la classe AbstractGame 

    private int tailleInitiale;
    private int nbreMaxDallumettesRetirableParUnJoueur;

    private int nbreCourantDallumettes;

    public Nim(int tailleInitiale, int nbreMaxDallumettesRetirableParUnJoueur, String j1, String j2) {
        super(j1, j2);
        this.tailleInitiale = tailleInitiale;
        this.nbreMaxDallumettesRetirableParUnJoueur = nbreMaxDallumettesRetirableParUnJoueur;
        this.nbreCourantDallumettes = tailleInitiale;
    }

    // méthode getInitialNbMatches() : accesseur pour le nombre initial d'allumettes 
    public int getInitialNbMatches() {
        return this.tailleInitiale;
    }

    // méthode getCurrentNbMatches() : accesseur pour le nombre courant d'allumettes
    public int getCurrentNbMatches() {
        return this.nbreCourantDallumettes;
    }

    // méthode situationToString()  : affiche l'état actuel du jeu
    public String situationToString() {
        return "Il reste " + getCurrentNbMatches() + " allumettes.";
    }


    /**
     * Redéfinition de la méthode doExecute
     *
     * @param nbreDallumettesARetirer : le nombre d'allumettes à retirer
     * 
     * Retire du nombre courant d'allumettes le nombre d'allumlettes passé en paramètre.
     */
    @Override
    protected void doExecute(int nbreDallumettesARetirer) {

        this.nbreCourantDallumettes = this.nbreCourantDallumettes - nbreDallumettesARetirer;

    }


    // méthode isValid : prend en paramètre le nombre d'allumettes à retirer spécifié par le joueur courant
    // et vérifie si le nombre est valide 

    public boolean isValid(int nbreDallumettesARetirer) {
        if (nbreDallumettesARetirer < 1 || nbreDallumettesARetirer > getCurrentNbMatches()
                || nbreDallumettesARetirer > nbreMaxDallumettesRetirableParUnJoueur) {
            return false;
        }

        else
            return true;
    }

    // méthode isOver() : vérifie si la partie est terminée ou non en focntion de la valeur du nombre courant d'allumettes

    public boolean isOver() {
        if (getCurrentNbMatches() != 0) {
            return false;
        }

        else
            return true;
    }

    // méthode getWinner() : renvoie le gagnant de la partie 
    // Le joueur perdant est celui qui retire la dernière allumette 
    // Lorsqu'il retire la dernière allumette le jeu passe la main au joueur suivant qui devient le joueur courant
    // Le gagnant est donc le joueur courant lorsque le nombre d'allumettes restant est 0

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