import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DesignTwitter {

    private final Map<Integer, Set<Integer>> followers;
    private final Map<Integer, Set<Post>> posts;
    private int count;

    public DesignTwitter() {
        followers = new HashMap<>();
        posts = new HashMap<>();
    }

    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
        twitter.postTweet(1, 5);
        List<Integer> result = twitter.getNewsFeed(1);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        List<Integer> result1 = twitter.getNewsFeed(1);
        twitter.unfollow(1, 2);
        List<Integer> result2 = twitter.getNewsFeed(1);

        result.addAll(result1);
        result.addAll(result2);
        System.out.println(result);
    }

    public void postTweet(int userId, int tweetId) {
        Set<Post> post;
        if (posts.containsKey(userId)) {
            post = posts.get(userId);
        } else {
            post = new HashSet<>();
        }
        post.add(new Post(tweetId, count));
        posts.put(userId, post);
        count++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Post> postList = new ArrayList<>();

        if (posts.containsKey(userId)) {
            postList.addAll(posts.get(userId));
        }

        if (followers.containsKey(userId)) {
            Set<Integer> follows = followers.get(userId);
            for (Integer follow : follows) {
                if (posts.containsKey(follow)) {
                    postList.addAll(posts.get(follow));
                }
            }
        }

        if (!postList.isEmpty()) {
            List<Integer> res = postList.stream()
                    .sorted(Comparator.comparingInt(i -> i.timestamp))
                    .map(i -> i.tweetId)
                    .collect(Collectors.toList());
            Collections.reverse(res);
            if (res.size() > 10) {
                res = res.subList(0, 10);
            }
            return res;
        }

        return Collections.emptyList();
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> follows;
        if (followers.containsKey(followerId)) {
            follows = followers.get(followerId);
        } else {
            follows = new HashSet<>();
        }
        follows.add(followeeId);
        followers.put(followerId, follows);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            Set<Integer> follows = followers.get(followerId);
            if (follows != null && !follows.isEmpty()) {
                follows.remove(followeeId);
            }
        }
    }

    private static class Post {
        int tweetId;
        int timestamp;

        public Post(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

}
