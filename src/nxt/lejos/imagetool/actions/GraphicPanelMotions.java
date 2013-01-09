package nxt.lejos.imagetool.actions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class GraphicPanelMotions implements MouseMotionListener
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static int x = 0;
	private static int y = 0;
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------
	
	@Override
	public void mouseDragged(MouseEvent arg0)
	{
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		x = arg0.getX();
		y = arg0.getY();
		System.out.println(x + " " + y);
	}
	
	public static Vector<Integer> getCoordinates()
	{
		Vector<Integer> coordinates = new Vector<Integer>(2);
		coordinates.add(x);
		coordinates.add(y);
		return coordinates;
	}
}
