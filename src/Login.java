import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;

import sound.*;


public class Login extends JPanel 
{ 	
	private static final long serialVersionUID = 1;
	JFrame parentFrame;
	private static JTextField txtFieldUsername;
	private JPasswordField passwordField;
	public static String sUsername;
	
	public Login(JFrame pParentFrame) 
	{
		AudioPlayer ap = new AudioPlayer(Sounds.SCAPEBOLD, true);		//create a sound playing thread
		ap.startSound();	//start the playing
		
		parentFrame = pParentFrame;
		
		setLayout(null);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setBounds(0, 0, 800, 600);
		add(pnlMain);
		pnlMain.setLayout(null);
		
		JPanel pnlLogin = new JPanel();
		pnlLogin.setBounds(231, 201, 326, 300);
		pnlMain.add(pnlLogin);
		pnlLogin.setLayout(null);
		
		txtFieldUsername = new JTextField();
		txtFieldUsername.setForeground(new Color(255, 204, 51));
		txtFieldUsername.setBackground(new Color(0, 0, 51));
		txtFieldUsername.setBounds(35, 59, 248, 22);
		pnlLogin.add(txtFieldUsername);
		txtFieldUsername.setColumns(10);
		txtFieldUsername.setOpaque(false);
		
		JButton btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(checkPassword(DBModel.getPassword(getUsername()), ap))
				{
				Lobby l = new Lobby(parentFrame, 1, ap);
				parentFrame.setContentPane(l);
				parentFrame.revalidate();
				}
			}
		});
		btnLogin.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Login Button.png"));
		btnLogin.setBounds(55, 180, 221, 37);
		pnlLogin.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(255, 204, 51));
		passwordField.setBackground(new Color(0, 0, 51));
		passwordField.setBounds(35, 131, 248, 22);
		pnlLogin.add(passwordField);
		passwordField.setOpaque(false);
		
		JButton btnFacebook = new JButton("");
		btnFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				openFacebook();
			}
		});
		btnFacebook.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Facebook button.png"));
		btnFacebook.setBounds(109, 242, 45, 45);
		pnlLogin.add(btnFacebook);
		
		JButton btnGoogle = new JButton("");
		btnGoogle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				openGooglePlus();
			}
		});
		btnGoogle.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Google Plus Button.png"));
		btnGoogle.setBounds(162, 242, 46, 43);
		pnlLogin.add(btnGoogle);
		
		JLabel lblPanelBackground = new JLabel("");
		lblPanelBackground.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Login Panel.png"));
		lblPanelBackground.setBounds(0, 0, 326, 300);
		pnlLogin.add(lblPanelBackground);
		
		JPanel pnlCreate = new JPanel();
		pnlCreate.setBounds(231, 514, 330, 57);
		pnlMain.add(pnlCreate);
		pnlCreate.setLayout(null);
		
		JButton btnCreate = new JButton("");
		btnCreate.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Create Account Button.png"));
		btnCreate.setBounds(28, 13, 274, 32);
		pnlCreate.add(btnCreate);
		
		JLabel lblCreateBackground = new JLabel("");
		lblCreateBackground.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Create Account Panel.png"));
		lblCreateBackground.setBounds(0, 0, 330, 57);
		pnlCreate.add(lblCreateBackground);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Backgrounds\\Login Background.png"));
		lblBackground.setBounds(0, 0, 800, 600);
		pnlMain.add(lblBackground);
	}
	

	public static String getUsername()
	{
		sUsername = txtFieldUsername.getText();
		return sUsername;
	}
	
	public static void openFacebook()
	{
		try
		{
			java.awt.Desktop.getDesktop().browse(new URI("https://www.facebook.com/"));
		}
		catch(IOException | URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void openGooglePlus()
	{
		try
		{
			java.awt.Desktop.getDesktop().browse(new URI("https://plus.google.com/"));
		}
		catch(IOException | URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	public boolean checkPassword(ResultSet rs, AudioPlayer ap)
	{
		char[] pass = passwordField.getPassword();
		
		String passString = new String(pass);
		try 
		{
			while(rs.next())
			{
				if(passString.equals(rs.getString(1)))
				{
					Lobby l = new Lobby(parentFrame, getUserID(DBModel.getUserID(getUsername())), ap);
					parentFrame.setContentPane(l);
					parentFrame.revalidate();
					
					return true;
				}
				else
				{
					JOptionPane.showMessageDialog(parentFrame, "Incorrect Username/Password");
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static int getUserID(ResultSet rs)
	{
		int iID = 0;
		try
		{
			while(rs.next())
			{
				iID = rs.getInt(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return iID;
		
	}
	
}
