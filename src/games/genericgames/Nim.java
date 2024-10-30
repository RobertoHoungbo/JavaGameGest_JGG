package games.genericgames;

import java.util.ArrayList;
import java.util.List;

import games.players.Player;

/*
 * author: @roberto_houngbo
 * game: nim
 * fil rouge 1: Jeu du Nim
 * 
 */


public class Nim extends AbstractGame{

    // Implémentation de la classe Nim avec ses attributs

    private int tailleInitiale;
    private int nbreMaxDallumettesRetirableParUnJoueur;

    private int nbreCourantDallumettes;

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

    // méthode situationToString()  : affiche l'état actuel du jeu
    public String situationToString() {
        System.out.println(this.validMoves());
        return "Il reste " + getCurrentNbMatches() + " allumettes." + "\n";
    }

    // méthode removeMatches : retire le nombre d'allumettes spécifié par le joueur courant 
    // et passe la main au joueur suivant

    
    @Override
    protected void doExecute(int nbreDallumettesARetirer) {
        if (isValid(nbreDallumettesARetirer)) {

            this.nbreCourantDallumettes = this.nbreCourantDallumettes - nbreDallumettesARetirer;
    
        }

        else
            System.out.println("Veuillez choisir un nombre compris entre 1 et " +
                    getCurrentNbMatches() + " inclus, et pas plus de " + this.nbreMaxDallumettesRetirableParUnJoueur
                    + ".");
    }

    // @Override
    // public void execute(int nbreDallumettesARetirer) {
        
    // }

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

    public Player getWinner() {
        if (isOver() && this.joueurCourant.equals(this.joueur1)) {
            return this.joueur1;
        } else if (isOver() && this.joueurCourant.equals(this.joueur2)) {
            return this.joueur2;
        }

        else
            return null;
    }

    @Override
    public List<Integer> validMoves() {
        List<Integer> coupsValides = new ArrayList<Integer>();
        for(int i=1; i<=this.nbreCourantDallumettes; i++){
            if(this.isValid(i)){
                coupsValides.add(i);
            }
        }
        return coupsValides;
    }

    @Override
    public Game copy() {
        Nim res = new Nim(this.tailleInitiale, this.nbreMaxDallumettesRetirableParUnJoueur, this.joueur1, this.joueur2); 
        res.nbreCourantDallumettes = this.nbreCourantDallumettes;
        res.joueurCourant = super.joueurCourant;
        return res;
    }

    @Override
    public String moveToString(int coup) {
        return "[" + coup + "]";
    }

}