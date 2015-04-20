package wildwestshootout.entity;

import java.util.Random;
import wildwestshootout.graphics.Screen;
import wildwestshootout.level.Level;

/**
 *
 * @author Sami nurmivaara
 */
public abstract class Entity {
    
    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();
    
    public void update() {
    }
    
    public void render(Screen screen) {
    }
    
    public void remove(){
        //Poistetaan yksikkö levelistä
        removed = true;
    }
    
    public boolean isRemoved() {
        return removed;
    }
    
    public void init(Level level) {
        this.level = level;
    }
    
}
