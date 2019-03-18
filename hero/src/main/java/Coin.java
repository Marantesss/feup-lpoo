import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element {

    Coin(Position position) {
        this.position = position;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "€");
    }
}
