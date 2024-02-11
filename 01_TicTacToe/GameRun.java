import java.io.IOException;
import java.lang.Math;

public class GameRun {
    public static void main(String[] args) {
        // Initialize new game state
        GameBoard gameState = new GameBoard();
        gameState.resetBoard();

        // Create two new players for game
        Player player1 = new AI();
        player1.setName("CPU");
        player1.setValue(-1);
        player1.setOpponent(1);
        Player player2 = new Human();
        player2.setName("Human Player");
        player2.setValue(1);

        // Main game loop
        int winnerStateCode = 0;
        do {
            System.out.print("Turn " + (gameState.getCurrentTurn() + 1) + ", ");
            if(gameState.getCurrentTurn() % 2 == 0) {
                doPlayerTurn(gameState, player1);
            }
            else {
                doPlayerTurn(gameState, player2);
            }
            gameState.printBoard();
            winnerStateCode = Math.abs(gameState.checkForWinner());
        } while((winnerStateCode == 0) && (winnerStateCode != 99));

        if(winnerStateCode == -1) {
            System.out.println(player1.getName() + " wins!");
        }
        else if (winnerStateCode == 1) {
            System.out.println(player2.getName() + " wins!");
        }
        else {
            System.out.println("\nGame ends in a stalemate!");
        }
    }

    public static void doPlayerTurn(GameBoard gameState, Player activePlayer) {
        try {
            boolean goodInputFlag = false;
            int cellSelection = 0;
            while(goodInputFlag == false) {
                activePlayer.intakeBoard(gameState);
                cellSelection = activePlayer.chooseCell();
                goodInputFlag = gameState.setCell(cellSelection, activePlayer);
            }
        }
        catch(IOException e) {
            System.out.println();
        }
    }
}
