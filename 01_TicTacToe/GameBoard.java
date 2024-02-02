public class GameBoard {
    private int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    final private int[] magic_square = {8, 3, 4, 1, 5, 9, 6, 7, 2};
    private int currentTurn = 0;

    public int getCurrentTurn() {
        return this.currentTurn;
    }

    public boolean setCell(int cellIndex, Player activePlayer) {
        /* Indices for board in a 2-D array instead of a vector
         * 0 1 2
         * 3 4 5
         * 6 7 8
         */
        // Only set if empty
        if(this.board[cellIndex] == 0) {
            this.board[cellIndex] = activePlayer.playerValue;
            ++this.currentTurn;
        }
        else
            return false;

        return true;
    }

    public int getCell(int x, int y) {
        return(this.board[x + (y * 3)]);
    }

    public void resetBoard() {
        for(int i = 0; i < 9; i++)
            this.board[i] = 0;
        this.currentTurn = 0;
    }

    public int checkForWinner() {
        /* Magic square for board
         * 8 3 4
         * 1 5 9
         * 6 7 2
         * Source: https://vtupulse.com/artificial-intelligence/tic-tac-toe-game-using-magic-square-program-2-in-ai/
         */
        // Sum rows
        int sum;
        for(int i = 0; i < 3; i++) {
            sum = (this.magic_square[i * 3] * this.board[i * 3]) +
                  (this.magic_square[(i * 3) + 1] * this.board[(i * 3) + 1]) +
                  (this.magic_square[(i * 3) + 2] * this.board[(i * 3) + 2]);
            if(sum == 15)
                return 1;
            else if(sum == -15)
                return -1;
        }

        // Sum columns
        for(int i = 0; i < 3; i++) {
            sum = (this.magic_square[i] * this.board[i]) +
                  (this.magic_square[i + 3] * this.board[i + 3]) +
                  (this.magic_square[i + 6] * this.board[i + 6]);

            if(sum == 15)
                return 1;
            else if (sum == -15)
                return -1;
        }

        // Sum "back slash" diagonal
        sum = (this.magic_square[0] * this.board[0]) +
              (this.magic_square[4] * this.board[4]) +
              (this.magic_square[8] * this.board[8]);
        if(sum == 15)
            return 1;
        else if(sum == -15)
            return -1;

        // Sum "forward slash diagonal
        sum = (this.magic_square[2] * this.board[2]) +
              (this.magic_square[4] * this.board[4]) +
              (this.magic_square[6] * this.board[6]);

        if(sum == 15)
            return 1;
        else if(sum == -15)
            return -1;

        // Check for draw state
        for(int i = 0; i < 9; i++) {
            if(this.board[i] == 0)
                return 0;
        }

        return 99;
    }

    public void printBoard() {
        for(int i = 0; i < 9; i++) {
            if(i % 3 == 0)
                System.out.println();
            if(this.board[i] == -1)
                System.out.print("O ");
            else if(this.board[i] == 1)
                System.out.print("X ");
            else
                System.out.print("_ ");
        }
        System.out.println('\n');
    }
}
