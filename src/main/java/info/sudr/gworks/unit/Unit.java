package info.sudr.gworks.unit;

import java.util.HashMap;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Unit {

	private HashMap<String, Object> properties = new HashMap<String,Object>();
	private final String type;
	
	public Unit(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setProperty(String propertyName, Object propertyValue) {
		properties.put(propertyName, propertyValue);
	}
	
	public Object getProperty(String propertyName) {
		return properties.get(propertyName);
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("U").toString();
	}

}
