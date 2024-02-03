import java.lang.NumberFormatException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Human extends Player {
    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int chooseCell() throws IOException {
        boolean goodInput = false;
        // Get coordinates from human player
        int x = 0, y = 0;
        while(!goodInput) {
            try {
                System.out.print("\nCell Selection\nx: ");
                x = Integer.parseInt(this.consoleReader.readLine());
                System.out.print("y: ");
                y = Integer.parseInt(this.consoleReader.readLine());
            }
            catch(NumberFormatException e)
            {
                System.out.println();
                continue;
            }

            if(x > 2 || y > 2)
                continue;
            
            goodInput = true;
        }

        // Convert 2-D coordinates to 1-D
        return (x + (y * 3));
    }


}
