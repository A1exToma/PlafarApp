package frontendmyApp;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class tableForm extends JPanel{

	/*private int numberOfRows=43;
	public Object[][] listaProduses;
	
	*/
	
	File dir;
	
	private String[]columnNames;
	protected DefaultTableModel tableModel;
	protected BufferedReader br;
	protected Object[] tableLines;
	
	public JTable table;
	private JScrollPane scrollPaneTable;
	
	public tableForm() {

		
		init();
	}
	
	
	public void init() {
		
		String[]columnNames= {"Denumire produs","Cantitate disponibila","Pret "};
		
		dir=new File("D:\\github\\myPlafarApp\\src\\frontendmyApp\\plante.txt");
		
		tableModel=new DefaultTableModel() {
			
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
		       return false;
		    }
			
 		};
		
		tableModel.setColumnIdentifiers(columnNames);
		
		try {
			
			br=new BufferedReader(new FileReader(dir));
			tableLines=br.lines().toArray();
			
			for(int i=0;i<tableLines.length;i++) {
				String line=tableLines[i].toString().trim();
				String[] dataRow=line.split(" ");
				
				String denumire=dataRow[0];
				int cantitate=Integer.parseInt(dataRow[1]);
				float pret=Float.parseFloat(dataRow[2]);
				
				Object[] rowdata= {denumire,cantitate,pret};
				
				tableModel.addRow(rowdata);
			}
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
		
		scrollPaneTable=new JScrollPane();
		
		table=new JTable(tableModel);
		table.setRowHeight(35);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setFont(new Font("Arial Black", Font.PLAIN, 13));
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.getColumnModel().getColumn(0).setPreferredWidth(124);
		table.getColumnModel().getColumn(1).setPreferredWidth(117);
		table.getColumnModel().getColumn(2).setPreferredWidth(37);
		table.setBackground(Color.CYAN);

		scrollPaneTable.add(table);
		scrollPaneTable.setViewportView(table);
		scrollPaneTable.setBounds(0, 0, 506, 561);
		
		
		this.add(scrollPaneTable);
		this.setBackground(Color.CYAN);
		this.setBounds(0, 0, 506, 561);
		this.setLayout(null);
		
		/*Object[][] listaProduses = new Object[43][3];
		
		
		try {//se citesc datele din fisierul plante
			Scanner read= new Scanner (new File("D:\\github\\myPlafarApp\\src\\frontendmyApp\\plante.txt"));
			
			String denumire,temp;
			int cantitate;
			float pret;
			
			int i=0,j=0;
			
			while(read.hasNext())
			{
				denumire=read.next();
				
				temp=read.next();
				cantitate=Integer.parseInt(temp);
				
				temp=read.next();
				pret=Float.parseFloat(temp);
				
				listaProduses[i][j++]=denumire;
				listaProduses[i][j++]=new Integer(cantitate);
				listaProduses[i][j]=new Float(pret);
				i++;
				j=0;
				
			}
			read.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		tableModel = new DefaultTableModel(listaProduses,columnNames) {//make cells nonEditable

		
		scrollPaneTable=new JScrollPane();
		
		table = new JTable(listaProduses,columnNames);
		table.setRowHeight(35);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setFont(new Font("Arial Black", Font.PLAIN, 13));
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.getColumnModel().getColumn(0).setPreferredWidth(124);
		table.getColumnModel().getColumn(1).setPreferredWidth(117);
		table.getColumnModel().getColumn(2).setPreferredWidth(37);
		table.setBackground(Color.CYAN);
		table.setModel(tableModel);//nonEditable cells
		
		scrollPaneTable.add(table);
		scrollPaneTable.setViewportView(table);
		scrollPaneTable.setBounds(0, 0, 506, 561);
		
		
		this.add(scrollPaneTable);
		this.setBackground(Color.CYAN);
		this.setBounds(0, 0, 784, 561);
		this.setLayout(null);
		*/
		
	}
	
}
