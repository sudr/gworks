package info.sudr.gworks.board;

import info.sudr.gworks.unit.Unit;

import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;

public class Board {

	private final int width;
	private final int height;
	private Tile[][] tiles;

	private static Logger logger = Logger.getLogger(Board.class);

	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		initializeTiles();
		if (logger.isDebugEnabled()) {
			logger.debug("Initialized board: " + toString());
		}
	}

	private void initializeTiles() {
		tiles = new Tile[width][height];
		for (int x = 1; x <= width; x++) {
			for (int y = 1; y <= height; y++) {
				setTile(new Tile(), new Position(x, y));
			}
		}
	}

	private void setTile(Tile tile, Position pos) {
		tiles[pos.getX() - 1][pos.getY() - 1] = tile;
	}

	public Tile getTile(Position pos) {
		return tiles[pos.getX() - 1][pos.getY() - 1];
	}

	public void addUnit(Unit unit, Position pos) {
		getTile(pos).addUnit(unit);
	}

	public boolean removeUnit(Unit unit, Position pos) {
		return getTile(pos).removeUnit(unit);
	}

	public Set<Unit> getUnits(Position pos) {
		return getTile(pos).getUnits();
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
		builder.append("width", width);
		builder.append("height", height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				builder.append(tiles[x][y]);
			}
		}
		return builder.toString();
	}
}
