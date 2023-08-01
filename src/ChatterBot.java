import java.util.*;

/**
 * Base file for the ChatterBot exercise.
 * The bot's replyTo method receives a statement.
 * If it starts with the constant REQUEST_PREFIX, the bot returns
 * whatever is after this prefix. Otherwise, it returns one of
 * a few possible replies as supplied to it via its constructor.
 * In this case, it may also include the statement after
 * the selected reply (coin toss).
 * @author Dan Nirel
 */
class ChatterBot {

	private String name;
	static final String REQUEST_PREFIX = "say ";
	Random rand = new Random();
	String[] repliesToIllegalRequest;

	 ChatterBot(String name, String[] repliesToIllegalRequest) {
		 this.name = name;
		this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length];
		for(int i = 0 ; i < repliesToIllegalRequest.length ; i = i+1) {
			this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
		}
	}

	 String replyTo(String statement) {
		if(statement.startsWith(REQUEST_PREFIX)) {
			//we don’t repeat the request prefix, so delete it from the reply
			return statement.replaceFirst(REQUEST_PREFIX, "");
		}
		return respondToIllegalRequest(statement);
	}

	private String respondToIllegalRequest(String statement) {
		int randomIndex = rand.nextInt(repliesToIllegalRequest.length);
		String reply = repliesToIllegalRequest[randomIndex];
		if(rand.nextBoolean()) {
			reply = reply + statement;
		}
		return reply;
	}

	String getName(){
		 return name;
	}
}
