package de.spurowski.stutils.utils.timer

import de.spurowski.stutils.colors
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import de.spurowski.stutils.settings.settings.timer.time.h
import de.spurowski.stutils.settings.settings.timer.time.min
import de.spurowski.stutils.settings.settings.timer.time.sec
import de.spurowski.stutils.settings.settings.timer.timer
import de.spurowski.stutils.settings.settings.timer.countdown
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.items.*


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
            meta {
                name = literalText("${colors["value"]}Countdown ${colors["default"]}[${
                    if (countdown) {
                        "${colors["enable"]}aktiv"
                    } else {
                        "${colors["disable"]}inaktiv"
                    }
                }${colors["default"]}]")
            }
        }
    }
    fun timer(): ItemStack {
        return itemStack(Material.CLOCK) {
            amount = 1
            meta {
                name = literalText("${colors["value"]}Timer${colors["default"]} [${
                    if (timer) {
                        "${colors["enable"]}aktiv"
                    } else {
                        "${colors["disable"]}inaktiv"
                    }
                }${colors["default"]}]")
            }
        }
    }
    val fill = itemStack(Material.GRAY_STAINED_GLASS_PANE){amount = 1; meta { name = literalText("") }}
    val back = itemStack(Material.MAGENTA_GLAZED_TERRACOTTA){amount = 1; meta { name = literalText("${colors["default"]}back") }}
}