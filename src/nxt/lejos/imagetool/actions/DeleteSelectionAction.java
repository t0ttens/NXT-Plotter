package nxt.lejos.imagetool.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nxt.lejos.imagetool.view.TableContainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteSelectionAction extends AbstractAction
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	
	//Logger
	private static final Logger logger = LoggerFactory.getLogger(DeleteSelectionAction.class.getName());
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		logger.debug("aufgerufen");
		TableContainer.getInstance().deleteSelectionFromTable();
	}
}
