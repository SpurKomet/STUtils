package de.spurowski.stutils.commands;

import de.spurowski.stutils.JMain;
import de.spurowski.stutils.util.Reset;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class ResetCommand implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender,  Command command,  String label,  String[] args) {
        Bukkit.getOnlinePlayers().forEach(player -> player.kickPlayer("§9Reset von §8" + sender + " ausgeführt"));
        JMain.getInstance().getConfig().set("isReset", true);
        JMain.getInstance().saveConfig();
        Bukkit.spigot().restart();
        return false;
    }
}
