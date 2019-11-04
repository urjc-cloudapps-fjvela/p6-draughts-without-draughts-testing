package views;

import utils.Console;

public class ResumeView {

    private Console console;
    public ResumeView() {
        console = new Console();
    }

    public boolean askNewGame() {

		char answer;
		boolean ok;
		do {
			answer = this.console.readChar("¿Queréis jugar otra? (s/n): ");
			ok = isAfirmative(answer) || isNegative(answer);
			if (!ok) {
				this.console.writeln("Escribe s or n");
			}
		} while (!ok);
        return isAfirmative(answer);
        
    }

    private boolean isAfirmative(char answer) {
		return Character.toLowerCase(answer) == 's';
	}

	private  boolean isNegative(char answer) {
		return Character.toLowerCase(answer) == 'n';
	}

}