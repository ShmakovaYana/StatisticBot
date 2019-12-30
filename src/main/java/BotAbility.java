import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.objects.*;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.abilitybots.api.util.AbilityExtension;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.Arrays;
import java.util.Map;
import static org.telegram.abilitybots.api.util.AbilityUtils.stripTag;

public class BotAbility implements AbilityExtension {
    private SilentSender silent;
    private DBContext db;
    private User user;
    BotAbility(SilentSender silent, DBContext db) {
        this.silent = silent;
        this.db = db;
    }

    public BotAbility(DefaultBotOptions botOptions) {
    }

    public Reply AddPhoto() {
        return Reply.of(update -> {
            long chatId = update.getMessage().getChatId();
            long userId = user.getId();
            Stat stat = new Stat(db, chatId, userId);
            stat.newPhoto();
            },
                Flag.PHOTO);
    }
   public Reply AddMessage() {
        return Reply.of(update -> {
            long chatId = update.getMessage().getChatId();
            long userId = user.getId();
            Stat stat = new Stat(db, chatId, userId);
            stat.newMess();
            },
                Flag.TEXT);
    }
    public Reply AddAnswer() {
        return Reply.of(update -> {
            long chatId = update.getMessage().getChatId();
            long userId = user.getId();
            Stat stat = new Stat(db, chatId, userId);
            stat.newReply();
            },
                Flag.REPLY);
    }
    public Reply OutStat() {
        return Reply.of(update -> {
            long chatId = update.getMessage().getChatId();
            long userId = user.getId();
            Stat stat = new Stat(db, chatId, userId);
            silent.send(stat.get(), update.getMessage().getChatId());
            },
                update -> update.getMessage().getText().equals("statistic"));
    }
  }