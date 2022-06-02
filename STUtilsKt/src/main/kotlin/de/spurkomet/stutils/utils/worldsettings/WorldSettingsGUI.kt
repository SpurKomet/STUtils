package de.spurkomet.stutils.utils.worldsettings

import de.spurkomet.stutils.settings.settings.World.difficulty.hardcore
import de.spurkomet.stutils.settings.settings.World.difficulty.uHardcore
import de.spurkomet.stutils.settings.settings.World.difficulty.uuHardcore
import de.spurkomet.stutils.utils.worldsettings.difficulty.toHC
import de.spurkomet.stutils.utils.worldsettings.difficulty.toUHC
import de.spurkomet.stutils.utils.worldsettings.difficulty.toUUHC
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.gui.*

class WorldSettingsGUI {
    val settingsGUI = kSpigotGUI(GUIType.FIVE_BY_NINE) {
        title = literalText("World Settings")
        defaultPage = 0
        page(0) {
            this.placeholder(Slots.RowFive, WorldSettingsDisplayItems.fill)
            this.placeholder(Slots.RowTwo, WorldSettingsDisplayItems.fill)
            this.placeholder(Slots.RowOne, WorldSettingsDisplayItems.bottom)

            this.pageChanger(Slots.RowFourSlotOne, WorldSettingsDisplayItems.difficulty, 1)
        }
        page(1){

            this.placeholder(Slots.RowOne, WorldSettingsDisplayItems.bottom)
            this.pageChanger(Slots.RowOneSlotFive, WorldSettingsDisplayItems.settings, 0)

            this.placeholder(Slots.RowFiveSlotOne, WorldSettingsDisplayItems.hc)
            this.button(Slots.RowFourSlotOne, WorldSettingsDisplayItems.select(hardcore, "Hardcore")) {
                toHC(it.player)
                it.bukkitEvent.currentItem = WorldSettingsDisplayItems.select(hardcore, "Hardcore")
            }

            this.placeholder(Slots.RowFiveSlotTwo, WorldSettingsDisplayItems.uhc)
            this.button(Slots.RowFourSlotTwo, WorldSettingsDisplayItems.select(uHardcore, "Ultra Hardcore")) {
                toUHC(it.player)
                it.bukkitEvent.currentItem = WorldSettingsDisplayItems.select(uHardcore, "Ultra Hardcore")
            }

            this.placeholder(Slots.RowFiveSlotThree, WorldSettingsDisplayItems.uuhc)
            this.button(Slots.RowFourSlotThree, WorldSettingsDisplayItems.select(uuHardcore, "Ultra Ultra Hardcore")) {
                toUUHC(it.player)
                it.bukkitEvent.currentItem = WorldSettingsDisplayItems.select(uuHardcore, "Ultra Ultra Hardcore")
            }

        }
    }
}