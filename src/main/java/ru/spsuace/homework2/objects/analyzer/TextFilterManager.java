package ru.spsuace.homework2.objects.analyzer;


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
    private final TextAnalyzer[] Methods;
    /**
     * ��� ������ � ������ ��������� �������, ����� ������������ ���� for-each
     * ������� ��������, ��� ��� �� ������ �� �����, ����� ��������� ��� ������� ��������, ����� ������ ��,
     * ��� � ��� ���������� ��������� TextAnalyzer
     */
    public TextFilterManager(TextAnalyzer[] filters) {
        Methods = filters;
    }

    /**
     * ���� ���������� ����� ������ �� ���������, �� ��� ��������, ��� �� ���� ������ �� ��������
     */
    public FilterType analyze(String text) {
        for (TextAnalyzer textAnalyzer : Methods) {
            FilterType result = textAnalyzer.analyze(text);
            if (result != FilterType.GOOD) {
                return result;
            }
        }
        return FilterType.GOOD;
    }
}
