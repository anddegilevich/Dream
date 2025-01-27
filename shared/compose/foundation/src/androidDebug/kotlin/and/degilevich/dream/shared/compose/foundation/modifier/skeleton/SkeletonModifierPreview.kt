package and.degilevich.dream.shared.compose.foundation.modifier.skeleton

import and.degilevich.dream.shared.loremipsum.rememberLoremIpsumText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
private fun SkeletonModifierPreview() {

    var isSkeleton by remember { mutableStateOf(false) }
    val itemsCount = remember(isSkeleton) { if (isSkeleton) 3 else 5 }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(
            onClick = {
                isSkeleton = !isSkeleton
            }
        ) {
            Text(
                text = if (isSkeleton) {
                    "Disable skeleton"
                } else {
                    "Enable skeleton"
                }
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(
                modifier = Modifier
                    .skeleton(isSkeleton = isSkeleton)
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    modifier = Modifier
                        .skeleton(isSkeleton = isSkeleton)
                        .widthIn(min = 100.dp),
                    text = if (isSkeleton) "" else rememberLoremIpsumText(wordsCount = 1),
                    style = TextStyle(
                        fontSize = 24.sp
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier
                        .skeleton(isSkeleton = isSkeleton)
                        .fillMaxWidth(),
                    text = if (isSkeleton) "" else rememberLoremIpsumText(wordsCount = 10),
                    minLines = 3,
                    style = TextStyle(
                        fontSize = 16.sp
                    )
                )
            }
        }
        for (i in 1..itemsCount) {
            key(i) {
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .skeleton(isSkeleton = isSkeleton)
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = if (isSkeleton) "" else rememberLoremIpsumText(wordsCount = 1),
                        minLines = 1,
                        style = TextStyle(
                            fontSize = 20.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = if (isSkeleton) "" else rememberLoremIpsumText(wordsCount = 7),
                        minLines = 2,
                        style = TextStyle(
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
    }
}