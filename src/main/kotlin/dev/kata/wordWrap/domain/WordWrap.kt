package dev.kata.wordWrap.domain

class WordWrap {
    companion object {
        fun execute(text: String, columns: Int): String {
            val wordLongerThanTheColumnWidth = text.length > columns
            if (wordLongerThanTheColumnWidth) {
                return addLineBreaks(text, columns)
            }
            return text
        }

        private fun addLineBreaks(text: String, columns: Int): String {
            var wordWrapped = ""
            var restOfWord = text

            while (restOfWord.isNotEmpty()) {
                if (restOfWord.length <= columns) {
                    wordWrapped = wordWrapped.plus(restOfWord)
                    restOfWord = ""
                } else {
                    var positionWrap = restOfWord.lastIndexOf(' ', columns)
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
