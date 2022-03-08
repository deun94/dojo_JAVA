// don't need to compile this file directly
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        //$s. for the variable
        return String.format("Hello, %s. Lovely to see you.", name);
    }

    public String guestGreeting(String name, String daytime) {
        return String.format("Good $s. $s. Lovely to see you", daytime, name);
    }
    
    public String dateAnnouncement() {
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy");

        // LocalDateTime now = LocalDateTime.now();
        ZonedDateTime now = ZonedDateTime.now();
        String currentDate = dateFormatter.format(now);
        
        return String.format("Current date is: %s.", currentDate);
    }
    
    public String respondBeforeAlexis(String conversation) {
        // boolean alexisAppear = true;
        // boolean alfredAppear = true;
        // if(alexisAppear) {
        //     return "Right away, sir.She certainly isn't sophisticated enough for that";
        // }
        // else if (alfredAppear)

        if(conversation.indexOf("Alexis") > -1){
            return "Right Away, sir. She certainly isn't sophisticated enough for that.";
        }
        //-1 is basically saying if the said string is inside the conversation. if it is 0, it'll be the start of the conversation
        else if (conversation.indexOf("Alfred") > -1){
            return "I am here, how can I help you?";
        }

        return "All right. With that I shall retire";
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
    public String yellAtCustomer(String rude){
        return String.format("That is not nice of you to say %s. How rude!!", rude);
    }
}

