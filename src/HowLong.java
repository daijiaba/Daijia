import java.util.Scanner;


public class HowLong {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		double a1 = s.nextDouble();
		double a2 = s.nextDouble();
		double b1 = s.nextDouble();
		double b2 = s.nextDouble();
		double length;
//		length = 111.12 * cos(1/(sin(a2)*sin(b2)*cos(b1-a1)+cos(a2)*cos(b2)));
		length = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin((rad(a2)-rad(b2))/2), 2) + Math.cos(rad(a2)) * Math.cos(rad(b2)) * Math.pow(Math.sin(((rad(a1)-rad(b1))/2)),2)));

		length = length * 6378.137;
//		length = Math.round(length * 10000)/10000;
		System.out.println(length);
	}
	
	public static double cos(double d){
		return Math.cos(d);
	}
	
	public static double sin(double d){
		return Math.sin(d);
	}
	
	public static double rad(double d){
		return d * Math.PI/180.0;
	}
}
