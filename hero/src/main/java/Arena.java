import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    // Arena Size
    private int height;
    private int width;

    // Hero
    private Hero hero;

    // Walls
    private List<Wall> walls;

    // coins
    private List<Coin> coins;

    // monsters
    private List<Monster> monsters;

    Arena(int height, int width) {
        // creating arena
        this.height = height;
        this.width = width;

        // creating hero
        hero = new Hero(new Position(5, 5));

        // creating walls
        this.walls = createWalls();

        // creating coins
        this.coins = createCoins();

        // creating monsters
        this.monsters = createMonsters();
    }


    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(new Position(c, 0)));
            walls.add(new Wall(new Position(c, height - 1)));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(new Position(0, r)));
            walls.add(new Wall(new Position(width - 1,r)));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1)));
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            monsters.add(new Monster(new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1)));
        return monsters;
    }

    private void retrieveCoins() {
        Coin foundCoin = null;
        // We cannot modify a List (or any other data structure for that matter) at the same time you are looping over it
        for (Coin coin : coins)
            if (coin.getPosition().equals(hero.getPosition())) {
                 foundCoin = coin;
                 break;
            }
        if (foundCoin != null)
            this.coins.remove(foundCoin);
    }

    private void moveMonsters() {
        for (Monster monster : monsters)
            monster.move();
    }

    public boolean verifyMonsterCollisions() {
        // Detecting Collision
        for (Monster monster : monsters)
            if (monster.getPosition().equals(hero.getPosition())) {
                return true;
            }

        return false;
    }

    public void processKey(KeyStroke key) {
        //System.out.println(key);
        switch (key.getKeyType()) {
            // feel the power off Alt+Enter :)
            case Character:
                break;
            case Escape:
                break;
            case Backspace:
                break;
            case ArrowLeft:
                this.updateArena(hero.moveLeft());
                break;
            case ArrowRight:
                this.updateArena(hero.moveRight());
                break;
            case ArrowUp:
                this.updateArena(hero.moveUp());
                break;
            case ArrowDown:
                this.updateArena(hero.moveDown());
                break;
            case Insert:
                break;
            case Delete:
                break;
            case Home:
                break;
            case End:
                break;
            case PageUp:
                break;
            case PageDown:
                break;
            case Tab:
                break;
            case ReverseTab:
                break;
            case Enter:
                break;
            case F1:
                break;
            case F2:
                break;
            case F3:
                break;
            case F4:
                break;
            case F5:
                break;
            case F6:
                break;
            case F7:
                break;
            case F8:
                break;
            case F9:
                break;
            case F10:
                break;
            case F11:
                break;
            case F12:
                break;
            case F13:
                break;
            case F14:
                break;
            case F15:
                break;
            case F16:
                break;
            case F17:
                break;
            case F18:
                break;
            case F19:
                break;
            case Unknown:
                break;
            case CursorLocation:
                break;
            case MouseEvent:
                break;
            case EOF:
                break;
        }
    }

    private boolean canMonsterMove(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;

        for (Coin coin : coins)
            if (coin.getPosition().equals(position))
                return false;

        return true;
    }

    private boolean canHeroMove(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;

            return true;
    }

    public void updateArena(Position position) {
        // moving hero
        if (canHeroMove(position)) {
            hero.setPosition(position);
            this.retrieveCoins();
        }
        // moving monsters
        for (Monster monster : monsters) {
            Position newPosition = monster.move();
            if (canMonsterMove(newPosition)) {
                monster.setPosition(newPosition);
            }
        }
    }

    public void draw(TextGraphics graphics) {
        // drawing the arena
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.getWidth(), this.getHeight()), ' ');
        //graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');

        // drawing the hero
        hero.draw(graphics);

        // drawing the walls
        for (Wall wall : walls)
            wall.draw(graphics);

        // drawing coins
        for (Coin coin : coins)
            coin.draw(graphics);

        // drawing monsters
        for (Monster monster : monsters)
            monster.draw(graphics);
    }
}
