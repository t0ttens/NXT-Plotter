package nxt.lejos.imagetool.actions;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import nxt.lejos.imagetool.view.TableContainer;

public class InputKeyListener implements KeyListener
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			TableContainer.getInstance().addVectorToTable();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
}
