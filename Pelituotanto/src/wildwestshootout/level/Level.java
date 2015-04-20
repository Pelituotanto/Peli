package wildwestshootout.level;

import java.util.ArrayList;
import java.util.List;
import wildwestshootout.entity.Entity;
import wildwestshootout.entity.particle.Particle;
import wildwestshootout.entity.projectile.Projectile;
import wildwestshootout.graphics.Screen;
import wildwestshootout.level.tile.Tile;

/**
 *
 * @author Sami nurmivaara
 */
public class Level {

    protected int width, height;
    protected int[] tilesInt;
    protected int[] tiles;

    private List<Entity> entities = new ArrayList<>();
    private List<Projectile> projectiles = new ArrayList<>();
    private List<Particle> particles = new ArrayList<>();

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tilesInt = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel(path);
        generateLevel();
    }

    protected void generateLevel() {
    }

    protected void loadLevel(String path) {
    }

    public void update() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
        }
        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).update();
        }
        for (int i = 0; i < particles.size(); i++) {
            particles.get(i).update();
        }
        remove();
    }
    
    private void remove() {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).isRemoved()) {
                entities.remove(i);
            }
        }
        for (int i = 0; i < projectiles.size(); i++) {
            if (projectiles.get(i).isRemoved()) {
                projectiles.remove(i);
            }
        }
        for (int i = 0; i < particles.size(); i++) {
            if (particles.get(i).isRemoved()) {
                particles.remove(i);
            }
        }
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    private void time() {
    }

    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll);
        int x0 = xScroll >> 4; // ">> 4" == "/ 16"
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x, y, screen);
            }
        }
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).render(screen);
        }

        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).render(screen);
        }
        for (int i = 0; i < particles.size(); i++) {
            particles.get(i).render(screen);
        }
    }

    public void add(Entity e) {
        e.init(this);
        if (e instanceof Particle) {
            particles.add((Particle) e);
        } else if (e instanceof Projectile) {
            projectiles.add((Projectile) e);
        } else {
            entities.add(e);
        }
    }

    public Tile getTile(int x, int y) {
        //Palautetaan voidTile jos poistutaan kartalta
        if (x < 0 || y < 0 || x >= this.width || y >= this.height) {
            return Tile.voidTile;
        }

        /**
         * Hiekka = 0xFFFFFF00 Betoni = 0xFF808080 Kaktus hiekalla = 0xFFAAD800
         * Kivi hiekalla = 0xFFCEAC00
         */
        if (tiles[x + y * width] == Tile.col_sand) {
            return Tile.sand;
        }
        if (tiles[x + y * width] == Tile.col_concrete) {
            return Tile.concrete;
        }
        if (tiles[x + y * width] == Tile.col_sandCactus) {
            return Tile.sandCactus;
        }
        if (tiles[x + y * width] == Tile.col_sandRock) {
            return Tile.sandRock;
        }

        return Tile.voidTile;
    }

    public boolean tileCollision(int x, int y, int size, int xOffset, int yOffset) {
        boolean solid = false;
        for (int c = 0; c < 4; c++) {
            int xt = (x - c % 2 * size + xOffset) >> 4;
            int yt = (y - c / 2 * size + yOffset) >> 4;
            if (getTile(xt, yt).solid()) {
                solid = true;
            }
        }
        return solid;
    }
}
