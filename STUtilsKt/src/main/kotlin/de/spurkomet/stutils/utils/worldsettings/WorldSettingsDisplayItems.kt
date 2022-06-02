package de.spurkomet.stutils.utils.worldsettings

import de.spurkomet.stutils.colors
import net.axay.kspigot.chat.col
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.items.*
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

object WorldSettingsDisplayItems{
    val fill = itemStack(Material.GRAY_STAINED_GLASS_PANE){amount = 1; meta { name = literalText("") }}
    val bottom = itemStack(Material.BROWN_STAINED_GLASS_PANE){amount = 1; meta { name = literalText("") }}

    val settings = itemStack(Material.COMMAND_BLOCK_MINECART){amount = 1; meta { name = literalText("${colors["value"]}Settings <-") }}
    val back = itemStack(Material.MAGENTA_GLAZED_TERRACOTTA){amount = 1; meta { name = literalText("${colors["default"]}previous Page") }}
    val next = itemStack(Material.MAGENTA_GLAZED_TERRACOTTA){amount = 1; meta { name = literalText("${colors["default"]}next Page") }}

    val difficulty = itemStack(Material.STONE_SWORD){amount = 1; meta { name = literalText("${colors["value"]}Difficulties")}}
    val hc = itemStack(Material.DIAMOND_SWORD){
        amount = 1
        meta {
            name = literalText("${colors["value"]}Hardcore")
            addLore {
            +"${colors["default"]}No Respawn"
            }
            flag(ItemFlag.HIDE_ATTRIBUTES)
        }
    }
    val uhc = itemStack(Material.GOLDEN_APPLE){
        amount = 1
        meta {
            name = literalText("${colors["value"]}Ultra Hardcore")
            addLore {
                +"${colors["default"]}No natural Regeneration"
                +"${colors["default"]}${col("italic")}Healing only by Soups or Gaps"
            }
        }
    }
    val uuhc = itemStack(Material.ENCHANTED_GOLDEN_APPLE){
        amount = 1
        meta {
            name = literalText("${colors["value"]}Ultra Ultra Hardcore")
            addLore {
                +"${colors["default"]}No Regeneration"
            }
        }
    }


    fun select(option: Boolean, optionName: String = ""): ItemStack{
        val itemName = if(optionName != "") "${colors["value"]}$optionName ${colors["default"]}ist " else ""
        if (option){
            return itemStack(Material.LIME_STAINED_GLASS_PANE){amount = 1; meta{ name = literalText("${itemName}${colors["enable"]}aktiv")}}
        }
        return itemStack(Material.RED_STAINED_GLASS_PANE){amount = 1; meta{ name = literalText("${itemName}${colors["disable"]}inaktiv")}}
    }
}