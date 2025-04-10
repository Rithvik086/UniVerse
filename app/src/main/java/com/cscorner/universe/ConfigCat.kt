package com.cscorner.universe
import com.configcat.ConfigCatClient

object ConfigCat {
val configcatclient : ConfigCatClient = ConfigCatClient.get("configcat-sdk-1/93fdCBGYb0WFUDTRJeY7mw/tpDRrk1GNE2dlTw8vs4H7w"){

}
    fun isInMaintainence(): Boolean? {
        return configcatclient.getValue(Boolean::class.java, "isInMaintainence", false)
    }
}