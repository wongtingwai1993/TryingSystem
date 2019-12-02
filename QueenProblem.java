package com.sgx.regsub;

public class QueenProblem
{
    static final int boardSizeWidthIndex = 3;
    static final int boardSizeHeightIndex = 3;
    static int[][] chessBoard = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
    static int totalQueen = 0;
    
    public static void main( String[] args )
    {
        // init data
        for(int x = 0; x < chessBoard.length; x++){
            for(int y=0; y< chessBoard[0].length; y++){
                
            }
        }
        
        
        
        for ( int x = 0; x < boardSizeWidthIndex; x++ )
        {
            boolean isSolvable = queenLocation( 0, x );
            
            if ( isSolvable )
            {
                printAnswer();
            }
            System.out.println( "--------------------------" );
        }
    }
    
    private static void printAnswer()
    {
        System.out.println( "Good to go!" );
        for ( int row = 0; row < chessBoard.length; row++ )
        {
            for ( int col = 0; col < chessBoard[row].length; col++ )
            {
                System.out.print( chessBoard[row][col] );
                if ( chessBoard[row][col] == 1 )
                {
                    chessBoard[row][col] = 0;
                }
            }
            System.out.println( "" );
        }
    }
    
    public static boolean queenLocation( int row, int col )
    {
        boolean placeable = chessLocationValidator( row, col );
        
        // reach last row
        if ( placeable && row == boardSizeWidthIndex )
        {
            chessBoard[row][col] = 1;
            return true;
        }
        if ( !placeable && col == boardSizeHeightIndex )
        {
            return false;
        }
        
        if ( placeable )
        {
            System.out.println( "Place queen at: x:" + row + ",y::" + col );
            chessBoard[row][col] = 1;
            if ( !queenLocation( row + 1, 0 ) )
            {
                chessBoard[row][col] = 0;
                return false;
            }
            return true;
        }
        else
        {
            chessBoard[row][col] = 0;
            System.out.println( "Try Place queen at: x:" + row + "y::" + ( col + 1 ) );
            return queenLocation( row, col + 1 );
        }
    }
    
    private static boolean chessLocationValidator( int row, int col )
    {
        boolean placeable = false;
        // check row
        boolean checkRow = chessBoard[row][0] != 1 && chessBoard[row][1] != 1 && chessBoard[row][2] != 1;
        // check col
        boolean checkCol = chessBoard[0][col] != 1 && chessBoard[1][col] != 1 && chessBoard[2][col] != 1;
        // check left top diagonal
        boolean checkUpperLeftDiagonal = true;
        int tempRow = row;
        int tempCol = col;
        while ( tempRow - 1 > -1 && tempCol - 1 > -1 && checkUpperLeftDiagonal )
        {
            if ( chessBoard[tempRow - 1][tempCol - 1] == 1 )
            {
                checkUpperLeftDiagonal = false;
            }
            tempRow -= 1;
            tempCol -= 1;
        }
        // check btm right diagonal
        boolean checkBtmRightDiagonal = true;
        tempRow = row;
        tempCol = col;
        while ( tempRow + 1 < boardSizeWidthIndex && tempCol + 1 < boardSizeHeightIndex && checkBtmRightDiagonal )
        {
            if ( chessBoard[tempRow + 1][tempCol + 1] == 1 )
            {
                checkBtmRightDiagonal = false;
            }
            tempRow += 1;
            tempCol += 1;
        }
        // check upper right diagonal
        boolean checkUpperRightDiagonal = true;
        tempRow = row;
        tempCol = col;
        while ( tempRow - 1 > -1 && tempCol + 1 < boardSizeHeightIndex + 1 && checkUpperRightDiagonal )
        {
            if ( chessBoard[tempRow - 1][tempCol + 1] == 1 )
            {
                checkUpperRightDiagonal = false;
            }
            tempRow -= 1;
            tempCol += 1;
        }
        // check btm left diagonal
        boolean checkBtmLeftDiagonal = true;
        tempRow = row;
        tempCol = col;
        while ( tempRow - 1 > -1 && tempCol + 1 > boardSizeHeightIndex + 1 && checkBtmLeftDiagonal )
        {
            if ( chessBoard[tempRow - 1][tempCol + 1] == 1 )
            {
                checkBtmLeftDiagonal = false;
            }
            tempRow -= 1;
            tempCol -= 1;
        }
        if ( checkRow && checkCol && checkUpperLeftDiagonal && checkBtmRightDiagonal && checkUpperRightDiagonal &&
            checkBtmLeftDiagonal )
        {
            placeable = true;
        }
        return placeable;
    }
}
