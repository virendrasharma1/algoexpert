package graphs;

public class wordSearchBoard {

    static boolean wordExists(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, 0, i, j)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    static boolean dfs(char[][] board, String word, int wordIndex, int row, int column) {

        if (wordIndex == word.length()) return true;
        if (row < 0 || column < 0) return false;
        if (row >= board.length || column >= board[0].length) return false;

        char character = word.charAt(wordIndex);

        if(character == board[row][column]) {
            return dfs(board, word, wordIndex + 1, row + 1, column) ||
                    dfs(board, word, wordIndex + 1, row - 1, column) ||
                    dfs(board, word, wordIndex + 1, row, column + 1) ||
                    dfs(board, word, wordIndex + 1, row, column - 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] rivers = new char[][]{
                {'A', 'W', 'O', 'R'},
                {'T', 'E', 'R', 'K'},
                {'T', 'A', 'K', 'A'}
        };
        System.out.println(wordExists(rivers, "AWORKREG"));
    }
}
