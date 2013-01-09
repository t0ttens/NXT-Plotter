package nxt.lejos.imagetool.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nxt.lejos.imagetool.view.TableContainer;

public class ExportFileAction extends AbstractAction
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
		TableContainer.getInstance().exportListToFile();
	}
}
