package wildwestshootout.entity.mob;

import wildwestshootout.Game;
import wildwestshootout.entity.projectile.BulletProjectile;
import wildwestshootout.entity.projectile.Projectile;
import wildwestshootout.graphics.AnimatedSprite;
import wildwestshootout.graphics.Screen;
import wildwestshootout.graphics.Sprite;
import wildwestshootout.graphics.SpriteSheet;
import wildwestshootout.input.Keyboard;
import wildwestshootout.input.Mouse;

/**
 *
 * @author Sami nurmivaara
 */
public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;
    private int animation = 0;
    private boolean walking = false;
    private AnimatedSprite test = new AnimatedSprite(SpriteSheet.player_right, 32, 32, 8);

    Projectile p;
    private int reloadSpeed = 0;

    public Player(Keyboard input) {
        this.input = input;
        sprite = Sprite.player_front;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
        reloadSpeed = BulletProjectile.RELOAD_SPEED;
    }

    @Override
    public void update() {
        test.update();
        if (reloadSpeed > 0) {
            reloadSpeed--;
        }
        int xa = 0, ya = 0;

        if (animation < 7500) {
            animation++;
        } else {
            animation = 0;
        }

        if (input.up) {
            ya--;
        }
        if (input.down) {
            ya++;
        }
        if (input.left) {
            xa--;
        }
        if (input.right) {
            xa++;
        }
        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }
        clear();
        updateShooting();
    }

    @Override
    public void render(Screen screen) {

        if (direction == 0) {
            sprite = Sprite.player_back;
            if (walking) {
                if (animation % 20 > 10) {
                    sprite = Sprite.player_back_1;
                } else {
                    sprite = Sprite.player_back_2;
                }
            }
        }
        if (direction == 1) {
            sprite = Sprite.player_left;
            if (walking) {
                if (animation % 20 > 10) {
                    sprite = Sprite.player_left_1;
                } else {
                    sprite = Sprite.player_left_2;
                }
            }
        }
        if (direction == 2) {
            sprite = Sprite.player_front;
            if (walking) {
                if (animation % 20 > 10) {
                    sprite = Sprite.player_front_1;
                } else {
                    sprite = Sprite.player_front_2;
                }
            }
        }
        if (direction == 3) {
            sprite = Sprite.player_right;
            if (walking) {
                if (animation % 20 > 10) {
                    sprite = Sprite.player_right_1;
                } else {
                    sprite = Sprite.player_right_2;
                }
            }
        }

        sprite = test.getSprite();
        screen.renderDoubleTile(x - 16, y - 16, sprite);
    }

    private void updateShooting() {
        if (Mouse.getButton() == 1 && reloadSpeed <= 0) {
            double dx = Mouse.getX() - Game.getWindowWidth() / 2;
            double dy = Mouse.getY() - Game.getWindowHeight() / 2;
            double dir = Math.atan2(dy, dx);
            shoot(x, y, dir);
            reloadSpeed = BulletProjectile.RELOAD_SPEED;
        }
    }

    private void clear() {
        for (int i = 0; i < level.getProjectiles().size(); i++) {
            Projectile p = level.getProjectiles().get(i);
            if (p.isRemoved()) {
                level.getProjectiles().remove(i);
            }
        }
    }

}
