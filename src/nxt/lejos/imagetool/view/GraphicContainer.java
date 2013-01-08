package nxt.lejos.imagetool.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import nxt.lejos.imagetool.model.Constants;

public class GraphicContainer extends JPanel
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	private static GraphicContainer instance = null;
	
	private int borderWidth = 20;
	private int scale = 20;
	private int xMax = Constants.xMax / this.scale;
	private int yMax = Constants.yMax / this.scale;
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------
	
	private GraphicContainer()
	{
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
	
	private void initAppearance()
	{
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(this.xMax + 2*this.borderWidth, this.yMax + 2*this.borderWidth));
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawLine(this.borderWidth, this.borderWidth, xMax+this.borderWidth, yMax+this.borderWidth);
		g.drawRect(10, 10, 100, 400);
	}
}
