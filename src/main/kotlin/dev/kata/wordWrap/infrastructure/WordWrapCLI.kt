import dev.kata.wordWrap.domain.WordWrap
import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    println("Ingrese el texto:")
    val text: String = scanner.nextLine()

    println("Ingrese el número de columnas")
    val columns = scanner.nextInt()

    val wordWrapped = WordWrap.execute(text, columns)
    println(wordWrapped)
}
