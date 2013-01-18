package nxt.lejos.imagetool.view.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JComponent;

import nxt.lejos.data.Constants;

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

	private int xMaxScaled = 0;
	private int yMaxScaled = 0;
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	private SimpleDrawComponent()
	{
		logger.debug("instanziiert");

		this.xMaxScaled = Constants.X_MAX/Constants.GRAPH_SCALE_DIVISOR;
		this.yMaxScaled = Constants.Y_MAX/Constants.GRAPH_SCALE_DIVISOR;
		
		this.setPreferredSize(new Dimension(this.xMaxScaled, this.yMaxScaled));
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
			//Umrandung
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, this.xMaxScaled, this.yMaxScaled);
			
			g.setColor(Color.RED);
			
			for (int i=1; i<data.size(); i++)
			{
				int x1, y1, x2, y2;
				
				try
				{
					x1 = data.get(i-1).get(0) / Constants.GRAPH_SCALE_DIVISOR;
					y1 = data.get(i-1).get(1) / Constants.GRAPH_SCALE_DIVISOR;
					x2 = data.get(i).get(0) / Constants.GRAPH_SCALE_DIVISOR;
					y2 = data.get(i).get(1) / Constants.GRAPH_SCALE_DIVISOR;
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
