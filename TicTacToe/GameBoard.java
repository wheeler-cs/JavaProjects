public class GameBoard {
    private char[] board = {' ', ' ', ' ', ' ', ' ', ' ' , ' ', ' ', ' '};
    int currentTurn = 0;

    public void resetBoard() {
        for(int i = 0; i < 9; i++)
            this.board[i] = ' ';
        this.currentTurn = 0;
    }

    public boolean setCell(int x, int y, char symbol) {
        // Convert the 2-D cell to corresponding 1-D cell
        int flattenedIndex = (x + (y * 3));
        // Only set if empty
        if(this.board[flattenedIndex] == ' ')
        {
            this.board[flattenedIndex] = symbol;
            ++this.currentTurn;
        }
        else
        {
            return false;
        }

        return true;
    }

    public char getCell(int x, int y) {
        return(this.board[x + (y * 3)]);
    }

    public void printBoard() {
        for(int i = 0; i < 9; i++) {
            if(i % 3 == 2)
                System.out.println(this.board[i]);
            else {
                System.out.print(this.board[i]);
                System.out.print(' ');
            }
        }
        System.out.println();
    }
}
