import java.util.Arrays;
class valid_sudoku {
    public boolean isValidSudoku(char[][] board){
        //gud
        //1ms to 4ms
        int[][] chckR = new int[9][9];
        int[][] chckC = new int[9][9];
        int[][][] chckB = new int[3][3][9];
        for(int i=0 ; i<9; i++){
            for(int j=0; j<9 ;j++){
                if(board[i][j]!='.'){
                    int index = board[i][j]-'1';
                    chckR[j][index] += 1;
                    chckC[i][index] += 1;
                    chckB[i/3][j/3][index] += 1;
                    if(chckR[j][index] > 1 || chckC[i][index] > 1 || chckB[i/3][j/3][index]>1) return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku2(char[][] board){
        //8ms
        //printMatrix(board);
        char[][] tboard = transpose(board);
        char[][] nboard = copy2DArray(board);
        //printMatrix(nboard);
        for(int i=0 ; i<9; i++){
            int[] nums = {0,0,0,0,0,0,0,0,0};
            Arrays.sort(board[i]);
            for(int j=8; j>=0 ;j--){
                if(board[i][j]=='.'){
                    break;
                }
                nums[board[i][j]-49] += 1;
                if(nums[board[i][j]-49]>1){
                    //System.out.println(board[i]);
                    for(char k : board[i]){
                        System.out.print(k);
                    }
                    System.out.println();
                    return false;
                }
            }
        }
        //board = transpose(board);
        //System.out.println("Transposed");
        //printMatrix(board);
        for(int i=0 ; i<9; i++){
            int[] nums = {0,0,0,0,0,0,0,0,0};
            Arrays.sort(tboard[i]);
            for(int j=8; j>=0 ;j--){
                if(tboard[i][j]=='.'){
                    break;
                }
                nums[tboard[i][j]-49] += 1;
                if(nums[tboard[i][j]-49]>1){
                    //System.out.println(board[i]);
                    for(char k : tboard[i]){
                        System.out.print(k);
                    }
                    return false;
                }
            }
        }
        //printMatrix(nboard);
        if(checkBox(nboard, 0, 0)&&checkBox(nboard, 0, 3)&&checkBox(nboard, 0, 6)&&checkBox(nboard, 3, 0)&&checkBox(nboard, 3, 3)&&checkBox(nboard, 3, 6)&&checkBox(nboard, 6, 0)&&checkBox(nboard, 6, 3)&&checkBox(nboard, 6, 6)){
            return true;
        }
        return false;
    }
    public boolean isValidSudoku3(char[][] board){
        //13ms
        //printMatrix(board);
        char[][] tboard = transpose(board);
        char[][] nboard = copy2DArray(board);
        //printMatrix(nboard);
        for(int i=0 ; i<9; i++){
            //int[] nums = {0,0,0,0,0,0,0,0,0};
            Arrays.sort(board[i]);
            for(char k : board[i]){
                System.out.print(k);
            }
            System.out.println();
            for(int j=8; j>0 ;j--){
                if(tboard[i][j]=='.'){
                    break;
                }
                System.out.println(board[i][j]);
                if(tboard[i][j]==tboard[i][j-1]){
                    return false;
                }
            }
        }
        //board = transpose(board);
        //System.out.println("Transposed");
        //printMatrix(board);
        System.out.println();
        for(int i=0 ; i<9; i++){
            //int[] nums = {0,0,0,0,0,0,0,0,0};
            Arrays.sort(tboard[i]);
            for(char k : tboard[i]){
                System.out.print(k);
            }
            System.out.println();
            for(int j=8; j>0 ;j--){
                if(board[i][j]=='.'){
                    break;
                }
                if(board[i][j]==board[i][j-1]){
                    return false;
                }
            }
        }
        if(checkBox(nboard, 0, 0)&&checkBox(nboard, 0, 3)&&checkBox(nboard, 0, 6)&&checkBox(nboard, 3, 0)&&checkBox(nboard, 3, 3)&&checkBox(nboard, 3, 6)&&checkBox(nboard, 6, 0)&&checkBox(nboard, 6, 3)&&checkBox(nboard, 6, 6)){
            return true;
        }
        return false;
    }
    private static char[][] transpose(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] transposedMatrix = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
    private static boolean checkBox(char[][] board, int si, int sj){
        int[] nums = {0,0,0,0,0,0,0,0,0};
        for(int i = si; i<si+3; i++){
            //System.out.println();
            for(int j = sj; j<sj+3; j++){
                if(!(board[i][j]=='.')){
                    nums[board[i][j]-49] += 1;
                    if(nums[board[i][j]-49]>1){
                        System.out.println(si+" "+sj);
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private static void printMatrix(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t"); // Separate elements with tabs
            }
            System.out.println(); // Move to the next line for the next row
        }
    }
    public static char[][] copy2DArray(char[][] original) {
        int rows = original.length;
        int columns = original[0].length;
        char[][] copy = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }
    public static void main(String[] args) {
        valid_sudoku vs = new valid_sudoku();
        char[][] board = {{'.','.','4',     '.','.','.',    '6','3','.'},
                          {'.','.','.',     '.','.','.',    '.','.','.'},
                          {'5','.','.',     '.','.','.',    '.','9','.'},

                          {'.','.','.',     '5','6','.',    '.','.','.'},
                          {'4','.','3',     '.','.','.',    '.','.','1'},
                          {'.','.','.',     '7','.','.',    '.','.','.'},

                          {'.','.','.',     '5','.','.',    '.','.','.'},
                          {'.','.','.',     '.','.','.',    '.','.','.'},
                          {'.','.','.',     '.','.','.',    '.','.','.'}};
        System.out.println(vs.isValidSudoku2(board));
        //System.out.println(checkBox(board, 3, 6));
    }
}
