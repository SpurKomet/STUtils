package de.spurowski.stutils

import de.spurowski.stutils.JMain.*
import net.axay.kspigot.main.KSpigot

class InternalMainClass : KSpigot() {

    companion object {
        lateinit var INSTANCE: InternalMainClass; private set
    }


    override fun load() {
        INSTANCE = this
        tOnLoad()
    }

    override fun startup() {
        tOnEnable()
    }

    override fun shutdown() {
        tOnDisable()
    }
}