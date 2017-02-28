/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    let res = [];
    nums = nums.sort((a, b) => a - b);
    for (let i = 0; i < nums.length - 2; i++) {
        if (nums[i - 1] !== undefined && nums[i - 1] === nums[i]) {
            continue;
        }
        let num = nums[i];
        let m = i + 1;
        let n = nums.length - 1;
        while (m < n) {
            if (nums[m] + nums[n] + num === 0) {
                res.push([num, nums[m], nums[n]]);
                while (m < n && nums[m] === nums[m + 1]) {
                    m++;
                }
                while (m < n && nums[n] === nums[n - 1]) {
                    n--;
                }
                m++;
                n--;
            } else if (nums[m] + nums[n] + num > 0) {
                n--;
            } else {
                m++;
            }
        }
    }
    return res;
};
