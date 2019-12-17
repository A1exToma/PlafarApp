package frontendmyApp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.sun.glass.events.WindowEvent;

public class mainPlafarrrApp {

	private JFrame frame;
	
	private JPanel rightPanelCart;
	private JButton updateButton;
	private JButton btnAdd;
	
	private JButton btnCumparare;
	
	private JLabel lblProduse;
	private JLabel lblCantitate;
	

	private JTextField pretFieldupdate;
	private JTextField cantitateFieldupdate;
	private JTextField denumireFieldupdate;
	
	private JTextField cantitateField;
	
	private JList<Object> cartList;
	
	private tableForm backGRDPanel;
	
	protected BufferedWriter writer = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPlafarrrApp window = new mainPlafarrrApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public mainPlafarrrApp() {
		guiApp();
		logic();

	}

	private void guiApp() {
		frame = new JFrame("Plafar");
		
		//              x  y  dim   
		frame.setBounds(300, 50, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frame,"Are you sure you want to close this window?", "Close Window?", JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        	
		        	try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		            System.exit(0);
		        }
		    }
		
		});
		frame.getContentPane().setLayout(null);
		
		backGRDPanel = new tableForm();
		backGRDPanel.setBackground(Color.CYAN);
		backGRDPanel.setBounds(0, 0, 506, 561);
		backGRDPanel.setLayout(null);
		frame.getContentPane().add(backGRDPanel);
		
		rightPanelCart = new JPanel();
		rightPanelCart.setForeground(Color.WHITE);
		rightPanelCart.setBackground(Color.DARK_GRAY);
		rightPanelCart.setBounds(504, 0, 280, 561);
		frame.getContentPane().add(rightPanelCart);
		rightPanelCart.setLayout(null);
		
		btnCumparare = new JButton("CUMPARARE");
		btnCumparare.setForeground(Color.DARK_GRAY);
		btnCumparare.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnCumparare.setBackground(Color.CYAN);
		btnCumparare.setBounds(20, 447, 250, 23);
		rightPanelCart.add(btnCumparare);
		
		cartList = new JList<Object>();
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
		
		updateButton = new JButton("Actualizeaza");
		updateButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateButton.setBackground(Color.CYAN);
		updateButton.setBounds(20, 189, 131, 23);
		rightPanelCart.add(updateButton);
		
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
		separator.setBounds(20, 246, 237, 2);
		rightPanelCart.add(separator);
		
		cantitateField = new JTextField();
		cantitateField.setFont(new Font("Tahoma", Font.BOLD, 13));
		cantitateField.setBounds(205, 365, 65, 34);
		rightPanelCart.add(cantitateField);
		cantitateField.setColumns(10);
		
		btnAdd = new JButton("Adauga");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(169, 189, 101, 23);
		rightPanelCart.add(btnAdd);
		
	}
	
	private void logic() {
		
		try {
			writer = new BufferedWriter(new FileWriter("planteVandute.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		backGRDPanel.table.addMouseListener(new java.awt.event.MouseAdapter() {
			
			 public void mouseClicked(java.awt.event.MouseEvent evt) {
				 
			    int row=backGRDPanel.table.rowAtPoint(evt.getPoint());
			    int col= backGRDPanel.table.columnAtPoint(evt.getPoint());

			    if (row >= 0 && col == 0) {
			    	
			    	DefaultListModel<Object> productModelList=new DefaultListModel<Object>();
					productModelList.addElement(backGRDPanel.tableModel.getValueAt(row, col));
			    	cartList.setModel(productModelList);
			    	
			    }
			    
			 }
			});
		
		
	
		btnCumparare.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				int row=backGRDPanel.table.getSelectedRow();
				
				int cantitate=Integer.parseInt(cantitateField.getText());
				int actualvalue=(int) backGRDPanel.tableModel.getValueAt(row, 1);
				
				if(actualvalue>=cantitate) {//se actualizeaza cantitatea de produse 
					
					backGRDPanel.tableModel.setValueAt(actualvalue-cantitate, row, 1);
					
				    String fileContent = backGRDPanel.tableModel.getValueAt(row, 0)+" "+cantitate+"\n";
					
					try {
						writer.write(fileContent);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
					cantitateField.setText(null);
				}
				else
				{
					
					JOptionPane.showMessageDialog(null,"Nu avem cantitatea ceruta","Invalid Quantity",JOptionPane.ERROR_MESSAGE);
			
				}
			}
			
		});
		
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int row=backGRDPanel.table.getSelectedRow();
				
				if(row>=0) {
					String denumire;
					if(denumireFieldupdate.getText()!=null)
					{
						denumire=denumireFieldupdate.getText();
						backGRDPanel.tableModel.setValueAt(denumire, row, 0);
						
					}
					
					int cantitate;
					if(cantitateFieldupdate.getText()!=null){
						
						cantitate=Integer.parseInt(cantitateFieldupdate.getText());
						backGRDPanel.tableModel.setValueAt(cantitate, row, 1);
						
					}
					
					float pret;
					if(pretFieldupdate.getText()!=null) {
						
						pret=Float.parseFloat(pretFieldupdate.getText());
						backGRDPanel.tableModel.setValueAt(pret, row, 2);
						
					}
				}			
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				String denumire=denumireFieldupdate.getText();
				int cantitate=Integer.parseInt(cantitateFieldupdate.getText());
				float pret=Float.parseFloat(pretFieldupdate.getText());
				
				backGRDPanel.tableModel.addRow(new Object[] {denumire,cantitate,pret});
				
			}
		});

	}
	
}
