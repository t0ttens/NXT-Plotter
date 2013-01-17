package nxt.lejos.imagetool.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import nxt.lejos.data.Constants;
import nxt.lejos.imagetool.actions.AddVectorAction;
import nxt.lejos.imagetool.actions.DeleteSelectionAction;
import nxt.lejos.imagetool.actions.ExitAction;
import nxt.lejos.imagetool.actions.ExportFileAction;
import nxt.lejos.imagetool.actions.ImportFileAction;
import nxt.lejos.imagetool.actions.InputKeyListener;
import nxt.lejos.imagetool.actions.ManualControlAction;
import nxt.lejos.imagetool.actions.ProcessListAction;
import nxt.lejos.imagetool.actions.TestAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgramFrame extends JFrame
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	private static ProgramFrame instance = null;
	
	//Logger
	private static final Logger logger = LoggerFactory.getLogger(ProgramFrame.class.getName());
	
	//MenBar
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu fileMenu = new JMenu("Datei");
	private JMenu importExportMenu = new JMenu("Import/Export");
	private JMenuItem importItem = new JMenuItem("importieren...");
	private JMenuItem exportItem = new JMenuItem("exportieren...");
	private JMenuItem exitItem = new JMenuItem("beenden");
	
	private JMenu machineMenu = new JMenu("Maschine");
	private JMenuItem manualControlItem = new JMenuItem("Manuelle Steuerung");
	private JMenuItem processListItem = new JMenuItem("Liste bearbeiten...");
	
	//inputPanel
	private JPanel inputPanel = new JPanel();
	private JLabel xInputLabel = new JLabel("x");
	private JTextField xInputField = new JTextField(5);
	private JLabel yInputLabel = new JLabel("y");
	private JTextField yInputField = new JTextField(5);
	private JButton inputButton = new JButton("hinzufuegen");
	
	//optionPanel
	private JPanel optionPanel = new JPanel();
	private JButton deleteVectorButton = new JButton("Auswahl loeschen");
	private JButton testButton = new JButton("Test");
	
	//leftPanel
	private JPanel leftPanel = new JPanel();
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	private ProgramFrame()
	{	
		logger.debug("instanziiert");
		
		this.initBehaviour();
		this.initAppearance();
		this.initMenuBar();
		this.initContent();
		
		//TEST
		TableContainer.getInstance().fillList();
		
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
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		this.setLocationByPlatform(true);
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setTitle("ImageTool " + Constants.VERSION);
	}
	
	private void initMenuBar()
	{
		this.menuBar.add(this.fileMenu);
		this.fileMenu.add(this.importExportMenu);
		this.importExportMenu.add(this.importItem);
		this.importExportMenu.add(this.exportItem);
		this.fileMenu.addSeparator();
		this.fileMenu.add(this.exitItem);
		this.importItem.addActionListener(new ImportFileAction());
		this.exportItem.addActionListener(new ExportFileAction());
		this.exitItem.addActionListener(new ExitAction());
		
		this.menuBar.add(this.machineMenu);
		this.manualControlItem.addActionListener(new ManualControlAction());
		this.machineMenu.add(this.manualControlItem);
		this.machineMenu.addSeparator();
		this.processListItem.addActionListener(new ProcessListAction());
		this.machineMenu.add(this.processListItem);
		
		this.setJMenuBar(this.menuBar);
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
		
		//optionPanel
		this.optionPanel.setLayout(new FlowLayout());
		this.deleteVectorButton.addActionListener(new DeleteSelectionAction());
		this.deleteVectorButton.setEnabled(false);
		this.optionPanel.add(this.deleteVectorButton);
		this.testButton.addActionListener(new TestAction());
		this.optionPanel.add(this.testButton);
		
		//leftPanel
		this.leftPanel.setLayout(new BorderLayout());
		this.leftPanel.add(this.inputPanel, BorderLayout.NORTH);
		this.leftPanel.add(TableContainer.getInstance(), BorderLayout.CENTER);
		this.leftPanel.add(this.optionPanel,BorderLayout.SOUTH);
		
		//ProgramFrame
		this.add(this.leftPanel, BorderLayout.WEST);
		this.add(SimpleDrawComponent.getInstance(), BorderLayout.CENTER);
		
		//Umrandungen
		this.inputPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		TableContainer.getInstance().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		this.optionPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		SimpleDrawComponent.getInstance().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
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
