package dev.kata.wordWrap

class WordWrap {
    companion object {
        fun wrap(word: String, columns: Int): String {
            val wordLongerThanTheColumnWidth = word.length > columns
            if (wordLongerThanTheColumnWidth) {
                return addLineBreacks(word, columns)
            }
            return word
        }

        private fun addLineBreacks(word: String, columns: Int):String {
            if(word.contains(" ")) {
                val replaceSpacesByLineBreaks = word.replace(" ", "\n")
                return replaceSpacesByLineBreaks
            }
            val addLineBreackInWord = word.substring(0, columns).plus("\n").plus(word.substring(columns))
            return addLineBreackInWord
        }

    }

}
