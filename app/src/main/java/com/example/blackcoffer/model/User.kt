package com.example.blackcoffer.model

data class User(
    val name : String?,
    val city : String?,
    val profession : String?,
    val status : String? = "Hi community! I am open to new connections \uD83D\uDE0A",
    var request : String = "INVITE",
    val gender : String?,
    val profile_score : Float = 0.3f,
    val distance : String = "2.3 KM",
    val availability : String = "Available",
    val your_purpose : List<String> = arrayListOf("Coffee")
)


val users = listOf(
    User(
        name = "Alice Smith",
        city = "New York",
        profession = "Software Engineer",
        gender = "Female",
        profile_score = 0.23f,
        your_purpose = listOf("Coffee", "Hobbies", "Movies")
    ),
    User(
        name = "Bob Johnson",
        city = "Los Angeles",
        profession = "Graphic Designer",
        gender = "Male",
        profile_score = 0.45f,
        your_purpose = listOf("Business", "Friendship", "Dining")
    ),
    User(
        name = "Charlie Brown",
        city = "Chicago",
        profession = "Teacher",
        gender = "Other",
        profile_score = 0.4f,
        your_purpose = listOf("Coffee", "Hobbies", "Dating")
    ),
    User(
        name = "Alice Smith",
        city = "New York",
        profession = "Software Engineer",
        gender = "Female",
        profile_score = 0.7f,
        your_purpose = listOf("Coffee", "Hobbies", "Movies")
    ),
    User(
        name = "Bob Johnson",
        city = "Los Angeles",
        profession = "Graphic Designer",
        gender = "Male",
        profile_score = 0.56f,
        your_purpose = listOf("Business", "Friendship", "Dining")
    ),
    User(
        name = "Charlie Brown",
        city = "Chicago",
        profession = "Teacher",
        gender = "Other",
        profile_score = 0.39f,
        your_purpose = listOf("Coffee", "Hobbies", "Dating")
    ),    User(
        name = "Alice Smith",
        city = "New York",
        profession = "Software Engineer",
        gender = "Female",
        profile_score = 0.88f,
        your_purpose = listOf("Coffee", "Hobbies", "Movies")
    ),
    User(
        name = "Bob Johnson",
        city = "Los Angeles",
        profession = "Graphic Designer",
        gender = "Male",
        profile_score = 0.65f,
        your_purpose = listOf("Business", "Friendship", "Dining")
    ),
    User(
        name = "Charlie Brown",
        city = "Chicago",
        profession = "Teacher",
        gender = "Other",
        profile_score = 0.45f,
        your_purpose = listOf("Coffee", "Hobbies", "Dating")
    ),

)

