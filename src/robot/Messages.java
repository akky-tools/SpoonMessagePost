package robot;

import java.util.HashMap;
import java.util.Map;

public class Messages {
    Map<Integer, String> map = new HashMap<>();

    /** 入室 */
    private static final String ENTRANCE = "";

    /** 退室 */
    private static final String EXIT = "";

    /** ハーコメ */
    private static final String HEART_COMMENT = "";

    /** 自己紹介 */
    private static final String SELF_INTRODUCTION = "";

    public Messages() {
        map.put(1, ENTRANCE);
        map.put(2, EXIT);
        map.put(3, HEART_COMMENT);
        map.put(4, SELF_INTRODUCTION);
    }
}
