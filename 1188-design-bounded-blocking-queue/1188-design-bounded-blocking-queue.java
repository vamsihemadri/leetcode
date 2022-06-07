class BoundedBlockingQueue {
    
    int cap;
    Semaphore es;
    Semaphore ds;
    ArrayDeque<Integer> deq;

    public BoundedBlockingQueue(int capacity) {
        cap = capacity;
       es = new Semaphore(capacity);
        ds = new Semaphore(0);
        deq = new ArrayDeque();
        
    }
    
    public void enqueue(int element) throws InterruptedException {
        
        es.acquire();
        deq.offerLast(element);
        ds.release();
        
    }
    
    public int dequeue() throws InterruptedException {
        
        int toReturn = -1;
        ds.acquire();
        toReturn = deq.removeFirst();
        es.release();
        return toReturn;
    }
    
    public int size() {
        return deq.size();
    }
}