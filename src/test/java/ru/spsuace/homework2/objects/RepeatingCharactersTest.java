package ru.spsuace.homework2.objects;

import org.junit.Test;

import ru.spsuace.homework2.objects.RepeatingCharacters;
import ru.spsuace.homework2.objects.RepeatingCharacters.Pair;

import static org.junit.Assert.*;

public class RepeatingCharactersTest {

    @Test
    public void getMaxRepeatingCharacters_stringIsNull() {
        assertNull(RepeatingCharacters.getMaxRepeatingCharacters(null));
        assertNull(RepeatingCharacters.getMaxRepeatingCharacters(""));
    }

    @Test
    public void getMaxRepeatingCharacters_oneMax() {
        assertEquals(new Pair<>('d', 4), RepeatingCharacters.getMaxRepeatingCharacters("aaaddddggeeereee"));
        assertEquals(new Pair<>('g', 3), RepeatingCharacters.getMaxRepeatingCharacters("ggg"));
        assertEquals(new Pair<>('c', 4), RepeatingCharacters.getMaxRepeatingCharacters("bbbaabbbccccaa"));
        assertEquals(new Pair<>('f', 6), RepeatingCharacters.getMaxRepeatingCharacters("abbcccddddeeeeeffffff"));
    }

    @Test
    public void getMaxRepeatingCharacters_manyMax() {
        assertEquals(new Pair<>('a', 1), RepeatingCharacters.getMaxRepeatingCharacters("abcd"));
        assertEquals(new Pair<>('g', 2), RepeatingCharacters.getMaxRepeatingCharacters("gagaggaa"));
        assertEquals(new Pair<>('a', 3), RepeatingCharacters.getMaxRepeatingCharacters("abcaabbccaaabbbccc"));
    }
}