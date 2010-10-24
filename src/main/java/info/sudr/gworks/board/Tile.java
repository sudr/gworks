package info.sudr.gworks.board;

import info.sudr.gworks.unit.Unit;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Tile {

	private Set<Unit> units = new HashSet<Unit>();

	void addUnit(Unit unit) {
		units.add(unit);
	}

	Set<Unit> getUnits() {
		return Collections.unmodifiableSet(units);
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
		for (Unit u : units) {
			builder.append("unit", u);
		}
		return builder.toString();
	}

	boolean removeUnit(Unit unit) {
		return units.remove(unit);
	}
}
