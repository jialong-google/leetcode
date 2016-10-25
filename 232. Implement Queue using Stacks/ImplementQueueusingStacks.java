class MyQueue {
    // Push element x to the back of queue.
    Deque<Integer> stack1 = new LinkedList<Integer>();
    Deque<Integer> stack2 = new LinkedList<Integer>();
    public void push(int x) {
        stack1.offerLast(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stack2.isEmpty())
        {
            while(!stack1.isEmpty())
            {
                stack2.offerLast(stack1.pollLast());
            }
        }
        stack2.pollLast();
    }

    // Get the front element.
    public int peek() {
        if(stack2.isEmpty())
        {
            while(!stack1.isEmpty())
            {
                stack2.offerLast(stack1.pollLast());
            }
        }
        return stack2.peekLast();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty())
        {
            return true;
        }
        return false;
        
    }
}