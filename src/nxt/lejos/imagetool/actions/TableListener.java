package nxt.lejos.imagetool.actions;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import nxt.lejos.imagetool.view.ProgramFrame;
import nxt.lejos.imagetool.view.SimpleDrawComponent;

public class TableListener implements FocusListener, TableModelListener
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
		//geht leider nicht, weil der Button schon deaktiviert wird, bevor die Action aufgerufen wird
		//ProgramFrame.getInstance().enableDeleteButton(false);
	}

	@Override
	public void tableChanged(TableModelEvent arg0)
	{
		SimpleDrawComponent.getInstance().repaint();
	}
}
