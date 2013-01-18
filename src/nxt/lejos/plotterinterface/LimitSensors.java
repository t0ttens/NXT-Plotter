package nxt.lejos.plotterinterface;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

/**
 *	Christopher Ottens
 *	2013
 */

public class LimitSensors
{
	//-----------------------------------------------------------------------------
	//------------------------Variables--------------------------------------------
	//-----------------------------------------------------------------------------

	private static LimitSensors instance = null;
	
	TouchSensor limitX = null;
	TouchSensor limitY = null;
	
	//-----------------------------------------------------------------------------
	//------------------------Constructor(s)---------------------------------------
	//-----------------------------------------------------------------------------

	private LimitSensors()
	{
		limitX = new TouchSensor(SensorPort.S1);
		limitY = new TouchSensor(SensorPort.S2);
	}
	
	//-----------------------------------------------------------------------------
	//------------------------Methods/Functions------------------------------------
	//-----------------------------------------------------------------------------
	
	public static LimitSensors getInstance()
	{
		if (instance == null)
		{
			instance = new LimitSensors();
		}
		return instance;
	}
	
	public boolean limitXreached()
	{
		return limitX.isPressed();
	}
	
	public boolean limitYreached()
	{
		return limitY.isPressed();
	}
}
