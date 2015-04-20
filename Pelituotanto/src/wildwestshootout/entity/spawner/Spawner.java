package wildwestshootout.entity.spawner;

import wildwestshootout.entity.Entity;
import wildwestshootout.entity.particle.Particle;
import wildwestshootout.level.Level;

/**
 *
 * @author Sami nurmivaara
 */
public class Spawner extends Entity {
    
    public enum Type {
        MOB, PARTICLE;
    }
    
    private Type type;
    
    public Spawner(int x, int y, Type type, int amount, Level level) {
        init(level);
        this.x = x;
        this.y = y;
        this.type = type;
    }
    
}
