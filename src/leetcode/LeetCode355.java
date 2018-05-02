package leetcode;

import java.util.*;

/**
 * @Author ROKG
 * @Description 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * @Date: Created in 上午11:57 2018/5/2
 * @Modified By:
 */
public class LeetCode355 {

    List<Tweet> tweets=new ArrayList<>();

    Map<Integer,List<Integer>> follows=new HashMap<>();

    public LeetCode355(){

    }

    class Tweet{
        int tweetId;
        int userId;
        public Tweet(int tweetId,int userId){
            this.tweetId=tweetId;
            this.userId=userId;
        }

        public int getTweetId() {
            return tweetId;
        }

        public void setTweetId(int tweetId) {
            this.tweetId = tweetId;
        }
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(0,new Tweet(tweetId,userId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> integers=new ArrayList<>();
        integers.add(userId);
        if(follows.containsKey(userId)){
            integers.addAll(follows.get(userId));
        }
        List<Integer> result=new ArrayList<>();
        int count=0;
        for (Tweet tweet:tweets){
            if(count>=10){
                break;
            }
            if(integers.contains(tweet.userId)){
                result.add(tweet.getTweetId());
                count++;
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)){
            List<Integer> list=follows.get(followerId);
            list.add(followeeId);
            follows.put(followerId,list);
        }else{
            List<Integer> list=new ArrayList<>();
            list.add(followeeId);
            follows.put(followerId,list);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)) {
            List<Integer> list = follows.get(followerId);
            list.remove(Integer.valueOf(followeeId));
            follows.put(followerId, list);
        }else {
            return;
        }
    }

    public static void main(String[] args) {

    }
}

