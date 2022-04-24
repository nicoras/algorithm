public class LeetCode21_mergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        LeetCode21_mergeTwoSortedLists a = new LeetCode21_mergeTwoSortedLists();
        ListNode c = a.mergeTwoLists(l1,l2);
        System.out.println(c);
    }
}
