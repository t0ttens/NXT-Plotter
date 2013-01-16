package nxt.lejos.plotterinterface;

/**
 *	Christopher Ottens
 *	2013
 */

public class MotorMovements
{
	//-----------------------------------------------------------------------------
	//------------------------Variables--------------------------------------------
	//-----------------------------------------------------------------------------

	private static MotorMovements instance = null;
	
	//-----------------------------------------------------------------------------
	//------------------------Constructor(s)---------------------------------------
	//-----------------------------------------------------------------------------

	private MotorMovements()
	{
		System.out.println("tut");
	}
	
	//-----------------------------------------------------------------------------
	//------------------------Methods/Functions------------------------------------
	//-----------------------------------------------------------------------------
	
	public static MotorMovements getInstance()
	{
		if (instance == null)
		{
			instance = new MotorMovements();
		}
		return instance;
	}
}
