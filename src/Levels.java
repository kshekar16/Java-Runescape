import java.sql.ResultSet;


public class Levels 
{
	private static int iUserID = Lobby.getUserID();

		
	public static int getHP(ResultSet rs)
	{
		int iHP = 0;
		try
		{
			while(rs.next())
			{
				iHP = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iHP;
	}
	
	public static int getDefence(ResultSet rs)
	{
		int iDefence = 0;
		try
		{
			while(rs.next())
			{
				iDefence = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iDefence;
	}
	
	public static int getAttack(ResultSet rs)
	{
		int iAttack = 0;
		try
		{
			while(rs.next())
			{
				iAttack = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iAttack;
	}
	
	public static int getPrayer(ResultSet rs)
	{
		int iPrayer = 0;
		try
		{
			while(rs.next())
			{
				iPrayer = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iPrayer;
	}
	
	public static int getSummoning(ResultSet rs)
	{
		int iSummoning = 0;
		try
		{
			while(rs.next())
			{
				iSummoning = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iSummoning;
	}
	
	public static int getStrength(ResultSet rs)
	{
		int iStrength = 0;
		try
		{
			while(rs.next())
			{
				iStrength = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iStrength;
	}
	
	public static int getMining(ResultSet rs)
	{
		int iMining = 0;
		try
		{
			while(rs.next())
			{
				iMining = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iMining;
	}
	
	public static int getFishing(ResultSet rs)
	{
		int iFishing = 0;
		try
		{
			while(rs.next())
			{
				iFishing = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iFishing;
	}
	
	public static int getRanged(ResultSet rs)
	{
		int iRanged = 0;
		try
		{
			while(rs.next())
			{
				iRanged = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iRanged;
	}
	
	public static int getMagic(ResultSet rs)
	{
		int iMagic = 0;
		try
		{
			while(rs.next())
			{
				iMagic = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iMagic;
	}
	
	public static int getCooking(ResultSet rs)
	{
		int iCooking = 0;
		try
		{
			while(rs.next())
			{
				iCooking = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iCooking;
	}
	
	public static int getFiremaking(ResultSet rs)
	{
		int iFiremaking = 0;
		try
		{
			while(rs.next())
			{
				iFiremaking = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iFiremaking;
	}
	
	public static int getFletching(ResultSet rs)
	{
		int iFletching = 0;
		try
		{
			while(rs.next())
			{
				iFletching = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iFletching;
	}
	
	public static int getSlayer(ResultSet rs)
	{
		int iSlayer = 0;
		try
		{
			while(rs.next())
			{
				iSlayer = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iSlayer;
	}
	
	public static int getMoney(ResultSet rs)
	{
		int iMoney = 0;
		try
		{
			while(rs.next())
			{
				iMoney = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iMoney;
	}
	
	public static int getSmithing(ResultSet rs)
	{
		int iSmithing = 0;
		try
		{
			while(rs.next())
			{
				iSmithing = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iSmithing;
	}
	
	public static int getWoodcutting(ResultSet rs)
	{
		int iWoodcutting = 0;
		try
		{
			while(rs.next())
			{
				iWoodcutting = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iWoodcutting;
	}
	
	public static int getTotalLevel()
	{
		int iTotalLevel = (getHP(DBModel.getHP(iUserID)) + getDefence(DBModel.getDefence(iUserID)) + getAttack(DBModel.getAttack(iUserID)) + getPrayer(DBModel.getAttack(iUserID))
				+ getSummoning(DBModel.getSummoning(iUserID)) + getStrength(DBModel.getStrength(iUserID)) + getMining(DBModel.getMining(iUserID)) + getFishing(DBModel.getFishing(iUserID))
				+ getRanged(DBModel.getRanged(iUserID)) + getMagic(DBModel.getMagic(iUserID)) + getCooking(DBModel.getCooking(iUserID)) + getFiremaking(DBModel.getFiremaking(iUserID))
				+ getFletching(DBModel.getFletching(iUserID)) + getSlayer(DBModel.getSlayer(iUserID)) + getSmithing(DBModel.getSmithing(iUserID)) + getWoodcutting(DBModel.getWoodcutting(iUserID))) + 9;
		
		return iTotalLevel;
	}

	public static int getCombatLevel()
	{
		double dCombatLevel = ((13/10) * (((getAttack(DBModel.getAttack(iUserID)) + getStrength(DBModel.getStrength(iUserID))) + (2 * getMagic(DBModel.getMagic(iUserID))) + (2 * getRanged(DBModel.getRanged(iUserID)))) + getDefence(DBModel.getDefence(iUserID)) + getHP(DBModel.getHP(iUserID)) + (0.5 * getPrayer(DBModel.getPrayer(iUserID))) + (0.5 * getSummoning(DBModel.getSummoning(iUserID)))))/4;
		int iCombatLevel = (int) Math.round(dCombatLevel);
		
			return iCombatLevel;
		
	}
	
	public static int getExpLevel(int piLevel)
	{
		int iExp = 0;
				
		switch(piLevel)
		{
			case 1: iExp = 83;
			break;
			
			case 2: iExp = 174;
			break;
			
			case 3: iExp = 276;
			break;
			
			case 4: iExp = 388;
			break;
			
			case 5: iExp = 512;
			break;
			
			case 6: iExp = 650;
			break;
			
			case 7: iExp = 801;
			break;
			
			case 8: iExp = 969;
			break;
			
			case 9: iExp = 1154;
			break;
			
			case 10: iExp = 1358;
			break;
			
			case 11: iExp = 1584;
			break;
			
			case 12: iExp = 1833;
			break;
			
			case 13: iExp = 2107;
			break;
			
			case 14: iExp = 2411;
			break;
			
			case 15: iExp = 2746;
			break;
			
			case 16: iExp = 3115;
			break;
			
			case 17: iExp = 3523;
			break;
			
			case 18: iExp = 3973;
			break;
			
			case 19: iExp = 4470;
			break;
			
			case 20: iExp = 5018;
			break;
			
			case 21: iExp = 5624;
			break;
			
			case 22: iExp = 6291;
			break;
			
			case 23: iExp = 7028;
			break;
			
			case 24: iExp = 7842;
			break;
			
			case 25: iExp = 8740;
			break;
			
			case 26: iExp = 9730;
			break;
			
			case 27: iExp = 10824;
			break;
			
			case 28: iExp = 12031;
			
			case 29: iExp = 13363;
			break;
			
			case 30: iExp = 14833;
			break;
		}
		
		return iExp;
	}

	/*
	 * For the update thing, you want to get the current exp from this method ^ then when you kill something, aka a cow, you'll subtract this by the exp a cow gives
	 * then after you get the current exp, you'll change it in the database by using an update statement. Then you can keep calling the method getCurrentExp() and 
	 * keep repeating. Only use this method ^ when you call the checkLevelUp() method which gets the current exp, subtracts the whatever killed, and makes sure it's greater than
	 * zero. If it's less than zero then you say it's a level up, you get the level from the database, add one, then update it and then call this method ^ to get the
	 * new exp.
	 */
	
	public static int getAttackExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getConstitutionExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getMiningExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getStrengthExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getDefenceExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getFishingExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getRangedExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getCookingExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getPrayerExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getFiremakingExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getMagicExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getFletchingExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getWoodcuttingExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getSlayerExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getSummoningExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
	
	public static int getSmithingExp(ResultSet rs)
	{
		int iExp = 0;
		
		try
		{
			while(rs.next())
			{
				iExp = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return iExp;
	}
}
