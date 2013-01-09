package nxt.lejos.imagetool.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nxt.lejos.imagetool.view.SimpleDrawComponent;

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
		System.out.println("TestButton");
		SimpleDrawComponent.getInstance().fetchData();
		SimpleDrawComponent.getInstance().repaint();
	}
}
