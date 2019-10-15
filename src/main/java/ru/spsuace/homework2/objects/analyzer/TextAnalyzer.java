package ru.spsuace.homework2.objects.analyzer;


/**
 * ������� ���������� �������, ���������� ����� ����������� ������ ��������������� � ���� ��� ������
 * ������� ������.
 * ���� ���� ����������� ������, ������� ������� ������� ��������� ���� (�� ��� ��� ���������� ���������, ��� ��� ���
 * ����� ���, ��� ��� �� ����� ���������� ����������, � ����� ������ ��������, ��� ��������� ����������� �������
 * ����� ���-�� ������������� �����). ���� ����������� ������ ��� ����� ��� �������� ������,
 * ��� �� ��� �������� ������� (������� �� ��������) � ���� "������������" �� ��������.
 *
 * ��� �� ���������� ������� ��� ���������� ������, ������� ����� ��� ����� ��� ������� ������
 * �� ���� �������� � ������ TextFilterManager
 */
public interface TextAnalyzer {

    static TextAnalyzer createTooLongAnalyzer(long maxLength) {
        return new TooLong(maxLength);
    }

    static TextAnalyzer createSpamAnalyzer(String[] spam) {
        return new Spam(spam);
    }

    static TextAnalyzer createNegativeTextAnalyzer() {
        return new Negative();
    }

    FilterType analyze(String text);

    static TextAnalyzer createCustomAnalyzer() {
        return new Custom();
    }
}
