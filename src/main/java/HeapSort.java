/**
 * 堆排序
 * @author zhouwq
 * @date 2019/9/28 13:49
 */

public class HeapSort {

    public static void heapify(int[] arr, int index, int size){
        int left = 2 * index + 1;
        while (left < size){
            int childMax = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            childMax = arr[childMax] > arr[index] ? childMax : index;
            if(childMax == index){
                break;
            }
            swap(arr, childMax, index);
            index = childMax;
            left = 2 * index + 1;
        }

    }

    public static void heapInsert(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int idx = i;
            while(arr[(idx -1) / 2] < arr[idx]){
                swap(arr, (idx -1) /2, idx);
                idx = (idx - 1) /2;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 7, 4, 3, 8, 1};
        heapInsert(arr);
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0){
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
        System.out.println(arr);
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
