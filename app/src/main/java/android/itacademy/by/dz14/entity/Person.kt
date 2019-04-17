package android.itacademy.by.dz14.entity

data class Person(
        val urlPhoto: String,
        val name: String,
        val surname: String,
        val age: Int,
        val sex: Enum<Sex>
)


enum class Sex {
    M, F

}