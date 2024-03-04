package com.example.movieapp.presentation.components.common.error_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.R
import com.example.movieapp.presentation.components.LottieIcons
import com.example.movieapp.presentation.theme.BlackBackgroundColor
import com.example.movieapp.presentation.theme.RedButton
import com.example.movieapp.presentation.theme.dp12
import com.example.movieapp.presentation.theme.dp250
import com.example.movieapp.presentation.theme.dp7
import com.example.movieapp.presentation.theme.sp22

@Composable
fun ErrorScreen(
    message: String,
    modifier: Modifier=Modifier,
    tryAgain: () -> Unit,
) {

    Box(
        modifier = modifier.fillMaxSize().background(BlackBackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dp7)
        ) {
            LottieIcons(
                modifier = Modifier.size(dp250),
                lottie = R.raw.lottie_error
            )
            Text(
                text = message,
                fontSize = sp22,
                fontWeight = FontWeight.Medium,
                modifier=modifier.fillMaxWidth(0.9f),
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Button(
                onClick = {
                    tryAgain.invoke()
                },
                modifier = Modifier.fillMaxWidth(0.8f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = RedButton
                ),
                shape = RoundedCornerShape(dp12)
            ) {
                Text(
                    text = stringResource(R.string.retry),
                    color = Color.White
                )
            }
        }
    }

}
@Preview()
@Composable
fun ErrorScreenPreview() {
    MaterialTheme {
        ErrorScreen(
            message = "NO LOcation",
            modifier = Modifier.background(MaterialTheme.colorScheme.onBackground),
        ) {}
    }
}