package pe.com.master.machines.design.components.toolbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import pe.com.master.machines.design.components.text.CustomText
import pe.com.master.machines.design.theme.ColorBlack
import pe.com.master.machines.design.theme.DynamicTextTwentyTwo
import pe.com.master.machines.design.theme.robotoRegular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarTitleWithIcon(
    modifier: Modifier = Modifier,
    text: String,
    colorBackground: Color = Color.Transparent,
    colorTextAndIcon: Color = ColorBlack,
    onNavigateToBack: () -> Unit,
) {

    TopAppBar(
        modifier = modifier.fillMaxWidth(), colors = TopAppBarColors(
            containerColor = colorBackground,
            scrolledContainerColor = Color.Black,
            navigationIconContentColor = Color.Black,
            titleContentColor = Color.Gray,
            actionIconContentColor = Color.Black
        ), title = {
            CustomText(
                text = text,
                modifier = Modifier.fillMaxWidth(),
                textColor = colorTextAndIcon,
                fontWeight = FontWeight.W400,
                maxLines = 1,
                fontSize = DynamicTextTwentyTwo,
                fontFamily = FontFamily(robotoRegular)
            )
        }, navigationIcon = {
            IconButton(onClick = { onNavigateToBack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Menu",
                    tint = colorTextAndIcon
                )
            }
        })
}

@Preview
@Composable
fun PreviewToolbarTitleWithIcon() {
    ToolbarTitleWithIcon(
        text = "Titulo",
        onNavigateToBack = {}
    )
}