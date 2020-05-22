package two_way_list

class TwoWayList<E> : Iterable<E> {
    private var node: Node<E> = Node()
    private var counter = 0

    fun addEnd (element: E) {
        if (counter == 0) {
            // первый узел надо обработать отдельно, иначе в первом узле элемент будет балластом
            node!!.set(element)
        } else {
            node!!.addEnd(element)
        }
        counter++ // увеличим счетчик элементов
    }

    fun addStart(element: E) {
        if (counter == 0) {
            // первый узел надо обработать отдельно, иначе в первом узле элемент будет балластом
            node!!.set(element)
        } else {
            node!!.addStart(element)
        }
        counter++ // увеличим счетчик элементов
    }

    // Размер
    fun size(): Int {
        return counter
    }

    override fun iterator(): Iterator<E> {
        return TwoWayListIterator(node!!)
    }

    // Итератор, светить наружу его тоже не хочется, он слишком специфичный.
    private inner class TwoWayListIterator
    internal constructor(private var current: Node<E>) : MutableIterator<E> {
        private var isFirst = true // первый узел надо обработать отдельно
        override fun hasNext(): Boolean {
            return if (counter == 1 && isFirst) true else current.isNext() // отдельно обработать один элемент (потому как у него нет next)
        }

        override fun next(): E {
            if (isFirst)
                isFirst = false
            else
                current = current.next!!
            return current.get()!!
        }

        override fun remove() {
            TODO("Not yet implemented")
        }
    }
}