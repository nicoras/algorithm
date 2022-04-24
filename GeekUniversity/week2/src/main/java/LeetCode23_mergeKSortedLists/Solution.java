package LeetCode23_mergeKSortedLists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        return merge(lists,0,lists.length-1);

    }
    //拆分
    private ListNode merge(ListNode[] mergeLists,int left,int right){
        if(left == right){
            return mergeLists[left];
        }
        if(left > right){
            return null;
        }
        int mid = (left + right)/2;
        //merge左边子集
        ListNode leftRtn = merge(mergeLists,left,mid);
        //merge右边子集
        ListNode rightRtn = merge(mergeLists,mid+1,right);;
        //合并两个子集
        ListNode rtn = mergeTwoLists(leftRtn,rightRtn);
        return rtn;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //创建临时节点，指向最小的list头节点
        ListNode preNode = new ListNode();
        //如果list1或者list2为null不遍历
        //遍历list1 list2,每次从当前的头节点取一个最小值，接在指针上
        //如果list1或者list2遍历完，则指针移到末尾，新的point为null
        ListNode point = preNode;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                point.next = list1;
                list1 = list1.next;
            }else{
                point.next = list2;
                list2 = list2.next;
            }
            point = point.next;
        }
        //剩余未合并完的数据加载末尾
        point.next = list1==null?list2:list1;
        return preNode.next;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}
