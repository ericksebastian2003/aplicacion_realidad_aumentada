package com.ericksebas03.realidadaumentadamuseo

class GetPoints {
    var totalPoints : Int = 0
    fun calculatePoints(correctAnswers : Int):Int{
        val pointsForAnswers = correct * 10
        val totalPoints = pointForAnswers + 20
        return totalPoints
    }
}