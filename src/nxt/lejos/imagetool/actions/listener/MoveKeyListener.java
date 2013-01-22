package nxt.lejos.imagetool.actions.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveKeyListener implements KeyListener
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
	public void keyPressed(KeyEvent e)
	{	
		System.out.println("keyPressed");
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		System.out.println("keyReleased");
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
}
