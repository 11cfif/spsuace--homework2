package ru.spsuace.homework2.objects.analyzer;


import java.util.Arrays;

/**
 * ������� �������� ������� ���������� ������������.
 * ���� ����������� ��� ���� ������������ ��������
 * 1) ������ ��� ������� ������� ������� (����� �������� ��� ��������) (TOO_LONG)
 * 2) ������ ��� ����� (���������� ������ ������ ����, ������� �� ������ ���� � ������) (SPAM)
 * 3) ������ ��� ������� � ������� ��������. (� ������ �� ������ ���� ����� �������:
 * "=(", ":(", ":|" (NEGATIVE_TEXT)
 * + � �������� ��� �������, ������ ������� ����� ���� ������ (CUSTOM)
 * <p>
 * ����� TextFilterManager ������ ��������� ��� �������, ������� ���������� ��� � ������������,
 * � ��� ������� ������ ����� ����� analyze ������ �������� ������ "��������" ������,
 * ���� �� ���� �� ������, �� ���������� ��� GOOD.
 * + � �������� ��� �������, ����� ���� ����� �������� ������ ���������
 * (SPAM, TOO_LONG, NEGATIVE_TEXT, CUSTOM - � ����� �������) � ���������� ��� � ������������ �����������.
 * ������������� ������� ����� � ������� �������
 * Arrays.sort(filter, (filter1, filter2) -> {
 *     if (filter1 < filter2) {
 *         return -1;
 *     } else if (filter1 == filter2) {
 *         return 0;
 *     }
 *     return 1;
 * }
 * ��� ������ ��������� ����� �������� ������ ���� ���������� �����-�� �������������� ���������� �������
 */
public class TextFilterManager {

    /**
     * ��� ������ � ������ ��������� �������, ����� ������������ ���� for-each
     * ������� ��������, ��� ��� �� ������ �� �����, ����� ��������� ��� ������� ��������, ����� ������ ��,
     * ��� � ��� ���������� ��������� TextAnalyzer
     */

    private TextAnalyzer[] filters;

    public TextFilterManager(TextAnalyzer[] filters) {
        this.filters = filters;
        Arrays.sort(filters, (filter1, filter2) -> {
            if (filter1.getPriority() < filter2.getPriority()) {
                return -1;
            } else if (filter1.getPriority() == filter2.getPriority()) {
                return 0;
            }
            return 1;
        });
    }

    /**
     * ���� ���������� ����� ������ �� ���������, �� ��� ��������, ��� �� ���� ������ �� ��������
     */

    public FilterType analyze(String text) {
        if (filters.length == 0) {
            return FilterType.GOOD;
        }
        if (text == null || text.isEmpty()) {
            return FilterType.GOOD;
        }
        for (TextAnalyzer filter : filters) {
            FilterType result = filter.analyze(text);
            if (result != FilterType.GOOD) {
                return result;
            }
        }
        return FilterType.GOOD;
    }
}
