package com.ericksebas03.realidadaumentadamuseo

class GetPoints {
    var totalPoints : Int = 0
    fun calculatePoints(correctAnswers : Int):Int{
        val pointsForAnswers = correctAnswers * 10
        val totalPoints = pointsForAnswers + 20
        return totalPoints
    }
}