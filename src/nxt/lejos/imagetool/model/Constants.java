package nxt.lejos.imagetool.model;

public interface Constants
{
	//Version
	public String version = "v0.1";
	
	//Dimensionen
	public final int XMIN = 0;
	public final int XMAX = 14000;
	public final int YMIN = 0;
	public final int YMAX = 13000;
	
	public final int SCALEDIVISOR = 20;
	
	//Programmablauf
	public enum ValidatorResults {TRUE, X_INVALID, Y_INVALID}
}