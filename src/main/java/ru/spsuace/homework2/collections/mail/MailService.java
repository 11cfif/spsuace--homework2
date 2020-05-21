package ru.spsuace.homework2.collections.mail;

import ru.spsuace.homework2.collections.mail.MailException;
import ru.spsuace.homework2.collections.mail.BaseMail;
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
    private MailRepository mailRepository = new MailRepository();

    /**
     * С помощью этого метода почтовый сервис обрабатывает письма и зарплаты
     * 2 балл
     */
    @Override
    public void accept(BaseMail o) {
        mailRepository.saveMail(o);
    }

    /**
     * Метод возвращает мапу получатель -> все объекты которые пришли к этому получателю через данный почтовый сервис
     * 1 балл
     */
    public Map<String, List<BaseMail>> getMailBox() {
        Map<String, List<BaseMail>> mailMap = new HashMap<>();
        List<BaseMail> mails = mailRepository.getAllEmail();

        for (BaseMail baseMail : mails) {
            String recipient = baseMail.getRecipient();

            if (mailMap.get(recipient) == null) {
                List<BaseMail> mailList = new ArrayList<>();
                mailList.add(baseMail);
                mailMap.put(recipient, mailList);
                continue;
            }
            mailMap.get(recipient).add(baseMail);
        }
        return mailMap;
    }

    /**
     * Возвращает самого популярного отправителя
     * 1 балл
     */
    public String getPopularSender() throws MailException {
        Map<String, Integer> countMap = new HashMap<>();
        List<BaseMail> mails = mailRepository.getAllEmail();
        for (BaseMail baseMail : mails) {
            String sender = baseMail.getSender();
            Integer count = countMap.get(sender);
            if (count == null) {
                count = 1;
                countMap.put(sender, count);
                continue;
            }
            count = count + 1;
            countMap.put(sender, count);
        }

        String sender;
        try {
            sender = countMap.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).findFirst().get().getKey();
        } catch (Exception e) {
            throw new MailException(e.getMessage());
        }
        return sender;
    }

    /**
     * Возвращает самого популярного получателя
     * 1 балл
     */
    public String getPopularRecipient() throws MailException {
        Map<String, Integer> countMap = new HashMap<>();
        List<BaseMail> mails = mailRepository.getAllEmail();
        for (BaseMail baseMail : mails) {
            String recipient = baseMail.getRecipient();
            Integer count = countMap.get(recipient);
            if (count == null) {
                count = 1;
                countMap.put(recipient, count);
                continue;
            }
            count = count + 1;
            countMap.put(recipient, count);
        }

        String recipient;
        try {
            recipient = countMap.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).findFirst().get().getKey();
        } catch (Exception e) {
            throw new MailException(e.getMessage());
        }
        return recipient;
    }

    /**
     * Метод должен заставить обработать service все mails.
     * 1 балл
     */
    public static void process(MailService service, List<BaseMail> baseMails) {
        baseMails.forEach(baseMail -> service.accept(baseMail));
    }
}
