package ua.kpi.comsys.ip8421_1_2

import kotlin.math.ceil

fun main(args: Array<String>){

    // Дано масив з максимально можливими оцінками
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

// Завдання 2
// Заповніть словник, де:
// - ключ – назва групи
// - значення – словник, де:
//   - ключ – студент, який відносяться до відповідної групи
//   - значення – масив з оцінками студента (заповніть масив випадковими значеннями, використовуючи функцію `randomValue(maxValue: Int) -> Int`)

    fun randomValue(maxValue: Int) : Int {
        return when((Math.random() * 6 ).toInt()){
            1 -> (ceil(maxValue.toFloat() * 0.7).toInt())
            2 -> (ceil(maxValue.toFloat() * 0.9).toInt())
            3, 4, 5 -> maxValue
            else -> 0
        }
    }

    var studentPoints = mutableMapOf<String, MutableList<MutableMap<String, MutableList<Int>>>>()

// Ваш код починається тут

    val studGroupList: List<String> = studentsStr.split("; ")


    studGroupList.forEach{
        val pointsOfStudent = mutableMapOf<String, MutableList<Int>>()
        val studentAndGroup = it.split("- ")
        val marks = mutableListOf<Int>()
        val student = studentAndGroup[0]
        val group = studentAndGroup[1]
        for(i in 1..7){
            marks.add(randomValue(points[i]))
        }
        pointsOfStudent[student] = marks

        if(!studentPoints.containsKey(group) ){
            studentPoints[group] = mutableListOf(pointsOfStudent)
        } else {
            studentPoints[group]?.add(pointsOfStudent)
        }
    }


// Ваш код закінчується тут

    println("Завдання 2")
    println(studentPoints)
    println()


}