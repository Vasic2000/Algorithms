package two_way_list

fun main() {
    val twoWayList: TwoWayList<Int> = TwoWayList()
    twoWayList.addEnd(1)
    twoWayList.addEnd(4)
    twoWayList.addEnd(6)
    twoWayList.addEnd(4)
    twoWayList.addStart(5)

    for(t2 in twoWayList) {
        println(t2)
    }


//    System.out.println(vectorList.get(0))
//    System.out.println(vectorList.get(1))
//    System.out.println(vectorList.get(2))
//    System.out.println(vectorList.get(3))
//    System.out.println(vectorList.get(4))
//
//    System.out.println(vectorList.getLast(0))
//    System.out.println(vectorList.getLast(1))
//    System.out.println(vectorList.getLast(2))
//    System.out.println(vectorList.getLast(3))
//    System.out.println(vectorList.getBack(0))
//    System.out.println(vectorList.getBack(1))
//    System.out.println(vectorList.getBack(2))
//    System.out.println(vectorList.getBack(3))
}
