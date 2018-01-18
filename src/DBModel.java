import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBModel {

	private static String connectionUrl = "jdbc:sqlserver://localhost;user=sa;password=password;databaseName=Scape";
	
	public static ResultSet ExecuteQuery(String cmd){
		ResultSet r = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(connectionUrl);
			Statement s = con.createStatement();
			r = s.executeQuery(cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public static void Execute(String cmd){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection con = DriverManager.getConnection(connectionUrl);
			Statement s = con.createStatement();
			s.executeUpdate(cmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet getPassword(String psUsername)
	{		
		String sSQL = "SELECT Password_txt "
				+ "FROM ScUser "
				+ "WHERE Username_txt LIKE'" + psUsername + "'";
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getUserID(String psUsername)
	{
		String sSQL = "SELECT ID "
				+ "FROM ScUser sc "
				+ "WHERE Username_txt = '" + psUsername + "'";
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getUsername(int piID)
	{
		String sSQL = "SELECT sc.Username_txt "
				+ "FROM ScUser sc "
				+ "WHERE ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getHP(int piID)
	{
		String sSQL = "SELECT l.Constitution "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getAttack(int piID)
	{
		String sSQL = "SELECT l.Attack "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getDefence(int piID)
	{
		String sSQL = "SELECT l.Defence "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getMining(int piID)
	{
		String sSQL = "SELECT l.Mining "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getStrength(int piID)
	{
		String sSQL = "SELECT l.Strength "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getFishing(int piID)
	{
		String sSQL = "SELECT l.Fishing "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getRanged(int piID)
	{
		String sSQL = "SELECT l.Ranged "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getCooking(int piID)
	{
		String sSQL = "SELECT l.Cooking "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getPrayer(int piID)
	{
		String sSQL = "SELECT l.Prayer "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getFiremaking(int piID)
	{
		String sSQL = "SELECT l.Firemaking "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getMagic(int piID)
	{
		String sSQL = "SELECT l.Magic "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getFletching(int piID)
	{
		String sSQL = "SELECT l.Fletching "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getWoodcutting(int piID)
	{
		String sSQL = "SELECT l.Woodcutting "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getSummoning(int piID)
	{
		String sSQL = "SELECT l.Summoning "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getSlayer(int piID)
	{
		String sSQL = "SELECT l.Slayer "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID =  " + piID;
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getMoney(int piID)
	{
		String sSQL = "SELECT c.Money "
				+ "FROM Character c JOIN ScUser sc "
				+ "ON c.User_ID = sc.ID "
				+ "WHERE c.User_ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}

	public static ResultSet getSmithing(int piID) 
	{
		String sSQL = "SELECT l.Smithing "
				+ "FROM Level l JOIN Character c "
				+ "ON l.Character_ID = c.ID "
				+ "WHERE c.User_ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getAttackExp(int piID)
	{
		String sSQL = "SELECT le.Attack_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getConstitutionExp(int piID)
	{
		String sSQL = "SELECT le.Constitution_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getMiningExp(int piID)
	{
		String sSQL = "SELECT le.Mining_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getStrengthExp(int piID)
	{
		String sSQL = "SELECT le.Strength_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getDefenceExp(int piID)
	{
		String sSQL = "SELECT le.Defence_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getFishingExp(int piID)
	{
		String sSQL = "SELECT le.Fishing_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getRangedExp(int piID)
	{
		String sSQL = "SELECT le.Ranged_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getCookingExp(int piID)
	{
		String sSQL = "SELECT le.Cooking_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getPrayerExp(int piID)
	{
		String sSQL = "SELECT le.Prayer_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getFiremakingExp(int piID)
	{
		String sSQL = "SELECT le.Firemaking_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getMagicExp(int piID)
	{
		String sSQL = "SELECT le.Magic_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getFletchingExp(int piID)
	{
		String sSQL = "SELECT le.Fletching_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getWoodcuttingExp(int piID)
	{
		String sSQL = "SELECT le.Woodcutting_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getSlayerExp(int piID)
	{
		String sSQL = "SELECT le.Slayer_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getSummoningExp(int piID)
	{
		String sSQL = "SELECT le.Summoning_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public static ResultSet getSmithingExp(int piID)
	{
		String sSQL = "SELECT le.Smithing_Exp "
				+ "FROM Level_Exp le JOIN ScUser sc "
				+ "ON le.Character_ID = sc.ID "
				+ "WHERE sc.ID = " + piID;
		
		return ExecuteQuery(sSQL);
	}
	
	public void updateAttackLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Attack = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateConstitutionLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Constitution = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateMiningLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Mining = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateStrengthLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Strength = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateDefenceLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Defence = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateFishingLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Attack = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateRangedLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Ranged = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateCookingLevl(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Cooking = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updatePrayerLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Prayer = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
	
	}
	
	public void updateFiremakingLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Firemaking = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateMagicLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Magic = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateFletchingLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Fletching = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateWoodcuttingLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Woodcutting = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateSlayerLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Slayer = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateSummoningLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Summoning = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateSmithingLevel(int piID, int piLevel)
	{
		String sSQL = "UPDATE Level "
				+ "SET Smithing = " + piLevel
				+ "WHERE Character_ID = " + piID;
		
		Execute(sSQL);
		
	}
	
	public void updateAttackExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Attack_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}
	
	public void updateConstitutionExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Constitution_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}
	
	public void updateMiningExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Mining_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}
	
	public void updateStrengthExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Strength_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}
	
	public void updateDefenceExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Defence_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}
	
	public void updateFishingExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Fishing_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}
	
	public void updateRangedExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Ranged_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}
	
	public void updateCookingExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Cooking_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}
	
	public void updatePrayerExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Prayer_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}
	
	public void updateFiremakingExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Firemaking_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}

	public void updateMagicExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Magic_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}

	public void updateFletchingExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Fletching_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}

	public void updateWoodcuttingExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Woodcutting_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}

	public void updateSlayerExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Slayer_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}

	public void updateSummoningExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Summoning_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}
	
	public void updateSmithingExp(int piID, int piExp)
	{
		String SQL = "UPDATE Level_Exp "
				+ "SET Smithing_Exp = " + piExp
				+ "WHERE Character_ID = " + piID;
		
		Execute(SQL);
	}

}