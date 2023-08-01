import java.util.Scanner;

public class Chat {

    public static void main(String[] args) {

        String[] repliesToIllegalRequest1 = {
                "what ",
                "say I should say "
        };

        String[] repliesToIllegalRequest2 = {
                "what ",
                "say I should say "
        };

        ChatterBot[] chatterBots = new ChatterBot[] {
                new ChatterBot("Erik", repliesToIllegalRequest1),
                new ChatterBot("Yuval" ,repliesToIllegalRequest2)
        };

        String statement = "Hi Israel";

        Scanner s = new Scanner(System.in);
        String keyToContinue = "";
        while(!keyToContinue.equals("exit")){
            for(ChatterBot bot : chatterBots){
                statement = bot.replyTo(statement);
                System.out.println(bot.getName() + ": " + statement);
                keyToContinue = s.nextLine();
            }
        }
    }
}