package nxt.lejos.imagetool.view.components;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import nxt.lejos.data.Constants.MotorDirections;
import nxt.lejos.plotterinterface.MotorController;

public class DirectionButton extends JButton
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	
	private MotorDirections direction = null;
	private final int fontSize = 50;
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	public DirectionButton(MotorDirections direction)
	{
		this.direction = direction;
		this.setFontSize();
		this.setArrowIcon();
		this.initAction();
	}
	
	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------
	
	private void setFontSize()
	{
		Font buttonFont = new Font(this.getFont().getName(), this.getFont().getStyle(), this.fontSize);
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
	
	private void initAction()
	{
		switch (this.direction)
		{
		case LEFT_UP:
			this.addActionListener(new AbstractAction()
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					MotorController.getInstance().moveLeftUp(true);
				}
			});
			break;
		case UP:
			this.addActionListener(new AbstractAction()
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					MotorController.getInstance().moveUp(true);
				}
			});
			break;
		case RIGHT_UP:
			this.addActionListener(new AbstractAction()
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					MotorController.getInstance().moveRightUp(true);
				}
			});
			break;
		case LEFT:
			this.addActionListener(new AbstractAction()
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					MotorController.getInstance().moveLeft(true);
				}
			});
			break;
		case RIGHT:
			this.addActionListener(new AbstractAction()
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					MotorController.getInstance().moveRight(true);
				}
			});
			break;
		case LEFT_DOWN:
			this.addActionListener(new AbstractAction()
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					MotorController.getInstance().moveLeftDown(true);
				}
			});
			break;
		case DOWN:
			this.addActionListener(new AbstractAction()
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					MotorController.getInstance().moveDown(true);
				}
			});
			break;
		case RIGHT_DOWN:
			this.addActionListener(new AbstractAction()
			{
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					MotorController.getInstance().moveRightDown(true);
				}
			});
			break;
		}
	}
	
//	public MotorDirections getDirection()
//	{
//		return this.direction;
//	}
}
