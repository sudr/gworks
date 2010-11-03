package info.sudr.gworks.unit

shared_behavior "shared behaviors", {
	given "a airplane unit", {
		unit = new Unit("airplane")
	}
}

scenario "the type on an airplane unit", {
	it_behaves_as "shared behaviors"
	
	then "the unit's type  must be an airplane", {
		unit.getType().shouldBeEqualTo "airplane"
	}
}

scenario "setting the speed on an airplane unit", {
	it_behaves_as "shared behaviors"
	
	when "the speed is set", {
		unit.setProperty("speed", 140)
	}
	
	then "I must be able to ask for the speed", { 
		unit.getProperty("speed").shouldBeEqualTo 140
	}
}

scenario "modifying the speed on an airplane unit", {
	it_behaves_as "shared behaviors"
	
	and
	
	when "the speed is set to 140", {
		unit.setProperty("speed", 140)
	}
	
	when "the speed is changed to 160", {
		unit.setProperty("speed", 160)
	}
	
	then "the speed must be 160", {
		unit.getProperty("speed").shouldBeEqualTo 160
	}
}

scenario "query for a property when none are set", {
	it_behaves_as "shared behaviors"
	
	then "asking for a property must throw an exception", {
		ensureThrows(RuntimeException) {
			unit.getProperty("speed")
		}
	}
}

scenario "query for a property when specific property is not set", {
	it_behaves_as "shared behaviors"
	
	when "the speed is set to 160", {
		unit.setProperty("speed", 160)
	}
	
	then "asking for altitude property must throw an exception", {
		ensureThrows(RuntimeException) {
			unit.getProperty("altitude")
		}
	}
}

scenario "adding a weapon to a unit", {
	it_behaves_as "shared behaviors"
	
	when "a weapon is added to the unit", {
		weapon = new Weapon()
		unit.addWeapon(weapon)
	}
	
	then "asking for altitude property must throw an exception", {
		ensure(unit.weapons) {
			contains(weapon)
		}
	}
}