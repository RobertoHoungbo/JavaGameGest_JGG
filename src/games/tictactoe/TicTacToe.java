package games.tictactoe;

public class TicTacToe {

    private String joueur1;
    private String joueur2;

    private String joueurCourant;

    private String[][] grilleCoupsJoues;

    public TicTacToe(String joueur1, String joueur2) {

        this.joueur1 = joueur1;
        this.joueur2 = joueur2;

        this.grilleCoupsJoues = new String[3][3];

        this.joueurCourant = joueur1;

    }

    public String getCurrentPlayer() {
        return this.joueurCourant;
    }

    public void execute(int ligneCoupAJouer, int colonneCoupAJouer) {

        if (isValid(ligneCoupAJouer, colonneCoupAJouer)) {

            if (this.joueurCourant.equals(this.joueur1)) {
                this.grilleCoupsJoues[ligneCoupAJouer][colonneCoupAJouer] = "X";
                this.joueurCourant = this.joueur2;
            }

            else if (this.joueurCourant.equals(this.joueur2)) {
                this.grilleCoupsJoues[ligneCoupAJouer][colonneCoupAJouer] = "O";
                this.joueurCourant = this.joueur1;
            }

        }

        else {
            System.out.println("La case que vous avez choisie contient déjà une valeur ou n'existe pas !");
        }

    }

    public boolean isValid(int ligneCoupAJouer, int colonneCoupAJouer) {

        if (ligneCoupAJouer < 0 || ligneCoupAJouer > 2 || colonneCoupAJouer < 0 || colonneCoupAJouer > 2
                || this.grilleCoupsJoues[ligneCoupAJouer][colonneCoupAJouer] != null) {
            return false;
        }

        else
            return true;
    }

    public boolean wins(String joueurCourant, int rowNumber, int columnNumber, int deltaRow, int deltaColumn) {

        for (int i = 0; i < 3; i++) {
            if(this.grilleCoupsJoues[rowNumber  + deltaRow * i][columnNumber + deltaColumn * i] == joueurCourant){
                return true;
            }

        }
        return false;

    }

    public String getWinner() {

        for (int i = 0; i < 3; i++) {
            if(wins("X", i, 0, 0, 1)){
                return this.joueur1;
            }

            if(wins("O", i, 0, 0, 1)){
                return this.joueur2;
            }
        }

        for(int j=0; j < 3; j++){
            if(wins("X", 0, j, 1, 0)){
                return this.joueur1;
            }

            if(wins("O", 0, j, 1, 0)){
                return this.joueur2;
            }
        }

        if(wins("X", 0, 0, 1, 1)){
            return this.joueur1;
        }

        if(wins("O", 0, 0, 1, 1)){
            return this.joueur2;
        }

        if(wins("X", 0, 2, 1, -1)){
            return this.joueur1;
        }

        if(wins("O", 0, 2, 1, -1)){
            return this.joueur2;
        }

        return null;

    }

    public boolean tableauRempli(){
        for(int i=0; i < 3; i++){
            for(int j=0; i < 3; i++){
                if(this.grilleCoupsJoues[i][j] == null){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isOver(){
        if(getWinner() != null){
            return true;
        }

        else if(this.tableauRempli()){
            return true;
        }

        return false; 
        
    }

}