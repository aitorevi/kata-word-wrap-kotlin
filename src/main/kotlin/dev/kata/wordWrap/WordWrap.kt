package dev.kata.wordWrap

class StringCalculator(
    private val dependency: StringCalculatorDependency,
) {
    fun execute() {
        dependency.doSomething()
    }
}

class StringCalculatorDependency {
    fun doSomething() {}
}

class WordWrap {
    companion object {
        fun wrap(word: String, columns: Int): String {
            TODO("Not yet implemented")
        }
    }

}
