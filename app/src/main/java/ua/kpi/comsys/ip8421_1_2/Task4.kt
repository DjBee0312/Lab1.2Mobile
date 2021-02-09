package ua.kpi.comsys.ip8421_1_2

import kotlin.math.ceil

fun main(args: Array<String>){
    // Завдання 4
// Заповніть словник, де:
// - ключ – назва групи
// - значення – середня оцінка всіх студентів групи

    var groupAvg =  mutableMapOf<String, Float>()

// Ваш код починається тут
    var sumPoints = mutableMapOf<String, MutableList<MutableMap<String, Int>>>()

    var points: IntArray = intArrayOf(12, 12, 12, 12, 12, 12, 12, 16)

    var studentsStr = "Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; Лесик Сергій - ІО-82;" +
            " Ткаченко Ярослав - ІВ-83; Аверкова Анастасія - ІО-83; Соловйов Даніїл - ІО-83;" +
            " Рахуба Вероніка - ІО-81; Кочерук Давид - ІВ-83; Лихацька Юлія - ІВ-82;" +
            " Головенець Руслан - ІВ-83; Ющенко Андрій - ІО-82; Мінченко Володимир - ІП-83;" +
            " Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81; Снігурець Олег - ІВ-81;" +
            " Роман Олександр - ІО-82; Дудка Максим - ІО-81; Кулініч Віталій - ІВ-81;" +
            " Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; Іванов Володимир - ІО-81;" +
            " Востриков Нікіта - ІО-82; Бондаренко Максим - ІВ-83; Скрипченко Володимир - ІВ-82;" +
            " Кобук Назар - ІО-81; Дровнін Павло - ІВ-83; Тарасенко Юлія - ІО-82;" +
            " Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; Крамар Віктор - ІО-83;" +
            " Іванов Дмитро - ІВ-82"


    fun randomValue(maxValue: Int) : Int {
        return when((Math.random() * 6 ).toInt()){
            1 -> (ceil(maxValue.toFloat() * 0.7).toInt())
            2 -> (ceil(maxValue.toFloat() * 0.9).toInt())
            3, 4, 5 -> maxValue
            else -> 0
        }
    }


    val studGroupList: List<String> = studentsStr.split("; ")


    studGroupList.forEach{
        val pointsOfStudent = mutableMapOf<String, Int>()
        val studentAndGroup = it.split("- ")
        val marks = mutableListOf<Int>()
        val student = studentAndGroup[0]
        val group = studentAndGroup[1]
        for(i in 1..7){
            marks.add(randomValue(points[i]))
        }
        pointsOfStudent[student] = marks.sum()

        if(!sumPoints.containsKey(group) ){
            sumPoints[group] = mutableListOf(pointsOfStudent)
        } else {
            sumPoints[group]?.add(pointsOfStudent)
        }
    }
    sumPoints.forEach {
        var sum = 0f
        var avg = 0f
        var counter = 0f
        it.value.forEach {
            counter++
            sum += it.values.sum()
        }
        avg = (sum / counter)
        groupAvg[it.key] = avg
    }



// Ваш код закінчується тут

    println("Завдання 4")
    println(groupAvg)
    println()
}