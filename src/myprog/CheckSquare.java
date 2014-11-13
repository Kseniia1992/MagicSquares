package myprog;

/**
 * Checks whether a matrix is a magic square.
 * @author ksolodovnik
 */
public class CheckSquare {
    /* magic square */
    int matrix[][];
    /* sum of columns, rows and diagonals */
    static final int SUM = 15;

    /**
     * Constructor
     * @param arr - two-dimensional array for checking
     */
    public CheckSquare(int[][] arr){
        this.matrix = arr;
    }

    /**
     * Checks the sum of all elements of rows and columns and diagonals of the array.
     * If sum = 15 it's a magic square.
     * @return res
     */
    protected boolean isMagic(){
        boolean res;
        if(rowAndColumn()==true && diagonalLeft() == true && diagonalRight() == true) {
            res = true;        //magic square
        }else{
            res = false;       //it is not a magic square
        }
        return res;
    }

    /**
     * Checks sum of left diagonal elements
     * @return true if sum = 15
     */
    private boolean diagonalLeft(){
        int sum = 0;
        for(int d = 0; d < matrix[0].length; d++)
            sum = sum + matrix[d][(matrix.length-1) - d];
        return (sum == SUM);
    }

    /**
     * Checks sum of right diagonal elements
     * @return true if sum = 15
     */
    private boolean diagonalRight (){
        int sum = 0;
        for (int d = 0; d < matrix[0].length; d++)
            sum = sum + matrix[d][d];
        return (sum == SUM);
    }

    /**
     * Checks sum of rows and columns elements
     * @return true if sum = 15
     */
    private boolean rowAndColumn(){
        int rowsum = 0, colsum = 0;
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                rowsum = rowsum + matrix[i][j];
                colsum = colsum + matrix[j][i];
            }
            if(rowsum != SUM || colsum != SUM)
                return false; // if the sums doesn't match
            rowsum = 0;      //reset row count
            colsum = 0;      //reset col count
        }
        return true;
    }
}
