package xhuihui.mpt;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import xhuihui.mpt.commands.FCReload;
import xhuihui.mpt.events.FC;

import java.util.Objects;


public class FCommand extends JavaPlugin {

    public static String normal = ChatColor.BLUE + "[FCommand] ";
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new FC(), this);
        Objects.requireNonNull(getCommand("FCReload")).setExecutor(new FCReload());
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        System.out.println(normal + "插件已启用");
    }

    @Override
    public void onDisable() {
        System.out.println(normal + "插件已卸载");
    }
}
