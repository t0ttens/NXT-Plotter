package nxt.lejos.data;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public interface Constants
{
	//Version
	public final String NAME = "NXT-Plotter";
	public final String VERSION = "v0.1";
	
	//Dimensionen
	public final int XMIN = 0;
	public final int XMAX = 14000;
	public final int YMIN = 0;
	public final int YMAX = 13000;
	
	public final int SCALEDIVISOR = 20;
	
	//Grafik
	public final Border preferedBorderType = BorderFactory.createEtchedBorder();
	
	//Programmablauf
	public enum ValidatorResults {TRUE, X_INVALID, Y_INVALID}
	public enum MotorDirections {LEFT_UP, UP, RIGHT_UP, LEFT, RIGHT, LEFT_DOWN, DOWN, RIGHT_DOWN}
}