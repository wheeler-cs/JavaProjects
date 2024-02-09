import java.util.Random;
import java.io.IOException;

public class AI extends Player {

    int nextMove = 0;

    @Override
    public int chooseCell() throws IOException {
        System.out.println("AI Chooses: " + this.nextMove);
        return this.nextMove;
    }

    @Override
    public void intakeBoard(GameBoard gameState) {
        System.out.println("CPU is thinking...");
        // Monopolize on the center cell if it's the first turn (don't need algo for that)
        if(gameState.getCurrentTurn() == 0) {
            this.nextMove = 4;
        }
        // Need a more complex algorithm because moves have already been made
        else {
            this.calculateNextMove(gameState.getBoard(), this.playerValue, 5);
        }
    }

    public int calculateNextMove(int[] gameVector, int actingPlayer, int depth) {
        // Create a duplicate game board for testing scenario
        GameBoard predictedGame = new GameBoard();
        predictedGame.copyBoard(gameVector);

        // Maximum recursion depth has been reached, just give a random empty space
        if(depth <= 0) {
            int randomCell = 0;
            Random rand = new Random();
            do {
                randomCell = rand.nextInt(9);
            } while(gameVector[randomCell] != 0);
            this.nextMove = randomCell;
            return 0;
        }

        int moveScore = 0, bestScore = 0;
        for(int i = 0; i < 9; i++) {
            // Cell isn't taken, predict game based on taking it
            if(predictedGame.getCell(i) == 0) {
                predictedGame.setCell(i, actingPlayer);
                // Check if the move made leads to the actor winning
                if(predictedGame.checkForWinner() == this.playerValue)
                    return 1000;
                else if(predictedGame.checkForWinner() == this.opponentValue)
                    return -1000;
                
                // No winner, do the next turn for actingPlayer's opponent
                if(actingPlayer == this.playerValue)
                    moveScore = this.calculateNextMove(gameVector, this.opponentValue, depth - 1);
                else
                    moveScore = this.calculateNextMove(gameVector, this.playerValue, depth - 1);

                // A better move was found, replace the current one
                if(moveScore > bestScore) {
                    bestScore = moveScore;
                    this.nextMove = i;
                }
                predictedGame.setCell(i, 0);
            }
        }

        return bestScore;
    }
}