package nxt.lejos.imagetool.view.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import nxt.lejos.data.Constants;

public class GraphicContainer extends JComponent
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	private static GraphicContainer instance = null;
	
	private int borderWidth = 30;
	private int scaleLines = 10;
	private int scale = 20;
	private int xMax = Constants.XMAX / this.scale;
	private int yMax = Constants.YMAX / this.scale;
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------
	
	private GraphicContainer()
	{
		this.initBehaviour();
		this.initAppearance();
	}

	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------
	
	public static GraphicContainer getInstance()
	{
		if (instance == null)
		{
			instance = new GraphicContainer();
		}
		return instance;
	}
	
	private void initBehaviour()
	{
//		this.addMouseListener(new GraphicPanelListener());
//		this.addMouseMotionListener(new GraphicPanelMotions());
	}
	
	private void initAppearance()
	{
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(this.xMax + 2*this.borderWidth, this.yMax + 2*this.borderWidth));
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.drawCoordinateSystem();
	}
	
	public void drawCoordinateSystem()
	{
		Graphics graphics = this.getGraphics();
		graphics.drawLine(this.borderWidth, this.borderWidth, xMax+this.borderWidth, this.borderWidth);
		for (int i=0; i<=this.xMax; i=i+this.xMax/(Constants.XMAX/1000))
		{
			graphics.drawLine(this.borderWidth+i, this.borderWidth, this.borderWidth+i, this.borderWidth-this.scaleLines);
		}
		graphics.drawLine(this.borderWidth, this.borderWidth, this.borderWidth, this.borderWidth+yMax);
		for (int i=0; i<=this.yMax; i=i+this.yMax/(Constants.YMAX/1000))
		{
			graphics.drawLine(this.borderWidth, i+this.borderWidth, this.borderWidth-this.scaleLines, i+this.borderWidth);
		}
	}
	
	public void drawLine(int x1, int y1, int x2, int y2)
	{
		Graphics2D g2d = (Graphics2D) getGraphics();
		x1 += this.borderWidth;
		y1 += this.borderWidth;
		x2 += this.borderWidth;
		y2 += this.borderWidth;
		System.out.println(x1 + " " + y1+ " "+ x2 + " " + y2);
		g2d.drawLine(x1, y1, x2, y2);
	}
}
