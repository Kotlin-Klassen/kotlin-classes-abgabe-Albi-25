package com.example.kotlin_classes.classes.sealed_class

sealed class BookStatus {
    object Available : BookStatus()
    data class CheckedOut(val dueDate: String) : BookStatus()
    data class Reserved(val reservedBy: String) : BookStatus()

    fun getStatusDescription(): String {
        return when (this) {
            is Available -> "Available"
            is CheckedOut -> "Checked out, due back on $dueDate"
            is Reserved -> "Reserved by $reservedBy"
        }
    }
}
