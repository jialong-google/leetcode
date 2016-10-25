public class Twitter {

    /** Initialize your data structure here. */
    private class Tweet{
        int tweetID;
        long timestep;
        int userID;
        public Tweet(int tweetID,int userID, long timestep){
            this.tweetID = tweetID;
            this.timestep = timestep;
            this.userID = userID;
        }
    }
    private long time;
    Map<Integer,LinkedList<Tweet>> IDtoFeeds;
    Map<Integer,Set<Integer>> follow;
    public Twitter() {
        time = 0;
        IDtoFeeds = new HashMap<Integer, LinkedList<Tweet>>();
        follow = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        time++;
        Tweet tweet = new Tweet(tweetId, userId,time);
        LinkedList<Tweet> current = IDtoFeeds.get(userId);
        if(current == null)
        {
            current = new LinkedList<Tweet>();
        }
        current.addFirst(tweet);
        if(current.size() > 10)
        {
            current.removeLast();
        }
        IDtoFeeds.put(userId,current);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followee = follow.get(userId);
        List<Integer> result = new ArrayList<Integer>(10);
        int len = 1;
        if(followee != null)
        {
            len = followee.size() + 1;
        }
        PriorityQueue<Tweet> heap = new PriorityQueue<Tweet>(len, new Comparator<Tweet>(){
            public int compare(Tweet t1, Tweet t2)
            {
                if(t1.timestep == t2.timestep)
                {
                    return 0;
                }
                return t1.timestep > t2.timestep? -1: 1;
            }
        });
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        if(followee != null){
            for(Iterator it = followee.iterator(); it.hasNext();)
            {
                Integer followeeI = (Integer)it.next();
                counter.put(followeeI, 0);
                LinkedList<Tweet> current = IDtoFeeds.get(followeeI);
                if(current == null)
                {
                    continue;
                }
                if(current.getFirst()!= null){
                    heap.add(current.getFirst());
                }
            }
        }
        counter.put(userId, 0);
        LinkedList<Tweet> current = IDtoFeeds.get(userId);
        if(current != null && current.getFirst() != null)
        {
            heap.add(current.getFirst());
        }
        for(int i = 0; i < 10 && !heap.isEmpty() ; i ++)
        {
            Tweet need = heap.poll();
            result.add(need.tweetID);
            int c = counter.get(need.userID) + 1;
            counter.put(need.userID, c);
            LinkedList<Tweet> curren = IDtoFeeds.get(need.userID);
            if(c < curren.size())
            {
                heap.add(curren.get(c));
            }
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return ;
        Set<Integer> followee = follow.get(followerId);
        if(followee == null)
        {
            followee = new HashSet<Integer>();
        }
        followee.add(followeeId);
        follow.put(followerId, followee);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return ;
        Set<Integer> followee = follow.get(followerId);
        if(followee == null)
        {
            followee = new HashSet<Integer>();
        }
        followee.remove(followeeId);
        follow.put(followerId, followee);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */