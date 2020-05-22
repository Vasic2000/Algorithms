package two_way_list

class Node<E> {
    var element: E? = null
    var next: Node<E>? = null
    var previous: Node<E>? = null

    constructor()

    constructor(element: E) {
        set(element)
    }

    fun addEnd(element: E) {
        if (isNext()) {                      // если существует следующий узел, передадим ему эстафету
            next!!.addEnd(element)
        } else {                               // иначе создадим следующий узел
            next = Node(element)
        }
    }

    fun addStart(element: E) {
        if (isPrevious()) {                      // если существует предыдущий узел, передадим ему эстафету
            previous!!.addStart(element)
        } else {                               // иначе создадим предыдущий узел
            previous = Node(element)
        }
    }

    // Геттер и сеттер
    fun set(element: E) {
        this.element = element
    }

    fun get(): E? {
        return element
    }

    fun isNext(): Boolean {
        return next != null
    }

    fun isPrevious(): Boolean {
        return previous != null
    }
}


