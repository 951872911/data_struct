package com.demo.data.struct;

/**
* @Description: 链表
* @Author: pzq
* @Date:
*/
public class MyLinkedList {

    private Node head;

    private Node last;

    private int size = 0;

    /**
     * 链表插入方法
     * @param data
     * @param index
     * @return
     */
    private Node insertNode(int data, int index) throws IndexOutOfBoundsException {
        if (index <0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node insertNode = new Node(data);
        // 空链表
        if (size == 0) {
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            // 头部插入
            insertNode.next  = head;
            head = insertNode;
        } else if (index == size){
            // 尾部插入
            last.next = insertNode;
            last = insertNode;
        } else {
            // 中间插入
            Node preNode = get(index - 1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }

        size ++;
        return insertNode;
    }

    /**
     * 删除
     * @param index
     * @return
     */
    private Node deleteNode(int index) {
        if (index <0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        if (size == 0) {
            throw new IndexOutOfBoundsException("空链表");
        }
        Node node = null;
        if (index == 0) {
            // 头部删除
            node = head;
            head = head.next;

        }else if (index == size - 1) {
            // 尾部删除
            node = last;
            Node preNode = get(index - 1);
            preNode.next = null;
            last = preNode;
        } else {
            Node preNode = get(index - 1);
            preNode.next = preNode.next.next;
            node = preNode.next;
        }
        size --;
        return node;
    }

    /**
     * 查询
     * @param index
     * @return
     */
    private Node get(int index) {
        if (index <0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 链表节点
     */
    private static class Node {

        private int data;

        private Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
