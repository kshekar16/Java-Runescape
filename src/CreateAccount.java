import javax.swing.JFrame;
import javax.swing.JPanel;

import sound.AudioPlayer;
import sound.Sounds;
import javax.swing.JLabel;


public class CreateAccount extends JPanel 
{
	private static final long serialVersionUID = 5;
	JFrame parentFrame;
	
	public CreateAccount(JFrame pParentFrame) 
	{
		AudioPlayer ap = new AudioPlayer(Sounds.NEWBIEMELODY, true);
		ap.startSound();
		
		parentFrame = pParentFrame;
		
		setLayout(null);
		
		JPanel pnlMain = new JPanel();
		pnlMain.setBounds(0, 0, 800, 600);
		add(pnlMain);
		pnlMain.setLayout(null);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 800, 600);
		pnlMain.add(lblBackground);

	}
	
	public void addCharacter()
	{
		
	}
}
