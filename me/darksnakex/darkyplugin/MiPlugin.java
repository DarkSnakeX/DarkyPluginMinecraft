package me.darksnakex.darkyplugin;


import me.darksnakex.comandos.Comandoprincipal;
import me.darksnakex.comandos.Comandoweb;
import me.darksnakex.eventos.Entrar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public class MiPlugin extends JavaPlugin {

    public String rutaConfig;
    PluginDescriptionFile pdffile = getDescription();
    public String version = pdffile.getVersion();
    public String nombre = ChatColor.YELLOW+"["+ChatColor.BLUE+pdffile.getName()+ChatColor.YELLOW+"] ";

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("Darkyplugin ha sido activado con exito");
        registrosdecomandos();
        registrareventos();
        registerConfig();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Darkyplugin ha sido desactivado con exito");
    }

    public void registrosdecomandos(){
        this.getCommand("web").setExecutor(new Comandoweb(this));
        this.getCommand("darky").setExecutor(new Comandoprincipal(this));
    }

    public void registrareventos(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Entrar(this), this);
    }

    public void registerConfig(){
        File config = new File(this.getDataFolder(),"config.yml");
        rutaConfig = config.getPath();
        if(!config.exists()){
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }

}
