package pe.com.master.machines.design.components.row

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import pe.com.master.machines.design.components.images.ImageWithUrl
import pe.com.master.machines.design.components.text.CustomText
import pe.com.master.machines.design.theme.ColorWhite1
import pe.com.master.machines.design.theme.ContentInset
import pe.com.master.machines.design.theme.ContentInsetEight
import pe.com.master.machines.design.theme.ContentInsetOneHundredFifty
import pe.com.master.machines.design.theme.DynamicTextTwentySix
import pe.com.master.machines.design.theme.TextDescription
import pe.com.master.machines.design.theme.TextName
import pe.com.master.machines.model.model.Pets

@Composable
fun PetRow(
    item: Pets,
    onDetailPet: (Pets) -> Unit
) {

    Row(
        modifier = Modifier
            .clickable {
                onDetailPet(item)
            }
            .fillMaxWidth()
            .padding(horizontal = ContentInset)
            .background(color = ColorWhite1), verticalAlignment = Alignment.CenterVertically
    ) {

        ImageWithUrl(
            photoUrl = item.image,
            modifier = Modifier
                .padding(all = ContentInsetEight)
                .width(ContentInsetOneHundredFifty)
                .clip(RoundedCornerShape(ContentInset)),
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), verticalArrangement = Arrangement.Center
        ) {
            CustomText(
                text = item.name,
                textColor = TextName,
                fontWeight = FontWeight.Bold,
                fontSize = DynamicTextTwentySix,
            )

            Spacer(modifier = Modifier.height(ContentInset))

            CustomText(
                text = item.description, textColor = TextDescription, maxLines = 10
            )

            Spacer(modifier = Modifier.height(ContentInset))

            CustomText(
                text = "Almost ${item.age} years", textColor = TextName
            )
        }
    }
}

@Preview
@Composable
fun PreviewRowEvent() {
    PetRow(
        item = Pets(
            age = 0,
            description = "",
            name = "",
            image = "",
        ),
        onDetailPet = {},
    )

}