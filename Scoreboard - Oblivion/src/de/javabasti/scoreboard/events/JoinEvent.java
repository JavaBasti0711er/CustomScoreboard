package de.javabasti.scoreboard.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.javabasti.scoreboard.ScoreboardOblivion;
import de.javabasti.scoreboard.utils.CreateScoreboard;
import de.javabasti.scoreboard.utils.SetupScoreboard;

public class JoinEvent implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		SetupScoreboard sm = ScoreboardOblivion.instance.setupScoreboard;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(ScoreboardOblivion.getInstance(), new Runnable() {
			@Override
			public void run() {
				sm.load();
				CreateScoreboard.updateScoreboard(p);
			}
		}, 0, 40L);
	}

}
