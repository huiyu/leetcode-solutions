/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {

    var sum = 0, carry = 0;
    var result = new ListNode(), temp = new ListNode();
    
    //result指向temp链表头部
    result = temp;

    while(l1 || l2) {
        var num1 = l1? l1.val : 0;
        var num2 = l2? l2.val : 0;
        sum = num1 + num2 + carry;
        carry = parseInt(sum/10);
        temp.val = sum % 10;
        temp.next = (l1?l1.next:null)||(l2?l2.next:null)?(new ListNode()):(carry==1?(new ListNode(1)):null);
        temp = temp.next;

        l1 = l1 ? l1.next : null;
        l2 = l2 ? l2.next : null;
    }

    return result
};
