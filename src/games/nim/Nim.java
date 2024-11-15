package games.nim;

/*
 * author: @roberto_houngbo
 * game: nim
 * fil rouge 1: Jeu du Nim
 * 
 */

public class Nim {

    // Implémentation de la classe Nim avec ses attributs

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

        // initialisation des joueurs selon l'ordre d'entrée
        this.joueur1 = j1;
        this.joueur2 = j2;

        // initialisation du joueur courant à joueur1 en début de partie
        this.joueurCourant = j1;
    }

    // méthode getInitialNbMatches() : accesseur pour le nombre initial d'allumettes 
    public int getInitialNbMatches() {
        return this.tailleInitiale;
    }

    // méthode getCurrentNbMatches() : accesseur pour le nombre courant d'allumettes
    public int getCurrentNbMatches() {
        return this.nbreCourantDallumettes;
    }

    // méthode getCurrentPlayer() : accesseur pour le joueur courant 
    public String getCurrentPlayer() {
        return this.joueurCourant;
    }

    // méthode situationToString()  : affiche l'état actuel du jeu
    public String situationToString() {
        return "Il reste " + getCurrentNbMatches() + " allumettes.";
    }

    // méthode removeMatches : retire le nombre d'allumettes spécifié par le joueur courant 
    // et passe la main au joueur suivant

    public void removeMatches(int nbreDallumettesARetirer) {

        this.nbreCourantDallumettes = this.nbreCourantDallumettes - nbreDallumettesARetirer;
            
        if (this.joueurCourant.equals(this.joueur1)) {
            this.joueurCourant = this.joueur2;
        }    

        else
            this.joueurCourant = this.joueur1;
        
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