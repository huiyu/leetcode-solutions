/**
 * Two Sum
 * @see https://leetcode.com/problems/two-sum/
 *
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 *
 */
var twoSum = function(nums, target) {
    var length = nums.length;
    var comp = [];
    for(i=0;i<length;i++) {
        var idx = comp.indexOf(nums[i]),
            num2 = target - nums[i];
            // console.log("num2:"+num2 + "   idx2:"+idx)
        if(idx == -1){
            comp.push(num2);
        }
        else {
            return [nums.indexOf(num2), i]
        }
    }
};
