package com.example.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
class BookViewModel(private val bookDao: BookDao) : ViewModel() {
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val posts: StateFlow<List<Book>> = _books.asStateFlow()

    init {
        loadBooks()
    }

    private fun loadBooks() {
        viewModelScope.launch {
            bookDao.getAll().collect { books ->
                _books.value = books
            }
        }
    }

    fun addBook(book: Book) {
        viewModelScope.launch {
            bookDao.insert(book)
        }
    }

    fun deleteBook(book: Book) {
        viewModelScope.launch {
            bookDao.delete(book)
        }
    }
    fun getBookById(bookId: Int): Book? {
        return _books.value.find { it.id == bookId }
    }
}
