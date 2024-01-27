import java.io.IOException;

public class GameRun {
    public static void main(String[] args) {
        // Initialize new game state
        GameBoard gameState = new GameBoard();
        gameState.resetBoard();

        Human testHuman = new Human();
        testHuman.setSymbol('A');
        try {
            int flattenedCell = testHuman.chooseCell();
            gameState.setCell(flattenedCell, testHuman.getSymbol());
        }
        catch (IOException e) {
            System.out.println("Couldn't read player input...");
        }
        // Print board for player
        gameState.printBoard();
    }
}
