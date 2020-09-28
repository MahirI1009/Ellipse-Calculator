import java.util.*;
public class Ellipse_Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Ellipse ellipse = null; //creates an empty ellipse
		
		//asks user for input
		System.out.println("Is this Ellipse centered at the origin?\nEnter Yes or No");
		while (sc.hasNext()) {
			String originTrue = sc.next();
			//origin true is a String that takes input from the keyboard, it asks if the ellipse
			//is centered at the origin or not, if the answer is the following executes:
			if(originTrue.equals("Yes") || originTrue.equals("yes")) {
				System.out.println("Enter the value under x");
				int x = sc.nextInt();
				System.out.println("Enter the value under y");
				int y = sc.nextInt();
				//asks user to the denominators under x^2 and y^2
				ellipse = new Ellipse(x,y); //creates an ellipse centered at the origin with the given a^2 and b^2 values
			}
			//if it is not centered at the origin the following executes:
			if(originTrue.equals("No") || originTrue.equals("no")) {
				System.out.println("Enter the value after x");
				int h = sc.nextInt();
				System.out.println("Enter the value under x");
				int x = sc.nextInt();
				System.out.println("Enter the value after y");
				int k = sc.nextInt();
				System.out.println("Enter the value under y");
				int y = sc.nextInt();
				//asks user to the denominators under x^2 and y^2 and the h and k values
				ellipse = new Ellipse(x,y,h,k);
				//creates a shifted ellipse with the given a^2, b^2, h and k values
				}
			System.out.println(ellipse.toString()); 
			//now that the ellipse was created, it calculates and returns all the relevant info of the ellipse
			//which is returned by the toString method
			System.out.println("Do you want to go again?\nEnter Yes or No");
			//now it asks the user if the user wants to calculate another ellipse
			//if the user answers no the program ends, other it asks again for the values and repeats 
			//until the user decides to stop
			String cont = sc.next();
			if(cont.equals("No") || cont.equals("no")) break;
			if(cont.equals("Yes") || cont.equals("yes"))
				System.out.println("Is this Ellipse centered at the origin?\nEnter Yes or No");
		}
	}
}


//class that defines the ellipse object
class Ellipse { 
	private int majorAxis; //int that stores the value of the major Axis of an ellipse
	private int minorAxis; //int that stores the value of the minor Axis of an ellipse
	private int horizontalTranslation; //int that stores the h value of an ellipse
	private int verticalTranslation; //int that stores the k value of an ellipse
	private int a, b, c; //ints for the a and b values of an ellipse, as well as the c value
	private boolean aUnderX; //boolean to check if a is under x or not, if it is then its vertical
	private boolean isCentered; //boolean to check if the ellipse is centered at the origin
	private String equation; //holds the final equation of the ellipse
	private String center; //holds a String containing the coordinates of the center of the ellipse
	private String vertices; //holds a String containing the vertices of the ellipse
	private String foci; //holds a String containing the coordinates of the foci of the ellipse
	
	
	//constructor for an ellipse centered at the origin
	public Ellipse(int a, int b) { //takes in the values of the 2 denominators
		int aSquared = a, bSquared = b; //assigns the denominators to aSquared and bSquared
		//checks if a^2 is bigger than b^2, if it is then a^2 is under x, and it's a horizontal ellipse
		//otherwise, a^2 is under y, and it's a vertical ellipse
		if (aSquared > bSquared) {
			//find the major and minor axes which are 2*a and 2*b respectively
			majorAxis = (int) (2 * Math.sqrt(a));
			minorAxis = (int) (2 * Math.sqrt(b));
			aUnderX = true; //assigns true to aUnderX because a^2 is under x, not y
			//the denominators of x and y in an ellipse are a^2 and b^2, so we are finding the square roots
			//and assigning them to the a and b fields
			this.a = (int) Math.sqrt(a); 
			this.b = (int) Math.sqrt(b);
			//finding c which is the distance from the center to the foci
			//the equation is c^2 = a^2 - b^2
			c = (int) Math.sqrt((aSquared-bSquared));
		}
		//this executes if a^2 is less than b^2
		else {
			//does the same as the previous if statement, but assigns false to aUnderX
			//because in an ellipse when a^2 is less than b^2, then a^2 is under y
			majorAxis = (int) (2 * Math.sqrt(b));
			minorAxis = (int) (2 * Math.sqrt(b));
			aUnderX = false;
			this.a = (int) Math.sqrt(b);
			this.b = (int) Math.sqrt(a);
			c = (int) Math.sqrt((bSquared-aSquared));
		}
		center = "(0,0)"; //since this is a centered ellipse, the center is (0,0)
		isCentered = true; //assigns true to isCentered
		//String for the final equation of the ellipse which is in the form x^2/a^2 + y^2/b^2 = 1
		equation = "x²/" + a + " + y²/" + b + " = 1"; 
	}
	
	
	//constructor for an ellipse not centered at the origin
	//all of the following does the same as the previous constructor except for the vertical and horizontal translations
	//vertical and horizontal ellipse are vertically and/or horizontally shifted from the center
	public Ellipse(int a, int b, int h, int k) {
		int aSquared = a, bSquared = b;
		horizontalTranslation = h; //for a horizontal translation, in the equation, x is subtracted by h
		verticalTranslation = k; //for a vertical translation, in the equation, y is subtracted by k
		if (aSquared > bSquared) {
			majorAxis = (int) (2 * Math.sqrt(a));
			minorAxis = (int) (2 * Math.sqrt(b));
			aUnderX = true;
			this.a = (int) Math.sqrt(a);
			this.b = (int) Math.sqrt(b);
			c = (int) Math.sqrt((aSquared-bSquared));
		}
		else {
			majorAxis = (int) (2 * Math.sqrt(b));
			minorAxis = (int) (2 * Math.sqrt(b));
			aUnderX = false;
			this.a = (int) Math.sqrt(b);
			this.b = (int) Math.sqrt(a);
			c = (int) Math.sqrt((bSquared-aSquared));
		}
		isCentered = false; //since the ellipse is shifted, it is not centered at the origin
		/*coordinates of the center as it is shifted from the origin, the horizontal and vertical
		translations are subtracted from the x and y values just like in the equation, x and y are originally both 0.*/
		center = "(" + (0 - horizontalTranslation) + "," +  (0 - verticalTranslation) + ")";
		//String for the final equation of the ellipse which is in the form (x-h)^2/a^2 + (y-k)^2/b^2 = 1
		equation = "(x - " + horizontalTranslation + ")²/" + a + " + (y - " + verticalTranslation + ")²/" + b + " = 1";
	}
	
	//getter methods
	
	//returns the final equation after all the calculation in the constructor(s)
	public String getEquation() {return equation;} 
	
	//returns the major axis after all the calculation in the constructor(s)
	public int getMajorAxis() {return majorAxis;}
	
	//returns the minor axis after all the calculation in the constructor(s)
	public int getMinorAxis() {return minorAxis;}
	
	//returns whether or not the ellipse is centered at the origin 
	public boolean isCentered() {return isCentered;}
	
	//returns whether or not the ellipse is centered at the origin, if a^2 is under x^2 or (x-h)^2 then it's horizontal
	public boolean isHorizontal() {return aUnderX;}
	
	//returns whether or not the ellipse is centered at the origin, if a^2 is under y^2 or (y-k)^2 then it's vertical
	public boolean isVertical() {
		if (aUnderX == false) return true;
		else return false;
	}
	
	//returns the coordinates of the center
	public String getCenter() {return center;}
	
	//returns the vertices of the ellipse which are the coordinates of the endpoints of the major axis
	public String getVertices() {
		//in a horizontal ellipse, the coordinates are (h +/- a, k)
		if (aUnderX == true) {
			vertices = "(" + (0 - horizontalTranslation + a) + "," +  (0 - verticalTranslation) + ")";
			vertices += ",(" + (0 - horizontalTranslation - a) + "," +  (0 - verticalTranslation) + ")";
			return vertices;
		}
		/*in a vertical ellipse, the coordinates are (h, k +/- a), in this program, a is still stored in b
		even though technically it should be a, hence why the value is being subtracted/added by b*/
		else {
			vertices = "(" + (0 - horizontalTranslation) + "," +  (0 - verticalTranslation + b) + ")";
			vertices += "(" + (0 - horizontalTranslation) + "," +  (0 - verticalTranslation - b) + ")";
			return vertices;
		}
	}
	
	
	/*the coordinates are obtained similarly as the vertices, except a and b are replaced by c
	depending on whether or not it is a horizontal or vertical eclipse, the foci is (h +/- c, k)
	if it is horizontal and (h, k +/- c) if it is vertical */
	public String getFoci() {
		//foci if horizontal
		if (aUnderX == true) {
			foci = "(" + (0 - horizontalTranslation + c) + "," +  (0 - verticalTranslation) + ")";
			foci += ",(" + (0 - horizontalTranslation - c) + "," +  (0 - verticalTranslation) + ")";
			return foci;
		}
		//foci if vertical
		else {
			foci = "(" + (0 - horizontalTranslation) + "," +  (0 - verticalTranslation + c) + ")";
			foci += "(" + (0 - horizontalTranslation) + "," +  (0 - verticalTranslation - c) + ")";
			return foci;
		}
	}
	
	
	/*toString method which returns the equation, center, foci, vertices, major and minor axes, a, b and c values, 
	whether or not it's centered at the origin, or if it's vertical or horizontal ellipse and the specifics of
	how many units it is shifted if it is shifted.*/
	public String toString() {
		String ellipse = "The equation of the ellipse is: " + equation
			+ "\nThe coordinates of the center are: " + getCenter() 
			+ "\nThe coordinates of the foci are: " + getFoci()
			+ "\nThe coordinates of the vertices are: " + getVertices()
			+ "\nThe major axis is: " + majorAxis
			+ "\nThe minor axis is: " + minorAxis
			+ "\nThe a, b and c values are: a = " + a + ", b = " + b + ", c = " + c;
		
		if (aUnderX == true)
			ellipse += "\nThis is a vertical ellipse";
		else ellipse += "\nThis is a horizontal ellipse";
		
		if (isCentered == false) 
			if(horizontalTranslation < 0)
				ellipse += "\nThe ellipse has a horizontal shift of " + (horizontalTranslation * -1) + " units to the right";
			else ellipse += "\nThe ellipse has a horizontal shift of " + (horizontalTranslation) + " units to the left";
			if(verticalTranslation < 0)
				ellipse += "\nThe ellipse has a vertical shift of " + (verticalTranslation * -1) + " units up";
			else ellipse += "\nThe ellipse has a vertical shift of " + (verticalTranslation) + " units down";
		
		return ellipse;
	}
}