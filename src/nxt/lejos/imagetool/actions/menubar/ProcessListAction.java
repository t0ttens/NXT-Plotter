package nxt.lejos.imagetool.actions.menubar;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;

import nxt.lejos.imagetool.view.components.TableContainer;
import nxt.lejos.plotterinterface.Functions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessListAction extends AbstractAction
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	
	//Logger
	private static final Logger logger = LoggerFactory.getLogger(ProcessListAction.class.getName());
	
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
		
		Vector<Vector<Integer>> tablePoints = TableContainer.getInstance().getListItems();
		Vector<Vector<Integer>> pathData = Functions.calcPathData(tablePoints);
		
		Functions.doJob(pathData);
	}
}
