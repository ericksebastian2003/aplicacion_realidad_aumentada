package com.ericksebas03.realidadaumentadamuseo

object AdivinanzaState {
    var adivinanzaActiva: Int = 0 // Indica cuál adivinanza está activa (1 a 8)

    // Puedes agregar más variables si necesitas almacenar información adicional
    val respuestasCorrectas = mapOf(
        1 to "trex",
        2 to "mamut lanudo",
        3 to "tortuga de galapagos",
        4 to "Oso de anteojos",
        5 to "amazonas",
        6 to "anaconda",
        7 to "agua",
        8 to "basura"
    )
}
