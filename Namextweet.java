//unduh twitter4j di http://twitter4j.org/en/index.html
//masukkan ke project     
//twitter4j-async-a.b.c.jar
//    twitter4j-core-a.b.c.jar
//    twitter4j-media-support-a.b.c.jar
//    twitter4j-stream-a.b.c.jar
//ubah consumer key, consumer key secret, access token, access token secret sesuai akun twitter anda


import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "WP5jG16JHKIUrJARpaj44xiI7";
    private final static String CONSUMER_KEY_SECRET = "WlAETawdop5yPwAcbHD3IJVQKzNczdHW4VqydgN2hgtNwOxvvD";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("sabar");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "VQQjUbyuNfcC745KVom8n82LjREYyxOCDY25JlSq6Fgyc";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "995972897024847872-TIycKvkaBjMYndLP7M6m1Voe53NYu2b";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}
