package com.example.kotlin_classes.classes.enums

enum class Genre(val description: String) {
    FICTION("Fictional stories and novels"),
    NON_FICTION("Non-fictional works"),
    SCIENCE("Science-related books"),
    HISTORY("Books about historical events"),
    CHILDREN("Books for children");

    fun printDescription(): String {
        return description
    }
}
