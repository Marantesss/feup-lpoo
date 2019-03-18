import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    // stuff for lanterna
    private Terminal terminal;
    private Screen screen;

    private Arena arena;

    Game() {
        try {
            arena = new Arena(20, 40);
            terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key) throws IOException {
        this.arena.processKey(key);
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() {
        try {
            while (true) {
                // Detecting collision
                if (this.arena.verifyMonsterCollisions()) {
                    System.out.println("You died!");
                    break;
                }
                this.draw();
                KeyStroke key = screen.readInput();
                // Close the screen
                this.processKey(key);
                if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                    this.screen.close();
                // break the loop
                if (key.getKeyType() == KeyType.EOF)
                    break;
                // Detecting collision with monsters
                if (this.arena.verifyMonsterCollisions()) {
                    this.screen.close();
                    System.out.println("You died!");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
