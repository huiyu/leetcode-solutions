/**
 * Longest Substring Without Repeating Characters
 *
 * @param {string} s
 * @return {number}
 */
 var lengthOfLongestSubstring = function(s) {
     if(!s || s.length < 1) {
         return 0
     }
     if(s.length == 1) {
         return 1;
     }

     let arr = s.split(""),
         length = s.length,
         max = 0, start = 0;

     for (let i = 1; i < length; i++) {
         for (let j = i-1; j >= start; j--) {
             if (arr[j] == arr[i]) {
                 start = j + 1;
                 max = max > (i-start+1) ? max : (i-start+1);
                 break;
             }
             else {
                  if(max < i-j+1)
                     max = i - j +1;
             }
         }
     }

     return max;

 };
