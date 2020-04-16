public class BucketSort {

    /**
     * 无序数组排序后，返回相邻两数的最大差值
     */
    private static int bucketSort(int[] nums) {
        int max = 0;
        boolean[] isEmptyBucket = new boolean[nums.length + 1];
        int[] minBucket = new int[nums.length + 1];
        int[] maxBucket = new int[nums.length + 1];

        int numsMax = nums[0];
        int numsMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            numsMax = Math.max(numsMax, nums[i]);
            numsMin = Math.min(numsMin, nums[i]);
        }

        for (int num : nums) {
            int idx = ((num - numsMin) * nums.length) / (numsMax - numsMin);
            maxBucket[idx] = isEmptyBucket[idx] ? Math.max(maxBucket[idx], num) : num;
            minBucket[idx] = isEmptyBucket[idx] ? Math.min(minBucket[idx], num) : num;
            isEmptyBucket[idx] = true;
        }

        int lastMax = maxBucket[0];
        for (int i = 0; i < isEmptyBucket.length; i++) {
            if (isEmptyBucket[i]) {
                max = Math.max(minBucket[i] - lastMax, max);
                lastMax = maxBucket[i];
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,1,6,2,7};
        int max = bucketSort(arr);
        System.out.println(max);

    }
}
