package gfg.a16_Heap.common;



public class MinHeap {
    int[] heapArray;
    int current_heap_size, capacity;

    public MinHeap(int cap) {
        heapArray = new int[cap];
        current_heap_size = 0;
        capacity = cap;
    }

    // Swapping using reference
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Get the Left Child index for the given index
    int left(int index) {
        return 2 * index + 1;
    }

    // Get the Right Child index for the given index
    int right(int index) {
        return 2 * index + 2;
    }

    // Get the Parent index for the given index
    int parent(int index) {
        return (index - 1) / 2;
    }

    // Inserts a new key
    public boolean insertKey(int key) {
        // heap is full
        if (current_heap_size == capacity) return false;

        // First insert the new key at the end
        int i = current_heap_size;
        heapArray[i] = key;
        current_heap_size++;

        while (i != 0 && heapArray[i] < heapArray[parent(i)]) {
            swap(heapArray, i, parent(i));
            i = parent(i);
        }
        return true;
    }

    // A recursive method to heapify a subtree
    // with the root at given index
    // This method assumes that the subtrees
    // are already heapified
    private void MinHeapify(int index) {
        int l = left(index);
        int r = right(index);

        int smallest = index;
        if (l < current_heap_size && heapArray[l] < heapArray[smallest]) {
            smallest = l;
        }
        if (r < current_heap_size && heapArray[r] < heapArray[smallest]) {
            smallest = r;
        }

        if (smallest != index) {
            swap(heapArray, index, smallest);
            MinHeapify(smallest);
        }
    }

    // Returns the minimum key (key at
    // root) from min heap
    public int getMin() {
        return heapArray[0];
    }

    // Method to remove minimum element
    // (or root) from min heap
    public int extractMin() {
        if (current_heap_size <= 0) {
            return Integer.MAX_VALUE;
        }

        if (current_heap_size == 1) {
            current_heap_size--;
            return heapArray[0];
        }

        // Store the minimum value,
        // and remove it from heap
        int root = heapArray[0];

        heapArray[0] = heapArray[current_heap_size - 1];
        current_heap_size--;
        MinHeapify(0);

        return root;
    }

    // Decreases value of given key to new_val.
    // It is assumed that new_val is smaller
    // than heapArray[key].
    public void decreaseKey(int key, int new_val) {
        heapArray[key] = new_val;

        while (key != 0 && heapArray[key] < heapArray[parent(key)]) {
            swap(heapArray, key, parent(key));
            key = parent(key);
        }
    }

    // This function deletes key at the
    // given index. It first reduced value
    // to minus infinite, then calls extractMin()
    public void deleteKey(int key) {
        decreaseKey(key, Integer.MIN_VALUE);
        extractMin();
    }

    // Increases value of given key to new_val.
    // It is assumed that new_val is greater
    // than heapArray[key].
    // Heapify from the given key
    public void increaseKey(int key, int new_val) {
        heapArray[key] = new_val;
        MinHeapify(key);
    }

}