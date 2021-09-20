package com.prince.discordsync;

import com.prince.discordsync.api.BaseDiscordSync;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;

import java.util.logging.Logger;

public class DiscordSync extends BaseDiscordSync {

    private Logger logger;
    private DiscordSync plugin;

    @Override
    public void onEnable(){
        plugin = this;
        logger = getLogger();

        //Register Class Instance for API
        getServer().getServicesManager().register(BaseDiscordSync.class,this,this, ServicePriority.Highest);
        logger.info("[Discord Sync] Initialized API");
    }

    @Override
    public void onDisable(){
        getServer().getServicesManager().unregisterAll(this);
        Bukkit.getScheduler().cancelTasks(this);
    }

}
