package LRU_Cache;

import java.util.HashMap;
public class CustomLRU_Cache {
    public static  class LRUCache<K,V>{
        private final int capacity;
        private final HashMap<K,Node> map;
        private final doubleLinkedList dll;
        public LRUCache(int capacity){
            this.capacity = capacity;
            this.map = new HashMap<>();
            dll = new doubleLinkedList();

        }
        public V get(K key){
            if(!map.containsKey(key)){
                return null;
            }
            Node node = map.get(key);
            dll.moveToFront(node);
            return node.value;

           

       }
       public void put(K key,V value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            dll.moveToFront(node);

        }
        else{
            if(map.size() >= capacity){
                Node lru = dll.removeLast();
                map.remove(lru.key);
            }
            Node newNode = new Node(key,value);
            dll.addFirst(newNode);
            map.put(key, newNode);
        }

       }
       private class Node {
        K key;
        V value;
        Node pre , next;
        Node(K key,V value){
            this.key = key;
            this.value = value;
        }
       
        
       }
       private class doubleLinkedList {
        Node head , tail;
        doubleLinkedList(){
            head = new Node(null,null);
            tail = new Node(null,null);
            head.next = tail;
            tail.pre = head;

        }
        void addFirst(Node node){
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        void moveToFront(Node node){
            remove(node);
            addFirst(node);
        }
        void remove(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        Node removeLast(){
            if(tail.pre == head) return null;
            Node last = tail.pre;
            remove(last);
            return last;
        }
    }
    public void printCache(){
        Node cur = dll.head.next;
        while(cur != dll.tail){
            System.out.print(cur.key + " = " + cur.value + " ");
            cur=cur.next;
        }
        System.out.println();
    }
    }


    public static void main(String[] args) {
        LRUCache<Integer , String> cache = new LRUCache<>(4);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.printCache();
        cache.put(4, "D");
        cache.printCache();
        cache.put(5, "E"); //The cache will delete the LRU (least recently used ; A)
        cache.printCache();
        System.out.println("the value of 3 is : "+cache.get(3));

        
    }

    

}

