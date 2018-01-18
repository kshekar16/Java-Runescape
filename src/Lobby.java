import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import sound.AudioPlayer;

import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Lobby extends JPanel 
{
	private static final long serialVersionUID = 2;
	JFrame parentFrame;
	public static int iUserID;
	public static String sUsername;
	
	public Lobby(JFrame pParentFrame, int piID, AudioPlayer introSound) 
	{
		parentFrame = pParentFrame;
		setLayout(null);
		
		iUserID = piID;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 600);
		add(panel);
		panel.setLayout(null);
		
		JButton btnPlay = new JButton("");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				introSound.stopSound();
				Runescape_Map rm = new Runescape_Map(parentFrame, iUserID);
				parentFrame.setContentPane(rm);
				parentFrame.revalidate();
			}
		});
		btnPlay.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Play Now button.png"));
		btnPlay.setBounds(285, 537, 244, 50);
		panel.add(btnPlay);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Login l = new Login(parentFrame);
				parentFrame.setContentPane(l);
				parentFrame.revalidate();
				introSound.stopSound();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Lobby Log out.png"));
		btnNewButton.setBounds(754, 13, 46, 44);
		panel.add(btnNewButton);
		
		JLabel lblIP = new JLabel("You Last Logged in From: " + getIP());
		lblIP.setForeground(new Color(192, 192, 192));
		lblIP.setBounds(29, 95, 235, 16);
		panel.add(lblIP);
		
		JButton btnArrav = new JButton("");
		btnArrav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				openArrav();
			}
		});
		btnArrav.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Array Button.png"));
		btnArrav.setBounds(29, 188, 487, 156);
		panel.add(btnArrav);
		
		JButton btnRunelabs = new JButton("");
		btnRunelabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				openRuneLabs();
			}
		});
		btnRunelabs.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\RuneLabs Button.png"));
		btnRunelabs.setBounds(29, 403, 238, 110);
		panel.add(btnRunelabs);
		
		JButton btnExecutioner = new JButton("");
		btnExecutioner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				openExecutioner();
			}
		});
		btnExecutioner.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Executioner Button.png"));
		btnExecutioner.setBounds(279, 403, 235, 108);
		panel.add(btnExecutioner);
		
		JLabel lblUsername = new JLabel(getUsername(DBModel.getUsername(iUserID)));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(189, 74, 94, 16);
		panel.add(lblUsername);
		
		JButton btnDimension = new JButton("");
		btnDimension.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				openDimension();
			}
		});
		btnDimension.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Dimension of Disaster Button.png"));
		btnDimension.setBounds(534, 188, 221, 95);
		panel.add(btnDimension);
		
		JButton btnVideo = new JButton("");
		btnVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				openBTS();
			}
		});
		btnVideo.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\BTS Button.png"));
		btnVideo.setBounds(534, 287, 221, 96);
		panel.add(btnVideo);
		
		JButton btnQuestival = new JButton("");
		btnQuestival.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				openQuestival();
			}
		});
		btnQuestival.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Questival Button.png"));
		btnQuestival.setBounds(534, 389, 221, 97);
		panel.add(btnQuestival);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Backgrounds\\Lobby Background.png"));
		lblBackground.setBounds(0, 0, 800, 600);
		panel.add(lblBackground);
	}
	
	public String getIP()
	{
		 InetAddress iAddress = null;
		 
		try 
		{
			iAddress = InetAddress.getLocalHost();
		} 
		catch (UnknownHostException e)
		{
			
			e.printStackTrace();
		}
		  String currentIp = iAddress.getHostAddress();
		  	return currentIp;
	}
	
	public static void openArrav()
	{
		try
		{
			Desktop.getDesktop().browse(new URI("http://services.runescape.com/m=rswiki/en/Arrav_outfit"));
		}
		catch(IOException | URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void openRuneLabs()
	{
		try
		{
			Desktop.getDesktop().browse(new URI("https://secure.runescape.com/m=player-proposal/"));
		}
		catch(IOException | URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void openExecutioner()
	{
		try
		{
			Desktop.getDesktop().browse(new URI("http://services.runescape.com/m=rswiki/en/Executioner_Axe"));
		}
		catch(IOException | URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void openDimension()
	{
		try
		{
			Desktop.getDesktop().browse(new URI("http://services.runescape.com/m=rswiki/en/Dimension_of_Disaster_-_Spoilers"));
		}
		catch(IOException | URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void openBTS()
	{
		try
		{
			Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=laDk9gzdbwg"));
		}
		catch(IOException | URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void openQuestival()
	{
		try
		{
			Desktop.getDesktop().browse(new URI("http://runescape.wikia.com/wiki/Update:Questival_is_Here!"));
		}
		catch(IOException | URISyntaxException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getUsername(ResultSet rs)
	{
		try
		{
			while(rs.next())
			{
				sUsername = rs.getString(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return sUsername;
	}
	
	public static int getUserID()
	{
		return iUserID;
	}
}
