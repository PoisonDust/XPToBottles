package net.glitch.xptobottles;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class XPToBottlesCMDS implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("xpconvert")){
            if (sender instanceof Player) {
                if (p.hasPermission("convertxp.use")) {
                    if (p.getLevel() > 0) {

                        int xp = Integer.valueOf(p.getLevel());

                        ItemStack item = new ItemStack(Material.EXPERIENCE_BOTTLE, xp);
                        HashMap<Integer, ItemStack> remainingxp = p.getInventory().addItem(item);

                        if (!remainingxp.isEmpty()) {
                            for (ItemStack xpbottle : remainingxp.values()) {
                                p.getWorld().dropItem(p.getLocation(), xpbottle);
                            }
                        }
                        p.setExp(0);
                        p.setLevel(0);
                    } else {
                        p.sendMessage(ChatColor.RED + "You must have over 1 level to convert your XP levels into bottles!");
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "You do not have the required permission to run this command!");
                }
            }
        }
        return true;
    }
}
