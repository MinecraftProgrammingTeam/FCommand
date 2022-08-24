package xhuihui.mpt.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import xhuihui.mpt.FCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import java.util.ArrayList;
import java.util.Objects;

public class FC implements Listener{
    Plugin plugin = FCommand.getPlugin(FCommand.class);
    ArrayList<String> configCom = (ArrayList<String>) plugin.getConfig().getList("commands");
    @EventHandler
    public void FC(PlayerSwapHandItemsEvent swaps){
        Player player = swaps.getPlayer();
        player.sendMessage(FCommand.normal + "您按下了切换左右手的按键，正在执行指令.....");
        for (int i = 0; i < configCom.toArray().length; i++){
            String command = configCom.get(i).replace("%player%", player.getName());
            if (Objects.requireNonNull(plugin.getConfig().getString("mode")).equals("player")){
                player.performCommand(command);
            }
            else if (Objects.requireNonNull(plugin.getConfig().getString("mode")).equals("console")){
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            }
            else if (Objects.requireNonNull(plugin.getConfig().getString("mode")).equals("op")){
                player.setOp(true);
                player.performCommand(command);
                player.setOp(false);
            }
            else if (Objects.requireNonNull(plugin.getConfig().getString("mode")).equals("OP")){
                player.setOp(true);
                player.performCommand(command);
                player.setOp(false);
            }
            else {
                player.sendMessage(FCommand.normal + ChatColor.RED + "请填写正确的mode！");
            }
            if (player.isOp()){
                player.setOp(false);
            }
        }
        System.out.println(FCommand.normal + "执行完毕");

    }
}