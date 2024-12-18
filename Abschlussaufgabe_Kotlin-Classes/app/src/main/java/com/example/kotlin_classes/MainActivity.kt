
package com.example.kotlin_classes

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_classes.classes.Library
import com.example.kotlin_classes.classes.data.Book
import com.example.kotlin_classes.classes.enums.Genre
import com.example.kotlin_classes.classes.sealed_class.BookStatus

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val outputTextView: TextView = findViewById(R.id.outputTextView)
        val runButton: Button = findViewById(R.id.runButton)

        runButton.setOnClickListener {
            val result = runLogic()
            outputTextView.text = result
        }
    }

    private fun runLogic(): String {
        val sb = StringBuilder()
        val library = Library()

        val book1 = Book("The Hobbit", "J.R.R. Tolkien", Genre.FICTION, BookStatus.Available)
        val book2 = Book("A Brief History of Time", "Stephen Hawking", Genre.SCIENCE, BookStatus.Available)
        val book3 = Book("1984", "George Orwell", Genre.FICTION, BookStatus.Available)

        library.addBook(book1)
        library.addBook(book2)
        library.addBook(book3)

        val address = Library.LibraryAddress("123 Library Street", "Heilbronn", "74072")
        sb.append("=== Library Address ===\n${address.printAddress()}\n\n")

        val member = library.LibraryMember("Max Mustermann", "M123")
        sb.append("=== Member Actions ===\n")
        sb.append("${member.checkoutBook(book1, "2024-01-10")}\n")
        sb.append("${member.reserveBook(book2)}\n\n")

        sb.append("=== Current Book Status ===\n")
        sb.append(library.displayAllBooks())

        return sb.toString()
    }
}
