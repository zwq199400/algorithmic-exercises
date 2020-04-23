public class SelectInMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 5}, {2, 3, 4, 7}, {4, 4, 4, 8}, {6, 7, 7, 9}};
        /**
         * 给定一个有N*M的整型矩阵matrix和一个整数K，matrix的每一行和每一列都是排好序的。实现一个函数，判断K是否在matrix中。
         * 0 1 2 5
         * 2 3 4 7
         * 4 4 4 8
         * 6 7 7 9
         */
        System.out.println(judgeExists(matrix, 31));
    }

    private static boolean judgeExists(int[][] arr, int num) {
        int startRow = 0;
        int startCol = arr[0].length - 1;
        int row = arr.length - 1;
        while (startRow <= row && startCol >= 0) {
            if (num == arr[startRow][startCol]) {
                return true;
            }
            if (num > arr[startRow][startCol]) {
                startRow++;
            } else {
                startCol--;
            }
        }
        return false;
    }
}
