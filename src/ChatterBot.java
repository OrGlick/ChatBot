import java.util.*;

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
