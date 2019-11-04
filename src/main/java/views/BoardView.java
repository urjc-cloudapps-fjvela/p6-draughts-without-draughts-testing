package views;

import models.Board;
import utils.Console;

public class BoardView {

    private Console console;

    public BoardView() {
        console = new Console();
    }

    public void draw(Board board) {
        console.writeln(board.toString());
    }
}