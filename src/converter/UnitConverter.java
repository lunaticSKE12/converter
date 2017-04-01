package converter;

/**
 * UnitConverter is compute unit to other unit.
 * @author Napong Dungduangsasitorn
 *
 */
public class UnitConverter {
	
	/**
	 * convert is compute amount of unit to other unit.
	 * @param amount is value that want to convert.
	 * @param fromUnit is unit that use to convert.
	 * @param toUnit is unit that want convert to.
	 * @return result is value that need to convert to.
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit){
		double result = (amount * fromUnit.getValue()) / toUnit.getValue();
		return result;
	}
	
	/**
	 * getUnits is get unit from Length.
	 * @return units is array of unit in Length.
	 */
	public Unit[] getUnits(){
		Unit[] units = {Length.METER,Length.CENTIMETER,Length.MILE,Length.KILOMETER,
				Length.WA,Length.FOOT,Length.MICRON,Length.LIGHT_YEAR};
		return units;
	}

}
