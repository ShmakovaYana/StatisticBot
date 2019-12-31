import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.objects.*;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.abilitybots.api.util.AbilityExtension;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.abilitybots.api.objects.Reply;

public class BotAbility implements AbilityExtension {
    private SilentSender silent;
    private DBContext db;
    private User user;

    BotAbility(SilentSender silent, DBContext db) {
        this.silent = silent;
        this.db = db;
    }


    public Reply AddPhoto() {
        return Reply.of(update -> {
                    long chatId = update.getMessage().getChatId();
                    long userId = update.getMessage().getFrom().getId();
                    Stat stat = new Stat(db, chatId, userId);
                    stat.newPhoto();
                },
                Flag.PHOTO);
    }

    public Reply AddMessage() {
        return Reply.of(update -> {
                    long chatId = update.getMessage().getChatId();
                    long userId = update.getMessage().getFrom().getId();
                    Stat stat = new Stat(db, chatId, userId);
                    if (update.getMessage().getText().equals("/delete")) {
                        stat.remove();
                    } else if (update.getMessage().getText().equals("/statistic")) {
                        String user=update.getMessage().getFrom().getUserName();
                        silent.send(stat.get(user), update.getMessage().getChatId());
                    } else if (update.getMessage().getText().equals("/statisticAll")) {
                        silent.send(stat.getAll(), update.getMessage().getChatId());
                    }else if (update.getMessage().getText().equals("/delete@Unicpobot")) {
                            stat.remove();
                        } else if (update.getMessage().getText().equals("/statistic@Unicpobot")) {
                            String user=update.getMessage().getFrom().getUserName();
                            silent.send(stat.get(user), update.getMessage().getChatId());
                        } else if (update.getMessage().getText().equals("/statisticAll@Unicpobot")) {
                            silent.send(stat.getAll(), update.getMessage().getChatId());
                    }else if(update.getMessage().getText().equals("/help")){
                        silent.send("Информация по функционал бота\n/statistic-команда для получения статистики по ползователю\n/statisticAll-команда для получения статистики по всему чату\n/delete-очистка базы данных\n/help-информация по боту", update.getMessage().getChatId());
                    }else if(update.getMessage().getText().equals("/start@Unicpobot")) {
                        silent.send("Привет, я бот по получению статистики чата, для того, чтобы узнать, чем я занимаюсь напиши /help", update.getMessage().getChatId());
                    }else if(update.getMessage().getText().equals("/help@Unicpobot")){
                        silent.send("Информация по функционал бота\n/statistic-команда для получения статистики по ползователю\n/statisticAll-команда для получения статистики по всему чату\n/delete-очистка базы данных\n/help-информация по боту", update.getMessage().getChatId());

                    }else if(update.getMessage().getText().equals("/start")) {
                        silent.send("Привет, я бот по получению статистики чата, для того, чтобы узнать, чем я занимаюсь напиши /help", update.getMessage().getChatId());
                    }else {
                        stat.newMess();
                    }
                },
                Flag.TEXT);
    }

    public Reply AddAnswer() {
        return Reply.of(update -> {
                    long chatId = update.getMessage().getChatId();
                    long userId = update.getMessage().getFrom().getId();
                    Stat stat = new Stat(db, chatId, userId);
                    stat.newReply();
                },
                Flag.REPLY);
    }
    public Reply AddDoc() {
        return Reply.of(update -> {
                    long chatId = update.getMessage().getChatId();
                    long userId = update.getMessage().getFrom().getId();
                    Stat stat = new Stat(db, chatId, userId);
                    stat.newDoc();
                },
                Flag.DOCUMENT);
    }

}