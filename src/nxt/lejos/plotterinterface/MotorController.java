package nxt.lejos.plotterinterface;

import lejos.nxt.Motor;
import nxt.lejos.data.Constants;
import nxt.lejos.data.Constants.MotorDirections;

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
	protected final Logger logger = LoggerFactory.getLogger(MotorController.class.getName());
	
	protected boolean isDrawing = false;
	
	protected boolean xInverted = false;
	protected boolean yInverted = true;
	
	private boolean xMotorRuns = false;
	private boolean yMotorRuns = false;
	
	//-----------------------------------------------------------------------------
	//------------------------Constructor(s)---------------------------------------
	//-----------------------------------------------------------------------------

	protected MotorController()
	{		
		logger.debug("instanziiert, Dummy Modus: " + Constants.DUMMY_MODE);

		this.initMotorZ();
	}
	
	//-----------------------------------------------------------------------------
	//------------------------Methods/Functions------------------------------------
	//-----------------------------------------------------------------------------
	
	protected void initMotorZ()
	{
		Motor.C.resetTachoCount();
	}
	
	public boolean isDrawing()
	{
		return this.isDrawing;
	}
	
	public void moveToStartPosition()
	{
		logger.info("Zeichenvorrichtung faehrt Startposition an");

		
		
		Motor.A.setSpeed(360);
		Motor.B.setSpeed(360);
		
		if (!LimitSensors.getInstance().limitXreached())
		{
			if (!xInverted)
			{
				Motor.A.backward();
			}
			else
			{
				Motor.A.forward();
			}
			this.xMotorRuns = true;
		}
		
		if (!LimitSensors.getInstance().limitYreached())
		{
			if (!yInverted)
			{
				Motor.B.backward();
			}
			else
			{
				Motor.B.forward();
			}
			this.yMotorRuns = true;
		}
		
		while (this.xMotorRuns || this.yMotorRuns)
		{	
			if (LimitSensors.getInstance().limitXreached() && this.xMotorRuns)
			{
				Motor.A.stop();
				Motor.A.resetTachoCount();
				this.xMotorRuns = false;
			}
			
			if (LimitSensors.getInstance().limitYreached() && this.yMotorRuns)
			{
				Motor.B.stop();
				Motor.B.resetTachoCount();
				this.yMotorRuns = false;
			}
		}
		
		logger.info("Schlitten in Ausgangsposition: " + Motor.A.getTachoCount() + "/" + Motor.B.getTachoCount());
	}
	
	public void moveToPoint(int x, int y, int speedX, int speedY)
	{
		logger.info(x + "/" + y + " wird angefahren, Geschwindigkeit: " + speedX + "/" + speedY);
		
		if (this.xInverted)
		{
			x = -x;
		}
		
		if (this.yInverted)
		{
			y = -y;
		}

		Motor.A.setSpeed(speedX);
		Motor.B.setSpeed(speedY);
		
		Motor.A.rotateTo(x, true);
		Motor.B.rotateTo(y, true);
		
		this.xMotorRuns = true;
		this.yMotorRuns = true;
		
		while (Motor.A.isMoving() || Motor.B.isMoving())
		{
			
		}
		
		this.xMotorRuns = false;
		this.yMotorRuns = false;
		
		logger.info("Schlittenposition: " + Motor.A.getTachoCount() + "/" + Motor.B.getTachoCount());
	}
	
	public void draw(boolean b)
	{
		if (b)
		{
			if (this.isDrawing)
			{
				logger.error("Zeichenvorrichtung ist bereits unten!");
			}
			else
			{
				logger.info("Zeichenvorrichtung wird abgesenkt");
				
				Motor.C.setSpeed(50);
				Motor.C.rotateTo(-50);
				
				this.isDrawing = true;
			}
		}
		else
		{
			if (isDrawing)
			{
				logger.info("Zeichenvorrichtung wird hochgefahren");
				
				Motor.C.setSpeed(50);
				Motor.C.rotateTo(0);
				
				this.isDrawing = false;
			}
			else
			{
				logger.error("Zeichenvorrichtung ist bereits oben!");
			}
		}
	}
	
	public void move(MotorDirections direction)
	{
		logger.info("Schlitten faehrt nach " + direction);
		
		switch (direction)
		{
			case LEFT_UP:
				Motor.A.backward();
				Motor.B.forward();
				break;
			case UP:
				Motor.B.forward();
				break;
			case RIGHT_UP:
				Motor.A.forward();
				Motor.B.forward();
				break;
			case LEFT:
				Motor.A.backward();
				break;
			case RIGHT:
				Motor.A.forward();
				break;
			case LEFT_DOWN:
				Motor.A.backward();
				Motor.B.backward();
				break;
			case DOWN:
				Motor.B.backward();
				break;
			case RIGHT_DOWN:
				Motor.A.forward();
				Motor.B.backward();
				break;
			default:
				logger.error("Invalide Richtungsangabe, sollte niemals auftreten");
				break;
		}
		
		logger.debug("Motor(en) in Bewegung");
	}
	
	public void stop()
	{
		logger.info("Motor(en) stoppen");
		
		Motor.A.stop();
		Motor.B.stop();
		
		logger.debug("Motor(en) gestoppt");
		
		logger.info("Schlittenposition: " + Motor.A.getTachoCount() + "/" + Motor.B.getTachoCount());
	}
	
	public static MotorController getInstance()
	{
		if (instance == null)
		{
			if (Constants.DUMMY_MODE)
			{
				instance = new MotorControllerDummy();
			}
			else
			{
				instance = new MotorController();
			}
		}
		return instance;
	}
}
