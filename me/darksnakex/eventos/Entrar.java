package me.darksnakex.eventos;

import me.darksnakex.darkyplugin.MiPlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Entrar implements Listener {

    private MiPlugin plugin;

    public Entrar(MiPlugin plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void alentraralserver(PlayerJoinEvent event){
        Player jugador = event.getPlayer();
        Location l = new Location(jugador.getWorld(), 0, 0, 0, 0, 0);
        jugador.teleport(l);

        FileConfiguration config = plugin.getConfig();
        String path = "Config.mensaje-bienvenida";
        if(config.getString(path).equals("true")){
            String texto = "Config.mensaje-bienvenida-texto";
            jugador.sendMessage(ChatColor.translateAlternateColorCodes('&',config.getString(texto)).replaceAll("%player%", jugador.getName()));
        }

        return ;

    }
}
