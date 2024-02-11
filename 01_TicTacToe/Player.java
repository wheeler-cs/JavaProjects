import java.util.Random;
import java.io.IOException;

public class Player {
    String playerName = "";
    int playerValue = 0, opponentValue = 0;

    public void setName(String newName) {
        this.playerName = newName;
    }

    public String getName() {
        return this.playerName;
    }

    public void setValue(int newValue) {
        this.playerValue = newValue;
    }

    public int getValue() {
        return this.playerValue;
    }

    public void setOpponent(int newValue) {
        this.opponentValue = newValue;
    }

    public int getOpponent() {
        return this.opponentValue;
    }

    public int chooseCell() throws IOException {
        // Default behavior of just randomly choosing a cell
        Random rand = new Random();
        return (rand.nextInt(9));
    }

    public void intakeBoard(GameBoard gameState) {
        int[] gameVector = gameState.getBoard();
        for(int i = 0; i < 9; i++) {
            if(i % 3 == 0)
                System.out.println();
            if(gameVector[i] == -1)
                System.out.print("O ");
            else if(gameVector[i] == 1)
                System.out.print("X ");
            else
                System.out.print("_ ");
        }
        System.out.println();
    }
}
