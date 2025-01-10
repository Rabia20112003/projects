import java.util.*;

class nqueen {

    static boolean isSafe(int board[][], int row, int col, int N) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    static boolean solveNQueens(int board[][], int row, int N) {
        if (row >= N) {
            printBoard(board, N);
            return true;
        }

        boolean res = false;
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col, N)) {
                board[row][col] = 1;
                res = solveNQueens(board, row + 1, N) || res;
                board[row][col] = 0; 
            }
        }
        return res;
    }

    static void printBoard(int board[][], int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the chessboard (N): ");

        int N = sc.nextInt();
        
        int[][] board = new int[N][N];
        
        if (!solveNQueens(board,0, N)) {
            System.out.println("No solution exists.");
        }
    }
}
