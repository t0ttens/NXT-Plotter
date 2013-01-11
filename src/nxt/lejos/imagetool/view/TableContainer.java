package nxt.lejos.imagetool.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nxt.lejos.imagetool.actions.TableListener;
import nxt.lejos.imagetool.model.Constants;
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
				String xError = "x-Wert ausserhalb des gueltigen Bereichs\n(" + Constants.xMin + " bis " + Constants.xMax + ")";
				JOptionPane.showMessageDialog(this, xError, "Fehler", JOptionPane.ERROR_MESSAGE);
				return;
			case Y_INVALID:
				String yError = "y-Wert ausserhalb des gueltigen Bereichs\n(" + Constants.yMin + " bis " + Constants.yMax + ")";
				JOptionPane.showMessageDialog(this, yError, "Fehler", JOptionPane.ERROR_MESSAGE);
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
	
	public void importFileToList()
	{	
		Vector<Vector<Integer>> importData = new Vector<Vector<Integer>>();
		
		JFileChooser chooser = new JFileChooser();
//		chooser.setFileFilter(new FileNameExtensionFilter("CSV-Datei", ".csv"));
		int returnVal = chooser.showOpenDialog(this);
		
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			//Tabelleninhalt loeschen
			this.tableModel.setRowCount(0);
			
			try {
				File importFile = new File(chooser.getSelectedFile().getPath());
				FileReader reader = new FileReader(importFile);
				@SuppressWarnings("resource")
				BufferedReader bufferedReader = new BufferedReader(reader);
				
				String line;
				String[] splitLine;
				
				while (true)
				{
					//Schleife laeuft bis zur letzten Zeile
					line = bufferedReader.readLine();
					if (line == null)
					{
						break;
					}
					
					splitLine = line.split(";");
					
					Vector<Integer> temp = new Vector<>(splitLine.length);
					
					for (int i=0; i<splitLine.length; i++)
					{
						temp.add(Integer.parseInt(splitLine[i]));
					}
					
					importData.add(temp);
				}
				
				for (int i=0; i<importData.size(); i++)
				{
					this.tableModel.addRow(importData.get(i));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void exportListToFile()
	{
		@SuppressWarnings("unchecked")
		Vector<Vector<Integer>> data = this.tableModel.getDataVector();
		
		JFileChooser chooser = new JFileChooser();
//		chooser.setFileFilter(new FileNameExtensionFilter("CSV-Datei", ".csv"));
		int returnVal = chooser.showSaveDialog(this);
		
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{	
			String path = chooser.getSelectedFile().getPath();
			
			if (!path.toLowerCase().endsWith(".csv"))
			{
				path = path + ".csv";
			}
				 
			File exportFile = new File(path);
			
			FileWriter writer = null;
			
			try
			{
				writer = new FileWriter(exportFile);
				
				for (int i=0; i<data.size(); i++)
				{
					for (int j=0; j<data.get(i).size()-1; j++)
					{
						//Semikolon bis zum vorletzten Wert
						writer.write(data.get(i).get(j) + ";");
					}
					//Letztem Wert folgt ein Zeilenumbruch 
					writer.write(data.get(i).get(data.get(i).size()-1) + System.getProperty("line.separator"));
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
