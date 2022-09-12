package me.darksnakex.comandos;

import me.darksnakex.darkyplugin.MiPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comandoweb implements CommandExecutor {

    private MiPlugin plugin;

    public Comandoweb(MiPlugin plugin){
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(plugin.nombre + "Ejecuta este comando desde el cliente");
            return true;
        }
        else {
            Player jugador = (Player) commandSender;
            jugador.sendMessage(plugin.nombre+"Pagina web: No disponible por el momento");
            return false;
        }
    }
}
