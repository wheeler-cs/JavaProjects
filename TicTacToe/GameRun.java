public class GameRun {
    public static void main(String[] args) {
        GameBoard gameState = new GameBoard();
        gameState.resetBoard();
        for (int i = 0; i < 9; i++)
            gameState.setCell(i % 3, i/3, 'X');
        gameState.printBoard();
    }
}
