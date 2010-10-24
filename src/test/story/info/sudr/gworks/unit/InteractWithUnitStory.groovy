package info.sudr.gworks.unit

shared_behavior "shared behaviors", {
	given "a airplane unit", {
		unit = new Unit("airplane")
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

scenario "the type on an airplane unit", {
	it_behaves_as "shared behaviors"
	
	then "the unit's type  must be an airplane", {
		unit.getType().shouldBeEqualTo "airplane"
	}
}