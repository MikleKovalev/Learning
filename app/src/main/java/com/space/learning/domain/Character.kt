package com.space.learning.domain

data class Character(
    val name: String,
    val age: Int,
    val firstMeet: FirstMeet,
    val fraction: String,
    val id: Int = UNKNOWN_ID
) {
    companion object {
        const val UNKNOWN_ID = -1
    }

    override fun equals(other: Any?): Boolean {
        if (other === null) {
            return false
        }
        if (this === other) {
            return true
        }
        if (other !is Character) {
            return false
        }
        return id == other.id
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        result = 31 * result + firstMeet.hashCode()
        result = 31 * result + fraction.hashCode()
        result = 31 * result + id
        return result
    }
}