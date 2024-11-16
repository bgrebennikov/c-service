package com.example.data.responses

data class CfgResponse(
    val configs : Map<String, Any> = mapOf(
            "zayavka2" to CfgWrap(),
            "form_zayavka" to CfgWrap(),
            "zayavka-1" to CfgWrap(),
            "zayavka-2" to CfgWrap()
        )
){

    data class CfgWrap(
        val cfg: Cfg = Cfg()
    )

    data class Cfg(
        val antispam: String = "email77",
        val antispamjs : String = "address77",
        val notify: String = "color-modal-textbox"
    )
}