package wildwestshootout.level.tile;

import wildwestshootout.graphics.Screen;
import wildwestshootout.graphics.Sprite;

/**
 *
 * @author Sami nurmivaara
 */
public class Tile {

    public int x, y;
    public Sprite sprite;

    public static Tile sand = new SandTile(Sprite.sand);
    public static Tile concrete = new ConcreteTile(Sprite.concrete);
    public static Tile sandCactus = new SandCactusTile(Sprite.sandCactus);
    public static Tile sandRock = new SandRockTile(Sprite.sandRock);
    public static Tile musketBullet = new SandRockTile(Sprite.musketBullet);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);
    
    
    /**
     * Hiekka = 0xFFFFFF00 
     * Betoni = 0xFF808080 
     * Kaktus hiekalla = 0xFFAAD800
     * Kivi hiekalla = 0xFFCEAC00
     */
    public static final int col_sand = 0xFFFFFF00;
    public static final int col_concrete = 0xFF808080;
    public static final int col_sandCactus = 0xFFAAD800;
    public static final int col_sandRock = 0xFFCEAC00;
    

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
    }

    public boolean solid() {
        return false;
    }
    
    public boolean breakable() {
        return false;
    }
}
