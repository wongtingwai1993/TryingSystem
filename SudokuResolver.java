import java.time.LocalDateTime;

public class SudokuResolver
{
    static int[][] SUDOKU_BOARD = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
        { 0, 7, 0, 0, 9, 0, 2, 0, 0 }, { 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
        { 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6, 8 }, { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
        { 0, 9, 0, 0, 0, 0, 4, 0, 0 } };
    
    static int[][] CLONE_SUDOKU_BOARD = SUDOKU_BOARD;
    
    static boolean isSolve = false;
    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 9;
    static int targetX = 0;
    static int targetY = 0;
    
    static int initX = 0;
    static int initY = 1;
    
    public static void main( String[] args )
    {
        // TODO: Should have 1 method check for board before execute any sudoku
        // resolver
        System.out.println( LocalDateTime.now() );
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
        System.out.println( "DONE" );
        System.out.println( LocalDateTime.now() );
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
        boolean validateBox = canPutBoxValue( value, rowIndex, columnIndex );
        
        if ( validateRow && validateColumn && validateBox )
        {
            // update sudoku value
            SUDOKU_BOARD[rowIndex][columnIndex] = value;
            // System.out.println( "UPDATED-" + rowIndex + "::" + columnIndex +
            // "::" + value );
            
            // printSudoku();
            
            if ( rowIndex == MAX_VALUE - 1 && columnIndex == MAX_VALUE - 1 && SUDOKU_BOARD[rowIndex][columnIndex] != 0 )
            {
                isSolve = true;
                return true;
            }
            // proceed next value
            boolean isGetNextValue = getNextTargetColumnIndex( rowIndex, columnIndex );
            
            if ( isGetNextValue )
            {
                if ( !solveSudoku( targetX, targetY, MIN_VALUE ) )
                {
                    SUDOKU_BOARD[rowIndex][columnIndex] = 0;
                    // System.out.println( "rollback-" + rowIndex + "::" +
                    // columnIndex + "::" + value );
                    // printSudoku();
                    
                    // get back previous
                    if ( value + 1 > MAX_VALUE )
                    {
                        return false;
                    }
                    
                    return solveSudoku( rowIndex, columnIndex, ++value );
                }
                return true;
            }
            else
            {
                return false;
            }
            
        }
        else
        {
            if ( value == MAX_VALUE )
            {
                SUDOKU_BOARD[rowIndex][columnIndex] = 0;
                // System.out.println( "REACH MAX-" + rowIndex + "::" +
                // columnIndex + "::" + value );
                // printSudoku();
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
        System.out.println( "------------------------------------" );
    }
    
    /**
     * 
     * Validate the value with the row(index)
     * 
     * @param value
     * @param rowIndex
     * @return
     */
    static boolean canPutRowValue( int value, int rowIndex )
    {
        for ( int x = 0; x < SUDOKU_BOARD.length; x++ )
        {
            if ( value == SUDOKU_BOARD[rowIndex][x] )
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * Validate the value with the affected box(index)
     * 
     * @param value
     * @param currentRowIndex
     * @return
     */
    static boolean canPutBoxValue( int value, int currentRowIndex, int currentColIndex )
    {
        int rowStartIndex = 0;
        int rowValue = currentRowIndex + 1;
        if ( rowValue % 3 == 0 )
        {
            if ( rowValue / 3 == 1 )
            {
                // group 1
                rowStartIndex = 0;
            }
            if ( rowValue / 3 == 2 )
            {
                // group 2
                rowStartIndex = 3;
            }
            if ( rowValue / 3 == 3 )
            {
                // group 3
                rowStartIndex = 6;
            }
        }
        else
        {
            if ( rowValue / 3 == 0 )
            {
                // group 1
                rowStartIndex = 0;
            }
            if ( rowValue / 3 == 1 )
            {
                // group 2
                rowStartIndex = 3;
            }
            if ( rowValue / 3 == 2 )
            {
                // group 3
                rowStartIndex = 6;
            }
        }
        // retrieve column start value
        int colStartIndex = 0;
        int colValue = currentColIndex + 1;
        if ( colValue % 3 == 0 )
        {
            if ( colValue / 3 == 1 )
            {
                // group 1
                colStartIndex = 0;
            }
            if ( colValue / 3 == 2 )
            {
                // group 2
                colStartIndex = 3;
            }
            if ( colValue / 3 == 3 )
            {
                // group 3
                colStartIndex = 6;
            }
        }
        else
        {
            if ( colValue / 3 == 0 )
            {
                // group 1
                colStartIndex = 0;
            }
            if ( colValue / 3 == 1 )
            {
                // group 2
                colStartIndex = 3;
            }
            if ( colValue / 3 == 2 )
            {
                // group 3
                colStartIndex = 6;
            }
        }
        
        for ( int x = rowStartIndex; x < rowStartIndex + 3; x++ )
        {
            for ( int y = colStartIndex; y < colStartIndex + 3; y++ )
            {
                if ( value == SUDOKU_BOARD[x][y] )
                {
                    return false;
                }
            }
            
        }
        return true;
    }
    
    /**
     * 
     * Validate the value with the row(column)
     * 
     * @param value
     * @param columnIndex
     * @return
     */
    static boolean canPutColumnValue( int value, int columnIndex )
    {
        for ( int x = 0; x < SUDOKU_BOARD[columnIndex].length; x++ )
        {
            if ( value == SUDOKU_BOARD[x][columnIndex] )
            {
                return false;
            }
        }
        return true;
    }
    
    static boolean getNextTargetColumnIndex( int currentRowIndex, int currentColumnIndex )
    {
        int startingY = ( currentColumnIndex + 1 == MAX_VALUE ) ? 0 : currentColumnIndex;
        int startingX = ( currentColumnIndex + 1 == MAX_VALUE ) ? currentRowIndex + 1 : currentRowIndex;
        
        for ( int x = startingX; x < MAX_VALUE; x++ )
        {
            for ( int y = startingY; y < MAX_VALUE; y++ )
            {
                // reset column value if row updated
                if ( x != startingX )
                {
                    startingX = x;
                    y = 0;
                }
                if ( CLONE_SUDOKU_BOARD[x][y] == 0 )
                {
                    targetX = x;
                    targetY = y;
                    return true;
                }
            }
        }
        return false;
    }
}