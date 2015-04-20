package wildwestshootout.entity.projectile;

import wildwestshootout.entity.Entity;
import wildwestshootout.graphics.Sprite;

/**
 *
 * @author Sami nurmivaara
 */
public abstract class Projectile extends Entity {
    
    protected final int xOrigin, yOrigin;
    protected double angle;
    public Sprite sprite;
    protected double x, y;
    protected double nx, ny;
    protected double distance;
    protected double speed, range, damage;
    
    public Projectile(int xOrigin, int yOrigin, double direction) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.angle = direction;
        this.x = xOrigin;
        this.y = yOrigin;
    }
    
    public Sprite getSprite(){
        return sprite;
    }
    
    public int getSpriteSize() {
        return sprite.SIZE;
    }
    
    protected void move() {
        
    }
}
