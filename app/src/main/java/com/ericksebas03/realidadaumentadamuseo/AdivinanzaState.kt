package com.ericksebas03.realidadaumentadamuseo

object AdivinanzaState {
    var adivinanzaActiva: Int = 0 // Indica cuál adivinanza está activa (1 a 8)

    // Puedes agregar más variables si necesitas almacenar información adicional
    val respuestasCorrectas = mapOf(
        1 to "webos",
        2 to "sol",
        3 to "cielo",
        4 to "rio",
        5 to "montaña",
        6 to "estrella",
        7 to "arbol",
        8 to "mar"
    )
}
