package me.darksnakex.comandos;

import me.darksnakex.darkyplugin.MiPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comandoprincipal implements CommandExecutor {

    private final MiPlugin plugin;

    public Comandoprincipal(MiPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("version")) {
                    Bukkit.getConsoleSender().sendMessage(plugin.nombre + "Version: " + plugin.version + " - Hecho por: DarkSnakeX" );
                    return true;
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    plugin.registerConfig();
                    Bukkit.getConsoleSender().sendMessage(plugin.nombre + "Configuracion recargada ");
                    return true;
                }
                if (args[0].equalsIgnoreCase("spawn")) {
                    Bukkit.getConsoleSender().sendMessage(plugin.nombre + "Este comando solo se puede usar dentro del cliente");
                    return true;
                }
            } else {
                Bukkit.getConsoleSender().sendMessage(plugin.nombre + "Usa /darky version/reload/spawn");
                return true;
            }
            Bukkit.getConsoleSender().sendMessage(plugin.nombre + "Comando de /darky no identificado");
            return true;


        } else {


            Player jugador = (Player) commandSender;
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("version")) {
                    jugador.sendMessage(plugin.nombre + "Version: " + plugin.version);
                    return true;
                } else if (args[0].equalsIgnoreCase("spawn")) {
                    Location l = new Location(jugador.getWorld(), 0, 0, 0, 0, 0);
                    jugador.teleport(l);
                    return true;
                } else if (args[0].equalsIgnoreCase("reload")) {
                    plugin.reloadConfig();
                    jugador.sendMessage(plugin.nombre + "Configuracion recargada");
                    return true;

                } else {
                    jugador.sendMessage(plugin.nombre + "Ese comando no existe");
                    return true;
                }
            } else {
                jugador.sendMessage(plugin.nombre + "Usa /darky version/spawn/reload");
                return true;
            }

        }
    }
    }


