package com.example.book


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.book.Book
import com.example.book.BookViewModel
@OptIn(ExperimentalMaterial3Api::class)
class InsertBookActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val db = AppDatabase.getDatabase(applicationContext)
         val viewModel = BookViewModel(db.bookDao())
        setContent {
            var title by remember { mutableStateOf("") }
            var author by remember { mutableStateOf("") }

            Scaffold(
                topBar = { TopAppBar(title = { Text("إضافة كتاب جديد") }) },
                content = { padding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
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
                                    startActivity(Intent(this@InsertBookActivity, BookListActivity::class.java))
                                    finish()
                                }
                            },
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text("إضافة كتاب")
                        }
                    }
                }
            )
        }
    }
}
