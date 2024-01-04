package net.glitch.xptobottles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class XPToBottles extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("xpconvert").setExecutor(new XPToBottlesCMDS());
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "XP > Bottles" + ChatColor.GRAY + "] " + ChatColor.GREEN + "Enabled XP To Bottles!");
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "XP > Bottles" + ChatColor.GRAY + "] " + ChatColor.RED + "Disabled XP To Bottles!");
    }
}
