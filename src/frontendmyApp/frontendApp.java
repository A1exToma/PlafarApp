package frontendmyApp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class frontendApp {

	private JFrame frame;
	private JTable table;
	private JPanel backGRDPanel;
	private JPanel topPanel;
	private JPanel rightPanelCart;
	private JButton btnCumparare;
	private JLabel lblProduse;
	private JLabel lblCantitate;
	private JButton button;
	private JTextField pretFieldupdate;
	private JTextField cantitateFieldupdate;
	private JTextField denumireFieldupdate;
	private JTextField cantitateField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frontendApp window = new frontendApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frontendApp() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Plafar");
		
		//              x  y  dim   
		frame.setBounds(300, 50, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		backGRDPanel = new JPanel();
		backGRDPanel.setBackground(Color.CYAN);
		backGRDPanel.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(backGRDPanel);
		backGRDPanel.setLayout(null);
		
		topPanel = new JPanel();
		topPanel.setBackground(Color.LIGHT_GRAY);
		topPanel.setBounds(0, 0, 506, 66);
		backGRDPanel.add(topPanel);
		topPanel.setLayout(null);
		
		rightPanelCart = new JPanel();
		rightPanelCart.setForeground(Color.WHITE);
		rightPanelCart.setBackground(Color.DARK_GRAY);
		rightPanelCart.setBounds(504, 0, 280, 561);
		backGRDPanel.add(rightPanelCart);
		rightPanelCart.setLayout(null);
		
		btnCumparare = new JButton("CUMPARARE");
		btnCumparare.setForeground(Color.DARK_GRAY);
		btnCumparare.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnCumparare.setBackground(Color.CYAN);
		btnCumparare.setBounds(20, 447, 250, 23);
		rightPanelCart.add(btnCumparare);
		
		JList cartList = new JList();
		cartList.setForeground(Color.BLACK);
		cartList.setBackground(Color.LIGHT_GRAY);
		cartList.setFont(new Font("Calibri", Font.BOLD, 18));
		cartList.setBounds(20, 365, 185, 34);
		rightPanelCart.add(cartList);
		
		JLabel lblCos = new JLabel("      Cos");
		lblCos.setForeground(Color.LIGHT_GRAY);
		lblCos.setBackground(Color.CYAN);
		lblCos.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblCos.setBounds(61, 278, 90, 34);
		rightPanelCart.add(lblCos);
		
		lblProduse = new JLabel("Produs");
		lblProduse.setForeground(Color.LIGHT_GRAY);
		lblProduse.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProduse.setBounds(20, 340, 65, 14);
		rightPanelCart.add(lblProduse);
		
		lblCantitate = new JLabel("Cantitate");
		lblCantitate.setForeground(Color.LIGHT_GRAY);
		lblCantitate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantitate.setBounds(212, 340, 58, 14);
		rightPanelCart.add(lblCantitate);
		
		button = new JButton("Update Product");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBackground(Color.CYAN);
		button.setBounds(84, 190, 144, 23);
		rightPanelCart.add(button);
		
		pretFieldupdate = new JTextField();
		pretFieldupdate.setBounds(142, 127, 86, 20);
		rightPanelCart.add(pretFieldupdate);
		pretFieldupdate.setColumns(10);
		
		cantitateFieldupdate = new JTextField();
		cantitateFieldupdate.setBounds(142, 96, 101, 20);
		rightPanelCart.add(cantitateFieldupdate);
		cantitateFieldupdate.setColumns(10);
		
		denumireFieldupdate = new JTextField();
		denumireFieldupdate.setBounds(142, 65, 128, 20);
		rightPanelCart.add(denumireFieldupdate);
		denumireFieldupdate.setColumns(10);
		
		JLabel lblPlafar = new JLabel("PLAFAR");
		lblPlafar.setForeground(Color.CYAN);
		lblPlafar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblPlafar.setBounds(105, 40, 90, 14);
		rightPanelCart.add(lblPlafar);
		
		JLabel lblDenumire = new JLabel("Denumire");
		lblDenumire.setForeground(Color.CYAN);
		lblDenumire.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDenumire.setBounds(39, 68, 76, 14);
		rightPanelCart.add(lblDenumire);
		
		JLabel lblCantitate_1 = new JLabel("Cantitate");
		lblCantitate_1.setForeground(Color.CYAN);
		lblCantitate_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantitate_1.setBounds(39, 99, 76, 14);
		rightPanelCart.add(lblCantitate_1);
		
		JLabel lblPret = new JLabel("Pret");
		lblPret.setForeground(Color.CYAN);
		lblPret.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPret.setBounds(39, 130, 76, 14);
		rightPanelCart.add(lblPret);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 246, 230, 2);
		rightPanelCart.add(separator);
		
		cantitateField = new JTextField();
		cantitateField.setFont(new Font("Tahoma", Font.BOLD, 13));
		cantitateField.setBounds(205, 365, 65, 34);
		rightPanelCart.add(cantitateField);
		cantitateField.setColumns(10);
		
		
		String[]columnNames= {"Denumire produs","Cantitate disponibila","Pret "};
		Object[][] listaProduses = new Object[43][3];
		
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
		
		
		DefaultTableModel tableModel = new DefaultTableModel(listaProduses,columnNames) {//make cells nonEditable

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		
		JScrollPane scrollPaneTable=new JScrollPane();
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
		scrollPaneTable.setBounds(0, 65, 506, 496);
		
		backGRDPanel.add(scrollPaneTable);

		class linie{
			private int row;
			public linie()
			{
			
			}
			
			public void setRow(int r)
			{
				this.row=r;
			}
		};
		
		linie row=new linie();
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseClicked(java.awt.event.MouseEvent evt) {
			    row.setRow((table.rowAtPoint(evt.getPoint())));
			    int col= table.columnAtPoint(evt.getPoint());

			    if (row.row >= 0 && col == 0) {
			    	DefaultListModel productModel=new DefaultListModel();
					productModel.addElement(listaProduses[row.row][col]);
			    	cartList.setModel(productModel);

			    
			    }
			    
			 }
			});
		
		btnCumparare.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				int cantitate=Integer.parseInt(cantitateField.getText());
				
				int actualvalue=(int) listaProduses[row.row][1];
				
				if(actualvalue>=cantitate) {//se actualizeaza cantitatea de produse 
					listaProduses[row.row][1]=actualvalue-cantitate;
					tableModel.setValueAt(actualvalue-cantitate, row.row, 1);
				}
				else
				{
					
					JOptionPane.showMessageDialog(null,"Nu avem cantitatea ceruta","Invalid Quantity",JOptionPane.ERROR_MESSAGE);
			
				}
			}
			
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String denumire=denumireFieldupdate.getText();
				int cantitate=Integer.parseInt(cantitateFieldupdate.getText());
				float pret=Float.parseFloat(pretFieldupdate.getText());
				
				int row=table.getSelectedRow();
				
				listaProduses[row][0]=denumire;
				listaProduses[row][1]=cantitate;
				listaProduses[row][2]=pret;
				
				tableModel.setValueAt(denumire, row, 0);
				tableModel.setValueAt(cantitate, row, 1);
				tableModel.setValueAt(pret, row, 2);
				
			}
		});
		
		
	}
}
