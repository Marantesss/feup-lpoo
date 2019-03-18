import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element {

    Hero(Position position) {
        this.position = position;
    }

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }

    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");

        // graphics.putString(new TerminalPosition(position.getX() * 2, position.getY() * 2), "\\/");
        // graphics.putString(new TerminalPosition(position.getX() * 2, position.getY() * 2), "/\\");
    }
}
