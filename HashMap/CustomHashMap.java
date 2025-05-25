import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashMap {

    static class HashMap<K, V> { // generic
        private class node {
            K key;
            V value;

            node(K key, V value) {
                this.key = key;
                this.value = value;
            }

        }

        private int n; // -->total no of nodes
        private int N; // --> no of buckets
        private LinkedList<node> buckets[];
        final int constant = 2; // Load-factor-threshold

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashfunc(K key) { // black box
            int bi = key.hashCode(); // this can return any value 1,2,3,4,5 negative and positive
            return Math.abs(bi) % N; // i want the value b/w 0 and N-1
        }

        private int searchInLL(K key, int bi) {
            LinkedList<node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) {
                    return i;

                }
            }

            return -1;
        }

        @SuppressWarnings("unchacked")
        public void rehash() {
            LinkedList<node> oldBuckets[] = buckets;
            N = N * 2;
            LinkedList<node> buckets[] = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    node n = ll.get(j);
                    put(n.key, n.value);

                }
            }

        }

        public void put(K key, V value) {
            int bi = hashfunc(key); // bucket index
            int di = searchInLL(key, bi); // linked list index
            if (di == -1) {
                // Create the node in that position
                buckets[bi].add(new node(key, value));
                n++;
            } else {
                // update
                node data = buckets[bi].get(di);
                data.value = value;

            }
            double lambda = (double) n / N;
            if (lambda > constant) {
                // rehashing

                rehash();

            }

        }

        public V get(K key) {
            int bi = hashfunc(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                return null;
            } else {
                LinkedList<node> ll = buckets[bi];

                return ll.get(di).value;
            }

        }

        public boolean containsKey(K key) {
            int bi = hashfunc(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                return false;
            } else {
                return true;
            }

        }

        public V remove(K key) {
            int bi = hashfunc(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                return null;
            } else {
                LinkedList<node> ll = buckets[bi];
                node nd = ll.get(di);
                ll.remove(di);
                n--;
                return nd.value;

            }

        }

        public boolean isEmpty() {
            return n == 0;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> list = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    list.add(ll.get(j).key);
                }
            }
            return list;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 140);
        map.put("China", 135);
        map.put("USA", 40);
        System.out.println("Population of India is : " + map.get("India"));
        System.out.println("USA present or not : " + map.containsKey("USA"));
        System.out.println("Italy present or not : " + map.containsKey("Italy"));
        // delete usa
        System.out.println(map.remove("USA"));
        System.out.println("USA present or not : " + map.containsKey("USA"));
        System.out.println("Is map empty ? " + map.isEmpty());
        System.out.println("The list of keys is : " + map.keySet());

    }

}
