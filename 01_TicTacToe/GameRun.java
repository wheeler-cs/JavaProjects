import java.io.IOException;
import java.lang.Math;

public class GameRun {
    public static void main(String[] args) {
        // Initialize new game state
        GameBoard gameState = new GameBoard();
        gameState.resetBoard();

        // Create two new players for game
        Player player1 = new Player();
        player1.setName("Player 1");
        player1.setValue(-1);
        Player player2 = new Player();
        player2.setName("Player 2");
        player2.setValue(1);

        // Main game loop
        int winnerStateCode = 0;
        do {
            System.out.print("Turn: ");
            if(gameState.getCurrentTurn() % 2 == 0) {
                System.out.print(player1.getName());
                doPlayerTurn(gameState, player1);
            }
            else {
                System.out.print(player2.getName());
                doPlayerTurn(gameState, player2);
            }
            gameState.printBoard();
            winnerStateCode = Math.abs(gameState.checkForWinner());
        } while((winnerStateCode == 0) && (winnerStateCode != 99));

        if(winnerStateCode == 99) {
            System.out.println("\nGame ends in a stalemate!");
        }

    }

    public static void doPlayerTurn(GameBoard gameState, Player activePlayer) {
        try {
            boolean goodInputFlag = false;
            int cellSelection = 0;
            while(goodInputFlag == false) {
                cellSelection = activePlayer.chooseCell();
                goodInputFlag = gameState.setCell(cellSelection, activePlayer);
            }
        }
        catch(IOException e) {
            System.out.println();
        }
    }
}
