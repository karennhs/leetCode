import add.two.numbers.with.linked.lists.ListNode;
import add.two.numbers.with.linked.lists.OptimalSolution;
import add.two.numbers.with.linked.lists.Solution;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    ListNode listNode1 = new ListNode(9);
    ListNode listNode2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
            new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));

    OptimalSolution solution = new OptimalSolution();
    IO.println("solution:" + solution.addTwoNumbers(listNode1, listNode2));

}
