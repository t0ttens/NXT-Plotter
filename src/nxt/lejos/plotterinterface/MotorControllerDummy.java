package nxt.lejos.plotterinterface;

import nxt.lejos.data.Constants.MotorDirections;

/**
 *	Christopher Ottens
 *	2013
 */

public class MotorControllerDummy extends MotorController
{
	//-----------------------------------------------------------------------------
	//------------------------Variables--------------------------------------------
	//-----------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------
	//------------------------Constructor(s)---------------------------------------
	//-----------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------
	//------------------------Methods/Functions------------------------------------
	//-----------------------------------------------------------------------------

	@Override
	protected void initMotorZ()
	{
		logger.debug("Motor Z wird genullt");
	}
	
	@Override
	public void draw(boolean b)
	{
		logger.debug("draw() wird aufgerufen mit Parameter " + b);
		
		if (b)
		{
			if (this.isDrawing)
			{
				logger.error("Zeichenvorrichtung ist bereits unten!");
			}
			else
			{
				logger.info("Zeichenvorrichtung wird abgesenkt");
				
				this.isDrawing = true;
			}
		}
		else
		{
			if (isDrawing)
			{
				logger.info("Zeichenvorrichtung wird hochgefahren");
				
				this.isDrawing = false;
			}
			else
			{
				logger.error("Zeichenvorrichtung ist bereits oben!");
			}
		}
	}

	@Override
	public void moveToStartPosition()
	{
		logger.info("Schlitten faehrt Startposition an.");
	}

	@Override
	public void moveToPoint(int x, int y, int speedX, int speedY)
	{
		logger.info("Position wird angefahren:" + x + "/" + y + ", Geschwindigkeit: " + speedX + "/" + speedY);
		
		if (this.xInverted)
		{
			x = -x;
		}
		
		if (this.yInverted)
		{
			y = -y;
		}
	}

	@Override
	public void moveInDirection(MotorDirections direction)
	{
		logger.info("Schlitten faehrt nach " + direction);
	}

	@Override
	public void stopDirection(MotorDirections direction)
	{
		logger.debug(direction + " stoppt");
	}
	
	@Override
	public void stopMotors()
	{
		logger.info("Motoren stoppen");
	}
}