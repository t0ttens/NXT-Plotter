package nxt.lejos.imagetool.actions.programframe;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nxt.lejos.imagetool.view.components.TableContainer;

public class TestAction extends AbstractAction
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
		TableContainer.getInstance().generateRandomPoints();
	}
}
