package nxt.lejos.imagetool.view.components;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import nxt.lejos.data.Constants;
import nxt.lejos.data.Constants.MotorDirections;
import nxt.lejos.plotterinterface.MotorController;

public class DirectionButton extends JButton
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	
	private MotorDirections direction = null;
	private int fontSize = 0;
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	public DirectionButton(MotorDirections direction)
	{
		this.direction = direction;
		this.fontSize = Constants.ARROW_FONT_SIZE;
		this.setFontSize();
		this.setArrowIcon();
//		this.initAction();
		this.initMouseListener();
	}
	
	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------
	
	private void setFontSize()
	{
		//SansSerif hat Unicode-Pfeile fuer alle OS
		Font buttonFont = new Font("SansSerif", this.getFont().getStyle(), this.fontSize);
		this.setFont(buttonFont);
	}
	
	private void setArrowIcon()
	{
		switch (this.direction)
		{
		case LEFT_UP:
			this.setText(String.valueOf('\u2196'));
			break;
		case UP:
			this.setText(String.valueOf('\u2191'));
			break;
		case RIGHT_UP:
			this.setText(String.valueOf('\u2197'));
			break;
		case LEFT:
			this.setText(String.valueOf('\u2190'));
			break;
		case RIGHT:
			this.setText(String.valueOf('\u2192'));
			break;
		case LEFT_DOWN:
			this.setText(String.valueOf('\u2199'));
			break;
		case DOWN:
			this.setText(String.valueOf('\u2193'));
			break;
		case RIGHT_DOWN:
			this.setText(String.valueOf('\u2198'));
			break;
		}
	}
	
	private void initMouseListener()
	{
		this.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				MotorController.getInstance().stopMotors();
			}
			
			@Override
			public void mousePressed(MouseEvent arg0)
			{
				MotorController.getInstance().moveInDirection(direction);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0)
			{
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0)
			{
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
			}
		});
	}
}
