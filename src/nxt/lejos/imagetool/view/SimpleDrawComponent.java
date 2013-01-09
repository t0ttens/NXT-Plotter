package nxt.lejos.imagetool.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JComponent;

public class SimpleDrawComponent extends JComponent
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	private static SimpleDrawComponent instance = null;
	
	private Vector<Vector<Integer>> data = null;
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	private SimpleDrawComponent()
	{
		this.setPreferredSize(new Dimension(700, 650));
	}
	
	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------
	
	public static SimpleDrawComponent getInstance()
	{
		if (instance == null)
		{
			instance = new SimpleDrawComponent();
		}
		return instance;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{	
		super.paintComponent(g);
	
		//Hole gesamte Tabelle
		this.data = TableContainer.getInstance().getListItems();
		
		if (data != null)
		{
			g.setColor(Color.RED);
			
			for (int i=1; i<this.data.size(); i++)
			{
				int x1, y1, x2, y2;
				
				try
				{
					//Alle Werte definitiv auf Integer casten, Fehlerquelle!
					x1 = Integer.parseInt("" + this.data.get(i-1).get(0));
					y1 = Integer.parseInt("" + this.data.get(i-1).get(1));
					x2 = Integer.parseInt("" + this.data.get(i).get(0));
					y2 = Integer.parseInt("" + this.data.get(i).get(1));
				}
				catch (Exception e)
				{
					System.out.println("Fehlerhafter Tabelleneintrag: " + e);
					return;
				}
				
				g.drawLine(x1, y1, x2, y2);
			}
		}
	}
}
