package games.plays;

import java.util.Random;
import java.util.Scanner;

import games.genericgames.TicTacToeWithHints;
import games.genericgames.Nim;
import games.genericgames.TicTacToe;
import games.players.Human;
import games.players.NegamaxPlayer;
import games.players.NegamaxPlayerWithCache;
import games.players.Player;
import games.players.RandomPlayer;

public class MainPlay {
    
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random(123);

        

        System.out.println("Veuillez choisir le jeu auquel vous voulez jouer: ");
        System.out.println("1- Jeu du Nim ");
        System.out.println("2- Jeu du Morpion ");

        String inputStr1 = scanner.next();

        System.out.println("Veuillez choisir le type du joueur 1: ");
        System.out.println("1- Joueur Humain ");
        System.out.println("2- Joueur Aléatoire ");
        System.out.println("3- Joueur Négamax ");
        System.out.println("4- Joueur Négamax avec Cache ");


        String inputStr2 = scanner.next();


        System.out.println("Veuillez choisir le type du joueur 2: ");
        System.out.println("1- Joueur Humain ");
        System.out.println("2- Joueur Aléatoire ");
        System.out.println("3- Joueur Négamax ");
        System.out.println("4- Joueur Négamax avec Cache ");

        String inputStr3 = scanner.next();

        if(Integer.parseInt(inputStr1) == 1){

            if(Integer.parseInt(inputStr2) == 1 && Integer.parseInt(inputStr3) == 1){

                System.out.print("Veuillez entrez le nom du joueur 1: ");
                String nomJoueur1 = scanner.next();
                System.out.print("\n");

                System.out.print("Veuillez entrez le nom du joueur 2: ");
                String nomJoueur2 = scanner.next();
                System.out.print("\n");

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }


                Player player1 = new Human(nomJoueur1, scanner);
                Player player2 = new Human(nomJoueur2, scanner);

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();
                

            }

            else if(Integer.parseInt(inputStr2) == 1 && Integer.parseInt(inputStr3) == 2){

                System.out.print("Veuillez entrez le nom du joueur 1: ");
                String nomJoueur1 = scanner.next();
                System.out.print("\n");

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }


                Player player1 = new Human(nomJoueur1, scanner);
                Player player2 = new RandomPlayer(rand);

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 1 && Integer.parseInt(inputStr3) == 3){

                System.out.print("Veuillez entrez le nom du joueur 1: ");
                String nomJoueur1 = scanner.next();
                System.out.print("\n");

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }


                Player player1 = new Human(nomJoueur1, scanner);
                Player player2 = new NegamaxPlayer();

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 1 && Integer.parseInt(inputStr3) == 4){

                System.out.print("Veuillez entrez le nom du joueur 1: ");
                String nomJoueur1 = scanner.next();
                System.out.print("\n");

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }


                Player player1 = new Human(nomJoueur1, scanner);
                Player player2 = new NegamaxPlayerWithCache();

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 2 && Integer.parseInt(inputStr3) == 1){

                System.out.print("Veuillez entrez le nom du joueur 2: ");
                String nomJoueur2 = scanner.next();
                System.out.print("\n");

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }

                Player player1 = new RandomPlayer(rand);
                Player player2 = new Human(nomJoueur2, scanner);
                

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 2 && Integer.parseInt(inputStr3) == 2){

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }

                Player player1 = new RandomPlayer(rand);
                Player player2 = new RandomPlayer(rand);
                

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 2 && Integer.parseInt(inputStr3) == 3){

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }

                Player player1 = new RandomPlayer(rand);
                Player player2 = new NegamaxPlayer();
                

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 2 && Integer.parseInt(inputStr3) == 4){

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }

                Player player1 = new RandomPlayer(rand);
                Player player2 = new NegamaxPlayerWithCache();
                

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 3 && Integer.parseInt(inputStr3) == 1){

                System.out.print("Veuillez entrez le nom du joueur 2: ");
                String nomJoueur2 = scanner.next();
                System.out.print("\n");

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }

                Player player1 = new NegamaxPlayer();
                Player player2 = new Human(nomJoueur2, scanner);
                

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 3 && Integer.parseInt(inputStr3) == 2){

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }

                Player player1 = new NegamaxPlayer();
                Player player2 = new RandomPlayer(rand);
                

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 3 && Integer.parseInt(inputStr3) == 3){

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }

                Player player1 = new NegamaxPlayer();
                Player player2 = new NegamaxPlayer();
                

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 3 && Integer.parseInt(inputStr3) == 4){

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }

                Player player1 = new NegamaxPlayer();
                Player player2 = new NegamaxPlayerWithCache();
                

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 4 && Integer.parseInt(inputStr3) == 1){

                System.out.print("Veuillez entrez le nom du joueur 2: ");
                String nomJoueur2 = scanner.next();
                System.out.print("\n");

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }

                Player player1 = new NegamaxPlayerWithCache();
                Player player2 = new Human(nomJoueur2, scanner);
                

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 4 && Integer.parseInt(inputStr3) == 2){

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }

                Player player1 = new NegamaxPlayerWithCache();
                Player player2 = new RandomPlayer(rand);
                

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 4 && Integer.parseInt(inputStr3) == 3){

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }

                Player player1 = new NegamaxPlayerWithCache();
                Player player2 = new NegamaxPlayer();
                

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            else if(Integer.parseInt(inputStr2) == 4 && Integer.parseInt(inputStr3) == 4){

                System.out.print("Entrez le nombre initial d'allumettes: ");
                int nbreDallumetes = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreDallumetes <= 0) {
                    if(nbreDallumetes <= 0){
                        System.out.println("Veuillez choisir un nombre supérieur ou égal à 1"); 
                        System.out.print("Entrez le nombre initial d'allumettes: ");
                        nbreDallumetes = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                }
        

                System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                int nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                System.out.print("\n");

                while (nbreMaxDallumettesARetirer > nbreDallumetes) {
                    if(nbreMaxDallumettesARetirer > nbreDallumetes){
                        System.out.println("Veuillez choisir un nombre compris entre 1 et " + nbreDallumetes);
                        System.out.print("Entrez le nombre maximum d'allumettes retirable: ");
                        nbreMaxDallumettesARetirer = Integer.parseInt(scanner.next());
                        System.out.print("\n");
                    }

                    else break;
                
                    
                }

                Player player1 = new NegamaxPlayerWithCache();
                Player player2 = new NegamaxPlayerWithCache();
                

                
                Nim game = new Nim(nbreDallumetes, nbreMaxDallumettesARetirer, player1, player2); 
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();

            }

            
        
        }

        else if(Integer.parseInt(inputStr1) == 2){

            if(Integer.parseInt(inputStr2) == 1 && Integer.parseInt(inputStr3) == 1){
                System.out.print("Veuillez entrez le nom du joueur 1: ");
                String nomJoueur1 = scanner.next();
                System.out.print("\n");

                System.out.print("Veuillez entrez le nom du joueur 2: ");
                String nomJoueur2 = scanner.next();
                System.out.print("\n");

                Player player1 = new Human(nomJoueur1, scanner);
                Player player2 = new Human(nomJoueur2, scanner);

                System.out.print("Voulez-vous jouer avec des indices ?(Entrez oui ou non selon votre préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }



            }

            else if(Integer.parseInt(inputStr2) == 1 && Integer.parseInt(inputStr3) == 2){

                System.out.print("Veuillez entrez le nom du joueur 1: ");
                String nomJoueur1 = scanner.next();
                System.out.print("\n");

                Player player1 = new Human(nomJoueur1, scanner);
                Player player2 = new RandomPlayer(rand);

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }


            }

            else if(Integer.parseInt(inputStr2) == 1 && Integer.parseInt(inputStr3) == 3){

                System.out.print("Veuillez entrez le nom du joueur 1: ");
                String nomJoueur1 = scanner.next();
                System.out.print("\n");

                Player player1 = new Human(nomJoueur1, scanner);
                Player player2 = new NegamaxPlayer();

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }


            }

            else if(Integer.parseInt(inputStr2) == 1 && Integer.parseInt(inputStr3) == 4){

                System.out.print("Veuillez entrez le nom du joueur 1: ");
                String nomJoueur1 = scanner.next();
                System.out.print("\n");

                Player player1 = new Human(nomJoueur1, scanner);
                Player player2 = new NegamaxPlayerWithCache();

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }


            }

            else if(Integer.parseInt(inputStr2) == 2 && Integer.parseInt(inputStr3) == 1){

                System.out.print("Veuillez entrez le nom du joueur 2: ");
                String nomJoueur2 = scanner.next();
                System.out.print("\n");

                Player player1 = new RandomPlayer(rand);
                Player player2 = new Human(nomJoueur2, scanner);
                

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }


            }

            else if(Integer.parseInt(inputStr2) == 2 && Integer.parseInt(inputStr3) == 2){

                Player player1 = new RandomPlayer(rand);
                Player player2 = new RandomPlayer(rand);
                

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

            }

            else if(Integer.parseInt(inputStr2) == 2 && Integer.parseInt(inputStr3) == 3){

                Player player1 = new RandomPlayer(rand);
                Player player2 = new NegamaxPlayer();
                

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

            }

            else if(Integer.parseInt(inputStr2) == 2 && Integer.parseInt(inputStr3) == 4){

                Player player1 = new RandomPlayer(rand);
                Player player2 = new NegamaxPlayerWithCache();
                

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

            }

            else if(Integer.parseInt(inputStr2) == 3 && Integer.parseInt(inputStr3) == 1){

                System.out.print("Veuillez entrez le nom du joueur 2: ");
                String nomJoueur2 = scanner.next();
                System.out.print("\n");

                Player player1 = new NegamaxPlayer();
                Player player2 = new Human(nomJoueur2, scanner);
                

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }


            }

            else if(Integer.parseInt(inputStr2) == 3 && Integer.parseInt(inputStr3) == 2){

                Player player1 = new NegamaxPlayer();
                Player player2 = new RandomPlayer(rand);
                

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

            }

            else if(Integer.parseInt(inputStr2) == 3 && Integer.parseInt(inputStr3) == 3){

                Player player1 = new NegamaxPlayer();
                Player player2 = new NegamaxPlayer();
                

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

            }

            else if(Integer.parseInt(inputStr2) == 3 && Integer.parseInt(inputStr3) == 4){

                Player player1 = new NegamaxPlayer();
                Player player2 = new NegamaxPlayerWithCache();
                

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

            }

            else if(Integer.parseInt(inputStr2) == 4 && Integer.parseInt(inputStr3) == 1){

                System.out.print("Veuillez entrez le nom du joueur 2: ");
                String nomJoueur2 = scanner.next();
                System.out.print("\n");

                Player player1 = new NegamaxPlayerWithCache();
                Player player2 = new Human(nomJoueur2, scanner);
                

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }


            }

            else if(Integer.parseInt(inputStr2) == 4 && Integer.parseInt(inputStr3) == 2){

                Player player1 = new NegamaxPlayerWithCache();
                Player player2 = new RandomPlayer(rand);
                

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

            }

            else if(Integer.parseInt(inputStr2) == 4 && Integer.parseInt(inputStr3) == 3){

                Player player1 = new NegamaxPlayerWithCache();
                Player player2 = new NegamaxPlayer();
                

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

            }

            else if(Integer.parseInt(inputStr2) == 4 && Integer.parseInt(inputStr3) == 4){

                Player player1 = new NegamaxPlayerWithCache();
                Player player2 = new NegamaxPlayerWithCache();
                

                System.out.print("Veux-tu jouer avec des indices ?(Entre oui ou non selon ta préférence) : ");
                String inputStr4 = scanner.next();

                if(inputStr4.equals("oui")){
                    TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

                else{
                    TicTacToe game = new TicTacToe(player1, player2);
                    Orchestrator orchestrator = new Orchestrator(game);
                    orchestrator.play();
                    scanner.close();
                }

            }


            
        }

        else {
            while(Integer.parseInt(inputStr1) != 1 && Integer.parseInt(inputStr1) !=2){
                System.out.println("Veuillez choisir le jeu auquel vous voulez jouer: ");
                System.out.println("1- Jeu du Nim ");
                System.out.println("2- Jeu du Morpion ");

                inputStr1 = scanner.next();
            }
        }
       
        // Player player1 = new Human("Moi", scanner);
        // Player player2 = new RandomPlayer(rand);
        // TicTacToeWithHints game = new TicTacToeWithHints(player1, player2); 
        // Orchestrator orchestrator = new Orchestrator(game);
        // orchestrator.play();
        // scanner.close();


    }
}
