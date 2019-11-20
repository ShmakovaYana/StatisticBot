import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class BotAbility extends AbilityBot {

// public BotAbility(DefaultBotOptions botOptions) {
//super(botOptions);
// }

    private static final String BOT_USERNAME="Unicpobot";
    private static String BOT_TOKEN = System.getenv("BOT_TOKEN");

    BotAbility(DefaultBotOptions botOptions) {
        super(BOT_TOKEN, BOT_USERNAME, botOptions);
    }

    @Override
    public int creatorId() {
        return 0;
    }
    public Ability sayHelloWorld() {
        return Ability
                .builder()
                .name("hello")
                .info("says hello world")
                .input(0)
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> silent.send("Hello!",ctx.chatId()))
                .post(ctx->silent.send("bye world",ctx.chatId()))
                .build();

    }
    public Ability Botsay() {
        return Ability
                .builder()
                .name("bot")
                .info("says hello world")
                .input(0)
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> silent.execute(new SendMessage()))//"Bot Ability!",ctx.chatId()))
                .post(ctx->silent.send("I'm a bot",ctx.chatId()))
                .build();

    }
    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return  System.getenv("BOT_TOKEN");
    }
}