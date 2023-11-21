package dev.kata.wordWrap

class WordWrap {
    companion object {
        fun wrap(word: String, columns: Int): String {
            if (word.length > columns) {
                val wordWithLineBreack = word.substring(0,columns).plus("\n").plus(word.substring(columns))
                return wordWithLineBreack
            }
            return word
        }
    }

}
