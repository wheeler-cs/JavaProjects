import java.util.Random;
import java.io.IOException;

public class Player {
    String playerName = "";
    char playerSymbol = ' ';

    public void setName(String newName) {
        this.playerName = newName;
    }

    public String getName() {
        return this.playerName;
    }

    public void setSymbol(char newSymbol) {
        this.playerSymbol = newSymbol;
    }

    public char getSymbol() {
        return this.playerSymbol;
    }

    public int chooseCell() throws IOException {
        // Default behavior of just randomly choosing a cell
        Random rand = new Random();
        return (rand.nextInt(8));
    }
}
