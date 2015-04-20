package wildwestshootout.entity.mob;

import java.util.ArrayList;
import java.util.List;
import wildwestshootout.entity.projectile.BulletProjectile;
import wildwestshootout.entity.Entity;
import wildwestshootout.entity.particle.Particle;
import wildwestshootout.entity.projectile.Projectile;
import wildwestshootout.graphics.Sprite;

/**
 *
 * @author Sami nurmivaara
 */
public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int direction = 0;
    protected boolean moving = false;
    protected boolean walking = false;

    public void move(int xa, int ya) {
        //Jos liikutaan kahdella akselilla, suoritetaan kaksi move() metodia
        if (xa != 0 && ya != 0) {
            move(xa, 0);
            move(0, ya);
            return;
        }
        
        //vasen
        if (xa > 0) {
            this.direction = 1;
        }
        //oikea
        if (xa < 0) {
            this.direction = 3;
        }
        //ylös
        if (ya > 0) {
            this.direction = 2;
        }
        //alas
        if (ya < 0) {
            this.direction = 0;
        }

        //Liikutaan jos hahmo ei osu mihinkään liikkuessaan
        if (!collision(xa, ya)) {
            x += xa;
            y += ya;
        }
    }

    @Override
    public void update() {
        
    }
    
    protected void shoot(int x, int y, double direction) {
        Projectile projectile = new BulletProjectile(x, y, direction);
        level.add(projectile);
    }

    private boolean collision(int xa, int ya) {
        boolean solid = false;
        for (int c = 0; c < 4; c++) {
            int xt = ((x + xa) + c % 2 * 14 - 8) / 16;
            int yt = ((y + ya) + c / 2 * 12 + 3) / 16;
            if (level.getTile(xt, yt).solid()) {
                solid = true;
            }
        }
        return solid;
    }

    public void render() {
    }

}
