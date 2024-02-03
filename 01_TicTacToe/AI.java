import java.io.IOException;

public class AI extends Player {

    int nextMove = 0;

    @Override
    public int chooseCell() throws IOException {
        return this.nextMove;
    }

    @Override
    public void intakeBoard(int[] gameVector) {
        // Check to see if board is empty
        boolean isFirstTurn = true;
        for(int i = 0; i < 9; i++) {
            if(gameVector[i] != 0) {
                isFirstTurn = false;
                break;
            }
        }
        // Monopolize on the center cell if it's the first turn (don't need algo for that)
        if(isFirstTurn) {
            this.nextMove = 4;
        }
        // Need a more complex algorithm because moves have already been made
        else {
            this.nextMove = this.calculateNextMove(gameVector);
        }
    }

    public int calculateNextMove(int[] gameVectory) {
        return 0;
    }
}
