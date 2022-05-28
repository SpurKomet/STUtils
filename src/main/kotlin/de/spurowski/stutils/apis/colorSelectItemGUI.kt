package de.spurowski.stutils.utils.timer

import de.spurowski.stutils.colors
import de.spurowski.stutils.settings.settings
import net.axay.kspigot.chat.col
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.items.flag
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta
import net.axay.kspigot.items.name
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack


fun colorSelectItem(targetColor: String, currentColor: String = "", itemName: String = targetColor): ItemStack =
    when(targetColor.lowercase()) {
        "black" -> itemStack(Material.BLACK_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName")}}
        "dark_blue" -> itemStack(Material.BLUE_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "dark_green" -> itemStack(Material.GREEN_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "dark_aqua" -> itemStack(Material.CYAN_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "dark_red" -> itemStack(Material.RED_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "dark_purple" -> itemStack(Material.PURPLE_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "gold" -> itemStack(Material.ORANGE_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "gray" -> itemStack(Material.LIGHT_GRAY_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "dark_gray" -> itemStack(Material.GRAY_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "blue" -> itemStack(Material.LIGHT_BLUE_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "green" -> itemStack(Material.LIME_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "aqua" -> itemStack(Material.CYAN_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "red" -> itemStack(Material.RED_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "light_purple" -> itemStack(Material.PINK_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "yellow" -> itemStack(Material.YELLOW_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        "white" -> itemStack(Material.WHITE_CONCRETE){if (targetColor.lowercase() == currentColor.lowercase()) addEnchantment(Enchantment.DURABILITY, 1); meta {name = literalText("${col(targetColor)}$itemName"); flag(ItemFlag.HIDE_ENCHANTS) }}
        else -> itemStack(Material.RED_STAINED_GLASS_PANE){meta {name = literalText("${colors["error"]}wrong Color") }}
    }