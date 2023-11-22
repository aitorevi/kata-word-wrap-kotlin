package dev.kata.wordWrap.domain

import dev.kata.wordWrap.domain.WordWrap
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
    fun `the same word when the max length are greater than the word length`() {
        assertThat(WordWrap.execute("hola", 4)).isEqualTo("hola")
    }
    @Test
    fun `the same words when the columns are greater than the word length`() {
        val text: String = "hola mundo bonito"
        val columns: Int = 20
        val expected: String = "hola mundo bonito"

        assertThat(WordWrap.execute(text, columns)).isEqualTo(expected)
    }
    @Test
    fun `add the line break by the column width in the word`() {
        val text: String = "hola"
        val columns: Int = 2
        val expected: String = "ho\nla"

        assertThat(WordWrap.execute(text, columns)).isEqualTo(expected)
    }
    @Test
    fun `add the line break by the column width in the word in another position`() {
        val text: String = "hola"
        val columns: Int = 3
        val expected: String = "hol\na"

        assertThat(WordWrap.execute(text, columns)).isEqualTo(expected)
    }
    @Test
    fun `add the line break in the space if the second word does not fit in the column width`() {
        val text: String = "hola mundo"
        val columns: Int = 8
        val expected: String = "hola\nmundo"

        assertThat(WordWrap.execute(text, columns)).isEqualTo(expected)
    }
    @Test
    fun `add the line break by the column width in the space and words`() {
        val text: String = "hola caracola de goma"
        val columns: Int = 4
        val expected: String = "hola\ncara\ncola\nde\ngoma"

        assertThat(WordWrap.execute(text, columns)).isEqualTo(expected)
    }
    @Test
    fun `the same word becase the word is empty`() {
        val text: String = ""
        val columns: Int = 2
        val expected: String = ""

        assertThat(WordWrap.execute(text, columns)).isEqualTo(expected)
    }
}