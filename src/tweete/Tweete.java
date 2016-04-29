/*Copyright (c) 2016 Akash Srivastava

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package tweete;

import java.util.List;
import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;



/**
 *
 * @author Akash Srivastava a.k.a AXE
 */
public class Tweete {
    
   

    Tweete()
    {
        
    }
    public void updateTweete(String sta)
    {
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
              .setOAuthConsumerKey("######################")
              .setOAuthConsumerSecret("######################")
              .setOAuthAccessToken("############################################")
              .setOAuthAccessTokenSecret("############################################");
             TwitterFactory tf = new TwitterFactory(cb.build());
             Twitter twitter = tf.getInstance();
         
          try {
			
			twitter.updateStatus(sta);

			System.out.println("Successfully updated the status in Twitter.");
		 
	
        }catch(TwitterException te) {
            
            
            if (401 == te.getStatusCode()) {
                            System.out.println("Unable to get the access token.");
                        }
            
            else if(92 == te.getStatusCode()){
                System.out.println("SSL is required");
            }
            
            else{            
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
            }
        }catch(Exception e)
        {
            System.out.println("Something went wrong");
        }
	}	
    
    
    public void showTimeline()
    {
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
              .setOAuthConsumerKey("######################")
              .setOAuthConsumerSecret("######################")
              .setOAuthAccessToken("############################################")
              .setOAuthAccessTokenSecret("############################################");
             TwitterFactory tf = new TwitterFactory(cb.build());
             Twitter twitter = tf.getInstance();
         
           try {
          ResponseList<Status> a = twitter.getUserTimeline(new Paging(1,10));
           String statuses="";	
           for(Status b: a) {
        		statuses=statuses+b.getText()+"\n\n---------------------------------------\n\n";
                        
        	}
           
            new TweeteTimeline().Timeline(statuses);
           }catch(TwitterException te) {
            //te.printStackTrace();
            
            if (401 == te.getStatusCode()) {
                            System.out.println("Unable to get the access token.");
                        }
            
            else if(92 == te.getStatusCode()){
                System.out.println("SSL is required");
            }
            
            else{            
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
            }
        }catch(Exception e)
        {
            System.out.println("Something went wrong");
        }
	}
    
    public void sendMessage(String id,String msg)
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
              .setOAuthConsumerKey("######################")
              .setOAuthConsumerSecret("######################")
              .setOAuthAccessToken("############################################")
              .setOAuthAccessTokenSecret("############################################");
             TwitterFactory tf = new TwitterFactory(cb.build());
             Twitter twitter = tf.getInstance();
         
            
          
	 try {
            DirectMessage message = null;
            message = twitter.sendDirectMessage(id,msg);
            System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());
	
        }catch(TwitterException te) {
            //te.printStackTrace();
            
            if (401 == te.getStatusCode()) {
                            System.out.println("Unable to get the access token.");
                        }
            
            else if(92 == te.getStatusCode()){
                System.out.println("SSL is required");
            }
            
            else{            
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
            }
        }catch(Exception e)
        {
            System.out.println("Something went wrong");
        }
		
        
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TweeteMain T=new TweeteMain();   
                T.setVisible(true);
                T.setTitle("Tweete");
            }
        });
      
    }
    
}
