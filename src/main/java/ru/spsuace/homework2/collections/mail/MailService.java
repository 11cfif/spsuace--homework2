package ru.spsuace.homework2.collections.mail;


import java.util.*;
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

    private List<BaseMail> memory = new LinkedList<>();
    private List<String> receivers = new LinkedList<>();
    private List<String> senders = new LinkedList<>();

    /**
     * С помощью этого метода почтовый сервис обрабатывает письма и зарплаты
     * 2 балл
     */
    @Override
    public void accept(BaseMail o) {
        memory.add(o);
        receivers.add(o.getReceiver());
        senders.add(o.getSender());
    }

    /**
     * Метод возвращает мапу получатель -> все объекты которые пришли к этому получателю через данный почтовый сервис
     * 1 балл
     */
    public Map<String, List<BaseMail>> getMailBox() {
        Map<String, List<BaseMail>> map = new HashMap<>();
        for (String receiver : receivers) {
            List<BaseMail> newList = new LinkedList<>();
            for (BaseMail letter : memory) {
                if (letter.getReceiver().equals(receiver)) {
                    newList.add(letter);
                }
            }
            map.put(receiver, newList);
        }
        return map;
    }

    /**
     * Возвращает самого популярного отправителя
     * 1 балл
     */
    public String getPopularSender() {
        return getPopular(senders, true);
    }

    /**
     * Возвращает самого популярного получателя
     * 1 балл
     */
    public String getPopularRecipient() {
        return getPopular(receivers, false);
    }


    public String getPopular(List<String> list, boolean isSender) {
        Map<Integer, String> map = new LinkedHashMap<>();
        int max = 0;
        for (String name : list) {
            int counter = 0;
            for (BaseMail letter : memory) {
                if (isSender) {
                    if (letter.getSender().equals(name)) {
                        counter++;
                    }
                } else {
                    if (letter.getReceiver().equals(name)) {
                        counter++;
                    }
                }
                if (counter > max) {
                    max = counter;
                }
            }
            map.put(counter, name);
        }
        return map.get(max);
    }

    public List<BaseMail> getMemory(){
        return memory;
    }

    public List<String> getReceivers(){
        return receivers;
    }
    public List<String> getSenders(){
        return senders;
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
