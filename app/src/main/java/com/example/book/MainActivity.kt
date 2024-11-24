package com.example.book


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.book.BookListActivity
import com.example.book.InsertBookActivity

@OptIn(ExperimentalMaterial3Api::class)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = { TopAppBar(title = { Text("إدارة الكتب") }) },
                content = { padding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "مرحبًا بك في تطبيق إدارة الكتب",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            startActivity(Intent(this@MainActivity, BookListActivity::class.java))
                        }) {
                            Text("عرض قائمة الكتب")
                        }
                        Button(onClick = {
                            startActivity(Intent(this@MainActivity, InsertBookActivity::class.java))
                        }) {
                            Text("إضافة كتاب جديد")
                        }
                    }
                }
            )
        }
    }
}
