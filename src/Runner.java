import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;


public class Runner extends JFrame 
{
	private static final long serialVersionUID = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Runner frame = new Runner();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Runner() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 805, 630);
		
		Login login = new Login(this);
		setContentPane(login);
		
	}

}
