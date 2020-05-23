package fibonachi


fun main() {
    var number = readNumber()
    var fibonachi = getFiboArray(number)

    arrayPrint(fibonachi)
}

private fun readNumber() : Int {
    var flag = true
    var number = 0
    println("Напишите число для которого считаем Фибоначи")
    while (flag) {
        try {
            number = readLine()!!.toInt()
            flag = false
        } catch (nfe: NumberFormatException) {
            println("Нужно число!")
        }
    }
    return number
}

private fun getFiboArray(number: Int): IntArray {
    var fibo = IntArray(number)
    for (i in 0..number-1) {
        if (i == 0) {
            fibo[i] = 1
        }
        else if (i == 1) {
            fibo[i] = 1
        } else {
            fibo[i] = fibo[i - 1] + fibo[i - 2]
        }
    }
    return fibo
}

private fun arrayPrint(fibonachi: IntArray) {
    for (element in fibonachi) {
        print(element.toString() + " ")
    }
    println()
}