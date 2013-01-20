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
	
	private TouchSensor limitSensorX = null;
	private TouchSensor limitSensorY = null;
	
	//-----------------------------------------------------------------------------
	//------------------------Constructor(s)---------------------------------------
	//-----------------------------------------------------------------------------

	private LimitSensors()
	{
		limitSensorX = new TouchSensor(SensorPort.S1);
		limitSensorY = new TouchSensor(SensorPort.S2);
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
		return limitSensorX.isPressed();
	}
	
	public boolean limitYreached()
	{
		return limitSensorY.isPressed();
	}
}
