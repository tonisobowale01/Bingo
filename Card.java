public class Card {
    //    Data members
    private final int SIZE = 5; // Bingo 5x5
    private final int[][] card = new int[SIZE][SIZE];

    //    Constructors
    public Card() {
       cardGenerator();
    }

    //    Method to create the Bingo card with unique numbers
    private void cardGenerator(){
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int num;
                do {
                    num = (j * 15) + getRandomNumber(1, 15);
                }   while(checkNumber(num));
                card[i][j] = num;
            }
        }
        card[2][2] = 0;
    }

    //  Method to check if the number is present in the card
    private boolean checkNumber(int num) {
        for (int [] row : card) {
            for (int value : row) {
                if(value == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public void displayCard() {
        System.out.println("Here is your card: ");
        for (int[] row  : card) {
            for (int value : row) {
                System.out.printf("%-4d", value);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void markNumber(int num) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (card[i][j] == num) {
                    card[i][j] = 0;
                    break;
                }
            }
        }
    }

    public boolean checkForBingo() {
        // Check rows, columns, and diagonals
        if (checkRows(card) || checkCols(card) || checkDias(card)){
            return true;
        }
        return false;
    }


    private boolean checkRows(int[][] value) {
        // Rows are horizontal
        // This loop iterates over the rows in the grid(Array)
        for (int row = 0; row < value.length; row++) {
            // This keeps count of the matching condition which is how many zeros are in a row
            int zeroCount = 0;
            // This loop iterates over the columns in the grid
            for (int column = 0; column < value[row].length; column++) {
                // This checks each values in a row that matches zero
                if(value[row][column] == 0) {
                    zeroCount++;
                }
            }
            // This checks whether the total number of zeros in a row is equal to SIZE
            if (zeroCount == SIZE){
                return true;
            }
        }
        return false;
    }
    private boolean checkCols(int[][] value) {
        // Columns are vertical
        // This loop iterates over the columns in the grid(Array)
        for (int column = 0; column < value.length; column++) {
            // This keeps count of the matching condition which is how many zeros are in a column
            int zeroCount = 0;
            // This loop iterates over the rows in the grid
            for (int row = 0; row < value[column].length; row++) {
                // This checks each values in a column that matches zero
                if (value[row][column] == 0) {
                    zeroCount++;
                }
            }
            // This checks whether the total number of zeros in a column is equal to SIZE
            if (zeroCount == SIZE) {
                return true;
            }
        }
        return false;
    }
    private boolean checkDias(int[][] value){
        /*
         * Logic for checking diagonals
         * Left  Right
         * 0, 0  0, 2
         * 1, 1  1, 1
         * 2, 2  2, 0
         *
         * */
        return leftDiagonal(value) || rightDiagonal(value);
    }
    private boolean leftDiagonal(int[][] value) {
        // This keeps count of the matching condition which is how many zeros are in the left diagonal
        int zeroCount = 0;
        // Loops Left logic
        for (int diagonal = 0; diagonal < value.length; diagonal++){
            if (value[diagonal][diagonal] == 0) {
                zeroCount++;
            }
        }
        // This checks total number of zeros in the left diagonal
        if (zeroCount == SIZE) {
            return true;
        }
        return false;
    }

    private boolean rightDiagonal(int[][] value) {
        // This keeps count of the matching condition which is how many zeros are in the right diagonal
        int zeroCount = 0;
        // Loops Right logic
        for (int diagonal = 4; diagonal >= 0; diagonal--){
            if (value[(4-diagonal)][diagonal] == 0) {
                zeroCount++;
            }
        }
        // This checks total number of zeros in the right diagonal
        if (zeroCount == SIZE) {
            return true;
        }
        return false;
    }
}
