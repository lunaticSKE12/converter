package converter;

public enum Length implements Unit{
	 /*  Define the members of the enumeration   
	  *  The attributes are:   
	  *  name = a string name for this unit,    
	  *  value = multiplier to convert to meters.
	  */
	METER("Meter",1.0),
	CENTIMETER("Centimeter",0.01),
	KILOMETER("Kilometer",1000.0),
	MILE("Mile",1609.344),
	FOOT("Foot",0.30480),
	WA("Wa",2.0),
	MICRON("Micron",1.0E-6),
	LIGHT_YEAR("Light year", 9460730472580800.0);

	
	/** name of this unit */ 
	public final String name;
	/** multiplier to convert this unit to std unit */
	public final double value;
	
	/** Private constructor for enum members */
	Length(String name, double value){
		this.name = name;
		this.value = value;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	public String toString(){
		return name;
	}
}
