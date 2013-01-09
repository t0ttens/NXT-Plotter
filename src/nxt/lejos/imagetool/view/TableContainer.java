package nxt.lejos.imagetool.view;

import java.io.File;
import java.io.FileWriter;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
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
		TableListener tableListener = new TableListener();
		
		this.tableModel = new DefaultTableModel(this.columnNames, 0);
		this.tableModel.addTableModelListener(tableListener);
		this.vectorTable = new JTable(this.tableModel);
		this.vectorTable.addFocusListener(tableListener);
		
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
		
		if (vectorToAdd == null)
		{
			return;
		}
		
		//ueberpruefe, ob eingegebener Punkt innerhalb des gueltigen Bereichs liegt
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
		
		//Eingabefelder loeschen und Cursor ins x-Feld setzen
		ProgramFrame.getInstance().clearInputFields();
	}
	
	public void deleteSelectionFromTable()
	{
		int[] selectedRows = this.vectorTable.getSelectedRows();
		
		//Schleife zum Entfernen der markierten Eintraege
		//muss rueckwaerts laufen, da sich nach jedem Loeschen die Indizes verschieben
		for (int i=selectedRows.length-1; i>=0; i--)
		{
			this.tableModel.removeRow(selectedRows[i]);
		}
		
		ProgramFrame.getInstance().enableDeleteButton(false);
	}
	
	@SuppressWarnings("unchecked")
	public Vector<Vector<Integer>> getListItems()
	{
		return this.tableModel.getDataVector();
	}
	
	public void exportListToFile()
	{
		@SuppressWarnings("unchecked")
		Vector<Vector<Integer>> data = this.tableModel.getDataVector();
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("CSV-Datei", ".csv"));
		int returnVal = chooser.showSaveDialog(this);
		
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			File exportFile = chooser.getSelectedFile();
			System.out.println(exportFile.getName());
			
			FileWriter writer = null;
			
			try
			{
				writer = new FileWriter(exportFile);
				
				for (int i=0; i<data.size(); i++)
				{
					for (int j=0; j<data.get(i).size(); j++)
					{
						writer.write(data.get(i).get(j) + ";");
					}
					writer.write(System.getProperty("line.separator"));
				}
				
				writer.flush();
				writer.close();
			}
			catch (Exception e)
			{
				System.out.println("Speichern nicht möglich: " + e);
			}
			
		}
	}
	
	//-----------------------------------------------------------------------------
	//-----------------------------Test-Functions----------------------------------
	//-----------------------------------------------------------------------------
	
	public void fillList()
	{
		for (int i=0; i<14000; i++)
		{
			Vector<Integer> pointToAdd = new Vector<Integer>(2);
			pointToAdd.add(i);
			pointToAdd.add((int) (4000*Math.sin(i/(double) 100) + 6500));
			
			this.tableModel.addRow(pointToAdd);
		}
	}
}
