package wildwestshootout.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Sami nurmivaara
 */
public class Mouse implements MouseListener, MouseMotionListener{

    private static int mouseX = -1;
    private static int mouseY = -1;
    private static int mouseB = -1;
    
    public static int getX() {
        return mouseX;
    }
    
    public static int getY() {
        return mouseY;
    }
    
    public static int getButton() {
        return mouseB;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        mouseB = me.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        mouseB = -1;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
    }
    
}
