package nxt.lejos.imagetool.actions.menubar;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nxt.lejos.imagetool.view.ManualControlFrame;

public class ManualControlAction extends AbstractAction
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		new ManualControlFrame();
	}
}
