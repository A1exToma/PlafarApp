package Login_Sys;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import frontendmyApp.frontendApp;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login_S {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField txtPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_S window = new Login_S();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login_S() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Plafar Login System");
		frame.setBounds(500, 250, 385, 258);
		frame.setMinimumSize(new Dimension(385,258));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel loginLabel = new JLabel("PLAFAR LOGIN");
		loginLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		loginLabel.setBounds(143, 11, 133, 28);
		frame.getContentPane().add(loginLabel);
		
		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		userNameLabel.setBounds(50, 74, 89, 14);
		frame.getContentPane().add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		passwordLabel.setBounds(50, 112, 100, 14);
		frame.getContentPane().add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Arial Black", Font.PLAIN, 13));
		usernameField.setBounds(145, 71, 152, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Arial Black", Font.PLAIN, 13));
		txtPassword.setBounds(145, 109, 152, 20);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user=usernameField.getText();
				String pass=txtPassword.getText();
				
				if(user.contains("alextoma")&&pass.contains("12345"))
				{
					usernameField.setText(null);
					txtPassword.setText(null);
					
					//s au introdus corect datele de login
					//se deschide aplicatia
					
					frame.setVisible(false);
					
					frontendApp.main(null);
				}
				else
				{
					usernameField.setText(null);
					txtPassword.setText(null);
					
					//daca s-a introdus o parola gresita se semnaleaza printr o casuta de eroare
					JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnLogin.setBounds(143, 145, 154, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnExitSS = new JButton("EXIT");
		btnExitSS.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnExitSS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame frmLoginsystem=new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginsystem,"Confirm if you want to exit","Login Systems",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
				
					System.exit(0);
				}
				
			}
		});
		btnExitSS.setBounds(143, 179, 154, 23);
		frame.getContentPane().add(btnExitSS);
	}
}
