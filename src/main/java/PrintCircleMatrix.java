public class PrintCircleMatrix {

    public static void main(String[] args) {
        int[][] m={{1}};
        /**
         * 1  2  3  4
         * 5  6  7  8
         * 9  10 11 12
         * 13 14 15 16
         */
        printMatrix(m);//1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
    }

    private static void printMatrix(int[][] arr) {
        int xLength = arr.length;
        int yLength = arr[0].length;
        if (xLength == 1 || yLength == 1) {
            for (int[] a : arr) {
                for (int b : a) {
                    System.out.println(b);
                }
            }
        } else {

            printCircle(arr, 0 ,0, xLength, yLength);
        }
    }

    private static void printCircle(int[][] arr, int x, int y, int xLength, int yLength) {
        if (xLength == x || y == yLength) {
            return;
        }
        while (y < yLength - 1) {
            System.out.println(arr[x][y++]);
        }
        while (x < xLength - 1) {
            System.out.println(arr[x++][y]);
        }
        while (y > arr.length - xLength) {
            System.out.println(arr[x][y--]);
        }
        while (x > arr[0].length - yLength) {
            System.out.println(arr[x--][y]);
        }
        printCircle(arr, ++x, ++y, --xLength, --yLength);
    }
}
