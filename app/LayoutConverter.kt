object LayoutConverter {

    // Українська розкладка → QWERTY
    private val ukrainianToQwerty = mapOf(
        'й' to 'q', 'ц' to 'w', 'у' to 'e', 'к' to 'r', 'е' to 't',
        'н' to 'y', 'г' to 'u', 'ш' to 'i', 'щ' to 'o', 'з' to 'p',
        'х' to '[', 'ї' to ']', 'ф' to 'a', 'і' to 's', 'в' to 'd',
        'а' to 'f', 'п' to 'g', 'р' to 'h', 'о' to 'j', 'л' to 'k',
        'д' to 'l', 'ж' to ';', 'є' to '\'','я' to 'z', 'ч' to 'x',
        'с' to 'c', 'м' to 'v', 'и' to 'b', 'т' to 'n', 'ь' to 'm',
        'б' to ',', 'ю' to '.', '.' to '/',
        // Великі літери
        'Й' to 'Q', 'Ц' to 'W', 'У' to 'E', 'К' to 'R', 'Е' to 'T',
        'Н' to 'Y', 'Г' to 'U', 'Ш' to 'I', 'Щ' to 'O', 'З' to 'P',
        'Х' to '{', 'Ї' to '}', 'Ф' to 'A', 'І' to 'S', 'В' to 'D',
        'А' to 'F', 'П' to 'G', 'Р' to 'H', 'О' to 'J', 'Л' to 'K',
        'Д' to 'L', 'Ж' to ':', 'Є' to '"', 'Я' to 'Z', 'Ч' to 'X',
        'С' to 'C', 'М' to 'V', 'И' to 'B', 'Т' to 'N', 'Ь' to 'M',
        'Б' to '<', 'Ю' to '>'
    )

    // Російська розкладка → QWERTY
    private val russianToQwerty = mapOf(
        'й' to 'q', 'ц' to 'w', 'у' to 'e', 'к' to 'r', 'е' to 't',
        'н' to 'y', 'г' to 'u', 'ш' to 'i', 'щ' to 'o', 'з' to 'p',
        'х' to '[', 'ъ' to ']', 'ф' to 'a', 'ы' to 's', 'в' to 'd',
        'а' to 'f', 'п' to 'g', 'р' to 'h', 'о' to 'j', 'л' to 'k',
        'д' to 'l', 'ж' to ';', 'э' to '\'','я' to 'z', 'ч' to 'x',
        'с' to 'c', 'м' to 'v', 'и' to 'b', 'т' to 'n', 'ь' to 'm',
        'б' to ',', 'ю' to '.', '.' to '/',
        // Великі літери
        'Й' to 'Q', 'Ц' to 'W', 'У' to 'E', 'К' to 'R', 'Е' to 'T',
        'Н' to 'Y', 'Г' to 'U', 'Ш' to 'I', 'Щ' to 'O', 'З' to 'P',
        'Х' to '{', 'Ъ' to '}', 'Ф' to 'A', 'Ы' to 'S', 'В' to 'D',
        'А' to 'F', 'П' to 'G', 'Р' to 'H', 'О' to 'J', 'Л' to 'K',
        'Д' to 'L', 'Ж' to ':', 'Э' to '"', 'Я' to 'Z', 'Ч' to 'X',
        'С' to 'C', 'М' to 'V', 'И' to 'B', 'Т' to 'N', 'Ь' to 'M',
        'Б' to '<', 'Ю' to '>'
    )

    enum class Language { UKRAINIAN, RUSSIAN }

    fun convert(text: String, language: Language): String {
        val map = when (language) {
            Language.UKRAINIAN -> ukrainianToQwerty
            Language.RUSSIAN   -> russianToQwerty
        }
        return text.map { char -> map[char] ?: char }.joinToString("")
    }
}