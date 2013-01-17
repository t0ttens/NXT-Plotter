package nxt.lejos.plotterinterface;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Functions
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	//Logger
	private static final Logger logger = LoggerFactory.getLogger(Functions.class.getName());
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------
	
	private static int[] calcSpeeds(int greaterDistance, int smallerDistance)
	{
		int[] speeds = new int[2];
		
		double quotDistance = (double)smallerDistance/greaterDistance;
		
		int greaterSpeed = 360;
		int smallerSpeed = (int)Math.round(360*quotDistance);
		
		double quotSpeed = (double)smallerSpeed/greaterSpeed;
		
		if (quotDistance != quotSpeed)
		{
			System.out.println("qD="+quotDistance+"\tqS="+quotSpeed);
		}
		
		speeds[0] = greaterSpeed;
		speeds[1] = smallerSpeed;
		
		return speeds;
	}
	
	public static Vector<Vector<Integer>> calcPathData(Vector<Vector<Integer>> pathPoints)
	{
		logger.debug("Berechne Koordinaten und Geschwindigkeiten aus der Tabelle");
		
		Vector<Vector<Integer>> pathData = new Vector<Vector<Integer>>();
		
		int prevX;
		int prevY;
		int currX;
		int currY;
		int diffX;
		int diffY;
		int speedX;
		int speedY;
//		int draw;
		
		for (int vector=0; vector<pathPoints.size(); vector++)
		{
			//Fuer den ersten Punkt gibt es keinen vorherigen, dieser ist dann 0/0
			if (vector == 0)
			{
				prevX = 0;
				prevY = 0;
			}
			else
			{
				prevX = pathPoints.get(vector-1).get(0);
				prevY = pathPoints.get(vector-1).get(1);
			}
			
			currX = pathPoints.get(vector).get(0);
			currY = pathPoints.get(vector).get(1);
			
//			draw = pathPoints.get(vector).get(2);
			
			diffX = Math.abs(currX - prevX);
			diffY = Math.abs(currY - prevY);
			
			if (diffX == diffY)
			{
				speedX = 360;
				speedY = 360;
			}
			else if (diffX > diffY)
			{
				int[] speeds = calcSpeeds(diffX, diffY);
				speedX = speeds[0];
				speedY = speeds[1];
			}
			else if (diffX < diffY)
			{
				int[] speeds = calcSpeeds(diffY, diffX);
				speedY = speeds[0];
				speedX = speeds[1];
			}
			else
			{
				logger.error("diffX und diffY kaputt");
				break;
			}
			
			//Punktdaten in temp-Vektor schreiben
			Vector<Integer> temp = new Vector<Integer>();
			temp.add(currX);
			temp.add(currY);
			temp.add(speedX);
			temp.add(speedY);
//			temp.add(draw);
			
			//temp-Vektor in Pfaddaten-Vektor schreiben
			pathData.add(temp);
		}
		
		return pathData;
	}
	
	public static void doJob(Vector<Vector<Integer>> pathData)
	{
		//Startposition anfahren
		MotorController.getInstance().moveToStartPosition();
		
		int x;
		int y;
		int speedX;
		int speedY;
		
		MotorController.getInstance().draw(true);
		
		for (int vector=0; vector<pathData.size(); vector++)
		{
			x = pathData.get(vector).get(0);
			y = pathData.get(vector).get(1);
			speedX = pathData.get(vector).get(2);
			speedY = pathData.get(vector).get(3);
			
			MotorController.getInstance().moveToPoint(x, y, speedX, speedY);
		}
		
		MotorController.getInstance().draw(false);
		
		MotorController.getInstance().moveToStartPosition();
	}

	//-----------------------------------------------------------------------------
	//-----------------------------TEST-Methods/Functions--------------------------
	//-----------------------------------------------------------------------------

	public static void print2DVector(Vector<Vector<Integer>> vector)
	{
		for (int i=0; i<vector.size(); i++)
		{
			for (int j=0; j<vector.get(i).size(); j++)
			{
				System.out.print(vector.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}

