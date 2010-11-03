package info.sudr.gworks.unit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Unit {

	private HashMap<String, Object> properties;
	private final String type;
	private int id;
	private String name;
	private Set<Weapon> weapons;
	
	public Unit(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setProperty(String propertyName, Object propertyValue) {
		if (properties == null) {
			properties = new HashMap<String,Object>();
		}
		properties.put(propertyName, propertyValue);
	}
	
	public Object getProperty(String propertyName) {
		if (properties == null) {
			throw new RuntimeException("No properties have been set");
		}
		Object value = properties.get(propertyName);
		
		if (value == null) {
			throw new RuntimeException("Property " + propertyName + " has not been set");
		}
		
		return value;
	}
	
	public void addWeapon(Weapon weapon) {
		if (weapons == null) {
			weapons = new HashSet<Weapon>();
		}
		weapons.add(weapon);
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("U").toString();
	}

}
