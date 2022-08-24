package xhuihui.mpt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import xhuihui.mpt.FCommand;

public class FCReload implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!sender.isOp()){
            sender.sendMessage(FCommand.normal + "您还不是op，无法执行此指令");
            return false;
        }
        Plugin plugin = FCommand.getPlugin(FCommand.class);
        plugin.reloadConfig();
        sender.sendMessage(FCommand.normal + "已重载config.yml文件");
        return false;
    }
}
