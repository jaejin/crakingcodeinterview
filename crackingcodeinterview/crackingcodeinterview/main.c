//
//  main.c
//  crackingcodeinterview
//
//  Created by jaejinyun on 2013. 12. 4..
//  Copyright (c) 2013년 skplanet. All rights reserved.
//

#include <stdio.h>

struct Node {
    int data;
    struct Node *next;
} typedef NODE;

NODE *newNode(int );


void freeNode(NODE *node) {
    while (node->next != NULL) {
        NODE *temp = node;
        node = node->next;
        free(temp);
    }
}


void append(NODE *node,NODE *another) {
    while (node->next != NULL) {
        node = node->next;
    }
    
    node->next = another;
    
}

NODE *last(NODE *node) {
    while (node->next != NULL) {
        node = node->next;
    }
    return node;
}

void *reverse(NODE *node) {
    while (node->next != NULL) {
        node = node->next;
    }
    return node;
}

void printNodes(NODE *node) {
    while (node->next != NULL) {
        printf("%d ",node->data);
        node = node->next;
    }
    
    printf("%d\n",node->data);
    
}

int main(int argc, const char * argv[])
{
    
    NODE *node = newNode(1);
    NODE *node2 = newNode(2);
    NODE *node3 = newNode(3);
    append(node,node2);
    append(node,node3);
    printNodes(node);
    
    printNodes(last(node));
    
    freeNode(node);
    return 0;
}


NODE *newNode(int data) {
    NODE *node = (NODE *)malloc(sizeof(NODE));
    node->data = data;
    node->next = NULL;
    return node;
}
