package de.spurkomet.stutils

import de.spurowski.stutils.Listener
import de.spurkomet.stutils.settings.Config
import de.spurkomet.stutils.settings.save
import de.spurkomet.stutils.settings.settings
import de.spurkomet.stutils.utils.Commands
import de.spurkomet.stutils.utils.worldsettings.worldListener
import net.axay.kspigot.main.KSpigot

class InternalMainClass : KSpigot() {

    companion object {
        lateinit var INSTANCE: InternalMainClass; private set
    }


    override fun load() {
        INSTANCE = this
        var config = Config()
        settings.load()
    }

    override fun startup() {
        setGets()
        Listener()
        Commands()
        worldListener()
    }

    override fun shutdown() {
        save()
        settings.save()
    }
}