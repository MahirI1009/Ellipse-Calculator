# Ellipse-Calculator
A Java program which takes input for h, k, a², and b² values of an ellipse. An ellipse is a conic section from Mathematics. An ellipse comes in the standard form of x²/a² + y²/b² = 1.
The graph of the ellipse can change based on the values of x², y², a² and b². An ellipse in standard form is horizontal and centered at the origin (0,0). An ellipse can become vertical in the case that the denominator of y² is larger x²  in the equation. 
An ellipse can be horizontally and/or vertically shifted from the origin, when this happens the ellipse comes in the form (x-h)²/a² + (y-k)²/b² = 1, with h and k representing the shifts from the x and y axes respectively. 
The graphs of ellipses have many properties such as the vertices, the foci and the major and minor axes. This program asks the user for the a² and b² values of the ellipse, it also asks for the h and k values if the user specifies that the ellipse is not centered at the origin. 
*I have created an ellipse class for this program, it contains two constructors, one for if the ellipse is centered at the origin and one if it isn't.*
The program then asks if the denominator of x² is larger than y² in the equation or not, so as to know whether or not the ellipse is vertical. Then an ellipse object is instantiated with the a² and b² values and a boolean value that is set to true if the denominator of x² is larger in the equation. 
The ellipse is instantiated with a different constructor that also sends the h and k values as parameters if the ellipse is shifted from the origin. 
Once this is done, the custom toString method of the ellipse class is called which then prints all the relevant information such as the coordinates of the vertices, foci and the center, the major and minor axes and the equation of ellipse. 
Lastly, the program asks the user if they want to calculate another ellipse, if they say yes, then this whole process repeats, otherwise the program ends.
