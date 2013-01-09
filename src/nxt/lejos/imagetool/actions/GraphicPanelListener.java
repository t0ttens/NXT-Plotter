package nxt.lejos.imagetool.actions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicPanelListener implements MouseListener
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------

	@Override
	public void mouseClicked(MouseEvent e)
	{
		System.out.println("click " + e.getButton());
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		System.out.println("enter ");
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		System.out.println("exit ");
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		System.out.println("press ");
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		System.out.println("release ");
	}
}
