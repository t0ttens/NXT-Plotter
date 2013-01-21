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
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			System.out.println("UP jo");
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			System.out.println("UP no");
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		System.out.println(e.getKeyCode() + " typed");
	}
}
