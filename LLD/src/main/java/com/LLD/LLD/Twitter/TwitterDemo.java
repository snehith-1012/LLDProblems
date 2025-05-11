package com.LLD.LLD.Twitter;

import java.util.List;

public class TwitterDemo {

    public static void main(String[] args) {

        Twitter twitter = Twitter.getInstance();
        User user1 = new User(101);
        User user2 = new User(102);
        User user3 = new User(103);
        User user4 = new User(104);
        User user5 = new User(105);
        User user6 = new User(106);
        User user7 = new User(107);
        User user8 = new User(108);
        User user9 = new User(109);
        User user10 = new User(110);

        twitter.addUser(user1);
        twitter.addUser(user2);
        twitter.addUser(user3);
        twitter.addUser(user4);
        twitter.addUser(user5);
        twitter.addUser(user6);
        twitter.addUser(user7);
        twitter.addUser(user8);
        twitter.addUser(user9);
        twitter.addUser(user10);

        twitter.followUser(user1.getUserId(), user2.getUserId());
        twitter.followUser(user2.getUserId(), user3.getUserId());
        twitter.followUser(user3.getUserId(), user4.getUserId());

        twitter.followUser(user4.getUserId(), user10.getUserId());
        twitter.followUser(user10.getUserId(), user1.getUserId());

        // follow and unfollow
        twitter.followUser(user5.getUserId(), user6.getUserId());
        twitter.removeFollower(user5.getUserId(), user6.getUserId());


        // create tweets
        Tweet tweet1 = new Tweet(101, "101");
        Tweet tweet2 = new Tweet(102, "102");
        Tweet tweet3 = new Tweet(103, "103");
        Tweet tweet4 = new Tweet(104, "104");
        Tweet tweet5 = new Tweet(105, "105");
        Tweet tweet6 = new Tweet(106, "106");
        Tweet tweet7 = new Tweet(107, "107");
        Tweet tweet8 = new Tweet(108, "108");
        Tweet tweet9 = new Tweet(109, "109");
        Tweet tweet10 = new Tweet(110, "110");
        Tweet tweet11 = new Tweet(111, "111");
        Tweet tweet12 = new Tweet(112, "112");
        Tweet tweet13 = new Tweet(113, "113");
        Tweet tweet14 = new Tweet(114, "114");
        Tweet tweet15 = new Tweet(115, "115");
        Tweet tweet16 = new Tweet(116, "116");
        Tweet tweet17 = new Tweet(117, "117");


        // user adds tweets
        twitter.tweet(101, tweet1);
        twitter.tweet(102, tweet2);
        twitter.tweet(103, tweet3);
        twitter.tweet(104, tweet4);
        twitter.tweet(105, tweet5);
        twitter.tweet(106, tweet6);
        twitter.tweet(107, tweet7);
        twitter.tweet(108, tweet8);
        twitter.tweet(109, tweet9);
        twitter.tweet(110, tweet10);
        twitter.tweet(101, tweet11);
        twitter.tweet(102, tweet12);
        twitter.tweet(103, tweet13);
        twitter.tweet(104, tweet14);
        twitter.tweet(105, tweet15);
        twitter.tweet(106, tweet16);
        twitter.tweet(107, tweet17);

        twitter.removeTweet(107, 117);


        List<Tweet> latestTweets1 = twitter.getLatestTweets();
        List<Tweet> popularTweets1 = twitter.getPopularTweets();

        // like and comment tweets
        twitter.likeTweet(101, user1.getUserId());
        twitter.likeTweet(101, user2.getUserId());
        twitter.doComment(101, user1.getUserId(), "nice tweet");
        twitter.doComment(101, user2.getUserId(), "bad tweet");

        twitter.likeTweet(102, user1.getUserId());
        twitter.likeTweet(102, user2.getUserId());
        twitter.doComment(102, user1.getUserId(), "nice tweet 2");
        twitter.doComment(102, user2.getUserId(), "bad tweet 2");

        twitter.likeTweet(103, user1.getUserId());
        twitter.likeTweet(103, user2.getUserId());
        int commentId = twitter.doComment(103, user1.getUserId(), "nice tweet 3");

        List<Tweet> latestTweets2 = twitter.getLatestTweets();
        List<Tweet> popularTweets2 = twitter.getPopularTweets();

        // unlike tweet
        twitter.unLikeTweet(102, user1.getUserId());

        List<Tweet> latestTweets3 = twitter.getLatestTweets();
        List<Tweet> popularTweets3 = twitter.getPopularTweets();

        // un comment
        twitter.unComment(103, commentId, user1.getUserId());

        List<Tweet> latestTweets4 = twitter.getLatestTweets();
        List<Tweet> popularTweets4 = twitter.getPopularTweets();

    }
}
