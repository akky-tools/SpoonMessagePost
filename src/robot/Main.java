package robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        final Logger logger = Logger.getLogger("MainLogging");
        try {
            post(Integer.parseInt(args[0]));
        } catch (AWTException awtException) {
            logger.log(Level.SEVERE, "*****AWTException*****\n" + awtException.getMessage());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException interruptedException) {
                logger.log(Level.SEVERE, "*****InterruptedException*****\n" + interruptedException.getMessage());
            }
        }
    }

    /*
     * クリップボードの値を任意のフォームに入力してエンターキーを押下する動作の自動化
     *
     */
    @SuppressWarnings("deprecation")
    static void post(int number) throws AWTException {
        Robot robot = new Robot();
        Messages messages = new Messages();

        // クリップボードに値をコピー
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(messages.map.get(number));
        clipboard.setContents(selection, null);

        // マウス移動
        robot.mouseMove(EnumSettings.COORDINATE_X.getValue(), EnumSettings.COORDINATE_Y.getValue());

        // 入力フィールドをクリック
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(EnumSettings.DELAY.getValue());

        // ペースト
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // エンター
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}