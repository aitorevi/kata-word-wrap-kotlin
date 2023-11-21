package dev.kata.wordWrap

class WordWrap {
    companion object {
        fun wrap(word: String, columns: Int): String {
            if (word.length > columns) {
                val wordWithLineBreack = word.substring(0,2).plus("\n").plus(word.substring(2))
                return wordWithLineBreack
            }
            return word
        }
    }

}
