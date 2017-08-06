/**
 *  Reverse Integer
 *
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let res = 0, left = 0;
    const MAX = Math.pow(2,31)-1;

    while(x !== 0)  {
        left = x % 10;
        res = res * 10 + left;
        x = parseInt(x/10);
    }

    if(res > MAX || res < -(1 + MAX)) {
        return 0;
    }

    return res;
};
