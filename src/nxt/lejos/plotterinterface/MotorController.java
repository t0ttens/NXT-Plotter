package nxt.lejos.plotterinterface;

import lejos.nxt.Motor;

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
	
	private int xPos = 0;
	private int yPos = 0;
	
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
	
	private int getXPos()
	{
		this.xPos = Motor.A.getTachoCount();
		return this.xPos;
	}
	
	private int getYPos()
	{
		this.yPos = Motor.B.getTachoCount();
		return this.yPos;
	}
	
	public void moveToStartPosition()
	{
		logger.info("Zeichenvorrichtung faehrt Startposition an");

		boolean xMotorRuns = false;
		boolean yMotorRuns = false;
		
		Motor.A.setSpeed(360);
		Motor.B.setSpeed(360);
		
		if (!LimitSensors.getInstance().limitXreached())
		{
			Motor.A.forward();
			xMotorRuns = true;
		}
		
		if (!LimitSensors.getInstance().limitYreached())
		{
			Motor.B.backward();
			yMotorRuns = true;
		}
		
		while (xMotorRuns || yMotorRuns)
		{	
			if (LimitSensors.getInstance().limitXreached() && xMotorRuns)
			{
				Motor.A.stop();
				System.out.println("x: " + this.getXPos());
				Motor.A.resetTachoCount();
				xMotorRuns = false;
			}
			
			if (LimitSensors.getInstance().limitYreached() && yMotorRuns)
			{
				Motor.B.stop();
				System.out.println("y: " + this.getYPos());
				Motor.B.resetTachoCount();
				yMotorRuns = false;
			}
		}
		logger.info("Schlitten in Ausgangsposition:\nx: " + Motor.A.getTachoCount() + "\ny: " + Motor.B.getTachoCount());
	}
	
	public void moveToPoint(int x, int y, int speedX, int speedY)
	{
		logger.info(x + "/" + y + " wird angefahren, Geschwindigkeit: " + speedX + "/" + speedY);
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
				isDrawing = true;
			}
		}
		else
		{
			if (isDrawing)
			{
				logger.info("Zeichenvorrichtung wird hochgefahren");
				isDrawing = false;
			}
			else
			{
				logger.error("Zeichenvorrichtung ist bereits oben!");
			}
		}
	}
	
	public void moveLeftUp(boolean b)
	{
		logger.info("Motor faehrt nach links oben");
	}
	
	public void moveUp(boolean b)
	{
		logger.info("Motor faehrt nach oben");
	}
	
	public void moveRightUp(boolean b)
	{
		logger.info("Motor faehrt nach rechts oben");
	}
	
	public void moveLeft(boolean b)
	{
		logger.info("Motor faehrt nach links");
	}
	
	public void moveRight(boolean b)
	{
		logger.info("Motor faehrt nach rechts");
	}
	
	public void moveLeftDown(boolean b)
	{
		logger.info("Motor faehrt nach links unten");
	}
	
	public void moveDown(boolean b)
	{
		logger.info("Motor faehrt nach unten");
	}
	
	public void moveRightDown(boolean b)
	{
		logger.info("Motor faehrt nach rechts unten");
	}
}
