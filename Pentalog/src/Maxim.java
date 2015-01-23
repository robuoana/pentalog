import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Maxim{
    int               m      = 2;
    int               dim    = 3;
    static double[][] matrix = new double[3][3];
    static Scanner    input  = new Scanner(System.in);
    
    public void readFile( String fileName ) throws IOException
    {
        String line = "";
        
        FileInputStream inputStream = new FileInputStream(fileName);
        DataInputStream in = new DataInputStream(inputStream);
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        
        int lineCount = 0;
        String[] numbers;
        while ( (line = bf.readLine()) != null )
        {
            numbers = line.split(" ");
            for ( int i = 0 ; i < dim ; i++ )
            {
                
                matrix[lineCount][i] = Double.parseDouble(numbers[i]);
            }
            
            lineCount++;
        }
        bf.close();
        
    }
    
    public void printArray( String fileName )
    {
        System.out.println("The matrix is:");
        
        for ( int i = 0 ; i < dim ; i++ )
        {
            for ( int j = 0 ; j < dim ; j++ )
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public String maxProduct( )
    {
        double maxProduct = 1;
        double temp = 1;
        int locali;
        String vals = "";
        String finalVals = "";
        
        // coloane
        for ( int row = 0 ; row < dim ; row++ )
        {
            
            for ( int col = 0 ; col < dim ; col++ )
            {
                vals = "";
                temp = 1;
                for ( int dist = 0 ; dist < m && col + dist < dim ; dist++ )
                {
                    temp = temp * matrix[row][col + dist];
                    vals += matrix[row][col + dist] + "*";
                }
                if ( temp > maxProduct )
                {
                    finalVals = vals;
                    maxProduct = temp;
                }
            }
        }
        
        // randuri
        for ( int col = 0 ; col < dim ; col++ )
        {
            for ( int row = 0 ; row < dim ; row++ )
            {
                vals = "";
                temp = 1;
                for ( int dist = 0 ; dist < m && row + dist < dim ; dist++ )
                {
                    temp = temp * matrix[row + dist][col];
                    vals += matrix[row + dist][col] + "*";
                }
                if ( temp > maxProduct )
                {
                    finalVals = vals;
                    maxProduct = temp;
                }
            }
        }
        
        // diagonale dreapta.
        for ( int row = 0 ; row < dim ; row++ )
        {
            int localCol;
            for ( int col = 0 ; col < row ; col++ )
            {
                vals = "";
                temp = 1;
                localCol = col;
                locali = row;
                for ( int dist = 0 ; dist < m && locali >= 0 ; dist++ )
                {
                    temp = temp * matrix[locali][localCol];
                    vals += matrix[locali][localCol] + "*";
                    locali--;
                    localCol++;
                }
                if ( temp > maxProduct )
                {
                    finalVals = vals;
                    maxProduct = temp;
                }
            }
        }
        
        // diagonala stanga
        for ( int row = dim - 1 ; row > 0 ; row-- )
        {
            int localCol, localRow;
            for ( int col = 0, x = row ; x <= dim - 1 ; col++, x++ )
            {
                
                vals = "";
                temp = 1;
                localCol = col;
                localRow = x;
                for ( int dist = 0 ; dist < m && localCol >= 0 ; dist++ )
                {
                    temp = temp * matrix[localRow][localCol];
                    vals += matrix[localRow][localCol] + "*";
                    localRow--;
                    localCol--;
                }
                if ( temp > maxProduct )
                {
                    finalVals = vals;
                    maxProduct = temp;
                }
            }
            
        }
        
        for ( int row = 0 ; row <= dim - 1 ; row++ )
        {
            
            int localCol, localY;
            for ( int col = 0, y = row ; (col <= dim - 1) && (y < dim) ; col++, y++ )
            {
                vals = "";
                temp = 1;
                localCol = col;
                localY = y;
                for ( int dist = 0 ; dist < m && localY < dim ; dist++ )
                {
                    temp = temp * matrix[localCol][localY];
                    vals += matrix[localCol][localY] + "*";
                    localY++;
                    localCol++;
                }
                if ( temp > maxProduct )
                {
                    finalVals = vals;
                    maxProduct = temp;
                }
            }
        }
        
        finalVals = finalVals.substring( 0, finalVals.length( ) - 1);
        return finalVals + "=" + maxProduct;
    }
    
}
