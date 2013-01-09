package nxt.lejos.imagetool.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nxt.lejos.imagetool.actions.AddVectorAction;
import nxt.lejos.imagetool.actions.DeleteVectorAction;
import nxt.lejos.imagetool.actions.InputKeyListener;
import nxt.lejos.imagetool.actions.TestAction;
import nxt.lejos.imagetool.model.Constants;

public class ProgramFrame extends JFrame
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	private static ProgramFrame instance = null;
	
	//inputPanel
	private JPanel inputPanel = new JPanel();
	private JLabel xInputLabel = new JLabel("x");
	private JTextField xInputField = new JTextField(5);
	private JLabel yInputLabel = new JLabel("y");
	private JTextField yInputField = new JTextField(5);
	private JButton inputButton = new JButton("hinzufuegen");

	//tablePanel
	private TableContainer tablePanel = null;
	
	//optionPanel
	private JPanel optionPanel = new JPanel();
	private JButton deleteVectorButton = new JButton("Auswahl loeschen");
	private JButton testButton = new JButton("Test");
	
	//leftPanel
	private JPanel leftPanel = new JPanel();
	
	//graphicPanel
	private JComponent graphicPanel = null;
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	private ProgramFrame()
	{
		this.initBehaviour();
		this.initAppearance();
		this.initContent();
		
		//TEST
		//this.tablePanel.fillList();
		
		this.pack();
		this.setVisible(true);
	}
	
	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------
	
	public static ProgramFrame getInstance()
	{
		if (instance == null)
		{
			instance = new ProgramFrame();
		}
		return instance;
	}
	
	private void initBehaviour()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initAppearance()
	{
		this.setLocationByPlatform(true);
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setTitle("ImageTool " + Constants.version);
	}
	
	private void initContent()
	{
		//inputPanel
		this.inputPanel.setLayout(new FlowLayout());
		this.inputPanel.add(this.xInputLabel);
		this.xInputField.addKeyListener(new InputKeyListener());
		this.inputPanel.add(this.xInputField);
		this.inputPanel.add(this.yInputLabel);
		this.yInputField.addKeyListener(new InputKeyListener());
		this.inputPanel.add(this.yInputField);
		this.inputButton.addActionListener(new AddVectorAction());
		this.inputPanel.add(this.inputButton);
		
		//tablePanel
		this.tablePanel = TableContainer.getInstance();
		
		//optionPanel
		this.optionPanel.setLayout(new FlowLayout());
		this.deleteVectorButton.addActionListener(new DeleteVectorAction());
		this.deleteVectorButton.setEnabled(false);
		this.optionPanel.add(this.deleteVectorButton);
		this.testButton.addActionListener(new TestAction());
		this.optionPanel.add(this.testButton);
		
		//leftPanel
		this.leftPanel.setLayout(new BorderLayout());
		this.leftPanel.add(this.inputPanel, BorderLayout.NORTH);
		this.leftPanel.add(this.tablePanel, BorderLayout.CENTER);
		this.leftPanel.add(this.optionPanel,BorderLayout.SOUTH);
		
		//graphicPanel
//		this.graphicPanel = GraphicContainer.getInstance();
		this.graphicPanel = SimpleDrawComponent.getInstance();
		
		//ProgramFrame
		this.add(this.leftPanel, BorderLayout.WEST);
		this.add(this.graphicPanel, BorderLayout.CENTER);
		
		//Umrandungen
		this.inputPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		this.tablePanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		this.optionPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		this.graphicPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
	}
	
	public Vector<Integer> getInputValues()
	{
		Vector<Integer> inputVector = new Vector<Integer>(2);
		
		try
		{
			inputVector.add(Integer.valueOf(this.xInputField.getText()));
			inputVector.add(Integer.valueOf(this.yInputField.getText()));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Mindestens einer der Werte is kein gueltiger Integer", "Fehler", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		return inputVector;
	}
	
	public void enableDeleteButton(boolean b)
	{
		if (b)
		{
			this.deleteVectorButton.setEnabled(true);
		}
		else
		{
			this.deleteVectorButton.setEnabled(false);
		}
	}
	
	public void clearInputFields()
	{
		//Texteingabefelder loeschen
		this.xInputField.setText("");
		this.yInputField.setText("");
		
		//Cursor wieder in x-Feld setzen
		this.xInputField.requestFocus();
	}
}
