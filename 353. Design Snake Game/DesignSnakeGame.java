public class SnakeGame {
    private static class SnakeNode{
        int x;
        int y;
        SnakeNode(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        @Override
        public int hashCode()
        {
            return x * 10 + y;
        }
        @Override
        public boolean equals(Object o2)
        {
            if(this.x == ((SnakeNode) o2).x && this.y == ((SnakeNode) o2).y)
                return true;
            return false;
        }
    }
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    private Deque<SnakeNode> snake;
    private Set<SnakeNode> snakeBody;
    private int width;
    private int height;
    private Queue<SnakeNode> food;
    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<SnakeNode>();
        snakeBody = new HashSet<SnakeNode>();
        snake.offerFirst(new SnakeNode(0, 0));
        snakeBody.add(new SnakeNode(0, 0));
        this.width = width;
        this.height = height;
        this.food = new LinkedList<SnakeNode>();
        for(int i = 0; i < food.length ; i++)
        {
            this.food.offer( new SnakeNode(food[i][0], food[i][1]));
        }
        this.food.offer(new SnakeNode(-1, -1));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        SnakeNode curFood = food.peek();
        SnakeNode head = snake.peek();
        SnakeNode new_head = null;
        if(direction.equals("U"))
        {
            new_head = new SnakeNode(head.x - 1, head.y);
        }
        else if(direction.equals("D"))
        {
            new_head = new SnakeNode(head.x + 1, head.y);
        }
        else if(direction.equals("R"))
        {
            new_head = new SnakeNode(head.x, head.y + 1);
        }
        else
        {
            new_head = new SnakeNode(head.x, head.y - 1);
        }
        if(new_head.x == curFood.x && new_head.y == curFood.y)
        {
            snake.offerFirst(food.poll());
            snakeBody.add(snake.peekFirst());
            return snake.size() - 1;
        }
        SnakeNode tail = snake.pollLast();
        snakeBody.remove(tail);
        if(new_head.x < 0 || new_head.x >= height || new_head.y < 0 || new_head.y >= width || !snakeBody.add(new_head))
        {
            return -1;
        }
        snake.offerFirst(new_head);
        return snake.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */