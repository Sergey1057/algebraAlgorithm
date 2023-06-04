package com.example.algebraalgorithm.hash_table;


public class HashTableStorage implements IStorage {

    private static final int DEFAULT_CAPACITY = 11;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int threshold;
    private final float loadFactor;

    transient Node[] buckets;
    transient int size;


    public HashTableStorage() {
        buckets = new Node[DEFAULT_CAPACITY];
        loadFactor = DEFAULT_LOAD_FACTOR;
        threshold = (int)(DEFAULT_CAPACITY * loadFactor);
    }

    class Node
    {
        public String key;
        public Integer value;
        public Node next;

        public Node(String key, Integer value, Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public boolean contains(Integer value){
        if (value == null)
            throw new NullPointerException();
        for (int i = buckets.length -1; i >=0; i--)
        {
            Node e = buckets[i];
            while ( e != null)
            {
                if (e.value.equals(value))
                    return true;
                e = e.next;
            }
        }
        return false;
    }

    public boolean containsKey(String key){
        int idx = hash(key);
        Node e = buckets[idx];
            while ( e != null)
            {
                if (e.key.equals(key))
                    return true;
                e = e.next;
            }
        return false;
    }

    @Override
    public Integer get(String key) {
        int idx = hash(key);
        Node e = buckets[idx];
        while ( e != null)
        {
            if (e.key.equals(key)){
                return e.value;
            }

            e = e.next;
        }
        return null;
    }


    @Override
    public void put(String key, Integer value) {
        int idx = hash(key);
        Node e = buckets[idx];
        if (value == null)
            throw new NullPointerException();
        if (e == null){
            addNewNode(key, value, idx);
        }
        else {
            boolean isAdded = false;
            while ( e != null) {
                if (e.key.equals(key)){
                    e.value = value;
                    isAdded = true;
                } else {
                    e = e.next;
                }
            }
            if (!isAdded) {
                addNewNode(key, value, idx);
            }
        }
}

    private void addNewNode(String key, Integer value, int idx) {
        Node e;
        if (++size > threshold) {
            rehash();
            idx = hash(key);
        }
        e = new Node(key, value, null);
        e.next = buckets[idx];
        buckets[idx] = e;
    }

    public synchronized int hash(String key){
        int hash = key.hashCode() % buckets.length;
        return  hash < 0 ? - hash : hash;
  }

    protected void rehash(){
        Node[] oldBuckets = buckets;
        int newcapacity = (buckets.length * 2) +1;
        threshold = (int) (newcapacity * loadFactor);
        buckets = new Node[newcapacity];

        for (int i = oldBuckets.length - 1; i >=0; i--){
            Node e = oldBuckets[i];
            while (e != null) {
                int  idx = hash(e.key);
                Node dest = buckets[idx];

                if (dest != null){
                    Node next = dest.next;
                    while (next != null){
                        dest = next;
                        next = dest.next;
                    }
                    dest.next = e;
                } else {
                    buckets[idx] = e;
                }
            }
            Node next = e.next;
            e.next = null;
            e = next;
        }
    }
}
