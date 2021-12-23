package com.github.ozmt.damage_to_death;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class DamageToDeath extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("プラグインが有効になったよ");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("プラグインが無効になったよ");
    }

    @EventHandler
    public void playerDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if(!(entity instanceof Player)) return;
        event.setCancelled(true);
        getServer().getOnlinePlayers().forEach(p -> p.setHealth(0));
    }

    @EventHandler
    public void setDeathMessage(PlayerDeathEvent event) {
        event.setDeathMessage("You died");
    }
}

