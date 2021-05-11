package com.example.starwars.model


//definizione della data class
data class StarWars(
    // @SerializedName("name")  se si vuol inserire un nome diverso nella classe rispetto al valore JSON
    val name: String, // in questo caso sia in Person che nel JSON (name è uguale)
    val height: Int,
    val mass: Double,
    val hair_color: String,
    val skin_color: String,
    val eye_color: String,
    val birth_year: String,
    val gender: String

)
