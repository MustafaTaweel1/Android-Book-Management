package com.example.book

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.book.Book
import com.example.book.BookViewModel

@OptIn(ExperimentalMaterial3Api::class)

class BookDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val db = AppDatabase.getDatabase(applicationContext)
        val viewModel = BookViewModel(db.bookDao())
        val bookId = intent.getIntExtra("bookId", -1)
        val book = viewModel.getBookById(bookId)

        setContent {
            Scaffold(
                topBar = { TopAppBar(title = { Text("تفاصيل الكتاب") }) },
                content = { padding ->
                    if (book != null) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                        ) {
                            Text("العنوان: ${book.title}", style = MaterialTheme.typography.titleLarge)
                            Text("المؤلف: ${book.author}", style = MaterialTheme.typography.bodyLarge)
                        }
                    } else {
                        Text("لم يتم العثور على الكتاب.", style = MaterialTheme.typography.bodyLarge)
                    }
                }
            )
        }
    }
}
