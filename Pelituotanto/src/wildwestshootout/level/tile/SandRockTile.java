package wildwestshootout.level.tile;

import wildwestshootout.graphics.Screen;
import wildwestshootout.graphics.Sprite;

/**
 *
 * @author Sami nurmivaara
 */
public class SandRockTile extends Tile{
    
    public SandRockTile(Sprite sprite) {
        super(sprite);
    }
    
    
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this); // << 4 = * 16
    }
    
    @Override
    public boolean solid() {
        return true;
    }
}
