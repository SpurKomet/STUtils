package de.spurowski.stutils.utils.timer

import de.spurowski.stutils.colors
import net.axay.kspigot.chat.col
import net.axay.kspigot.gui.Slots
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import de.spurowski.stutils.settings.settings.timer.time.h
import de.spurowski.stutils.settings.settings.timer.time.min
import de.spurowski.stutils.settings.settings.timer.time.sec
import de.spurowski.stutils.settings.settings.timer.timer
import de.spurowski.stutils.settings.settings.timer.countdown
import net.axay.kspigot.items.*
import org.bukkit.inventory.ItemFlag


object TimerDisplayItems {
    fun h(): ItemStack {
        return itemStack(Material.COMPASS) {
            amount = if (h == 0) 1 else h
            meta {
                name = Component.text("${colors.get("value")}$h ${colors.get("default")}Stunden")
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
                name = Component.text("${colors.get("value")}$min ${colors.get("default")}Minuten")
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
                name = Component.text("${colors.get("value")}$sec ${colors.get("default")}Sekunden")
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
            meta {
                name = Component.text("${colors.get("value")}Countdown ${colors.get("default")}[${
                    if (countdown) {
                        "${colors.get("enable")}aktiv"
                    } else {
                        "${colors.get("disable")}inaktiv"
                    }
                }${colors.get("default")}]")
            }
        }
    }
    fun timer(): ItemStack {
        return itemStack(Material.CLOCK) {
            amount = 1
            meta {
                name = Component.text("${colors.get("value")}Timer${colors.get("default")} [${
                    if (timer) {
                        "${colors.get("enable")}aktiv"
                    } else {
                        "${colors.get("disable")}inaktiv"
                    }
                }${colors.get("default")}]")
            }
        }
    }
    val fill = itemStack(Material.GRAY_STAINED_GLASS_PANE){amount = 1; meta { name = Component.text(""); flag(ItemFlag.HIDE_ATTRIBUTES)}}
}