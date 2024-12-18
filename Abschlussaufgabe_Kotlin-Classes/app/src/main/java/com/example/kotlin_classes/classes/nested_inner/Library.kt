
package com.example.kotlin_classes.classes.nested_inner

import com.example.kotlin_classes.classes.data.Book
import com.example.kotlin_classes.classes.sealed_class.BookStatus

class Library {

    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchBooks(query: String): List<Book> {
        return books.filter {
            it.title.contains(query, ignoreCase = true) || it.author.contains(query, ignoreCase = true)
        }
    }

    fun displayAllBooks(): String {
        val sb = StringBuilder()
        books.forEach { book ->
            sb.append("${book.title} by ${book.author}\n")
            sb.append("Status: ${book.status.getStatusDescription()}\n")
            sb.append("Genre: ${book.genre}\n\n")
        }
        return sb.toString()
    }

    class LibraryAddress(private val street: String, private val city: String, private val zipCode: String) {
        fun printAddress(): String {
            return "Library Address: $street, $city, $zipCode"
        }
    }

    inner class LibraryMember(val name: String, val memberID: String) {
        fun checkoutBook(book: Book, dueDate: String): String {
            return if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                "$name checked out '${book.title}', due back on $dueDate."
            } else {
                "Sorry, '${book.title}' is not available for checkout."
            }
        }

        fun reserveBook(book: Book): String {
            return if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                "$name reserved '${book.title}'."
            } else {
                "Sorry, '${book.title}' is not available for reservation."
            }
        }
    }
}
