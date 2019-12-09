
public class SudokuResolver
{
    static int[][] SUDOKU_BOARD = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
        { 0, 7, 0, 0, 9, 0, 2, 0, 0 }, { 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
        { 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6, 8 }, { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
        { 0, 9, 0, 0, 0, 0, 4, 0, 0 } };
    static boolean isSolve = false;
    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 9;
    
    public static void main( String[] args )
    {
        // TODO: Should have 1 method check for board before execute any sudoku
        // resolver
        printSudoku();
        
        for ( int x = 0; x < SUDOKU_BOARD.length; x++ )
        {
            for ( int y = 0; y < SUDOKU_BOARD[0].length; y++ )
            {
                if ( SUDOKU_BOARD[x][y] == 0 )
                {
                    solveSudoku( x, y, MIN_VALUE );
                    break;
                }
                
            }
        }
        System.out.println( "------------------------------------" );
        printSudoku();
        
    }
    
    private static boolean solveSudoku( int rowIndex, int columnIndex, int value )
    {
        if ( isSolve )
        {
            return true;
        }
        boolean validateRow = canPutRowValue( value, rowIndex );
        boolean validateColumn = canPutColumnValue( value, columnIndex );
        
        if ( validateRow && validateColumn )
        {
            SUDOKU_BOARD[rowIndex][columnIndex] = value;
            if ( rowIndex == MAX_VALUE - 1 && columnIndex == MAX_VALUE - 1 && SUDOKU_BOARD[rowIndex][columnIndex] != 0 )
            {
                isSolve = true;
            }
            boolean canPut = columnIndex == MAX_VALUE - 1
                ? solveSudoku( rowIndex + 1, 0,
                    SUDOKU_BOARD[rowIndex + 1][0] > 0 ? SUDOKU_BOARD[rowIndex + 1][0] : MIN_VALUE )
                : solveSudoku( 0, columnIndex + 1,
                    SUDOKU_BOARD[0][columnIndex + 1] > 0 ? SUDOKU_BOARD[0][columnIndex + 1] : MIN_VALUE );
            if ( !canPut )
            {
                System.out.println( rowIndex + "::" + columnIndex + "::" + value );
                SUDOKU_BOARD[rowIndex][columnIndex] = 0;
                return false;
            }
            
            return true;
        }
        else
        {
            if ( value == MAX_VALUE )
            {
                return false;
            }
            return solveSudoku( rowIndex, columnIndex, ++value );
        }
    }
    
    private static void printSudoku()
    {
        for ( int x = 0; x < SUDOKU_BOARD.length; x++ )
        {
            for ( int y = 0; y < SUDOKU_BOARD[0].length; y++ )
            {
                if ( SUDOKU_BOARD[x][y] == 0 )
                {
                    System.out.print( ". " );
                }
                else
                {
                    System.out.print( SUDOKU_BOARD[x][y] + " " );
                }
            }
            System.out.println();
        }
    }
    
    /**
     * 
     * Validate the value with the row(index)
     * 
     * @param value
     * @param row
     * @return
     */
    static boolean canPutRowValue( int value, int row )
    {
        for ( int x = 0; x < SUDOKU_BOARD.length; x++ )
        {
            if ( value == SUDOKU_BOARD[row][x] )
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * Validate the value with the row(column)
     * 
     * @param value
     * @param column
     * @return
     */
    static boolean canPutColumnValue( int value, int column )
    {
        for ( int x = 0; x < SUDOKU_BOARD[column].length; x++ )
        {
            if ( value == SUDOKU_BOARD[x][column] )
            {
                return false;
            }
        }
        return true;
    }
    
    static int[][] getNextTargetColumnIndex( int currentRowIndex, int currentColumnIndex )
    {
        for ( int x = currentRowIndex; x < MAX_VALUE; x++ )
        {
            for ( int y = currentColumnIndex; y < MAX_VALUE; y++ )
            {
                if ( SUDOKU_BOARD[x][y] > 0 )
                {
                    continue;
                }
                return SUDOKU_BOARD[x][y];
            }
            
        }
    }
}

class NextTargetObject{
    
}
