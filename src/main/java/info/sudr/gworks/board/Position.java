package info.sudr.gworks.board;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Position {

	private final int x;
	private final int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
					.append("x", x)
					.append("y", y)
					.toString();
	}
}
