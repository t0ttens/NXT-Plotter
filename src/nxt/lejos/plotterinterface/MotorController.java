package nxt.lejos.plotterinterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *	Christopher Ottens
 *	2013
 */

public class MotorController
{
	//-----------------------------------------------------------------------------
	//------------------------Variables--------------------------------------------
	//-----------------------------------------------------------------------------

	private static MotorController instance = null;
	
	//Logger
	private static final Logger logger = LoggerFactory.getLogger(MotorController.class.getName());
	
	private boolean isDrawing = false;
	
	//-----------------------------------------------------------------------------
	//------------------------Constructor(s)---------------------------------------
	//-----------------------------------------------------------------------------

	private MotorController()
	{
		logger.debug("instanziiert");
	}
	
	//-----------------------------------------------------------------------------
	//------------------------Methods/Functions------------------------------------
	//-----------------------------------------------------------------------------
	
	public static MotorController getInstance()
	{
		if (instance == null)
		{
			instance = new MotorController();
		}
		return instance;
	}
	
	public void moveToStartPosition()
	{
		logger.info("Zeichenvorrichtung faehrt Startposition an");
	}
	
	public void moveToPoint(int x, int y, int speedX, int speedY)
	{
		logger.info(x + "/" + y + "wird angefahren, Geschwindigkeit: " + speedX + "/" + speedY);
	}
	
	public void draw(boolean b)
	{
		if (b)
		{
			if (isDrawing)
			{
				logger.error("Zeichenvorrichtung ist bereits unten!");
			}
			else
			{
				logger.info("Zeichenvorrichtung wird abgesenkt");
			}
		}
		else
		{
			if (isDrawing)
			{
				logger.info("Zeichenvorrichtung wird hochgefahren");
			}
			else
			{
				logger.error("Zeichenvorrichtung ist bereits oben!");
			}
		}
	}
}
