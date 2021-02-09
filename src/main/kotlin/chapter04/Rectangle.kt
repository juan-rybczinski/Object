package chapter04

class Rectangle(
    private val left: Int,
    private val top: Int,
    private var right: Int,
    private var bottom: Int
) {
    fun enlarge(multiple: Int) {
        right *= multiple
        bottom *= multiple
    }
}