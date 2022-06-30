package com.ayou.springboot.minecraft;

import com.ayou.springboot.application.Application;
import dev.alangomes.springspigot.SpringSpigotBootstrapper;
import org.bukkit.plugin.java.JavaPlugin;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ExecutionException;

public final class SpringBootPluginTemplate extends JavaPlugin{
    private ConfigurableApplicationContext context;

    @Override
    public void onEnable() {
        try {
            context = SpringSpigotBootstrapper.initialize(this, Application.class);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        try {
            if (context != null){
                context.close();
            }
        }finally {
            context = null;
        }
    }
}
