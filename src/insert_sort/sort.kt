package insert_sort

fun main() {
    val array1 = intArrayOf(9, 6, 5, 3, 4, 8, 1)
    val array2 = intArrayOf(9, 54, 5, 35, 4, 8, -17, 1, 100, 0 , 91, 7, 99, 5, 90)

    Sort(array1)
    for (el in array1) {
        print(el.toString() + " ")
    }
    println()

    Sort(array2)
    for (el in array2) {
        print(el.toString() + " ")
    }
    println()
}

private fun Sort(array: IntArray): IntArray {
    var temp: Int
    for (i in 1 until array.size) if (array[i] < array[i - 1]) {
        var j = i
        while (j > 0) {
            while (array[j] < array[j - 1]) {
                temp = array[j - 1]
                array[j - 1] = array[j]
                array[j] = temp
            }
            j--
        }
    }
    return array
}