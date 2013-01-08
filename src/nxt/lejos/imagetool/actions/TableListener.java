package nxt.lejos.imagetool.actions;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import nxt.lejos.imagetool.view.ProgramFrame;

public class TableListener implements FocusListener
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
	public void focusGained(FocusEvent arg0)
	{
		ProgramFrame.getInstance().enableDeleteButton(true);
	}

	@Override
	public void focusLost(FocusEvent arg0)
	{
		
	}
}
