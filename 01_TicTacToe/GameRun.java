import java.io.IOException;

public class GameRun {
    public static void main(String[] args) {
        // Initialize new game state
        GameBoard gameState = new GameBoard();
        gameState.resetBoard();

        Human testHuman = new Human();
        testHuman.setValue(1);

        gameState.setCell(0, testHuman);
        gameState.setCell(1, testHuman);
        gameState.setCell(2, testHuman);

        int result = gameState.checkForWinner();

        System.out.println(result);

        // Print board for player
        gameState.printBoard();
    }
}
