package com.example.raastade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.raastade.ui.theme.RaastadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RaastadeTheme {
                MainScreen { hornName ->
                    // TODO: Play sound or trigger event
                    Log.d("HornClick", hornName)
                }
            }
        }
    }
}

@Composable
fun ImageButtonItem(
    drawableId: Int,
    description: String,
    size: Dp = 150.dp,
    padding: Dp = 0.dp,
    onClick: () -> Unit
) {
    val aspectRatio = when (drawableId) {
        R.drawable.lassi_truck -> 3f / 2f // Custom aspect ratio for wide images
        else -> 1f // Default square
    }

    Box(
        modifier = Modifier
            .padding(padding)
            .width(size)
            .aspectRatio(aspectRatio)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = description,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun MainScreen(onClick: (String) -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            ImageButtonItem(R.drawable.air_horn, "Air Horn") { onClick("air_horn") }
            Spacer(modifier = Modifier.width(30.dp))
            ImageButtonItem(R.drawable.bullet_horn, "Bullet Horn") { onClick("bullet_horn") }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            ImageButtonItem(
                drawableId = R.drawable.lassi_truck,
                description = "Lassi Truck",
                size = 200.dp,
                padding = 0.dp
            ) { onClick("lassi") }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            ImageButtonItem(R.drawable.maserati, "Maserati") { onClick("maserati") }
            Spacer(modifier = Modifier.width(30.dp))
            ImageButtonItem(R.drawable.ship, "Ship") { onClick("ship") }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            ImageButtonItem(R.drawable.truck, "Truck") { onClick("truck") }
        }
    }
}
