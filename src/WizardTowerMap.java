import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import sound.AudioPlayer;
import sound.Sounds;


public class WizardTowerMap extends JPanel {
	private static final long serialVersionUID = 4;
	public static int iUserID;
	JFrame parentFrame;
	
	private static String sUsername;
	private JLabel time;
	private JLabel lblPrayerBackground;
	private JButton btnPrayer;
	private JButton btnSpellbook;
	private JLabel lblNewLabel_2;
	private JTextField txtFieldEntry;
	private JTable table;
	
	public WizardTowerMap(JFrame pParentFrame, int piID) 
	{
		parentFrame = pParentFrame;
		setLayout(null);
				
		iUserID = piID;
		
		AudioPlayer music = playMusic();		
				
		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(0, 0, 800, 600);
		add(MainPanel);
		MainPanel.setLayout(null);
				
		
		time = new JLabel();
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setForeground(new Color(255, 204, 51));
		time.setBounds(594, 206, 48, 22);
		MainPanel.add(time);
		
		JLabel health = new JLabel();
		health.setHorizontalAlignment(SwingConstants.CENTER);
		health.setForeground(new Color(0, 255, 0));
		health.setBounds(565, 65, 31, 16);
		MainPanel.add(health);
		health.setText(Integer.toString(Levels.getHP(DBModel.getHP(iUserID))));
		
		JButton btnLogOut = new JButton("");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				music.stopSound();
				Lobby l = new Lobby(parentFrame, iUserID, music);
				parentFrame.setContentPane(l);
				parentFrame.revalidate();
				
			}
		});
		btnLogOut.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Game Logout Button.png"));
		btnLogOut.setBounds(780, 1, 18, 18);
		MainPanel.add(btnLogOut);
		
		JLabel prayer = new JLabel();
		prayer.setText(Integer.toString(Levels.getPrayer(DBModel.getPrayer(iUserID))));
		prayer.setHorizontalAlignment(SwingConstants.CENTER);
		prayer.setForeground(Color.GREEN);
		prayer.setBounds(560, 100, 31, 16);
		MainPanel.add(prayer);
		
		JLabel summoning = new JLabel();
		summoning.setText(Integer.toString(Levels.getSummoning(DBModel.getSummoning(iUserID))));
		summoning.setHorizontalAlignment(SwingConstants.CENTER);
		summoning.setForeground(Color.GREEN);
		summoning.setBounds(565, 135, 31, 16);
		MainPanel.add(summoning);
		
		JPanel panelInterface = new JPanel();
		panelInterface.setBounds(0, 0, 553, 410);
		MainPanel.add(panelInterface);
		panelInterface.setLayout(null);
		
		JLabel lblMap = new JLabel("");
		lblMap.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Maps\\Wizard's Tower Map.png"));
		lblMap.setBounds(0, 0, 553, 410);
		panelInterface.add(lblMap);
		
		JLabel money = new JLabel();
		money.setHorizontalAlignment(SwingConstants.RIGHT);
		money.setFont(new Font("Tahoma", Font.PLAIN, 10));
		money.setForeground(Color.GREEN);
		money.setBounds(667, 194, 48, 14);
		MainPanel.add(money);
		money.setText(Integer.toString(Levels.getMoney(DBModel.getMoney(iUserID))));
	
		JPanel pnlInventory = new JPanel();
		pnlInventory.setBounds(575, 276, 205, 278);
		MainPanel.add(pnlInventory);
		pnlInventory.setOpaque(false);
		pnlInventory.setEnabled(false);
		pnlInventory.setLayout(null);
		pnlInventory.setEnabled(false);
		
		JPanel pnlFriendsChat = new JPanel();
		pnlFriendsChat.setBounds(0, 0, 205, 278);
		pnlInventory.add(pnlFriendsChat);
		pnlFriendsChat.setLayout(null);
		
		JLabel lblFriendsChat = new JLabel("");
		lblFriendsChat.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Friends Chat Tab.PNG"));
		lblFriendsChat.setBounds(0, 0, 205, 278);
		pnlFriendsChat.add(lblFriendsChat);
		
		JPanel pnlCombat = new JPanel();
		pnlCombat.setBounds(0, 0, 205, 278);
		pnlInventory.add(pnlCombat);
		pnlCombat.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Combat Level: " + Levels.getCombatLevel());
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setBounds(50, 13, 118, 16);
		pnlCombat.add(lblNewLabel_2);
		
		JLabel lblCombat = new JLabel("");
		lblCombat.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Combat Tab.PNG"));
		lblCombat.setBounds(0, 0, 205, 278);
		pnlCombat.add(lblCombat);
		
		JPanel pnlSpellBook = new JPanel();
		pnlSpellBook.setBounds(0, 0, 205, 278);
		pnlInventory.add(pnlSpellBook);
		pnlSpellBook.setLayout(null);
		
		JLabel lblSpellBook = new JLabel("");
		lblSpellBook.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Spell Book Tab.PNG"));
		lblSpellBook.setBounds(0, 0, 205, 278);
		pnlSpellBook.add(lblSpellBook);
		
		JPanel pnlSetup = new JPanel();
		pnlSetup.setBounds(0, 0, 205, 278);
		pnlInventory.add(pnlSetup);
		pnlSetup.setLayout(null);
		pnlSetup.setEnabled(false);
		
		
		JLabel lblSetupBackground = new JLabel("");
		lblSetupBackground.setBounds(0, 0, 205, 278);
		lblSetupBackground.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Worn Equipment.png"));
		pnlSetup.add(lblSetupBackground);
		
		JPanel pnlStats = new JPanel();
		pnlStats.setBounds(0, 0, 205, 278);
		pnlInventory.add(pnlStats);
		pnlStats.setLayout(null);
		
		JLabel attack = new JLabel();
		attack.setHorizontalAlignment(SwingConstants.CENTER);
		attack.setFont(new Font("Tahoma", Font.PLAIN, 10));
		attack.setForeground(Color.ORANGE);
		attack.setBounds(29, 9, 34, 22);
		pnlStats.add(attack);
		attack.setText(Integer.toString(Levels.getAttack(DBModel.getAttack(iUserID))) + "/" + Integer.toString(Levels.getAttack(DBModel.getAttack(iUserID))));
		
		JLabel hitpoints = new JLabel();
		hitpoints.setHorizontalAlignment(SwingConstants.CENTER);
		hitpoints.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hitpoints.setForeground(Color.ORANGE);
		hitpoints.setBounds(96, 9, 34, 22);
		pnlStats.add(hitpoints);
		hitpoints.setText(Integer.toString(Levels.getHP(DBModel.getHP(iUserID))) + "/" + Integer.toString(Levels.getHP(DBModel.getHP(iUserID))));
		
		JLabel mining = new JLabel();
		mining.setHorizontalAlignment(SwingConstants.CENTER);
		mining.setFont(new Font("Tahoma", Font.PLAIN, 10));
		mining.setForeground(Color.ORANGE);
		mining.setBounds(168, 9, 34, 22);
		pnlStats.add(mining);
		mining.setText(Integer.toString(Levels.getMining(DBModel.getMining(iUserID))) + "/" + Integer.toString(Levels.getMining(DBModel.getMining(iUserID))));
		
		JLabel strength = new JLabel();
		strength.setHorizontalAlignment(SwingConstants.CENTER);
		strength.setFont(new Font("Tahoma", Font.PLAIN, 10));
		strength.setForeground(Color.ORANGE);
		strength.setBounds(29, 39, 34, 22);
		pnlStats.add(strength);
		strength.setText(Integer.toString(Levels.getStrength(DBModel.getStrength(iUserID))) + "/" + Integer.toString(Levels.getStrength(DBModel.getStrength(iUserID))));
		
		JLabel agility = new JLabel("1/1");
		agility.setHorizontalAlignment(SwingConstants.CENTER);
		agility.setFont(new Font("Tahoma", Font.PLAIN, 10));
		agility.setForeground(Color.ORANGE);
		agility.setBounds(96, 39, 34, 22);
		pnlStats.add(agility);
		
		JLabel smithing = new JLabel();
		smithing.setHorizontalAlignment(SwingConstants.CENTER);
		smithing.setFont(new Font("Tahoma", Font.PLAIN, 10));
		smithing.setForeground(Color.ORANGE);
		smithing.setBounds(168, 39, 34, 22);
		pnlStats.add(smithing);
		smithing.setText(Integer.toString(Levels.getSmithing(DBModel.getSmithing(iUserID))) + "/" + Integer.toString(Levels.getSmithing(DBModel.getSmithing(iUserID))));
		
		JLabel defence = new JLabel();
		defence.setHorizontalAlignment(SwingConstants.CENTER);
		defence.setFont(new Font("Tahoma", Font.PLAIN, 10));
		defence.setForeground(Color.ORANGE);
		defence.setBounds(29, 69, 34, 22);
		pnlStats.add(defence);
		defence.setText(Integer.toString(Levels.getDefence(DBModel.getDefence(iUserID))) + "/" + Integer.toString(Levels.getDefence(DBModel.getDefence(iUserID))));
		
		JLabel herblore = new JLabel();
		herblore.setText("1/1");
		herblore.setHorizontalAlignment(SwingConstants.CENTER);
		herblore.setFont(new Font("Tahoma", Font.PLAIN, 10));
		herblore.setForeground(Color.ORANGE);
		herblore.setBounds(96, 69, 34, 22);
		pnlStats.add(herblore);
				
		JLabel fishing = new JLabel();
		fishing.setHorizontalAlignment(SwingConstants.CENTER);
		fishing.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fishing.setForeground(Color.ORANGE);
		fishing.setBounds(168, 69, 34, 22);
		pnlStats.add(fishing);
		fishing.setText(Integer.toString(Levels.getFishing(DBModel.getFishing(iUserID))) + "/" + Integer.toString(Levels.getFishing(DBModel.getFishing(iUserID))));
		
		JLabel ranged = new JLabel();
		ranged.setHorizontalAlignment(SwingConstants.CENTER);
		ranged.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ranged.setForeground(Color.ORANGE);
		ranged.setBounds(29, 99, 34, 22);
		pnlStats.add(ranged);
		ranged.setText(Integer.toString(Levels.getRanged(DBModel.getRanged(iUserID))) + "/" + Integer.toString(Levels.getRanged(DBModel.getRanged(iUserID))));
		
		JLabel thieving = new JLabel();
		thieving.setText("1/1");
		thieving.setHorizontalAlignment(SwingConstants.CENTER);
		thieving.setFont(new Font("Tahoma", Font.PLAIN, 10));
		thieving.setForeground(Color.ORANGE);
		thieving.setBounds(96, 99, 34, 22);
		pnlStats.add(thieving);
		
		JLabel cooking = new JLabel();
		cooking.setHorizontalAlignment(SwingConstants.CENTER);
		cooking.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cooking.setForeground(Color.ORANGE);
		cooking.setBounds(168, 99, 34, 22);
		pnlStats.add(cooking);
		cooking.setText(Integer.toString(Levels.getCooking(DBModel.getCooking(iUserID))) + "/" + Integer.toString(Levels.getCooking(DBModel.getCooking(iUserID))));
		cooking.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JLabel prayer_1 = new JLabel();
		prayer_1.setHorizontalAlignment(SwingConstants.CENTER);
		prayer_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		prayer_1.setForeground(Color.ORANGE);
		prayer_1.setBounds(29, 129, 34, 22);
		pnlStats.add(prayer_1);
		prayer_1.setText(Integer.toString(Levels.getPrayer(DBModel.getPrayer(iUserID))) + "/" + Integer.toString(Levels.getPrayer(DBModel.getPrayer(iUserID))));
		
		JLabel crafting = new JLabel();
		crafting.setText("1/1");
		crafting.setHorizontalAlignment(SwingConstants.CENTER);
		crafting.setFont(new Font("Tahoma", Font.PLAIN, 10));
		crafting.setForeground(Color.ORANGE);
		crafting.setBounds(96, 129, 34, 22);
		pnlStats.add(crafting);
		crafting.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JLabel firemaking = new JLabel();
		firemaking.setHorizontalAlignment(SwingConstants.CENTER);
		firemaking.setFont(new Font("Tahoma", Font.PLAIN, 10));
		firemaking.setForeground(Color.ORANGE);
		firemaking.setBounds(168, 129, 34, 22);
		pnlStats.add(firemaking);
		firemaking.setText(Integer.toString(Levels.getFiremaking(DBModel.getFiremaking(iUserID))) + "/" + Integer.toString(Levels.getFiremaking(DBModel.getFiremaking(iUserID))));
		
		JLabel magic = new JLabel();
		magic.setHorizontalAlignment(SwingConstants.CENTER);
		magic.setFont(new Font("Tahoma", Font.PLAIN, 10));
		magic.setForeground(Color.ORANGE);
		magic.setBounds(29, 159, 34, 22);
		pnlStats.add(magic);
		magic.setText(Integer.toString(Levels.getMagic(DBModel.getMagic(iUserID))) + "/" + Integer.toString(Levels.getMagic(DBModel.getMagic(iUserID))));
		
		JLabel fletching = new JLabel();
		fletching.setHorizontalAlignment(SwingConstants.CENTER);
		fletching.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fletching.setForeground(Color.ORANGE);
		fletching.setBounds(96, 159, 34, 22);
		pnlStats.add(fletching);
		fletching.setText(Integer.toString(Levels.getFletching(DBModel.getFletching(iUserID))) + "/" + Integer.toString(Levels.getFletching(DBModel.getFletching(iUserID))));
		
		JLabel woodcutting = new JLabel();
		woodcutting.setHorizontalAlignment(SwingConstants.CENTER);
		woodcutting.setFont(new Font("Tahoma", Font.PLAIN, 10));
		woodcutting.setForeground(Color.ORANGE);
		woodcutting.setBounds(168, 159, 34, 22);
		pnlStats.add(woodcutting);
		woodcutting.setText(Integer.toString(Levels.getWoodcutting(DBModel.getWoodcutting(iUserID))) + "/" + Integer.toString(Levels.getWoodcutting(DBModel.getWoodcutting(iUserID))));
		
		JLabel runecrafting = new JLabel();
		runecrafting.setText("1/1");
		runecrafting.setHorizontalAlignment(SwingConstants.CENTER);
		runecrafting.setFont(new Font("Tahoma", Font.PLAIN, 10));
		runecrafting.setForeground(Color.ORANGE);
		runecrafting.setBounds(29, 190, 34, 22);
		pnlStats.add(runecrafting);
		
		JLabel slayer = new JLabel();
		slayer.setHorizontalAlignment(SwingConstants.CENTER);
		slayer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		slayer.setForeground(Color.ORANGE);
		slayer.setBounds(96, 190, 34, 22);
		pnlStats.add(slayer);
		slayer.setText(Levels.getSlayer(DBModel.getSlayer(iUserID)) + "/" + Levels.getSlayer(DBModel.getSlayer(iUserID)));
		
		JLabel farming = new JLabel();
		farming.setText("1/1");
		farming.setHorizontalAlignment(SwingConstants.CENTER);
		farming.setFont(new Font("Tahoma", Font.PLAIN, 10));
		farming.setForeground(Color.ORANGE);
		farming.setBounds(168, 190, 34, 22);
		pnlStats.add(farming);
		
		JLabel construction = new JLabel();
		construction.setText("1/1");
		construction.setHorizontalAlignment(SwingConstants.CENTER);
		construction.setFont(new Font("Tahoma", Font.PLAIN, 10));
		construction.setForeground(Color.ORANGE);
		construction.setBounds(29, 220, 34, 22);
		pnlStats.add(construction);
		
		JLabel hunter = new JLabel();
		hunter.setText("1/1");
		hunter.setHorizontalAlignment(SwingConstants.CENTER);
		hunter.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hunter.setForeground(Color.ORANGE);
		hunter.setBounds(96, 220, 34, 22);
		pnlStats.add(hunter);
		
		JLabel summoning_1 = new JLabel();
		summoning_1.setHorizontalAlignment(SwingConstants.CENTER);
		summoning_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		summoning_1.setForeground(Color.ORANGE);
		summoning_1.setBackground(Color.BLACK);
		summoning_1.setBounds(168, 220, 34, 22);
		pnlStats.add(summoning_1);
		summoning_1.setText(Integer.toString(Levels.getSummoning(DBModel.getSummoning(iUserID))) + "/" + Integer.toString(Levels.getSummoning(DBModel.getSummoning(iUserID))));
		
		JLabel dungeoneering = new JLabel();
		dungeoneering.setText("1/1");
		dungeoneering.setHorizontalAlignment(SwingConstants.CENTER);
		dungeoneering.setFont(new Font("Tahoma", Font.PLAIN, 10));
		dungeoneering.setForeground(Color.ORANGE);
		dungeoneering.setBounds(29, 250, 34, 22);
		pnlStats.add(dungeoneering);
		
		JLabel total = new JLabel();
		total.setForeground(Color.ORANGE);
		total.setBounds(75, 250, 116, 22);
		pnlStats.add(total);
		total.setText("Total Level: " + Levels.getTotalLevel());
		
		JLabel lblStatsBackground = new JLabel("");
		lblStatsBackground.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Stats.png"));
		lblStatsBackground.setBounds(0, 0, 205, 278);
		pnlStats.add(lblStatsBackground);
		
		JPanel pnlQuest = new JPanel();
		pnlQuest.setBounds(0, 0, 205, 278);
		pnlInventory.add(pnlQuest);
		pnlQuest.setLayout(null);
		
		JLabel lblQuest = new JLabel("");
		lblQuest.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Quest Tab.png"));
		lblQuest.setBounds(0, 0, 205, 278);
		pnlQuest.add(lblQuest);
		
		JPanel pnlPrayer = new JPanel();
		pnlPrayer.setBounds(0, 0, 205, 278);
		pnlInventory.add(pnlPrayer);
		pnlPrayer.setLayout(null);
		
		JLabel lblPrayerLevel = new JLabel("");
		lblPrayerLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrayerLevel.setForeground(Color.ORANGE);
		lblPrayerLevel.setBounds(79, 257, 56, 16);
		pnlPrayer.add(lblPrayerLevel);
		lblPrayerLevel.setText(Integer.toString(Levels.getPrayer(DBModel.getPrayer(iUserID))) + "/" + Integer.toString(Levels.getPrayer(DBModel.getPrayer(iUserID))));
		
		lblPrayerBackground = new JLabel("");
		lblPrayerBackground.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Prayer Tab.png"));
		lblPrayerBackground.setBounds(0, 0, 205, 278);
		pnlPrayer.add(lblPrayerBackground);
		
		JPanel pnlFriends = new JPanel();
		pnlFriends.setBounds(0, 0, 205, 278);
		pnlInventory.add(pnlFriends);
		pnlFriends.setLayout(null);
		
		JLabel lblFriends = new JLabel("");
		lblFriends.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Friends Tab.PNG"));
		lblFriends.setBounds(0, 0, 205, 278);
		pnlFriends.add(lblFriends);
		
		JPanel pnlClanChat = new JPanel();
		pnlClanChat.setBounds(0, 0, 205, 278);
		pnlInventory.add(pnlClanChat);
		pnlClanChat.setLayout(null);
		
		JLabel lblClanChat = new JLabel("");
		lblClanChat.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Clan Chat Tab.PNG"));
		lblClanChat.setBounds(0, 0, 205, 278);
		pnlClanChat.add(lblClanChat);
		
		JPanel pnlEmotes = new JPanel();
		pnlEmotes.setBounds(0, 0, 205, 278);
		pnlInventory.add(pnlEmotes);
		pnlEmotes.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Emotes Tab.PNG"));
		lblNewLabel_1.setBounds(0, 0, 205, 278);
		pnlEmotes.add(lblNewLabel_1);
		
		JPanel pnlGroup = new JPanel();
		pnlGroup.setBounds(0, 0, 205, 278);
		pnlInventory.add(pnlGroup);
		pnlGroup.setLayout(null);
		
		JLabel lblGroup = new JLabel("");
		lblGroup.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Group Tab.PNG"));
		lblGroup.setBounds(0, 0, 205, 278);
		pnlGroup.add(lblGroup);
		pnlInventory.setVisible(false);
		pnlInventory.setVisible(false);
		
		
		JPanel pnlMusic = new JPanel();
		pnlMusic.setBounds(0, 0, 205, 278);
		pnlInventory.add(pnlMusic);
		pnlMusic.setLayout(null);
		
		JLabel lblMusic = new JLabel("");
		lblMusic.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Misc\\Music Tab.PNG"));
		lblMusic.setBounds(0, 0, 205, 278);
		pnlMusic.add(lblMusic);
		pnlInventory.setVisible(false);
		pnlInventory.setVisible(false);
		
		
		JButton btnEquipment = new JButton("");
		btnEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				pnlInventory.setVisible(true);
				pnlSetup.setEnabled(true);
				pnlSetup.setVisible(true);
				pnlStats.setEnabled(false);
				pnlStats.setVisible(false);
				pnlQuest.setVisible(false);
				pnlQuest.setEnabled(false);
				pnlPrayer.setVisible(false);
				pnlPrayer.setEnabled(false);
				pnlSpellBook.setEnabled(false);
				pnlSpellBook.setVisible(false);
				pnlCombat.setEnabled(false);
				pnlCombat.setVisible(false);
				pnlFriendsChat.setVisible(false);
				pnlFriendsChat.setEnabled(false);
				pnlFriends.setVisible(false);
				pnlFriends.setEnabled(false);
			}
		});
		btnEquipment.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Setup Button.png"));
		btnEquipment.setBounds(706, 237, 31, 35);
		MainPanel.add(btnEquipment);
		
		JButton btnMap = new JButton("");
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				music.stopSound();
				Runescape_Map rm = new Runescape_Map(parentFrame, iUserID);
				parentFrame.setContentPane(rm);
				parentFrame.revalidate();
			}
		});
		btnMap.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Map button.png"));
		btnMap.setBounds(749, 166, 44, 40);
		MainPanel.add(btnMap);
		
		JButton btnStats = new JButton("");
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				pnlInventory.setVisible(true);
				pnlSetup.setVisible(false);
				pnlSetup.setEnabled(false);
				pnlStats.setEnabled(true);
				pnlStats.setVisible(true);
				pnlQuest.setVisible(false);
				pnlQuest.setEnabled(false);
				pnlPrayer.setVisible(false);
				pnlPrayer.setEnabled(false);
				pnlSpellBook.setEnabled(false);
				pnlSpellBook.setVisible(false);
				pnlCombat.setEnabled(false);
				pnlCombat.setVisible(false);
				pnlFriendsChat.setVisible(false);
				pnlFriendsChat.setEnabled(false);
				pnlFriends.setVisible(false);
				pnlFriends.setEnabled(false);
			}
		});
		btnStats.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Stats Button.png"));
		btnStats.setBounds(616, 236, 30, 35);
		MainPanel.add(btnStats);
		
		JButton btnQuest = new JButton("");
		btnQuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				pnlInventory.setVisible(true);
				pnlSetup.setVisible(false);
				pnlSetup.setEnabled(false);
				pnlStats.setEnabled(false);
				pnlStats.setVisible(false);
				pnlQuest.setVisible(true);
				pnlQuest.setEnabled(true);
				pnlPrayer.setVisible(false);
				pnlPrayer.setEnabled(false);
				pnlSpellBook.setEnabled(false);
				pnlSpellBook.setVisible(false);
				pnlCombat.setEnabled(false);
				pnlCombat.setVisible(false);
				pnlFriendsChat.setVisible(false);
				pnlFriendsChat.setEnabled(false);
				pnlFriends.setVisible(false);
				pnlFriends.setEnabled(false);
			}
		});
		btnQuest.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Quest Button.png"));
		btnQuest.setBounds(644, 235, 30, 38);
		MainPanel.add(btnQuest);
		
		btnPrayer = new JButton("");
		btnPrayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				pnlInventory.setVisible(true);
				pnlSetup.setVisible(false);
				pnlSetup.setEnabled(false);
				pnlStats.setEnabled(false);
				pnlStats.setVisible(false);
				pnlQuest.setVisible(false);
				pnlQuest.setEnabled(false);
				pnlPrayer.setEnabled(true);
				pnlPrayer.setVisible(true);
				pnlSpellBook.setVisible(false);
				pnlSpellBook.setEnabled(false);
				pnlCombat.setEnabled(false);
				pnlCombat.setVisible(false);
				pnlFriendsChat.setVisible(false);
				pnlFriendsChat.setEnabled(false);
				pnlFriends.setVisible(false);
				pnlFriends.setEnabled(false);
			}
		});
		btnPrayer.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Prayer Button.png"));
		btnPrayer.setBounds(736, 237, 31, 35);
		MainPanel.add(btnPrayer);
		
		JButton btnInventory = new JButton("");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				pnlInventory.setVisible(true);
				pnlSetup.setEnabled(false);
				pnlSetup.setVisible(false);
				pnlStats.setEnabled(false);
				pnlStats.setVisible(false);
				pnlQuest.setVisible(false);
				pnlQuest.setEnabled(false);
				pnlPrayer.setVisible(false);
				pnlPrayer.setEnabled(false);
				pnlSpellBook.setEnabled(false);
				pnlSpellBook.setVisible(false);
				pnlCombat.setEnabled(false);
				pnlCombat.setVisible(false);
				pnlFriends.setVisible(false);
				pnlFriends.setEnabled(false);
				pnlFriendsChat.setVisible(false);
				pnlFriendsChat.setEnabled(false);
				pnlClanChat.setEnabled(false);
				pnlClanChat.setVisible(false);
				pnlEmotes.setVisible(false);
				pnlEmotes.setEnabled(false);
				pnlGroup.setVisible(false);
				pnlGroup.setEnabled(false);
				pnlMusic.setEnabled(false);
				pnlMusic.setVisible(false);
			}
		});
		btnInventory.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Inventory Button.png"));
		btnInventory.setBounds(676, 235, 31, 37);
		MainPanel.add(btnInventory);
		
		btnSpellbook = new JButton("");
		btnSpellbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				pnlInventory.setVisible(true);
				pnlSetup.setEnabled(false);
				pnlSetup.setVisible(false);
				pnlStats.setEnabled(false);
				pnlStats.setVisible(false);
				pnlQuest.setVisible(false);
				pnlQuest.setEnabled(false);
				pnlPrayer.setVisible(false);
				pnlPrayer.setEnabled(false);
				pnlSpellBook.setEnabled(true);
				pnlSpellBook.setVisible(true);
				pnlCombat.setEnabled(false);
				pnlCombat.setVisible(false);
				pnlFriendsChat.setVisible(false);
				pnlFriendsChat.setEnabled(false);
				pnlFriends.setVisible(false);
				pnlFriends.setEnabled(false);
			}
		});
		btnSpellbook.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Spell Book Button.png"));
		btnSpellbook.setBounds(765, 237, 33, 35);
		MainPanel.add(btnSpellbook);
		
		JButton btnCombat = new JButton("");
		btnCombat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				pnlInventory.setVisible(true);
				pnlSetup.setEnabled(false);
				pnlSetup.setVisible(false);
				pnlStats.setEnabled(false);
				pnlStats.setVisible(false);
				pnlQuest.setVisible(false);
				pnlQuest.setEnabled(false);
				pnlPrayer.setVisible(false);
				pnlPrayer.setEnabled(false);
				pnlSpellBook.setEnabled(false);
				pnlSpellBook.setVisible(false);
				pnlCombat.setEnabled(true);
				pnlCombat.setVisible(true);
				pnlFriendsChat.setVisible(false);
				pnlFriendsChat.setEnabled(false);
				pnlFriends.setVisible(false);
				pnlFriends.setEnabled(false);
			}
		});
		btnCombat.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Combat Button.png"));
		btnCombat.setBounds(557, 234, 32, 38);
		MainPanel.add(btnCombat);
		
		JButton btnFriends = new JButton("");
		btnFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				pnlInventory.setVisible(true);
				pnlSetup.setEnabled(false);
				pnlSetup.setVisible(false);
				pnlStats.setEnabled(false);
				pnlStats.setVisible(false);
				pnlQuest.setVisible(false);
				pnlQuest.setEnabled(false);
				pnlPrayer.setVisible(false);
				pnlPrayer.setEnabled(false);
				pnlSpellBook.setEnabled(false);
				pnlSpellBook.setVisible(false);
				pnlCombat.setEnabled(false);
				pnlCombat.setVisible(false);
				pnlFriends.setVisible(true);
				pnlFriends.setEnabled(true);
				pnlFriendsChat.setVisible(false);
				pnlFriendsChat.setEnabled(false);
			}
		});
		btnFriends.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Friends Button.png"));
		btnFriends.setBounds(585, 559, 32, 35);
		MainPanel.add(btnFriends);
		
		JLabel lblUsername = new JLabel("The Real: " + getUsername(DBModel.getUsername(iUserID)));
		lblUsername.setBounds(12, 555, 102, 16);
		MainPanel.add(lblUsername);
		
		JButton btnFriendsChat = new JButton("");
		btnFriendsChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				pnlInventory.setVisible(true);
				pnlSetup.setEnabled(false);
				pnlSetup.setVisible(false);
				pnlStats.setEnabled(false);
				pnlStats.setVisible(false);
				pnlQuest.setVisible(false);
				pnlQuest.setEnabled(false);
				pnlPrayer.setVisible(false);
				pnlPrayer.setEnabled(false);
				pnlSpellBook.setEnabled(false);
				pnlSpellBook.setVisible(false);
				pnlCombat.setEnabled(false);
				pnlCombat.setVisible(false);
				pnlFriends.setVisible(false);
				pnlFriends.setEnabled(false);
				pnlFriendsChat.setVisible(true);
				pnlFriendsChat.setEnabled(true);
			}
		});
		btnFriendsChat.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Friends Chat Button.png"));
		btnFriendsChat.setBounds(616, 558, 30, 35);
		MainPanel.add(btnFriendsChat);
		
		JButton btnClanChat = new JButton("");
		btnClanChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				pnlInventory.setVisible(true);
				pnlSetup.setEnabled(false);
				pnlSetup.setVisible(false);
				pnlStats.setEnabled(false);
				pnlStats.setVisible(false);
				pnlQuest.setVisible(false);
				pnlQuest.setEnabled(false);
				pnlPrayer.setVisible(false);
				pnlPrayer.setEnabled(false);
				pnlSpellBook.setEnabled(false);
				pnlSpellBook.setVisible(false);
				pnlCombat.setEnabled(false);
				pnlCombat.setVisible(false);
				pnlFriends.setVisible(false);
				pnlFriends.setEnabled(false);
				pnlFriendsChat.setVisible(false);
				pnlFriendsChat.setEnabled(false);
				pnlClanChat.setEnabled(true);
				pnlClanChat.setVisible(true);
				
			}
		});
		btnClanChat.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Clan Chat Button.png"));
		btnClanChat.setBounds(645, 558, 32, 37);
		MainPanel.add(btnClanChat);
		
		JButton btnEmote = new JButton("");
		btnEmote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				pnlInventory.setVisible(true);
				pnlSetup.setEnabled(false);
				pnlSetup.setVisible(false);
				pnlStats.setEnabled(false);
				pnlStats.setVisible(false);
				pnlQuest.setVisible(false);
				pnlQuest.setEnabled(false);
				pnlPrayer.setVisible(false);
				pnlPrayer.setEnabled(false);
				pnlSpellBook.setEnabled(false);
				pnlSpellBook.setVisible(false);
				pnlCombat.setEnabled(false);
				pnlCombat.setVisible(false);
				pnlFriends.setVisible(false);
				pnlFriends.setEnabled(false);
				pnlFriendsChat.setVisible(false);
				pnlFriendsChat.setEnabled(false);
				pnlClanChat.setEnabled(false);
				pnlClanChat.setVisible(false);
				pnlEmotes.setEnabled(true);
				pnlEmotes.setVisible(true);
			}
		});
		btnEmote.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Emote Button.png"));
		btnEmote.setBounds(707, 558, 30, 36);
		MainPanel.add(btnEmote);
		
		JButton btnGroup = new JButton("");
		btnGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				pnlInventory.setVisible(true);
				pnlSetup.setEnabled(false);
				pnlSetup.setVisible(false);
				pnlStats.setEnabled(false);
				pnlStats.setVisible(false);
				pnlQuest.setVisible(false);
				pnlQuest.setEnabled(false);
				pnlPrayer.setVisible(false);
				pnlPrayer.setEnabled(false);
				pnlSpellBook.setEnabled(false);
				pnlSpellBook.setVisible(false);
				pnlCombat.setEnabled(false);
				pnlCombat.setVisible(false);
				pnlFriends.setVisible(false);
				pnlFriends.setEnabled(false);
				pnlFriendsChat.setVisible(false);
				pnlFriendsChat.setEnabled(false);
				pnlClanChat.setEnabled(false);
				pnlClanChat.setVisible(false);
				pnlEmotes.setEnabled(false);
				pnlEmotes.setVisible(false);
				pnlGroup.setEnabled(true);
				pnlGroup.setVisible(true);
			}
		});
		btnGroup.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Group Button.png"));
		btnGroup.setBounds(767, 559, 28, 35);
		MainPanel.add(btnGroup);
		
		JPanel pnlChat = new JPanel();
		pnlChat.setBounds(6, 415, 526, 136);
		MainPanel.add(pnlChat);
		pnlChat.setLayout(null);
		pnlChat.setOpaque(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(526, 0, -524, 136);
		pnlChat.add(scrollPane);
		scrollPane.setVisible(true);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		((DefaultTableModel)table.getModel()).addColumn("Input");
		table.getColumnModel().getColumn(0).setResizable(false);
		table.setVisible(true);
		table.setRowSelectionAllowed(false);
		
		
		
		txtFieldEntry = new JTextField();
		txtFieldEntry.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFieldEntry.setForeground(Color.BLACK);
		txtFieldEntry.setBounds(132, 555, 413, 16);
		MainPanel.add(txtFieldEntry);
		txtFieldEntry.setColumns(10);
		txtFieldEntry.setOpaque(false);
		txtFieldEntry.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtFieldEntry.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				((DefaultTableModel) table.getModel()).setRowCount(0);
				((DefaultTableModel) table.getModel()).addRow(new String [] {getUsername(DBModel.getUsername(iUserID)) +  txtFieldEntry.getText()});
				System.out.println(getUsername(DBModel.getUsername(iUserID)) + " " + txtFieldEntry.getText());
			
		}});
		
		JButton btnMusic = new JButton("");
		btnMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				pnlInventory.setVisible(true);
				pnlSetup.setEnabled(false);
				pnlSetup.setVisible(false);
				pnlStats.setEnabled(false);
				pnlStats.setVisible(false);
				pnlQuest.setVisible(false);
				pnlQuest.setEnabled(false);
				pnlPrayer.setVisible(false);
				pnlPrayer.setEnabled(false);
				pnlSpellBook.setEnabled(false);
				pnlSpellBook.setVisible(false);
				pnlCombat.setEnabled(false);
				pnlCombat.setVisible(false);
				pnlFriends.setVisible(false);
				pnlFriends.setEnabled(false);
				pnlFriendsChat.setVisible(false);
				pnlFriendsChat.setEnabled(false);
				pnlClanChat.setEnabled(false);
				pnlClanChat.setVisible(false);
				pnlEmotes.setEnabled(false);
				pnlEmotes.setVisible(false);
				pnlGroup.setEnabled(false);
				pnlGroup.setVisible(false);
				pnlMusic.setEnabled(true);
				pnlMusic.setVisible(true);
			}
		});
		btnMusic.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Buttons\\Music Button.png"));
		btnMusic.setBounds(736, 559, 31, 34);
		MainPanel.add(btnMusic);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\kshek\\Java Runescape\\Backgrounds\\Game Background.png"));
		lblBackground.setBounds(0, 0, 800, 600);
		MainPanel.add(lblBackground);
		
		registerTimeChanger();
		
	}
	public void registerTimeChanger()
	{
		Runnable r = new Runnable(){
			
			public void run()
			{
				while(true)
				{
					time.setText(new SimpleDateFormat("hh:mm").format(new Date()));
					try 
					{
						Thread.sleep(60 * 1000);
					}
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			}
		};
		
		new Thread(r).start();
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

	
	public AudioPlayer playMusic()
	{

			AudioPlayer ap = new AudioPlayer(Sounds.BOOKOFSPELLS, true);
			ap.startSound();
			return ap;
	}
	

	
	public static int getUserID()
	{
		return iUserID;
	}
}
