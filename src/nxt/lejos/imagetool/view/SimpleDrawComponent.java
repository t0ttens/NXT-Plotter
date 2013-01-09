package nxt.lejos.imagetool.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	
	public void clear()
	{
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		g2d.clipRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public void fetchData()
	{
		this.data = TableContainer.getInstance().getListItems();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		g2d.setColor(Color.RED);
		
		if (data != null)
		{
			for (int i=1; i<this.data.size(); i++)
			{
				int x1 = this.data.get(i-1).get(0);
				int y1 = this.data.get(i-1).get(1);
				int x2 = this.data.get(i).get(0);
				int y2 = this.data.get(i).get(1);
				
				g2d.drawLine(x1, y1, x2, y2);
			}
		}
	}
}
