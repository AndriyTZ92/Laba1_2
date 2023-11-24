package com.example.lab1_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1_2.ui.theme.Lab1_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1_2Content()
        }
    }
}

@Composable
fun Lab1_2Content() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Image taking the entire space
        Image(
            painter = painterResource(id = R.drawable.image1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Row with the back button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.background.copy(alpha = 0f))
                .padding(top = 16.dp, start = 16.dp),
            verticalAlignment = Alignment.Top
        ) {
            // Back button with a white background
            IconButton(
                onClick = { /* Handle back button click */ },
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Gray)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // Text "Calling...."
        Text(
            text = "Calling....",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = Color.White,
                fontSize = 12.sp
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 24.dp + 450.dp) // Нижче центру на 150
        )

        // Vertical space
        Spacer(modifier = Modifier.height(10.dp))

        // Text "Кошмак Андрій"
        Text(
            text = "Кошмак Андрій",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = Color.White,
                fontSize = 18.sp
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 24.dp + 490.dp)
        )

        // Row with three buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top =740.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // First button with a white background and micro.png
            RoundedImageButton(
                imageName = "micro",
                backgroundColor = Color.Gray
            )

            // Second button with a red background and telef.png
            RoundedImageButton(
                imageName = "telef",
                backgroundColor = Color.Red
            )

            // Third button with a white background and dynam.png
            RoundedImageButton(
                imageName = "dynam",
                backgroundColor = Color.Gray
            )
        }
    }
}

@Composable
fun RoundedImageButton(imageName: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(backgroundColor)
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = getResourceId(imageName, "drawable")),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun getResourceId(name: String, type: String): Int {
    val context = LocalContext.current
    return try {
        context.resources.getIdentifier(name, type, context.packageName)
    } catch (e: Exception) {
        0
    }
}

@Preview(showBackground = true)
@Composable
fun Lab1_2ContentPreview() {
    Lab1_2Content()
}
