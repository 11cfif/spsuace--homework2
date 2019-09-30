package ru.spsuace.homework2;

import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class TestObject {
    private final String str;

    @Contract(pure = true)
    public TestObject(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestObject that = (TestObject) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    @Override
    public String toString() {
        return str;
    }
}
