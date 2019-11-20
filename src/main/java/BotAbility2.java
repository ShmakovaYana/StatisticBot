//import org.telegram.abilitybots.api.bot.AbilityBot;
//import org.telegram.abilitybots.api.bot.AbilityBot;
//import org.telegram.abilitybots.api.db.DBContext;
//import org.telegram.abilitybots.api.objects.Ability;
//import org.telegram.abilitybots.api.objects.Locality;
//import org.telegram.abilitybots.api.objects.Privacy;
//import org.telegram.telegrambots.bots.DefaultBotOptions;
//import org.telegram.telegrambots.meta.api.objects.Update;
//
//import java.util.List;
//import java.util.Queue;
//
//public class BotAbility2 extends AbilityBot {
//
//// public BotAbility(DefaultBotOptions botOptions) {
////super(botOptions);
//// }
//
//    private static final String BOT_USERNAME = "Unicpobot";
//    private static final String BOT_TOKEN = "906247368:AAGjqbsyjAu9BAEu5PiW0dTaEjpn05OX9HU";
//    private String ;
//    //private final String BOT_TOKEN = System.getenv("TOKEN");
//
//    BotAbility2(DefaultBotOptions botOptions) {
//        super(BOT_TOKEN, BOT_USERNAME, botOptions);
//    }
//
//    @Override
//
//    public int creatorId() {
//        return 0;
//    }
//
//    public Ability sayHelloWorld() {
//        return Ability
//                .builder()
//                .name("bot")
//                .info("says hello world")
//                .input(0)
//                .locality(Locality.ALL)
//                .privacy(Privacy.PUBLIC)
//                .action(ctx ->{
//                    String text= ctx.first();
//                    try{
//                        Queue<E> keyboardButtonsRow1;
//                        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("Fi4a")
//                                .setCallbackData("CallFi4a"));
//                    }
//                }
//                .post(ctx -> silent.send("bye world", ctx.chatId()))
//                .build();
//
//    }
//
//    @Override
//    public String getBotUsername() {
//        return BOT_USERNAME;
//    }
//
//    @Override
//    public String getBotToken() {
//        return BOT_TOKEN;
//    }
//}

