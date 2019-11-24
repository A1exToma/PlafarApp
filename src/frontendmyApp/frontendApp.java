package frontendmyApp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class frontendApp {

	private JFrame frame;
	private JTable table;
	private JPanel backGRDPanel;
	private JPanel topPanel;
	private JPanel rightPanelCart;
	private JButton btnCumparare;

	
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
		frame.setBounds(0, 0, 800, 600);
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
		btnCumparare.setBounds(20, 476, 250, 23);
		rightPanelCart.add(btnCumparare);
		
		String[]columnNames= {"Denumire produs","Cantitate disponibila","Pret "};
		Object[][] listaProduses = new Object[43][3];
		
		try {
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
		
		
		JScrollPane scrollPane=new JScrollPane();
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
		scrollPane.add(table);
		scrollPane.setViewportView(table);
		scrollPane.setBounds(0, 65, 506, 496);
		backGRDPanel.add(scrollPane);
	}
}
