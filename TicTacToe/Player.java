import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Player {
    char playerSymbol = ' ';

    public void setSymbol(char newSymbol) {
        this.playerSymbol = newSymbol;
    }

    public int chooseCell() throws IOException {
        // Default behavior of just randomly choosing a cell
        Random rand = new Random();
        return (rand.nextInt(8));
    }
}

class Human extends Player {
    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int chooseCell() throws IOException {
        System.out.print("Enter your cell in x,y format: ");
        String coordinates = this.consoleReader.readLine();

        return 0;
    }
}

class AI extends Player {

}
