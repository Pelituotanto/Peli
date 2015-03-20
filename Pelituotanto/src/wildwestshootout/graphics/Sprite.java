package wildwestshootout.graphics;

/**
 *
 * @author Sami
 */
public class Sprite {
    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;
    
    //Sprite -lisääminen! Täyttö: (Koko (pikseleitä X * X), Y koordinaatti, X koordinaatti, Spritesheet joka kyseessä)
    public static Sprite sand = new Sprite(16, 0, 0, SpriteSheet.tiles);
    
    //Konstruktori
    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        this.SIZE = size;
        this.pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }
    
    //load() metodi joka lataa tietyt pikselit (tietyn Spriten määritellystä SpriteSheet:istä
    private void load() {
        for (int y = 0; y < this.SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }
    
}
