package nxt.lejos.imagetool.view;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nxt.lejos.imagetool.actions.TableListener;
import nxt.lejos.imagetool.model.Validator;

public class TableContainer extends JScrollPane
{
	//-----------------------------------------------------------------------------
	//-----------------------------Variables---------------------------------------
	//-----------------------------------------------------------------------------
	
	private static final long serialVersionUID = 1L;
	private static TableContainer instance = null;
	
	private String[] columnNames = {"x", "y"};
	private DefaultTableModel tableModel = null;
	private JTable vectorTable = null;
	
	//-----------------------------------------------------------------------------
	//-----------------------------Constructor(s)----------------------------------
	//-----------------------------------------------------------------------------

	private TableContainer()
	{
		this.tableModel = new DefaultTableModel(this.columnNames, 0);
		this.vectorTable = new JTable(this.tableModel);
		this.vectorTable.addFocusListener(new TableListener());
		
		//JTable in das Scrollpane einsetzen
		this.setViewportView(this.vectorTable);
	}
	
	//-----------------------------------------------------------------------------
	//-----------------------------Methods/Functions-------------------------------
	//-----------------------------------------------------------------------------

	public static TableContainer getInstance()
	{
		if (instance == null)
		{
			instance = new TableContainer();
		}
		return instance;
	}
	
	public void addVectorToTable()
	{
		Vector<Integer> vectorToAdd = ProgramFrame.getInstance().getInputValues();
		
		//ŸberprŸfe, ob eingegebener Punkt innerhalb des gŸltigen Bereichs liegt
		switch (Validator.validateVectorInput(vectorToAdd.get(0), vectorToAdd.get(1)))
		{
			case X_INVALID:
				JOptionPane.showMessageDialog(this, "x-Wert außerhalb des gültigen Bereichs", "Fehler", JOptionPane.ERROR_MESSAGE);
				return;
			case Y_INVALID:
				JOptionPane.showMessageDialog(this, "y-Wert außerhalb des gültigen Bereichs", "Fehler", JOptionPane.ERROR_MESSAGE);
				return;
			default:
				break;
		}
		
		//Vektor in Tabelle eintragen
		this.tableModel.addRow(vectorToAdd);
		
		//Eingabefelder lšschen und Cursor ins x-Feld setzen
		ProgramFrame.getInstance().clearInputFields();
	}
	
	public void deleteSelectionFromTable()
	{
		int[] selectedRows = this.vectorTable.getSelectedRows();
		
		//Schleife zum Entfernen der markierten EintrŠge
		//muss rŸckwŠrts laufen, da sich nach jedem Lšschen die Indizes verschieben
		for (int i=selectedRows.length-1; i>=0; i--)
		{
			this.tableModel.removeRow(selectedRows[i]);
		}
		
		ProgramFrame.getInstance().enableDeleteButton(false);
	}
	
	//-----------------------------------------------------------------------------
	//-----------------------------Test-Functions----------------------------------
	//-----------------------------------------------------------------------------
	
	public void fillList()
	{
		for (int i=0; i<100; i++)
		{
			Vector<Integer> pointToAdd = new Vector<Integer>(2);
			pointToAdd.add(i);
			pointToAdd.add(i);
			
			this.tableModel.addRow(pointToAdd);
		}
	}
}
