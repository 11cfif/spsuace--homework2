package ru.spsuace.homework2.collections.mail;

/**
 * Класс для базового сообщения
 * 1 балл
 */
public class BaseMail {
    public final String Destination;
    public final String Departure;

    public BaseMail(String Destination, String Departure) {
        this.Departure = Departure;
        this.Destination = Destination;

    }

    public String ReturnDestination() {
        return Destination;
    }

    public String ReturnDeparture() {
        return Departure;
    }

}
