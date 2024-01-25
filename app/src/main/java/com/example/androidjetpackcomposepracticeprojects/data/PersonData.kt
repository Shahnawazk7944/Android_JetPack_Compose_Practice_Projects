package com.example.androidjetpackcomposepracticeprojects.data

import com.example.androidjetpackcomposepracticeprojects.presentation.models.Person

class PersonData {
    fun getAllPersonsData(): List<Person> {
        return listOf(

            Person(
                age = 21,
                name = "Phyllis Johns",
                phone = 14354871,
                country = "New Zealand",
                postalCode = 544267
            ),
            Person(
                age = 52,
                name = "Brett Bonner",
                phone = 12419996,
                country = "Ukraine",
                postalCode = 952496
            ),
            Person(
                age = 73,
                name = "Dora Wooten",
                phone = 17685254,
                country = "Chile",
                postalCode = 553064
            ),
            Person(
                age = 54,
                name = "Demetria Wilkins",
                phone = 65247134,
                country = "Russian Federation",
                postalCode = 489625
            ),
            Person(
                age = 65,
                name = "Bell Frost",
                phone = 32659472,
                country = "New Zealand",
                postalCode = 648527
            ),
            Person(
                age = 26,
                name = "Briar Jefferson",
                phone = 96451285,
                country = "Netherlands",
                postalCode = 754869
            ),
            Person(
                age = 37,
                name = "Quasar Richardson",
                phone = 18749628,
                country = "Italy",
                postalCode = 547823
            ),
            Person(
                age = 28,
                name = "Nicole Jensen",
                phone = 22548164,
                country = "Ireland",
                postalCode = 216849
            ),
            Person(
                age = 29,
                name = "Sarah Sharpe",
                phone = 12487514,
                country = "New Zealand",
                postalCode = 125964
            ),
            Person(
                age = 20,
                name = "Bruno Pugh",
                phone = 14527896,
                country = "United States",
                postalCode = 326518
            ),
            Person(
                age = 21,
                name = "Gage Bullock",
                phone = 115487624,
                country = "Mexico",
                postalCode = 249576
            ),
            Person(
                age = 32,
                name = "Jolene Abbott",
                phone = 95784618,
                country = "United Kingdom",
                postalCode = 159354
            ),
            Person(
                age = 30,
                name = "Michael Matthews",
                phone = 88459612,
                country = "Turkey",
                postalCode = 540569
            ),
            Person(
                age = 41,
                name = "Thomas Atkins",
                phone = 84684256,
                country = "Australia",
                postalCode = 589184
            ),
            Person(
                age = 26,
                name = "Jillian Vincent",
                phone = 54169849,
                country = "France",
                postalCode = 124975
            )
        )
    }
}