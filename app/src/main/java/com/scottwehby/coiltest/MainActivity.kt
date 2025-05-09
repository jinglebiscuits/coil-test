package com.scottwehby.coiltest

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil3.load
import coil3.request.ImageRequest
import coil3.svg.SvgDecoder
import com.scottwehby.coiltest.ui.theme.CoilTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoilTestTheme {
                Scaffold { innerPadding ->
                    SvgTest(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SvgTest(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            modifier = Modifier.size(300.dp),
            factory = { context ->
                ImageView(context).apply {
                    load(R.raw.test) {
                        decoderFactory { result, options, _ -> SvgDecoder(result.source, options) }
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SvgTestPreview() {
    CoilTestTheme {
        SvgTest()
    }
}
