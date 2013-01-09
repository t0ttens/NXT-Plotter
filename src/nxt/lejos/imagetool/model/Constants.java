package nxt.lejos.imagetool.model;

public interface Constants
{
	//Version
	public String version = "v0.1";
	
	//Dimensionen
	public int xMin = 0;
	public int xMax = 14000;
	public int yMin = 0;
	public int yMax = 13000;
	
	public int scaleDivisor = 20;
	
	//Programmablauf
	public enum ValidatorResults {TRUE, X_INVALID, Y_INVALID}
}