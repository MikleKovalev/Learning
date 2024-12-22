package com.space.learning.domain

interface CharacterRepository {
    fun getCharacters(): List<Character>
    fun getCharacterById(id: Int): Character?
    fun editCharacter(character: Character)
    fun addCharacter(character: Character)
    fun removeCharacter(character: Character)
}