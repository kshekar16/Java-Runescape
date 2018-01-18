import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import sound.AudioPlayer;
import sound.Sounds;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Runescape_Map extends JPanel {
	
	private static final long serialVersionUID = 10;
	JFrame parentFrame;
	private static int iUserID;
	
	public Runescape_Map(JFrame pParentFrame, int piID) 
	{
		parentFrame = pParentFrame;
		iUserID = piID;
		
		setLayout(null);
		
		AudioPlayer music = playMusic();
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 800, 600);
		add(mainPanel);
		mainPanel.setLayout(null);
		
		JButton btnLumbridge = new JButton("");
		btnLumbridge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				music.stopSound();
				LumbridgeMap lm = new LumbridgeMap(parentFrame, iUserID);
				parentFrame.setContentPane(lm);
				parentFrame.revalidate();
			}
		});
		btnLumbridge.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Lumbridge Button.png"));
		btnLumbridge.setBounds(420, 395, 161, 114);
		mainPanel.add(btnLumbridge);
		
		JButton btnDraynor = new JButton("");
		btnDraynor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				music.stopSound();
				DraynorMap dm = new DraynorMap(parentFrame, iUserID);
				parentFrame.setContentPane(dm);
				parentFrame.revalidate();
			}
		});
		btnDraynor.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Draynor Button.png"));
		btnDraynor.setBounds(257, 326, 161, 139);
		mainPanel.add(btnDraynor);
		
		JButton btnVarrock = new JButton("");
		btnVarrock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				music.stopSound();
				VarrockMap vm = new VarrockMap(parentFrame, iUserID);
				parentFrame.setContentPane(vm);
				parentFrame.revalidate();
			}
		});
		btnVarrock.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Varrock Button.png"));
		btnVarrock.setBounds(418, 40, 190, 207);
		mainPanel.add(btnVarrock);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				music.stopSound();
				WizardTowerMap wtm = new WizardTowerMap(parentFrame, iUserID);
				parentFrame.setContentPane(wtm);
				parentFrame.revalidate();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Wizard's Tower button.png"));
		btnNewButton.setBounds(299, 469, 141, 131);
		mainPanel.add(btnNewButton);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Maps\\rsz_runescape_map_updated.png"));
		lblBackground.setBounds(0, 0, 800, 600);
		mainPanel.add(lblBackground);
		
	}
	
	public AudioPlayer playMusic()
	{

			AudioPlayer ap = new AudioPlayer(Sounds.HOMESWEETHOME, true);
			ap.startSound();
			return ap;
	}
}
