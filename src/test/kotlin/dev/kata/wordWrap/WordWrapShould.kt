package dev.kata.wordWrap

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WordWrapShould {
    // "hola", 4 -> "hola"
    // "hola", 2 -> "ho\nla"
    // "hola", 3 -> "hol\na"
    // "hola mundo", 8 -> "hola\nmundo

    @Test
    fun `the same word when the columns are greater than the word length`() {
        val word = "hola"
        val columns = 4
        val expected = "hola"

        assertThat(WordWrap.wrap(word, columns)).isEqualTo(expected)
    }


    /*
    @Test
    fun `throw not implemented`() {

        val dependencyMock = mock<StringCalculatorDependency> {
            on { doSomething() }
            doThrow(NotImplementedError("Time to do some TDD..."))
        }

        assertThatExceptionOfType(NotImplementedError::class.java)
            .isThrownBy {
                StringCalculator(dependencyMock).execute()
            }.withMessage("Time to do some TDD...")
    }
    */
}
