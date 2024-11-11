#include <iostream>
#include <vector>

// Assuming ListNode is already defined in the environment

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode dummy;
        ListNode* current = &dummy;

        while (list1 && list2) {
            if (list1->val <= list2->val) {
                current->next = list1;
                list1 = list1->next;
            } else {
                current->next = list2;
                list2 = list2->next;
            }
            current = current->next;
        }

        current->next = list1 ? list1 : list2;
        return dummy.next;
    }
};

ListNode* createLinkedList(const std::vector<int>& arr) {
    ListNode* head = nullptr, **current = &head;
    for (int val : arr) {
        *current = new ListNode(val);
        current = &((*current)->next);
    }
    return head;
}

void printLinkedList(ListNode* head) {
    while (head) {
        std::cout << head->val << " ";
        head = head->next;
    }
    std::cout << std::endl;
}

void runTests() {
    Solution solution;

    ListNode* list1 = createLinkedList({1, 2, 4});
    ListNode* list2 = createLinkedList({1, 3, 4});
    printLinkedList(solution.mergeTwoLists(list1, list2)); // Output: 1 1 2 3 4 4

    list1 = createLinkedList({});
    list2 = createLinkedList({});
    printLinkedList(solution.mergeTwoLists(list1, list2)); // Output: (empty)

    list1 = createLinkedList({});
    list2 = createLinkedList({0});
    printLinkedList(solution.mergeTwoLists(list1, list2)); // Output: 0
}

// Uncomment this if you want to run tests in a different environment
// int main() {
//     runTests();
//     return 0;
// }
