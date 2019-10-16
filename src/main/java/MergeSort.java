/**
 * @author zhouwq
 * @date 2019/8/26 8:54
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,9,6,8,5,4};
        mergeSort(arr);
        System.out.println();
    }

    /**
     * 归并算法
     *
     * 将数组分割成各部分，对分割的部分进行内部排序后，再将排序后的结果进行最终的排序
     */
    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int r, int l) {
        if(r == l){
            return;
        }
        int mid = r + ((l - r) >> 1);
        sort(arr, r, mid);
        sort(arr, mid + 1, l);
        merge(arr, r, mid, l);
    }

    public static void merge(int[] arr, int r, int mid, int l) {
        int[] temp = new int[l - r + 1];
        int j = r;
        int k = mid + 1;
        int i = 0;

        while (j <= mid && k <= l){
            if(arr[j] < arr[k]){
                temp[i] = arr[j];
                j++;
            }else{
                temp[i] = arr[k];
                k++;
            }
            i++;
        }

        //左边剩余数组
        while (j <= mid){
            temp[i++] = arr[j++];
        }

        //右边剩余数组
        while (k <= l){
            temp[i++] = arr[k++];
        }

        //复制temp数组到原数组中
       for(int x=0;x<temp.length;x++){
            arr[x+r] = temp[x];
        }

    }
}
