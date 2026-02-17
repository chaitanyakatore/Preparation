import java.util.Arrays;

// we have to make the small element to big element so for that we must need to sort the array
// once it is sort then we have to think (nums[r] - nums[l]) + (nums[r] - nums[l+1])... should be less than K
// so for this we can make the formula nums[r] - window_size - sum_of_numbers
// so with this logic we solved the problem
// time complexity : O(n log n) + O(n)
public class FreqOfMostFreqEle {

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxCnt = 0;
        int l = 0;
        long sum = 0;
        for(int r = 0; r < n; r++){
            sum += nums[r];

            while ((long) nums[r] * (r - l + 1) - sum > k) {
                sum -= nums[l];
                l++;
            }
            maxCnt = Math.max(maxCnt, r - l + 1);
        }
        return maxCnt;
    }

    public static void main(String[] args){
        int[] arr = {1,2,4};
        int ans = maxFrequency(arr, 5);
        System.out.println(ans);
    }
}
