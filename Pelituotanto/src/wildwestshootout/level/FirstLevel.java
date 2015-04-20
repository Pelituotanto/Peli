package wildwestshootout.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import wildwestshootout.level.tile.Tile;

/**
 *
 * @author Sami nurmivaara
 */
public class FirstLevel extends Level {

    public FirstLevel(String path) {
        super(path);
    }

    @Override
    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(FirstLevel.class.getResource(path));
            int w = width = image.getWidth();
            int h = height = image.getHeight();
            tiles = new int[w * h];
            image.getRGB(0, 0, w, h, tiles, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Virhe! Ei pystytty ladata level-tiedostoa!");
        }
    }

    @Override
    protected void generateLevel() {
    }

}
