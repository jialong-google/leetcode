class MyStack {
    // Push element x onto stack.
    Deque<Integer> queue = new LinkedList<Integer>();
    public void push(int x) {
        queue.offerLast(x);
        for(int i = 0; i < queue.size() - 1; i++)
        {
            queue.offerLast(queue.pollLast());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.pollLast();
    }

    // Get the top element.
    public int top() {
        return queue.peekLast();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}