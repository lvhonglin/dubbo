package com.kunpeng.dubbo.test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity=0;
    int len=0;
    Map<Integer,Node> map;
    class Node{
        Node last;
        Node next;
        int val;
        int key;
        public Node(Node last,Node next){
            this.last=last;
            this.next=next;
        }
        public Node(){

        }
    }
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.last=head;
        this.capacity=capacity;
        this.len=0;
        map=new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            return map.get(key).val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node res=map.get(key);
            res.val=value;
            res.last.next=res.next;
            res.next.last=res.last;
            Node tmp=head.next;
            head.next=res;
            res.next=tmp;
            tmp.last=res;
            res.last=head;
        }else{
            if(len==capacity){
                Node tmp=tail.last;
                map.remove(tmp.key);
                tmp.last.next=tmp.next;
                tmp.next.last=tmp.last;
                len--;
            }
            Node res=new Node(head,head.next);
            res.val=value;
            res.key=key;
            map.put(key,res);
            res.last.next=res;
            res.next.last=res;
            len++;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(2));
        lruCache.put(1,1);
        lruCache.put(4,1);
        System.out.println(lruCache.get(2));
    }
}