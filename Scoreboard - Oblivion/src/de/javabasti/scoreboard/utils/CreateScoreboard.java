package de.javabasti.scoreboard.utils;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.javabasti.scoreboard.ScoreboardOblivion;
import me.clip.placeholderapi.PlaceholderAPI;
import me.stress.tokens.Tokens;
import me.stress.tokens.TokensAPI;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardScore;
import net.minecraft.server.v1_8_R3.Scoreboard;
import net.minecraft.server.v1_8_R3.ScoreboardBaseCriteria;
import net.minecraft.server.v1_8_R3.ScoreboardObjective;
import net.minecraft.server.v1_8_R3.ScoreboardScore;

public class CreateScoreboard {

	static Scoreboard sb = new Scoreboard();

	public static void updateScoreboard(Player p) {
		SetupScoreboard sm = ScoreboardOblivion.instance.setupScoreboard;
		String withoutplaceholder_rankprefix = "%luckperms_prefix%";
		String withoutplaceholder_rankprison = "%luckperms_suffix%";
		String withoutplaceholder_prestige = "%ezprestige_prestige%";
		String withoutplaceholder_balance = "%vault_eco_balance_formatted%";
		String withoutplaceholder_blocks = "%ezblocks_broken%";

		String withplaceholder_rankprefix = PlaceholderAPI.setPlaceholders(p, withoutplaceholder_rankprefix);
		String withplaceholder_rankprison = PlaceholderAPI.setPlaceholders(p, withoutplaceholder_rankprison);
		String withplaceholder_prestige = PlaceholderAPI.setPlaceholders(p, withoutplaceholder_prestige);
		String withplaceholder_balance = PlaceholderAPI.setPlaceholders(p, withoutplaceholder_balance);
		String withplaceholder_blocks = PlaceholderAPI.setPlaceholders(p, withoutplaceholder_blocks);

		String displayname = sm.getString("Displayname");
		String score1 = sm.getString("Score1").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score2 = sm.getString("Score2").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score3 = sm.getString("Score3").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score4 = sm.getString("Score4").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score5 = sm.getString("Score5").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score6 = sm.getString("Score6").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score7 = sm.getString("Score7").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score8 = sm.getString("Score8").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score9 = sm.getString("Score9").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score10 = sm.getString("Score10").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score11 = sm.getString("Score11").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score12 = sm.getString("Score12").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score13 = sm.getString("Score13").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score14 = sm.getString("Score14").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(Tokens.getInstance().getSpinManger().getSpins(p)))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);
		String score15 = sm.getString("Score15").replaceAll("%playername%", p.getName())
				.replaceAll("%serverrank%", withplaceholder_rankprefix)
				.replaceAll("%miningrank%", withplaceholder_rankprison)
				.replaceAll("%prestige%", withplaceholder_prestige).replaceAll("%balance%", withplaceholder_balance)
				.replaceAll("%tokens%", String.valueOf(withSuffix(TokensAPI.getTokens(p))))
				.replaceAll("%spins%", String.valueOf(withSuffix(Tokens.getInstance().getSpinManger().getSpins(p))))
				.replaceAll("%onlineplayers%", String.valueOf(Bukkit.getOnlinePlayers().size()))
				.replaceAll("%maxplayers%", String.valueOf(Bukkit.getMaxPlayers()))
				.replaceAll("%blocksbroken%", withplaceholder_blocks);

		boolean score1b = sm.getBoolean("Score1boolean");
		boolean score2b = sm.getBoolean("Score2boolean");
		boolean score3b = sm.getBoolean("Score3boolean");
		boolean score4b = sm.getBoolean("Score4boolean");
		boolean score5b = sm.getBoolean("Score5boolean");
		boolean score6b = sm.getBoolean("Score6boolean");
		boolean score7b = sm.getBoolean("Score7boolean");
		boolean score8b = sm.getBoolean("Score8boolean");
		boolean score9b = sm.getBoolean("Score9boolean");
		boolean score10b = sm.getBoolean("Score10boolean");
		boolean score11b = sm.getBoolean("Score11boolean");
		boolean score12b = sm.getBoolean("Score12boolean");
		boolean score13b = sm.getBoolean("Score13boolean");
		boolean score14b = sm.getBoolean("Score14boolean");
		boolean score15b = sm.getBoolean("Score15boolean");

		if (sb.getObjective("board") == null) {

			sb.registerObjective("board", new ScoreboardBaseCriteria("board"));
			ScoreboardObjective obj = sb.getObjective("board");
			obj.setDisplayName(displayname);

			ScoreboardScore s1 = new ScoreboardScore(sb, sb.getObjective("board"), score1);
			ScoreboardScore s2 = new ScoreboardScore(sb, sb.getObjective("board"), score2);
			ScoreboardScore s3 = new ScoreboardScore(sb, sb.getObjective("board"), score3);
			ScoreboardScore s4 = new ScoreboardScore(sb, sb.getObjective("board"), score4);
			ScoreboardScore s5 = new ScoreboardScore(sb, sb.getObjective("board"), score5);
			ScoreboardScore s6 = new ScoreboardScore(sb, sb.getObjective("board"), score6);
			ScoreboardScore s7 = new ScoreboardScore(sb, sb.getObjective("board"), score7);
			ScoreboardScore s8 = new ScoreboardScore(sb, sb.getObjective("board"), score8);
			ScoreboardScore s9 = new ScoreboardScore(sb, sb.getObjective("board"), score9);
			ScoreboardScore s10 = new ScoreboardScore(sb, sb.getObjective("board"), score10);
			ScoreboardScore s11 = new ScoreboardScore(sb, sb.getObjective("board"), score11);
			ScoreboardScore s12 = new ScoreboardScore(sb, sb.getObjective("board"), score12);
			ScoreboardScore s13 = new ScoreboardScore(sb, sb.getObjective("board"), score13);
			ScoreboardScore s14 = new ScoreboardScore(sb, sb.getObjective("board"), score14);
			ScoreboardScore s15 = new ScoreboardScore(sb, sb.getObjective("board"), score15);
			if (score1b) {
				s1.setScore(15);
			}
			if (score2b) {
				s2.setScore(14);
			}
			if (score3b) {
				s3.setScore(13);
			}
			if (score4b) {
				s4.setScore(12);
			}
			if (score5b) {
				s5.setScore(11);
			}
			if (score6b) {
				s6.setScore(10);
			}
			if (score7b) {
				s7.setScore(9);
			}
			if (score8b) {
				s8.setScore(8);
			}
			if (score9b) {
				s9.setScore(7);
			}
			if (score10b) {
				s10.setScore(6);
			}
			if (score11b) {
				s11.setScore(5);
			}
			if (score12b) {
				s12.setScore(4);
			}
			if (score13b) {
				s13.setScore(3);
			}
			if (score14b) {
				s14.setScore(2);
			}
			if (score15b) {
				s15.setScore(1);
			}

			sb.setDisplaySlot(0, sb.getObjective("board"));
			sb.setDisplaySlot(1, sb.getObjective("board"));

			PacketPlayOutScoreboardObjective packet = new PacketPlayOutScoreboardObjective(sb.getObjective("board"), 0);
			PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1,
					sb.getObjective("board"));

			PacketPlayOutScoreboardScore p1 = new PacketPlayOutScoreboardScore(s1);
			PacketPlayOutScoreboardScore p2 = new PacketPlayOutScoreboardScore(s2);
			PacketPlayOutScoreboardScore p3 = new PacketPlayOutScoreboardScore(s3);
			PacketPlayOutScoreboardScore p4 = new PacketPlayOutScoreboardScore(s4);
			PacketPlayOutScoreboardScore p5 = new PacketPlayOutScoreboardScore(s5);
			PacketPlayOutScoreboardScore p6 = new PacketPlayOutScoreboardScore(s6);
			PacketPlayOutScoreboardScore p7 = new PacketPlayOutScoreboardScore(s7);
			PacketPlayOutScoreboardScore p8 = new PacketPlayOutScoreboardScore(s8);
			PacketPlayOutScoreboardScore p9 = new PacketPlayOutScoreboardScore(s9);
			PacketPlayOutScoreboardScore p10 = new PacketPlayOutScoreboardScore(s10);
			PacketPlayOutScoreboardScore p11 = new PacketPlayOutScoreboardScore(s11);
			PacketPlayOutScoreboardScore p12 = new PacketPlayOutScoreboardScore(s12);
			PacketPlayOutScoreboardScore p13 = new PacketPlayOutScoreboardScore(s13);
			PacketPlayOutScoreboardScore p14 = new PacketPlayOutScoreboardScore(s14);
			PacketPlayOutScoreboardScore p15 = new PacketPlayOutScoreboardScore(s15);
			sendPacket(p, packet);
			sendPacket(p, display);
			if (score1b) {
				sendPacket(p, p1);
			}
			if (score2b) {
				sendPacket(p, p2);
			}
			if (score3b) {
				sendPacket(p, p3);
			}
			if (score4b) {
				sendPacket(p, p4);
			}
			if (score5b) {
				sendPacket(p, p5);
			}
			if (score6b) {
				sendPacket(p, p6);
			}
			if (score7b) {
				sendPacket(p, p7);
			}
			if (score8b) {
				sendPacket(p, p8);
			}
			if (score9b) {
				sendPacket(p, p9);
			}
			if (score10b) {
				sendPacket(p, p10);
			}
			if (score11b) {
				sendPacket(p, p11);
			}
			if (score12b) {
				sendPacket(p, p12);
			}
			if (score13b) {
				sendPacket(p, p13);
			}
			if (score14b) {
				sendPacket(p, p14);
			}
			if (score15b) {
				sendPacket(p, p15);
			}
		} else {

			if (sb.getObjective("board") == null) {

				sb.registerObjective("board", new ScoreboardBaseCriteria("board"));

			}

			PacketPlayOutScoreboardObjective packet1 = new PacketPlayOutScoreboardObjective(sb.getObjective("board"),
					1);

			sendPacket(p, packet1);
			ScoreboardObjective obj = sb.getObjective("board");
			obj.setDisplayName(displayname);
			ScoreboardScore s1 = new ScoreboardScore(sb, sb.getObjective("board"), score1);
			ScoreboardScore s2 = new ScoreboardScore(sb, sb.getObjective("board"), score2);
			ScoreboardScore s3 = new ScoreboardScore(sb, sb.getObjective("board"), score3);
			ScoreboardScore s4 = new ScoreboardScore(sb, sb.getObjective("board"), score4);
			ScoreboardScore s5 = new ScoreboardScore(sb, sb.getObjective("board"), score5);
			ScoreboardScore s6 = new ScoreboardScore(sb, sb.getObjective("board"), score6);
			ScoreboardScore s7 = new ScoreboardScore(sb, sb.getObjective("board"), score7);
			ScoreboardScore s8 = new ScoreboardScore(sb, sb.getObjective("board"), score8);
			ScoreboardScore s9 = new ScoreboardScore(sb, sb.getObjective("board"), score9);
			ScoreboardScore s10 = new ScoreboardScore(sb, sb.getObjective("board"), score10);
			ScoreboardScore s11 = new ScoreboardScore(sb, sb.getObjective("board"), score11);
			ScoreboardScore s12 = new ScoreboardScore(sb, sb.getObjective("board"), score12);
			ScoreboardScore s13 = new ScoreboardScore(sb, sb.getObjective("board"), score13);
			ScoreboardScore s14 = new ScoreboardScore(sb, sb.getObjective("board"), score14);
			ScoreboardScore s15 = new ScoreboardScore(sb, sb.getObjective("board"), score15);
			if (score1b) {
				s1.setScore(15);
			}
			if (score2b) {
				s2.setScore(14);
			}
			if (score3b) {
				s3.setScore(13);
			}
			if (score4b) {
				s4.setScore(12);
			}
			if (score5b) {
				s5.setScore(11);
			}
			if (score6b) {
				s6.setScore(10);
			}
			if (score7b) {
				s7.setScore(9);
			}
			if (score8b) {
				s8.setScore(8);
			}
			if (score9b) {
				s9.setScore(7);
			}
			if (score10b) {
				s10.setScore(6);
			}
			if (score11b) {
				s11.setScore(5);
			}
			if (score12b) {
				s12.setScore(4);
			}
			if (score13b) {
				s13.setScore(3);
			}
			if (score14b) {
				s14.setScore(2);
			}
			if (score15b) {
				s15.setScore(1);
			}

			sb.setDisplaySlot(0, sb.getObjective("board"));
			sb.setDisplaySlot(1, sb.getObjective("board"));

			PacketPlayOutScoreboardObjective packet = new PacketPlayOutScoreboardObjective(sb.getObjective("board"), 0);
			PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1,
					sb.getObjective("board"));

			PacketPlayOutScoreboardScore p1 = new PacketPlayOutScoreboardScore(s1);
			PacketPlayOutScoreboardScore p2 = new PacketPlayOutScoreboardScore(s2);
			PacketPlayOutScoreboardScore p3 = new PacketPlayOutScoreboardScore(s3);
			PacketPlayOutScoreboardScore p4 = new PacketPlayOutScoreboardScore(s4);
			PacketPlayOutScoreboardScore p5 = new PacketPlayOutScoreboardScore(s5);
			PacketPlayOutScoreboardScore p6 = new PacketPlayOutScoreboardScore(s6);
			PacketPlayOutScoreboardScore p7 = new PacketPlayOutScoreboardScore(s7);
			PacketPlayOutScoreboardScore p8 = new PacketPlayOutScoreboardScore(s8);
			PacketPlayOutScoreboardScore p9 = new PacketPlayOutScoreboardScore(s9);
			PacketPlayOutScoreboardScore p10 = new PacketPlayOutScoreboardScore(s10);
			PacketPlayOutScoreboardScore p11 = new PacketPlayOutScoreboardScore(s11);
			PacketPlayOutScoreboardScore p12 = new PacketPlayOutScoreboardScore(s12);
			PacketPlayOutScoreboardScore p13 = new PacketPlayOutScoreboardScore(s13);
			PacketPlayOutScoreboardScore p14 = new PacketPlayOutScoreboardScore(s14);
			PacketPlayOutScoreboardScore p15 = new PacketPlayOutScoreboardScore(s15);
			sendPacket(p, packet);
			sendPacket(p, display);
			if (score1b) {
				sendPacket(p, p1);
			}
			if (score2b) {
				sendPacket(p, p2);
			}
			if (score3b) {
				sendPacket(p, p3);
			}
			if (score4b) {
				sendPacket(p, p4);
			}
			if (score5b) {
				sendPacket(p, p5);
			}
			if (score6b) {
				sendPacket(p, p6);
			}
			if (score7b) {
				sendPacket(p, p7);
			}
			if (score8b) {
				sendPacket(p, p8);
			}
			if (score9b) {
				sendPacket(p, p9);
			}
			if (score10b) {
				sendPacket(p, p10);
			}
			if (score11b) {
				sendPacket(p, p11);
			}
			if (score12b) {
				sendPacket(p, p12);
			}
			if (score13b) {
				sendPacket(p, p13);
			}
			if (score14b) {
				sendPacket(p, p14);
			}
			if (score15b) {
				sendPacket(p, p15);
			}
		}
	}

	public static void sendPacket(Player p, Packet<?> packet) {
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
	}
	public static String withSuffix(double d) {
		if (d < 1000)
			return "" + d;
		int exp = (int) (Math.log(d) / Math.log(1000));
		return String.format("%.0f%c", Double.valueOf(d / Math.pow(1000, exp)),
				"kMBTqQsSONdUDtPpEeonVu".charAt(exp - 1));
	}
}
