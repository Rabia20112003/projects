import java.util.*;

class sudoko {

  public static boolean solveSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {

          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
              board[i][j] = c;

              if (solveSudoku(board))
                return true;
              else
                board[i][j] = '.';
            }
          }

          return false;
        }
      }
    }
    return true;
  }

  public static boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == c)
        return false;

      if (board[row][i] == c)
        return false;

      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[][] board = new char[9][9];

    System.out.println("Enter the Sudoku board row by row:");
    System.out.println("Use '.' for empty cells and digits '1' to '9' for numbers.");
    
    for (int i = 0; i < 9; i++) {
      String row;
      while (true) {
        System.out.print("Row " + (i + 1) + ": ");
        row = sc.nextLine();
        if (row.length() == 9) {
          break;
        } else {
          System.out.println("Invalid input. Please enter exactly 9 characters.");
        }
      }
      board[i] = row.toCharArray();
    }

    if (solveSudoku(board)) {
      System.out.println("\nSolved Sudoku:");
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++)
          System.out.print(board[i][j] + " ");
        System.out.println();
      }
    } else {
      System.out.println("No solution exists for the given Sudoku.");
    }

    sc.close();
  }
}
