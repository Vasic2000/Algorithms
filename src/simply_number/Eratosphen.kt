package simply_number

fun main() {
    var number = readNumber()
    var simplyNumbersArray = getSimplyNumbers(number)
    arrayPrint(simplyNumbersArray)
}


private fun readNumber() : Int {
    var flag = true
    var number = 0
    println("Напишите число до которого считаем простые числа")
    while (flag) {
        try {
            number = readLine()!!.toInt()
            if(number < 2) throw java.lang.NumberFormatException()
            flag = false
        } catch (nfe: NumberFormatException) {
            println("Нужно число >= 2!")
        }
    }
    return number
}

fun getSimplyNumbers(number: Int): IntArray {
    var simply : ArrayList<Int> = ArrayList()
    for(i in 2..number-1) {
        if(checkNumber(i))
            simply.add(i)
    }
    return simply.toIntArray()
}

fun checkNumber(i: Int): Boolean {
    if(i==2) return true
    var maxDivider = maxDivider(i)
    for(j in 2..maxDivider) {
        if(i%j == 0) return false
    }
    return true
}

private fun maxDivider(number: Int) : Int  {
    var divider = 0
    while (divider * divider < number) {
        divider++
    }
    return divider
}

private fun arrayPrint(simplyNumbersArray: IntArray) {
    for (element in simplyNumbersArray) {
        print(element.toString() + " ")
    }
    println()
}