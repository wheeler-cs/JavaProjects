import java.util.Random;
import java.io.IOException;

public class Player {
    String playerName = "";
    int playerValue = 0;

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

    public int chooseCell() throws IOException {
        // Default behavior of just randomly choosing a cell
        Random rand = new Random();
        return (rand.nextInt(8));
    }
}
