package nxt.lejos.imagetool.actions.programframe;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nxt.lejos.imagetool.view.components.TableContainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddVectorAction extends AbstractAction
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	
	//Logger
	private static final Logger logger = LoggerFactory.getLogger(AddVectorAction.class.getName());
	
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
		TableContainer.getInstance().addVectorToTable();
	}
}
