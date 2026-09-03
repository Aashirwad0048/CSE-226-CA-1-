package com.example.cse_226

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cse_226.ui.theme.CSE226Theme

class ButtonUi : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CSE226Theme {
                MorphingActionButton()
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MorphingActionButton() {

    var isExpanded by remember {
        mutableStateOf(true)
    }

    val width by animateDpAsState(
        targetValue = if (isExpanded) 160.dp else 56.dp,
        animationSpec = tween(400),
        label = ""
    )

    val color by animateColorAsState(
        targetValue = if (isExpanded)
            MaterialTheme.colorScheme.primary
        else
            MaterialTheme.colorScheme.secondary,
        animationSpec = tween(400),
        label = ""
    )

    val cornerRadius by animateDpAsState(
        targetValue = if (isExpanded) 16.dp else 28.dp,
        animationSpec = tween(400),
        label = ""
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        IconButton(
            onClick = {
                isExpanded = !isExpanded
            },
            modifier = Modifier
                .width(width)
                .height(56.dp)
                .background(
                    color = color,
                    shape = RoundedCornerShape(cornerRadius)
                )
        ) {
            Row{
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = "Save"
                )
                Text(
                    text = if (isExpanded) "Save Activity" else ""
                )
            }
        }
    }
}
