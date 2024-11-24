package com.example.bookmanagement

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
@Composable
fun BookApp(viewModel: BookViewModel) {
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }

    // Collect books state from the ViewModel
    val books by viewModel.posts.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("إدارة الكتب") })
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                // Input fields for book details
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("عنوان الكتاب") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                TextField(
                    value = author,
                    onValueChange = { author = it },
                    label = { Text("اسم المؤلف") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                Button(
                    onClick = {
                        if (title.isNotBlank() && author.isNotBlank()) {
                            viewModel.addBook(Book(0, title, author))
                            title = ""
                            author = ""
                        }
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("إضافة كتاب")
                }

                // List of books
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    items(books) { book ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text("العنوان: ${book.title}", style = MaterialTheme.typography.titleMedium)
                                Text("المؤلف: ${book.author}", style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                }
            }
        }
    )
}
