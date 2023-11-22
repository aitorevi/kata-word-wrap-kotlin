package dev.kata.wordWrap

class WordWrap {
    companion object {
        fun wrap(word: String, columns: Int): String {
            val wordLongerThanTheColumnWidth = word.length > columns
            if (wordLongerThanTheColumnWidth || word.isNotEmpty()) {
                return addLineBreaks(word, columns)
            }
            return word
        }

        private fun addLineBreaks(word: String, columns: Int): String {
            var wordWrapped = ""
            var restOfWord = word

            val wordIsNotEmpty = restOfWord.isNotEmpty()
            while (wordIsNotEmpty) {
                if (restOfWord.length <= columns) {
                    wordWrapped = wordWrapped.plus(restOfWord)
                    restOfWord = ""
                } else {
                    val lastSpaceInColumWidth = restOfWord.lastIndexOf(' ', columns)
                    var positionWrap = lastSpaceInColumWidth

                    val notSpacesInColumnWidth = positionWrap == -1
                    if (notSpacesInColumnWidth) {
                        positionWrap = columns
                    }
                    wordWrapped = wordWrapped.plus(restOfWord.substring(0, positionWrap).plus("\n"))
                    restOfWord = restOfWord.substring(positionWrap).trim()
                }
            }
            return wordWrapped
        }
    }
}
