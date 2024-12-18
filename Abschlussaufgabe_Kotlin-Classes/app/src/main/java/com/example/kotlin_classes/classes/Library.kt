package com.example.kotlin_classes.classes

import com.example.kotlin_classes.classes.data.Book
import com.example.kotlin_classes.classes.sealed_class.BookStatus

class Library {

    private val books = mutableListOf<Book>()

    // Add a book to the library
    fun addBook(book: Book) {
        books.add(book)
    }

    // Search books by title or author
    fun searchBooks(query: String): List<Book> {
        return books.filter { it.title.contains(query, true) || it.author.contains(query, true) }
    }

    // Display the status of all books
    fun displayAllBooks() {
        books.forEach { book ->
            println("${book.title} by ${book.author}")
            println(book.status.getStatusDescription())
            println("Genre: ${book.genre}")
            println()
        }
    }

    // Nested class for Library Address
    class LibraryAddress(private val street: String, private val city: String, private val zipCode: String) {
        fun printAddress() {
            println("Library Address: $street, $city, $zipCode")
        }
    }

    // Inner class for Library Members
    inner class LibraryMember(val name: String, val memberID: String) {
        fun checkoutBook(book: Book, dueDate: String) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println("$name checked out '${book.title}' due back on $dueDate.")
            } else {
                println("Sorry, '${book.title}' is not available for checkout.")
            }
        }

        fun reserveBook(book: Book) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println("$name reserved '${book.title}'.")
            } else {
                println("Sorry, '${book.title}' is not available for reservation.")
            }
        }
    }
}
