import java.util.Scanner;

class MagicSquareValidator 
{
    static boolean isMagicSquare(int[][] square) 
    {
        int n = square.length;

        // first row as reference
        int magicSum = 0;
        for (int j = 0; j < n; j++) 
        {
            magicSum += square[0][j];
        }

        // row
        for (int i = 0; i < n; i++) 
        {
            int rowSum = 0;
            for (int j = 0; j < n; j++) 
            {
                rowSum += square[i][j];
            }
            if (rowSum != magicSum) 
            {
                return false;
            }
        }

        // column
        for (int j = 0; j < n; j++) 
        {
            int colSum = 0;
            for (int i = 0; i < n; i++) 
            {
                colSum += square[i][j];
            }
            if (colSum != magicSum) 
            {
                return false;
            }
        }

        // main diagonal
        int mainDiagonalSum = 0;
        for (int i = 0; i < n; i++) 
        {
            mainDiagonalSum += square[i][i];
        }
        if (mainDiagonalSum != magicSum) 
        {
            return false;
        }

        // secondary diagonal
        int secondaryDiagonalSum = 0;
        for (int i = 0; i < n; i++) 
        {
            secondaryDiagonalSum += square[i][n - 1 - i];
        }
        if (secondaryDiagonalSum != magicSum) 
        {
            return false;
        }

        return true;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the square grid (n x n): ");
        int n = sc.nextInt();

        int[][] square = new int[n][n];
        System.out.println("Enter the elements of the square:");
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                square[i][j] = sc.nextInt();
            }
        }

        int magicSum = 0;
        for (int j = 0; j < n; j++) 
        {
            magicSum += square[0][j];
        }

        if (isMagicSquare(square)) 
        {
            System.out.println("The input is a magic square.");
            System.out.println("The magic sum is: " + magicSum);
        } 
        else 
        {
            System.out.println("The input is not a magic square.");
        }

        sc.close();
    }
}
