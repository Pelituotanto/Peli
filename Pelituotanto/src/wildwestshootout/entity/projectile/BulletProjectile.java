package wildwestshootout.entity.projectile;

import wildwestshootout.entity.particle.Particle;
import wildwestshootout.graphics.Screen;
import wildwestshootout.graphics.Sprite;

/**
 *
 * @author Sami
 */
public class BulletProjectile extends Projectile {

    public static final int RELOAD_SPEED = 15;

    public BulletProjectile(int xOrigin, int yOrigin, double direction) {
        super(xOrigin, yOrigin, direction);
        range = 200;
        speed = 3;
        damage = 20;
        sprite = Sprite.musketBullet;

        nx = speed * Math.cos(angle);
        ny = speed * Math.sin(angle);
    }

    @Override
    public void update() {
        if (level.tileCollision(x, y, nx, ny, 7)) {
            Particle p = new Particle((int) x, (int) y, 50);
            level.add(p);
            remove();
        }
        move();
    }

    protected void move() {
        x += nx;
        y += ny;
        if (calculateDistance() > range) {
            remove();
        }
    }

    private double calculateDistance() {
        double distance = 0;
        distance = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
        return distance;
    }

    @Override
    public void render(Screen screen) {
        screen.renderProjectile((int) x - 10, (int) y - 2, this);
    }

}