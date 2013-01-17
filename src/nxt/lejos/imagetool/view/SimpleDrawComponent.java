package nxt.lejos.imagetool.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JComponent;

import nxt.lejos.imagetool.model.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleDrawComponent extends JComponent
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	private static SimpleDrawComponent instance = null;
	
	//Logger
	private static final Logger logger = LoggerFactory.getLogger(SimpleDrawComponent.class.getName());
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	private SimpleDrawComponent()
	{
		logger.debug("instanziiert");
		
		this.setPreferredSize(new Dimension(Constants.xMax/Constants.scaleDivisor, Constants.yMax/Constants.scaleDivisor));
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
		Vector<Vector<Integer>> data = TableContainer.getInstance().getListItems();
		
		if (data != null)
		{
			g.setColor(Color.BLUE);
			
			for (int i=1; i<data.size(); i++)
			{
				int x1, y1, x2, y2;
				
				try
				{
					//Alle Werte definitiv auf Integer casten, Fehlerquelle!
					x1 = Integer.parseInt("" + data.get(i-1).get(0)) / Constants.scaleDivisor;
					y1 = Integer.parseInt("" + data.get(i-1).get(1)) / Constants.scaleDivisor;
					x2 = Integer.parseInt("" + data.get(i).get(0)) / Constants.scaleDivisor;
					y2 = Integer.parseInt("" + data.get(i).get(1)) / Constants.scaleDivisor;
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
