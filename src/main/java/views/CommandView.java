package views;

import utils.Console;
import controllers.PlayController;
import models.Error;
import models.Coordinate;

public class CommandView  {


    private Console console;
    private PlayController playController;

    private static final String[] COLORS = { "blancas", "negras" };

    public CommandView(PlayController playController) {
        this.playController = playController;
        this.console = new Console();
    }

    public void interact() {
        String color = CommandView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        do {
            String command = this.console.readString("Mueven las " + color + ": ");
            int separatorIndex = command.indexOf(".");

            if (separatorIndex != -1) {

                int origin = Integer.parseInt(command.substring(0, separatorIndex));
                int target = Integer.parseInt(command.substring(separatorIndex + 1, command.length()));
                error = playController.move(new Coordinate(origin / 10, origin % 10),
                        new Coordinate(target / 10, target % 10));
            } else {
                error = Error.INVALID_COORDINATES;
            }
            if (error != null) {
                console.write("Error!!!" + error.name());
            }
        } while (error != null);
    }

}