package info.sudr.gworks.board;

import info.sudr.gworks.unit.*;

shared_behavior "shared behaviors", {
	given "a new board", {
		board = new Board(1,1)
	}
}

scenario "asking for a tile", {
	it_behaves_as "shared behaviors"
	
	when "a tile is asked for", {
		tile = board.getTile(new Position(1,1))
	}
	
	then "the tile must be valid", { tile.shouldNotBe null }
}

scenario "adding a unit to a tile", {
	it_behaves_as "shared behaviors"
	
	when "a unit is added to a tile", {
		unit = new Unit()
		board.addUnit(unit, new Position(1,1))
	}
	
	then "the unit must be on the tile", {
		board.getUnits(new Position(1,1)).shouldHave unit
	}
}

scenario "adding two units to a tile", {
	it_behaves_as "shared behaviors"
	
	when "two units are added to a tile", {
		unit1 = new Unit()
		board.addUnit(unit1, new Position(1,1))
		
		unit2 = new Unit()
		board.addUnit(unit2, new Position(1,1))
	}
	
	then "both units must be on the tile", {
		units = board.getUnits(new Position(1,1))
		units.size().shouldBeEqualTo 2
		units.shouldHave unit1
		units.shouldHave unit2
	}
}

scenario "removing a unit from  a tile", {
	it_behaves_as "shared behaviors"
	
	and
	
	given "two units are added to the board", {
		unit1 = new Unit()
		board.addUnit(unit1, new Position(1,1))
		
		unit2 = new Unit()
		board.addUnit(unit2, new Position(1,1))
	}
	
	when "first unit is removed", {
		board.removeUnit(unit1, new Position(1,1))
	}
	
	then "only the second unit remains", {
		units = board.getUnits(new Position(1,1))
		units.size().shouldBeEqualTo 1
		units.shouldHave unit2
	}
}