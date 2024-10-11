package games.tictactoe;

import java.util.ArrayList;

public class TicTacToeWithHints extends TicTacToe{


    public TicTacToeWithHints(String joueur1, String joueur2){
        super(joueur1, joueur2);
        
    }

    public ArrayList<Integer> hints(){

        ArrayList<Integer> hints = new ArrayList<Integer>();

        if(this.joueurCourant ==  joueur1){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                     if(this.grilleCoupsJoues[i][j].equals(".")){

                        this.joueurCourant = joueur2;           
                        this.execute(i, j);
    
                        if(getWinner() != null && getWinner() == joueur2){
                            hints.add(3*i + j);
                        }
    
                        this.grilleCoupsJoues[i][j] = ".";
                        this.joueurCourant = joueur1;
    
                    }
                }      
            }
        }

        if(this.joueurCourant ==  joueur2){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                     if(this.grilleCoupsJoues[i][j].equals(".")){

                        this.joueurCourant = joueur1;           
                        this.execute(i, j);
    
                        if(getWinner() != null && getWinner() == joueur1){
                            hints.add(3*i + j);
                        }
    
                        this.grilleCoupsJoues[i][j] = ".";
                        this.joueurCourant = joueur2;
    
                    }
                }      
            }
        }

        

        return hints;
    }
    
    public String situationToString(){

        String chaine = " " + " 0 " + "1 " + "2 ";
        chaine += System.lineSeparator();

        for (int i = 0; i < 3; i++) {
            chaine += String.valueOf(i) + " ";

            for (int j = 0; j < 3; j++) {

                if(this.hints().size() > 0){
                    for(int k=0; k < this.hints().size(); k++){
                        if((k-k%3)/3  == i && k%3 == j && this.grilleCoupsJoues[i][j].equals(".")){
                            this.grilleCoupsJoues[i][j]="!";
                            chaine += String.valueOf(this.grilleCoupsJoues[i][j]);
                            this.grilleCoupsJoues[i][j]=".";
                        }
                        else chaine += String.valueOf(this.grilleCoupsJoues[i][j]) + " ";
                    }
                }

                else chaine += String.valueOf(this.grilleCoupsJoues[i][j]) + " ";

                
            }

            chaine += System.lineSeparator();
        }

        if(this.hints().size() > 0){
            chaine += System.lineSeparator();
            for(int i=0; i < this.hints().size(); i++){

                chaine += "Attention " + this.joueurCourant + ", ton adversaire peut gagner au prochain tour s'il joue dans la case  marquée par ! ";
            }
            chaine += System.lineSeparator();
        }

        return chaine;
    }
    
}
