package dev.kata.wordWrap

class WordWrap {
    companion object {
        fun wrap(word: String, columns: Int): String {
            val wordLongerThanTheColumnWidth = word.length > columns
            if (wordLongerThanTheColumnWidth) {
                val wordWithLineBreack = addLineBreacks(word, columns)
                return wordWithLineBreack
            }
            return word
        }

        private fun addLineBreacks(word: String, columns: Int) =
            word.substring(0, columns).plus("\n").plus(word.substring(columns))
    }

}
