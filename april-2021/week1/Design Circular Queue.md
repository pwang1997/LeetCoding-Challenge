class MyCircularQueue {

    Node front = null, rear = null;
    int size = -1;
    int currentSize = -1;
    public MyCircularQueue(int k) {
        this.size = k;
        this.currentSize = 0;
    }

    public boolean enQueue(int value) {
        if(currentSize == size) {
            return false;
        }

        Node newNode = new Node(value);
        if(front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
        currentSize++;
        return true;
    }

    public boolean deQueue() {

        if(currentSize == 0) {
            return false;
        }
        this.front = this.front.next;
        this.currentSize--;
        return true;
    }

    public int Front() {
        return currentSize == 0 ? -1 : front.val;
    }

    public int Rear() {
        return currentSize == 0 ? -1 : rear.val;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public boolean isFull() {
        return this.size == this.currentSize;
    }
}

class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */