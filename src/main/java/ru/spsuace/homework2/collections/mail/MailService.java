package ru.spsuace.homework2.collections.mail;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Дополнительное задание:
 * Нужно создать сервис, который умеет обрабатывать некоторые базовые сообщения, а именно письма и зарплату.
 * Письма состоят из получателя, отправителя, текста сообщения
 * Зарплата состоит из получателя, отправителя и суммы.
 * Используйте ООП и основное задание для реализации данного дополнительного задания
 *
 * Полный балл за этот класс: 6
 * Сделайте тест (alt + enter) на названии класса -> create test
 * и сделайте там 3 теста (3 простых разных случая для тестирования класса). Например тестКейс только с одним
 * получателем и отправителем, но большим количеством писем и зарплат, и проверьте что три основных метода возвращают то,
 * что должны (по аналогии с моими тестами). 1 тест - 1 балл
 *
 * За все дополнительное задание в пакете mail можно получить 12 баллов
 */
public class MailService implements Consumer<BaseMail> {
    private final Map<String, List<BaseMail>> DestinationOfMap = new HashMap<>();
    private final Map<String, Integer> PopularDestinationOfMap = new HashMap<>();
    private final Map<String, Integer> PopularDepartureOfMap = new HashMap<>();
    /**
     * С помощью этого метода почтовый сервис обрабатывает письма и зарплаты
     * 2 балл
     */

    private void popularCount(Map<String, Integer> objectToPopularityMap, String person) {
        int popularCount = objectToPopularityMap.getOrDefault(person, 0);
        objectToPopularityMap.put(person, ++popularCount);
    }

    @Override
    public void accept(BaseMail mail) {
        List<BaseMail> departureMails = DestinationOfMap
                .computeIfAbsent(mail.ReturnDestination(), key -> new ArrayList<>());
        departureMails.add(mail);


        popularCount(PopularDestinationOfMap, mail.ReturnDestination());
        popularCount(PopularDepartureOfMap, mail.ReturnDeparture());



    }

    /**
     * Метод возвращает мапу получатель -> все объекты которые пришли к этому получателю через данный почтовый сервис
     * 1 балл
     */
    public Map<String, List<BaseMail>> getMailBox() {
        return DestinationOfMap;
    }

    private String getPopularObject(Map<String, Integer> objectToPopularityMap) {
        if (objectToPopularityMap.isEmpty()) {
            return null;
        }

        Map.Entry<String, Integer> maxPopularEntry = null;

        for (Map.Entry<String, Integer> objectToPopularityCount : objectToPopularityMap.entrySet()) {
            if (maxPopularEntry == null || maxPopularEntry.getValue() <= objectToPopularityCount.getValue()) {
                maxPopularEntry = objectToPopularityCount;
            }
        }
        return maxPopularEntry.getKey();

    }
    /**
     * Возвращает самого популярного отправителя
     * 1 балл
     */
    public String getPopularSender() {
        return getPopularObject(PopularDepartureOfMap);
    }

    /**
     * Возвращает самого популярного получателя
     * 1 балл
     */
    public String getPopularRecipient() {
        return getPopularObject(PopularDestinationOfMap);
    }

    /**
     * Метод должен заставить обработать service все mails.
     * 1 балл
     */
    public static void process(MailService service, List<BaseMail> baseMails) {
        for (BaseMail mail : baseMails) {
            service.accept(mail);
        }
    }
}