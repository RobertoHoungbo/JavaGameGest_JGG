Projet Java : Conception d'une application consistant en un ensemble de jeux de
stratégie simples, accompagnés d’un algorithme d’intelligence artificielle capable de jouer à tous ces jeux,
et d’un moteur de jeu permettant de faire jouer, à n’importe lequel de ces jeux, un joueur humain contre
un autre, contre un joueur aléatoire, contre l’algorithme, ou encore l’algorithme contre lui-même, contre
un joueur aléatoire, etc.


Le dossier src/ contient les sources Java.
Le dossier lib/ est destiné à recevoir les librairies externes. 
Le dossier build/ à recevoir les fichiers compilés.


Les classes exécutables sont :

Package Nim
    - games.nim.MainNim : permet de jouer une partie de Nim à 2 joueurs humains, au clavier

    - games.nim.Test : lance les tests unitaires sur la classe Nim


Package TicTacToe
    - games.tictactoe.MainTicTacToe : permet de jouer au jeu du Morpion avec ou sans indices

    - games.tictactoe.Test : lance les tests unitaires sur la classe TicTacToe

    - games.tictactoe.TestWithHints: lance les tests unitaires sur la classe TicTacToeWithHints


Package FactoredGames
    - games.factoredgames.MainNim : permet de jouer une partie de Nim à 2 joueurs humains, au clavier

    - games.factoredgames.MainTicTacToe :  permet de jouer au jeu du Morpion avec ou sans indices en renseignant 
        comme coup un entier sous la  forme i = 3r + c (r=row, c=column)

    - games.factoredgames.TestAbstractGame : lance les tests unitaires sur la classe AbstractGame

    - games.factoredgames.TestFactoredGames : lance les tests unitaires sur les trois jeux factorisés


Package GenericGames

    - games.genericGames.Test : lance les tests unitaires sur les trois jeux abstraits et la classe AbstractGame


Package Players
    - games.players.Test : lance les tests unitaires sur les classes Human, RandomPlayer et NegamaxPlayer

    - games.players.TestNegamaxPlayer : lance les tests unitaires sur la classe NegamaxPlayer

    - games.players.TestNegamaxPlayerWithCache : lance les tests unitaires sur la classe NegamaxPlayerWithCache

Package Plays 
    - games.plays.MainPlay : permet de jouer aux jeux (Nim et TicTacToe) avec n'importe quelle combinaison de joueurs
    (Humains, Aléatoires, Négamax, Négamax avec cache, ou le mélange deux par deux de ces différents types de joueurs)

    - games.plays.Test : lance les tests unitaires sur la classe Orchestrator



Tous les tests sont passés pour chacune des classes testées.

Le code des différentes classes est commenté. Mais pas celui des classes exécutables.  