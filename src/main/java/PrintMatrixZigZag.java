public class PrintMatrixZigZag {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
        /**
         * 1  2  3  4
         * 5  6  7  8
         * 9  10 11 12
         * 打印结果： 1 2 5 9 6 3 4 7 10 11 8 12
         */
    }

    private static void printMatrixZigZag(int[][] arr) {
        int col1 = 0;
        int row1 = 0;
        int col2 = 0;
        int row2 = 0;
        boolean flag = false;

        while (row1 <= arr.length - 1) {
            printMethod(col1, col2, row1, row2, flag, arr);
            flag = !flag;
            row1 = col1 == arr[0].length - 1 ? row1 + 1 : 0;
            col1 = col1 == arr[0].length - 1 ? col1 : col1 + 1;

            col2 = row2 == arr.length - 1 ? col2 + 1 : 0;
            row2 = row2 == arr.length - 1 ? row2 : row2 + 1;
        }
    }

    private static void printMethod(int col1, int col2, int row1, int row2, boolean flag, int[][] arr) {
        while (col1 != col2 || row1 != row2) {
            if (flag) {
                System.out.println(arr[row1++][col1--]);
            } else {
                System.out.println(arr[row2--][col2++]);
            }
        }
        System.out.println(arr[row1][col1]);
    }
}
