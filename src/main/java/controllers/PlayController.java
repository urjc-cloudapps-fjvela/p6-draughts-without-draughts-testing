package controllers;

import models.Game;
import models.Color;
import models.Coordinate;
import models.Piece;
import models.Error;

public class PlayController extends AcceptController {

	private Game game;

	public PlayController(Game game) {
		this.game = game;
	}

	public Error move(Coordinate origin, Coordinate target) {
		return game.move(origin, target);
	}

	public Piece getPiece(Coordinate origin) {
		return null;
	}

	public Color getColor() {
		return null;
	}
}