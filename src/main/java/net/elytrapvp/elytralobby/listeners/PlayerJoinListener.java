package net.elytrapvp.elytralobby.listeners;

import net.elytrapvp.elytralobby.ElytraLobby;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {
    private final ElytraLobby plugin;

    public PlayerJoinListener(ElytraLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Play the lobby music.
        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                if(player == null || !Bukkit.getOnlinePlayers().contains(player)) {
                    Bukkit.getScheduler().cancelTask(getTaskId());
                    return;
                }

                player.playSound(player.getLocation(), Sound.MUSIC_DISC_STRAD, 500, 1);
            }
        };

        runnable.runTaskTimer(plugin, 0, 3780);
    }
}
