/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

#include <stdlib.h>

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    if (l1 == NULL) {
        return l2;
    } else if (l2 == NULL) {
        return l1;
    }
    int carry = 0;
    int sum = 0;
    int l1Size = 0;
    int l2Size = 0;
    struct ListNode* l1Head = l1;
    struct ListNode* l2Head = l2;
    struct ListNode* l1LBO = l1;
    struct ListNode* l2LBO = l2;
    while (l1 != NULL && l2 != NULL) {
        sum = l1 -> val + l2 -> val + carry;
        carry = sum / 10;
        l1 -> val = sum % 10;
        l2 -> val = l1 -> val;
        l1LBO = l1;
        l2LBO = l2;
        l1 = l1 -> next;
        l2 = l2 -> next;
        l1Size++;
        l2Size++;
    }
    while ( l1 != NULL) {
        sum = l1 -> val + carry;
        carry = sum / 10;
        l1 -> val = sum % 10;
        l1LBO = l1;
        l1 = l1 -> next;
        l1Size++;
    }
    
    while ( l2 != NULL) {
        sum = l2 -> val + carry;
        carry = sum / 10;
        l2 -> val = sum % 10;
        l2LBO = l2;
        l2 = l2 -> next;
        l2Size++;
    }
    if (l1Size >= l2Size && carry != 0) {
        struct ListNode* temp = (struct ListNode*)malloc(sizeof(struct ListNode));
        temp -> val = carry;
        temp -> next = NULL;
        l1LBO -> next = temp;
        l1Size++;
    } else if (l2Size > l1Size && carry != 0) {
        struct ListNode* temp = (struct ListNode*)malloc(sizeof(struct ListNode));
        temp -> val = carry;
        temp -> next = NULL;
        l2LBO -> next = temp;
        l2Size++;
    }
    return l1Size > l2Size ? l1Head : l2Head;

}
