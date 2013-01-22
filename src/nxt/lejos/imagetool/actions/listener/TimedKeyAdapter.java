package nxt.lejos.imagetool.actions.listener;

//abgeschrieben hier
//http://www.arco.in-berlin.de/keyevent.html

import java.awt.event.*;
import java.util.TreeMap;
import javax.swing.Timer;

import nxt.lejos.data.Constants.MotorDirections;
import nxt.lejos.imagetool.view.ManualControlFrame;
import nxt.lejos.plotterinterface.MotorController;

public class TimedKeyAdapter implements KeyListener
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------
	
	private final int timerDelay;
	private final TreeMap<Integer, TimedKey> map = new TreeMap<Integer, TimedKey>();
	private boolean gameModus = false;
	
	private class TimedKey implements ActionListener
	{
		private final int code;
		private final Timer releaseTimer = new Timer(timerDelay, this);
		private KeyEvent releaseEvent;
		private TimedKey(int code)
		{
			this.code = code;
			map.put(code, this);
		}
		  
		public void restartTimer(KeyEvent e)
		{
			releaseEvent = e;
			releaseTimer.restart();
		}
		
		public void stopTimer()
		{
			releaseTimer.stop();
			releaseEvent = null;
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			releaseTimer.stop();
			map.remove(code);
			KeyReleased(releaseEvent);
			releaseEvent = null;
		}
	}

	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------
	
	public TimedKeyAdapter()
	{
		this(false);
	}
	
	public TimedKeyAdapter(boolean gameModus)
	{
		this(gameModus, 1);
	}
	
	public TimedKeyAdapter(boolean gameModus, int timerDelay)
	{
		this.gameModus = gameModus;
		this.timerDelay = timerDelay < 0 ? 1 : timerDelay;
	}
	
	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------
	
	public void clear()
	{
		map.clear();
	}
	
	public void clear(int extendedKeyCode)
	{
		map.remove(extendedKeyCode);
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		int code = e.getKeyCode();
		TimedKey tk = map.get(code);
	
	    if (null == tk)
	    {
	    	new TimedKey(code);
	    	KeyPressed(e);
	    }
	    else
	    {
	    	tk.stopTimer();
	    	if (!gameModus)
	    	{
	    		KeyPressed(e);
	    	}
	    }    
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		TimedKey tk = map.get(e.getKeyCode());
	
	    if (null != tk)
	    {
	    	tk.restartTimer(e);
	    }
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		KeyTyped(e);
	}
	
	public int getPressedCount()
	{
		return map.size();
	}
	
	public void KeyPressed(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_UP:
			{
				MotorController.getInstance().moveInDirection(MotorDirections.UP);
				break;
			}
			case KeyEvent.VK_LEFT:
			{
				MotorController.getInstance().moveInDirection(MotorDirections.LEFT);
				break;
			}
			case KeyEvent.VK_RIGHT:
			{
				MotorController.getInstance().moveInDirection(MotorDirections.RIGHT);
				break;
			}
			case KeyEvent.VK_DOWN:
			{
				MotorController.getInstance().moveInDirection(MotorDirections.DOWN);
				break;
			}
			case KeyEvent.VK_CONTROL:
			{
				boolean switcher = !MotorController.getInstance().isDrawing();
				MotorController.getInstance().draw(switcher);
				ManualControlFrame.getInstance().setCheckBox(switcher);
				break;
			}
			default:
			{
				break;
			}
		}
	}
	
	public void KeyReleased(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_UP:
			{
				MotorController.getInstance().stopDirection(MotorDirections.UP);
				break;
			}
			case KeyEvent.VK_LEFT:
			{
				MotorController.getInstance().stopDirection(MotorDirections.LEFT);
				break;
			}
			case KeyEvent.VK_RIGHT:
			{
				MotorController.getInstance().stopDirection(MotorDirections.RIGHT);
				break;
			}
			case KeyEvent.VK_DOWN:
			{
				MotorController.getInstance().stopDirection(MotorDirections.DOWN);
				break;
			}
			default:
			{
				break;
			}
		}
	}
	
	public void KeyTyped(KeyEvent e)
	{
		
	}
}