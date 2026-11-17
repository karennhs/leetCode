package maximum.alternating.sum.squares;


import java.util.Arrays;

/**
 * 3727. Maximum Alternating Sum of Squares
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * You are given an integer array nums. You may rearrange the elements in any order.
 * <p>
 * The alternating score of an array arr is defined as:
 * <p>
 * score = arr[0]2 - arr[1]2 + arr[2]2 - arr[3]2 + ...
 * Return an integer denoting the maximum possible alternating score of nums after rearranging its elements.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * <p>
 * Output: 12
 * <p>
 * Explanation:
 * <p>
 * A possible rearrangement for nums is [2,1,3], which gives the maximum alternating score among all possible rearrangements.
 * <p>
 * The alternating score is calculated as:
 * <p>
 * score = 22 - 12 + 32 = 4 - 1 + 9 = 12
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,-1,2,-2,3,-3]
 * <p>
 * Output: 16
 * <p>
 * Explanation:
 * <p>
 * A possible rearrangement for nums is [-3,-1,-2,1,3,2], which gives the maximum alternating score among all possible rearrangements.
 * <p>
 * The alternating score is calculated as:
 * <p>
 * score = (-3)2 - (-1)2 + (-2)2 - (1)2 + (3)2 - (2)2 = 9 - 1 + 4 - 1 + 9 - 4 = 16
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -4 * 104 <= nums[i] <= 4 * 104
 */
public class Solution {

    void main() {
        int[] intArray = {1,2,3,6,-5,1};

        IO.println("solution:" + maxAlternatingSum(intArray));

    }

    private long maxAlternatingSum(int[] nums) {

        int[] absArray = this.removeNegativeSigns(nums);
        Arrays.sort(absArray);
        IO.println("2. sorted array: " + Arrays.toString(absArray));

        int[] sortedNumsForMaxScore = this.getArraySortedForMaximumScore(absArray);

        return this.doScoreCalculation(sortedNumsForMaxScore);
    }

    private int[] getArraySortedForMaximumScore(int[] nums) {
        int[] sortedArray = new int[nums.length];
        int pos = 0;
        int i = 0;
        //[1,2,3]
        //[3,1,2]
        //pos= 3
        //i=2
        while (pos < nums.length) {
            sortedArray[pos] = nums[nums.length - 1 - i];
            if (pos < nums.length - 2) {
                sortedArray[pos + 1] = nums[i];
                pos += 2;
            } else {
                pos++;
            }
            i++;
        }

        return sortedArray;
    }

    private Long doScoreCalculation(int[] nums) {
        long score = 0;
        int factor = 1;
        for (int value : nums) {
            score = doCalculation(score, value, factor);
            factor = factor * (-1);
        }
        return score;
    }

    Long doCalculation(long score, int value, int factor) {
        score += (((long) value * value) * factor);
        return score;
    }

    private int[] removeNegativeSigns(int[] nums) {

        int[] array = Arrays.stream(nums).map(Math::abs).toArray();
        IO.println("1. array without negative signs: " + Arrays.toString(array));

        return array;

    }
}
