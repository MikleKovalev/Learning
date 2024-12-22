package com.space.learning.data

import com.space.learning.domain.Character
import com.space.learning.domain.CharacterRepository

class InMemoryCharacterRepository : CharacterRepository {
    private val characters = mutableListOf<Character>()

    override fun getCharacters(): List<Character> = characters

    override fun getCharacterById(id: Int): Character? = characters.firstOrNull { it.id == id }

    override fun editCharacter(character: Character) {
        removeCharacter(character)
        addCharacter(character)
    }

    override fun addCharacter(character: Character) {
        characters.add(character)
    }

    override fun removeCharacter(character: Character) {
        characters.remove(character)
    }
}