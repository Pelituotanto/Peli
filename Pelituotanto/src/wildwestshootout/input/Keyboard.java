package wildwestshootout.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Sami nurmivaara
 */
public class Keyboard implements KeyListener {

    //Määritellään muuttuja keys[] ka up, down, left & right
    private boolean[] keys = new boolean[120];
    public boolean up, down, left, right;

    //Asetetaan liikkumisnäppäimiksi ylös, alas, oikealle, vasemmalle sekä WASD
    public void update() {
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
    }

}
