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
        boolean flag = false;

        if (statMap.isEmpty()) {
            statMap.put(statMap.size(), new long[] {chatId,0,0,0,0});
        }

        for (int i : statMap.keySet()) {
            long q =statMap.get(i)[0];
            if (statMap.get(i)[0] == userId) {
                flag = true;
            }
        }

        if (!flag) {
            statMap.put(statMap.size(), new long[] {userId,0,0,0,0});
        }
    }

    void newMess () {
        for (int i : statMap.keySet()) {
            long q = statMap.get(i)[0];
            if (statMap.get(i)[0] == (chatId)) {
                statMap.put(i, new long[] {
                        statMap.get(i)[0],
                        statMap.get(i)[1] + 1,
                        statMap.get(i)[2],
                        statMap.get(i)[3],
                        statMap.get(i)[4]
                });
            } else if (statMap.get(i)[0] == (userId)) {
                statMap.put(i, new long[] {statMap.get(i)[0],
                        statMap.get(i)[1] + 1,
                        statMap.get(i)[2],
                        statMap.get(i)[3],
                        statMap.get(i)[4]
                });
            }
        }
    }

    void newPhoto () {
        for (int i : statMap.keySet()) {
            if (statMap.get(i)[0] == (chatId)) {
                statMap.put(i, new long[] {
                        statMap.get(i)[0],
                        statMap.get(i)[1],
                        statMap.get(i)[2] + 1,
                        statMap.get(i)[3],
                        statMap.get(i)[4]
                });
            }
            else if (statMap.get(i)[0] == (userId)) {
                statMap.put(i, new long[]{
                        statMap.get(i)[0],
                        statMap.get(i)[1],
                        statMap.get(i)[2] + 1,
                        statMap.get(i)[3],
                        statMap.get(i)[4]
                });
            }
        }
    }

    void newReply () {
        for (int i : statMap.keySet()) {
            if (statMap.get(i)[0] == (chatId)) {
                statMap.put(i, new long[] {
                        statMap.get(i)[0],
                        statMap.get(i)[1],
                        statMap.get(i)[2],
                        statMap.get(i)[3] + 1,
                        statMap.get(i)[4]
                });
            } else if (statMap.get(i)[0] == (userId)) {
                statMap.put(i, new long[]{
                        statMap.get(i)[0],
                        statMap.get(i)[1],
                        statMap.get(i)[2],
                        statMap.get(i)[3] + 1,
                        statMap.get(i)[4]
                });
            }
        }
    }
    void newDoc () {
        for (int i : statMap.keySet()) {
            if (statMap.get(i)[0] == (chatId)) {
                statMap.put(i, new long[] {
                        statMap.get(i)[0],
                        statMap.get(i)[1],
                        statMap.get(i)[2],
                        statMap.get(i)[3] ,
                        statMap.get(i)[4]+ 1
                });
            } else if (statMap.get(i)[0] == (userId)) {
                statMap.put(i, new long[]{
                        statMap.get(i)[0],
                        statMap.get(i)[1],
                        statMap.get(i)[2],
                        statMap.get(i)[3] ,
                        statMap.get(i)[4]+ 1
                });
            }
        }
    }


    String get(String user) {
        String a = "Пусто";
        for (int i : statMap.keySet()) {
            if (statMap.get(i)[0] == (userId)) {
                a = "Всего у " +user+":\n"+
                        statMap.get(i)[1] + "сообщений\n" +
                        statMap.get(i)[2] + "фото\n" +
                        statMap.get(i)[3] + "ответов\n"+
                        statMap.get(i)[4]+"документов\n";
            }
        }
        return a;
    }

    String getAll() {
        String a;
        int mess = 0;
        int photo = 0;
        int reply = 0;
        int doc = 0;
        for (int i : statMap.keySet()) {
            mess += statMap.get(i)[1];
            photo += statMap.get(i)[2];
            reply += statMap.get(i)[3];
            doc += statMap.get(i)[4];
        }
        a = "Всего:\n" + mess + "сообщений\n"
                + photo + "фото\n"
                + reply + "ответов\n"
                + doc + "документов\n";
        return a;
    }

    void remove () {
        for (int i : statMap.keySet()) {
            statMap.remove(i);
        }
    }
}