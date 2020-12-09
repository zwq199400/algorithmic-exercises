package exercises;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhouwq
 * @date 2020/7/17 15:34
 */

public class SearchRange {
    //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    //
    // 你的算法时间复杂度必须是 O(log n) 级别。
    //
    // 如果数组中不存在目标值，返回 [-1, -1]。
    //
    // 示例 1:
    //
    // 输入: nums = [5,7,7,8,8,10], target = 8
    //输出: [3,4]
    //
    // 示例 2:
    //
    // 输入: nums = [5,7,7,8,8,10], target = 6
    //输出: [-1,-1]

    public static int[] searchRange(int[] nums, int target) {
        return dichotomy(nums, target, 0, nums.length - 1);
    }

    private static int[] dichotomy(int[] nums, int target, int start, int end) {
        if (start > end) {
            return new int[]{-1, -1};
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            int index = mid;
            while (index >= 0 && nums[index] == target) {
                start = index--;
            }
            index = mid;
            while (index <= nums.length - 1 && nums[index] == target) {
                end = index++;
            }
            return new int[]{start, end};
        } else if (nums[mid] > target) {
            return dichotomy(nums, target, start, mid - 1);
        } else {
            return dichotomy(nums, target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 15, 120L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try{
                    int a = 1/0;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };

        threadPoolExecutor.execute(runnable);
    }
}

