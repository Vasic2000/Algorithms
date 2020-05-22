package two_way_list

class VectorList<E> : Iterable<E> {
    private var node: Node<E>? = null
    private var counter = 0
    fun size(): Int {
        return counter
    }

    fun addEnd(element: E) {
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

    // пробежимся по списку определенное количество раз
    operator fun get(index: Int): E? {
        if (index >= counter) throw IndexOutOfBoundsException(Integer.toString(index) + ">=" + Integer.toString(counter - 1))
        val iterator = iterator()
        return jump(index, iterator)
    }

    // Первый способ, известно количество элементов, просто отнимем от последнего элемента индекс
    fun getLast(index: Int): E? {
        var indexLast = counter - 1
        indexLast -= index
        if (indexLast < 0) throw IndexOutOfBoundsException(Integer.toString(indexLast))
        return get(indexLast)
    }

    // Второй способ, двигаем сначало первый указатель, затем двигаем два указателя одновременно, пока первый не достигнет конца
    fun getBack(index: Int): E {
        val iterator = iterator()
        jump(index, iterator)
        return jumpBack(iterator)
    }

    override fun iterator(): Iterator<E> {
        return VectorIterator(node!!)
    }

    private fun jump(index: Int, iterator: Iterator<E>): E? {
        var result: E? = null
        for (i in 0..index) {
            if (!iterator.hasNext()) throw IndexOutOfBoundsException()
            result = iterator.next()
        }
        return result
    }

    private fun jumpBack(iterator: Iterator<E>): E {
        val backIterator = iterator()
        var result: E
        do {
            result = backIterator.next()
            if (!iterator.hasNext()) break
            iterator.next()
        } while (true)
        return result
    }

    // Узел с элементом, сделан внутренним, чтобы не светить его наружу
    inner class Node<E> internal constructor(element: E) {
        private var element: E? = null
        var next: Node<E>? = null
        private var previous: Node<E>? = null

        init {
            set(element)
        }

        fun set(element: E) {
            this.element = element
        }

        fun addEnd(element: E) {
            if (isNext()) {                      // если существует следующий узел, передадим ему эстафету
                next!!.addEnd(element)
            } else {                               // иначе создадим следующий узел
                next = Node(element)
            }
        }

        fun addStart(element: E) {
            if (isNext()) {                      // если существует следующий узел, передадим ему эстафету
                next!!.addStart(element)
            } else {                               // иначе создадим следующий узел
                next = Node(element)
            }
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

    // Итератор, светить наружу его тоже не хочется, он слишком специфичный.
    private inner class VectorIterator
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