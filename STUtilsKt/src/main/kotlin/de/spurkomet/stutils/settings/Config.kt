package de.spurkomet.stutils.settings

import de.spurkomet.stutils.InternalMainClass
import de.spurkomet.stutils.settings.settings.configuration
import de.spurkomet.stutils.settings.settings.dir
import de.spurkomet.stutils.settings.settings.file
import net.kyori.adventure.text.format.TextColor
import java.io.IOException


fun Config(){
    if (!dir.exists()) {
        dir.mkdirs()
    }

    if (!file.exists()){
        try {
            file.createNewFile()
        }catch (e: IOException){
            e.printStackTrace()
        }
    }

}
fun save(){
    try {
        configuration.save(file)
    }catch (e: IOException){
        e.printStackTrace()
    }
}



fun Boolean.setConf(path: String){
    InternalMainClass.INSTANCE.config.set(path, this)
}
fun Int.setConf(path: String){
    InternalMainClass.INSTANCE.config.set(path, this)
}
fun String.setConf(path: String){
    InternalMainClass.INSTANCE.config.set(path, this)
}

fun getConf(path: String, orginal: Boolean): Boolean{
    var ret: Boolean = orginal
    if (configuration.contains(path)){ret = configuration.getBoolean(path)}
    return ret
}
fun getConf(path: String, orginal: Int): Int{
    var ret: Int = orginal
    if (configuration.contains(path)){ret = configuration.getInt(path)}
    return ret
}
fun getConf(path: String, orginal: String): String{
    var ret: String? = orginal
    if (configuration.contains(path)){configuration.getString(path)}
    if (ret != null) return ret
    ret = ""
    return ret
}