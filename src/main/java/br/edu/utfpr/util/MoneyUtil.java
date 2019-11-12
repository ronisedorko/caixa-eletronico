package br.edu.utfpr.util;

public class MoneyUtil {

	public static Long toReal(Long value) {
		return value / 100;
	}
	
	public static Long toCents(Long value) {
		return value % 100;
	}
	
	public static Long toLong(Float value) {
		return (long) (value * 100L);
	}
	
	public static String toCentsString(Long value) {
		Long v = value % 100;
		return (v < 10 ? "0" + v : "" + v);
	}
	
	public static String format(Long value) {
		return "R$ " + toReal(value) + "," + toCentsString(value);
	}
	
	
	
	
	
}
