public class validAnagramBruteForce {
    public static void main(String[] args) {
        String s = "listen";     // первая строка
        String t = "silent";     // вторая строка

        System.out.println(isAnagram(s, t)); // true
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; // если длина разная — не анаграмма

        // Преобразуем вторую строку в изменяемую строку (StringBuilder)
        StringBuilder tBuilder = new StringBuilder(t);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // берём символ из первой строки

            int index = tBuilder.indexOf(String.valueOf(ch)); // ищем символ в t

            if (index == -1) {
                return false; // если символ не найден — не анаграмма
            }

            tBuilder.deleteCharAt(index); // удаляем найденный символ из t, чтобы не повторялся
        }

        return tBuilder.length() == 0; // если всё удалили — это анаграмма
    }
}
