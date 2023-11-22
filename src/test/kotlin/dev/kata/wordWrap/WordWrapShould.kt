package dev.kata.wordWrap

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WordWrapShould {

    // * "hola", 4 -> "hola"
    // * "hola", 2 -> "ho\nla"
    // * "hola", 3 -> "hol\na"
    // * "hola mundo", 8 -> "hola\nmundo"
    // * "hola mundo", 11 -> "hola mundo"
    // * "hola caracola de goma", 4 -> "hola\ncara\ncola\nde\ngoma"
    // casos límite
    // "", 2 -> ""
    // "hola, 0 -> Error
    // "hola     mundo", 5 -> "hola\nmundo"
    // "hola     mundo", 4 -> "hola\nmund\no"

    @Test
    fun `the same word when the columns are greater than the word length`() {
        val word: String = "hola"
        val columns: Int = 4
        val expected: String = "hola"

        assertThat(WordWrap.wrap(word, columns)).isEqualTo(expected)
    }
    @Test
    fun `the same words when the columns are greater than the word length`() {
        val word: String = "hola mundo bonito"
        val columns: Int = 20
        val expected: String = "hola mundo bonito"

        assertThat(WordWrap.wrap(word, columns)).isEqualTo(expected)
    }
    @Test
    fun `add the line break by the column width in the word`() {
        val word: String = "hola"
        val columns: Int = 2
        val expected: String = "ho\nla"

        assertThat(WordWrap.wrap(word, columns)).isEqualTo(expected)
    }
    @Test
    fun `add the line break by the column width in the word in another position`() {
        val word: String = "hola"
        val columns: Int = 3
        val expected: String = "hol\na"

        assertThat(WordWrap.wrap(word, columns)).isEqualTo(expected)
    }
    @Test
    fun `add the line break in the space if the second word does not fit in the column width`() {
        val word: String = "hola mundo"
        val columns: Int = 8
        val expected: String = "hola\nmundo"

        assertThat(WordWrap.wrap(word, columns)).isEqualTo(expected)
    }
    @Test
    fun `add the line break by the column width in the space and words`() {
        val word: String = "hola caracola de goma"
        val columns: Int = 4
        val expected: String = "hola\ncara\ncola\nde\ngoma"

        assertThat(WordWrap.wrap(word, columns)).isEqualTo(expected)
    }
}