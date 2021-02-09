package ua.kpi.comsys.ip8421_1_2

fun main(args: Array<String>){
    // Частина 1

// Дано рядок у форматі "Student1 - Group1; Student2 - Group2; ..."

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

// Завдання 1
// Заповніть словник, де:
// - ключ – назва групи
// - значення – відсортований масив студентів, які відносяться до відповідної групи
    val studentsGroups = mutableMapOf<String, MutableList<String>>()

// Ваш код починається тут

    val studGroupList: List<String> = studentsStr.split("; ")

    studGroupList.forEach{
        val studentAndGroup = it.split("- ")
        if(!studentsGroups.containsKey(studentAndGroup[1]) ){
            studentsGroups[studentAndGroup[1]] = mutableListOf(studentAndGroup[0])
        } else {
            studentsGroups[studentAndGroup[1]]?.add(studentAndGroup[0])
        }
    }
    studentsGroups.forEach{
        it.value.sort()
    }

// Ваш код закінчується тут

    println("Завдання 1")
    println(studentsGroups)
    println()

}