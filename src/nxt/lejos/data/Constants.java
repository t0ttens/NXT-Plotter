package nxt.lejos.data;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public interface Constants
{
	//Version
	public final String NAME = "NXT-Plotter";
	public final String VERSION = "v0.1";
	
	//Dimensionen
	public final int X_MIN = 0;
	public final int X_MAX = 14000;
	public final int Y_MIN = 0;
	public final int Y_MAX = 13000;
	
	public final int GRAPH_SCALE_DIVISOR = 20;
	public final int ARROW_FONT_SIZE = 50;
	
	//Grafik
	public final Border PREFERED_BORDER_TYPE = BorderFactory.createEtchedBorder();
	
	//Programmablauf
	public final boolean DUMMY_MODE = true;
	
	public enum ValidatorResults {TRUE, X_INVALID, Y_INVALID}
	public enum MotorDirections {LEFT_UP, UP, RIGHT_UP, LEFT, RIGHT, LEFT_DOWN, DOWN, RIGHT_DOWN}
}