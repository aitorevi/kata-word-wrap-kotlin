package dev.kata.wordWrap

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WordWrapShould {

    // "hola", 4 -> "hola"
    // "hola", 2 -> "ho\nla"
    // "hola", 3 -> "hol\na"
    // "hola mundo", 8 -> "hola\nmundo

    @Test
    fun `the same word when the columns are greater than the word length`() {
        val word: String = "hola"
        val columns: Int = 4
        val expected: String = "hola"

        assertThat(WordWrap.wrap(word, columns)).isEqualTo(expected)
    }
    @Test
    fun `break the word by the column width`() {
        val word: String = "hola"
        val columns: Int = 2
        val expected: String = "ho\nla"

        assertThat(WordWrap.wrap(word, columns)).isEqualTo(expected)
    }
}