/**
 * 3Sum Closest
 * @see https://leetcode.com/problems/3sum-closest/
 *
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
  let n = nums.length;
  let sum, diff;

  nums = nums.sort((a, b) => a - b);

  for (i = 0; i < n - 2; i++) {
    if (nums[i] == nums[i - 1]) {
      continue;
    }
    let j = i + 1,
      k = n - 1;
    while (j < k) {
      let _sum = nums[i] + nums[j] + nums[k];
      let _diff = Math.abs(_sum - target);

      if (_sum === target) {
        return _sum;
      } else if (_sum < target) {
        j++;
      } else {
        k--;
      }

      if (!diff || diff > _diff) {
        diff = _diff;
        sum = _sum;
      }
    }

  }
  return sum;
};
