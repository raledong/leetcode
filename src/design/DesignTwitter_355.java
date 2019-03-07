package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author rale
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);
 */
public class DesignTwitter_355 {

	
	public DesignTwitter_355() {
        users = new HashMap<>();
    }
    
	public static int timestamp = 0;
	private Map<Integer, User> users;
	
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	if(!users.containsKey(userId)) {
        	User user = new User(userId);
        	users.put(userId, user);
        }
    	
    	User user = users.get(userId);
    	user.tweet(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. 
     * Each item in the news feed must be posted by users who the user followed or by the user herself. 
     * Tweets must be ordered from most recent to least recent. 
     * */
    public List<Integer> getNewsFeed(int userId) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(!users.containsKey(userId)) {
        	return result;
        }
    	User user = users.get(userId);
    	
    	PriorityQueue<Tweet> queue = new PriorityQueue<>(user.followed.size());
    	for(int followee : user.followed) {
    		User tmp = users.get(followee);
    		if(tmp != null && tmp.headTweet != null) {
    			queue.offer(tmp.headTweet);
    		} 
    	}
    	
    	while(!queue.isEmpty() && result.size() < 10) {
    		Tweet t = queue.poll();
    		result.add(t.tweetId);
    		if(t.next != null) {
    			queue.offer(t.next);
    		}
    	}
    	return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) {
        	User user = new User(followerId);
        	users.put(followerId, user);
        }
        if(!users.containsKey(followeeId)) {
        	User user = new User(followeeId);
        	users.put(followeeId, user);
        }
        
        User user = users.get(followerId);
        user.follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if(!users.containsKey(followerId) || followerId == followeeId) {
    		return;
        }
      
        
        User user = users.get(followerId);
        user.unfollow(followeeId);
    }
	
	public static class User{
		
		int userId;
		
		Set<Integer> followed;
		
		Tweet headTweet;
		
		public User(int userId) {
			this.userId = userId;
			this.followed = new HashSet<>();
			follow(userId);
		}
		
		public void follow(int userId) {
			followed.add(userId);
		}
		
		public void unfollow(int userId) {
			followed.remove(userId);
		}
		
		public void tweet(int tweetId) {
			Tweet tweet = new Tweet(tweetId);
			tweet.next = headTweet;
			headTweet = tweet;
		}
		
	}
	
	public static class Tweet implements Comparable<Tweet>{
		
		int tweetId;
		
	    Tweet next;
		
		int time;
		
		public Tweet(int tweetId) {
			this.tweetId = tweetId;
			this.time = timestamp++;
		}

		@Override
		public int compareTo(Tweet o) {
			return o.time - this.time;
		}
	}
}
