/**
 * String to Integer (atoi)
 *
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
    let res = parseInt(str);
    const MAX = Math.pow(2,31)-1, MIN = -1 * Math.pow(2,31);

    if(res > MAX){
        res = MAX;
    }
    else if(res < MIN){
        res = MIN;
    }
    return isNaN(res) ? 0 : res;
};
