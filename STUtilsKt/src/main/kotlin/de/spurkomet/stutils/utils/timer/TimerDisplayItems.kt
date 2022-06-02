package de.spurkomet.stutils.utils.timer

import de.spurkomet.stutils.colors
import de.spurkomet.stutils.settings.settings
import de.spurkomet.stutils.settings.settings.timer.challenges.bob
import de.spurkomet.stutils.settings.settings.timer.challenges.enderDragon
import de.spurkomet.stutils.settings.settings.timer.challenges.wither
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import de.spurkomet.stutils.settings.settings.timer.time.h
import de.spurkomet.stutils.settings.settings.timer.time.min
import de.spurkomet.stutils.settings.settings.timer.time.sec
import de.spurkomet.stutils.settings.settings.timer.timer
import de.spurkomet.stutils.settings.settings.timer.countdown
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.data.nbtData
import net.axay.kspigot.items.*
import org.bukkit.craftbukkit.v1_18_R1.util.CraftMagicNumbers
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag


object TimerDisplayItems {
    fun h(): ItemStack {
        return itemStack(Material.COMPASS) {
            amount = if (h == 0) 1 else h
            meta {
                name = literalText("${colors["value"]}$h ${colors["default"]}Stunden")
                addLore {
                    +"Left Click to Up"
                    +"Right Click to Down"
                }
            }
        }
    }
    fun min(): ItemStack {
        return itemStack(Material.COMPASS) {
            amount = if (min == 0) 1 else min
            meta {
                name = literalText("${colors["value"]}$min ${colors["default"]}Minuten")
                addLore {
                    +"Left Click to Up"
                    +"Right Click to Down"
                }
            }
        }
    }
    fun sec(): ItemStack {
        return itemStack(Material.COMPASS) {
            amount = if (sec == 0) 1 else sec
            meta {
                name = literalText("${colors["value"]}$sec ${colors["default"]}Sekunden")
                addLore {
                    +"Left Click to Up"
                    +"Right Click to Down"
                }
            }
        }
    }
    fun countdown(): ItemStack {
        return itemStack(Material.COMMAND_BLOCK) {
            amount = 1
            if (countdown){
                addUnsafeEnchantment(Enchantment.DURABILITY, 1)
            }
            meta {
                name = literalText("${colors["value"]}Countdown ${colors["default"]}[${
                    if (countdown) {
                        "${colors["enable"]}aktiv"
                    } else {
                        "${colors["disable"]}inaktiv"
                    }
                }${colors["default"]}]")
                flag(ItemFlag.HIDE_ENCHANTS)
            }
        }
    }
    fun timer(): ItemStack {
        return itemStack(Material.CLOCK) {
            amount = 1
            if (timer){
                addUnsafeEnchantment(Enchantment.DURABILITY, 1)
            }
            meta {
                name = literalText("${colors["value"]}Timer${colors["default"]} [${
                    if (timer) {
                        "${colors["enable"]}aktiv"
                    } else {
                        "${colors["disable"]}inaktiv"
                    }
                }${colors["default"]}]")
                flag(ItemFlag.HIDE_ENCHANTS)
            }
        }
    }

    fun enderdragon(): ItemStack = itemStack(Material.DRAGON_EGG){
        amount = 1
        if (enderDragon){
            addUnsafeEnchantment(Enchantment.DURABILITY, 1)
        }
        meta {
            name = literalText("${colors["value"]}Enderdragon Kill${colors["default"]} [${
                if (enderDragon) {
                    "${colors["enable"]}aktiv"
                } else {
                    "${colors["disable"]}inaktiv"
                }
            }${colors["default"]}]")
            flag(ItemFlag.HIDE_ENCHANTS)
        }

    }
    fun bob(): ItemStack = itemStack(Material.SPONGE){
        amount = 1
        if (bob){
            addUnsafeEnchantment(Enchantment.DURABILITY, 1)
        }
        meta {
            name = literalText("${colors["value"]}Bob (Elder Guardian) Kill${colors["default"]} [${
                if (bob) {
                    "${colors["enable"]}aktiv"
                } else {
                    "${colors["disable"]}inaktiv"
                }
            }${colors["default"]}]")
            flag(ItemFlag.HIDE_ENCHANTS)
        }

    }
    fun wither(): ItemStack = itemStack(Material.WITHER_ROSE){
        amount = 1
        if (wither){
            addUnsafeEnchantment(Enchantment.DURABILITY, 1)
        }
        meta {
            name = literalText("${colors["value"]}Wither Kill${colors["default"]} [${
                if (wither) {
                    "${colors["enable"]}aktiv"
                } else {
                    "${colors["disable"]}inaktiv"
                }
            }${colors["default"]}]")
            flag(ItemFlag.HIDE_ENCHANTS)
        }

    }



    val fill = itemStack(Material.GRAY_STAINED_GLASS_PANE){amount = 1; meta { name = literalText("") }}
    val line = itemStack(Material.BLACK_STAINED_GLASS_PANE){amount = 1; meta { name = literalText("") }}
    val back = itemStack(Material.MAGENTA_GLAZED_TERRACOTTA){amount = 1; meta { name = literalText("${colors["default"]}back") }}
}