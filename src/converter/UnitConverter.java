package converter;

public class UnitConverter {
	public double convert(double amount, Unit fromUnit, Unit toUnit){
		double convert = (amount * fromUnit.getValue()) / toUnit.getValue();
		return convert;
	}
	
	public Unit[] getUnits(){
		Unit[] units = {Length.METER,Length.CENTIMETER,Length.MILE,Length.KILOMETER,
				Length.WA,Length.FOOT,Length.MICRON,Length.LIGHT_YEAR};
		return units;
	}

}
