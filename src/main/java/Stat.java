import org.telegram.abilitybots.api.db.DBContext;

import java.util.Map;

public class Stat {
    private Map<Integer, long[]> statMap;
    private long chatId;
    private long userId;

    public Stat(DBContext db, long chatId, long userId) {
        statMap = db.getMap(String.valueOf(chatId));

        this.chatId = chatId;
        this.userId = userId;

        for (int i : statMap.keySet()) {

            if (statMap.get(i)[0] != chatId) {
                statMap.put(statMap.size(), new long[] {chatId,0,0,0});
            }
            if (statMap.get(i)[0] != userId) {
                statMap.put(statMap.size(), new long[] {userId,0,0,0});
            }
        }
    }
    void newMess () {
        for (int i : statMap.keySet()) {
            if (statMap.get(i)[0] == (chatId)) {
                statMap.put(statMap.size(), new long[] {
                        statMap.get(i)[0],
                        statMap.get(i)[1] + 1,
                        statMap.get(i)[2],
                        statMap.get(i)[3],
                });
            }
            if (statMap.get(i)[0] == (userId)) {
                statMap.put(statMap.size(), new long[] {
                        statMap.get(i)[0],
                        statMap.get(i)[1] + 1,
                        statMap.get(i)[2],
                        statMap.get(i)[3],
                });
            }
        }
    }

    void newPhoto () {
        for (int i : statMap.keySet()) {
            if (statMap.get(i)[0] == (chatId)) {
                statMap.put(statMap.size(), new long[] {
                        statMap.get(i)[0],
                        statMap.get(i)[1],
                        statMap.get(i)[2] + 1,
                        statMap.get(i)[3],
                });
            }
            if (statMap.get(i)[0] == (userId)) {
                statMap.put(statMap.size(), new long[]{
                        statMap.get(i)[0],
                        statMap.get(i)[1],
                        statMap.get(i)[2] + 1,
                        statMap.get(i)[3],
                });
            }
        }
    }
    void newReply () {
        for (int i : statMap.keySet()) {
            if (statMap.get(i)[0] == (chatId)) {
                statMap.put(statMap.size(), new long[] {
                        statMap.get(i)[0],
                        statMap.get(i)[1],
                        statMap.get(i)[2],
                        statMap.get(i)[3] + 1,
                });
            }
            if (statMap.get(i)[0] == (userId)) {
                statMap.put(statMap.size(), new long[]{
                        statMap.get(i)[0],
                        statMap.get(i)[1], statMap.get(i)[2],
                        statMap.get(i)[3] + 1,
                });
            }
        }
    }
    String get() {
        String a = "Пусто";
        for (int i : statMap.keySet()) {
            if (statMap.get(i)[0] == (userId)) {
                a = "Всего:\n"
                        + statMap.get(i)[1]
                        + "сообщений\n"
                        + statMap.get(i)[2]
                        + "фото\n"
                        + statMap.get(i)[3]
                        + "ответов\n";
            }
        }
        return a;
    }
}
