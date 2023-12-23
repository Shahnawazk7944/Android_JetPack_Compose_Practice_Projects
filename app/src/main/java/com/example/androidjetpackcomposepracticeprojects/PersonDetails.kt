package com.example.androidjetpackcomposepracticeprojects

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidjetpackcomposepracticeprojects.models.Person
import com.example.androidjetpackcomposepracticeprojects.ui.theme.AzureMist
import com.example.androidjetpackcomposepracticeprojects.ui.theme.ChocolateBrown
import com.example.androidjetpackcomposepracticeprojects.ui.theme.DarkBrown
import com.example.androidjetpackcomposepracticeprojects.ui.theme.RootBeer

@Composable
fun PersonDetails(person: Person) {
    Column(
        modifier = Modifier
            .background(AzureMist)
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start,
        //verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
//this Row represent the persons Age and Name
        Row {
            Text(
                text = "${person.age}",
                color = ChocolateBrown,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = person.name,
                color = ChocolateBrown,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Normal
            )
        }
//..........
        //the text Compose is for persons phone or contact number

        Text(
            text = "Phone - ${person.phone}",
            color = RootBeer,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        //this Row is for persons residence details like Country and Postal code

        Row {
            Text(
                text = "Country - ${person.country}",
                color = DarkBrown,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Postal Code - ${person.postalCode}",
                color = DarkBrown,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
        }




    }
}

@Preview(showBackground = true)
@Composable
fun PersonDetailsPreview() {
    PersonDetails(person =
    Person(
        age = 54,
        name = "Demetria Wilkins",
        phone = 65247134,
        country = "Russian Federation",
        postalCode = 489625
    )
    )
}