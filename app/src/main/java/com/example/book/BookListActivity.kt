package com.example.book

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.book.Book
import com.example.book.BookViewModel

@OptIn(ExperimentalMaterial3Api::class)
class BookListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val db = AppDatabase.getDatabase(applicationContext)
            val viewModel = BookViewModel(db.bookDao())
            val books by viewModel.posts.collectAsState(initial = emptyList())

            Scaffold(
                topBar = { TopAppBar(title = { Text("قائمة الكتب") }) },
                content = { padding ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        items(books) { book ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .clickable {
                                        val intent = Intent(
                                            this@BookListActivity,
                                            BookDetailActivity::class.java
                                        )
                                        intent.putExtra("bookId", book.id)
                                        startActivity(intent)
                                    },
                                elevation = CardDefaults.cardElevation(4.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column {
                                        Text("العنوان: ${book.title}", style = MaterialTheme.typography.titleMedium)
                                        Text("المؤلف: ${book.author}", style = MaterialTheme.typography.bodyMedium)
                                    }
                                    IconButton(onClick = { viewModel.deleteBook(book)}) {
                                        Icon(Icons.Default.Delete, contentDescription = "حذف الكتاب")
                                    }
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}
