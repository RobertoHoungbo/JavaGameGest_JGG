package games.genericgames;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import games.players.Player;

/*
 * author: @roberto_houngbo
 * game: generic games - nim
 * fil rouge 5: Jeu du Nim abstrait
 * 
 */

public class Nim extends AbstractGame {

    // Implémentation de la classe Nim qui étend la classe AbstractGame

    private int tailleInitiale;
    private int nbreMaxDallumettesRetirableParUnJoueur;

    private int nbreCourantDallumettes;

    /**
     * Constructeur de la classe
     *
     * @param tailleInitiale : La taille initiale du tas
     * @param nbreMaxDallumettesRetirableParUnJoueur : Le nombre maximum d'allumettes que peut retirer un joueur
     * @param j1 : Le premier joueur.
     * @param j2 : Le second joueur.
     * 
     */
    public Nim(int tailleInitiale, int nbreMaxDallumettesRetirableParUnJoueur, Player j1, Player j2) {
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

    // méthode situationToString() : affiche l'état actuel du jeu
    public String situationToString() {
        System.out.println(this.validMoves());
        return "Il reste " + getCurrentNbMatches() + " allumettes." + "\n";
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


    // méthode isValid : prend en paramètre le nombre d'allumettes à retirer
    // spécifié par le joueur courant
    // et vérifie si le nombre est valide
    public boolean isValid(int nbreDallumettesARetirer) {
        if (nbreDallumettesARetirer < 1 || nbreDallumettesARetirer > getCurrentNbMatches()
                || nbreDallumettesARetirer > nbreMaxDallumettesRetirableParUnJoueur) {
            return false;
        }

        else
            return true;
    }


    // méthode isOver() : vérifie si la partie est terminée ou non en focntion de la
    // valeur du nombre courant d'allumettes
    public boolean isOver() {
        if (getCurrentNbMatches() != 0) {
            return false;
        }

        else
            return true;
    }


    // méthode getWinner() : renvoie le gagnant de la partie
    // Le joueur perdant est celui qui retire la dernière allumette
    // Lorsqu'il retire la dernière allumette le jeu passe la main au joueur suivant
    // qui devient le joueur courant
    // Le gagnant est donc le joueur courant lorsque le nombre d'allumettes restant
    // est 0
    public Player getWinner() {
        if (isOver() && this.joueurCourant.equals(this.joueur1)) {
            return this.joueur1;
        } else if (isOver() && this.joueurCourant.equals(this.joueur2)) {
            return this.joueur2;
        }

        else
            return null;
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
        for (int i = 1; i <= this.nbreCourantDallumettes; i++) {
            if (this.isValid(i)) {
                coupsValides.add(i);
            }
        }
        return coupsValides;
    }

    
    /**
     * Redéfinition de la méthode copy
     *
     * @return Une instance de jeu.
     * 
     * La méthode permet de créer une copie avec la même situation, du jeu sur lequel elle est appelée.
     * 
     */
    @Override
    public Game copy() {
        Nim res = new Nim(this.tailleInitiale, this.nbreMaxDallumettesRetirableParUnJoueur, this.joueur1, this.joueur2);
        res.nbreCourantDallumettes = this.nbreCourantDallumettes;
        res.joueurCourant = super.joueurCourant;
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
        return "[" + coup + "]";
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
        if (other == null || !(other instanceof Nim)) {
            return false;
        }

        Nim otherAsNim = (Nim) other;
        return  this.joueurCourant.equals(otherAsNim.joueurCourant)
                && this.nbreCourantDallumettes ==  otherAsNim.nbreCourantDallumettes
                && this.nbreMaxDallumettesRetirableParUnJoueur == otherAsNim.nbreMaxDallumettesRetirableParUnJoueur
                && this.tailleInitiale ==  otherAsNim.tailleInitiale;
    }

    /**
     * Redéfinition de la méthode hashCode
     * 
     * @return Le hashCode correspondant à l'objet.
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.joueurCourant, this.nbreCourantDallumettes, this.nbreMaxDallumettesRetirableParUnJoueur, this.tailleInitiale);
    }

}