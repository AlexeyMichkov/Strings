public class Main
{
    public static void main(String[] args) {
// Строка представляет собой последовательность символов. Для работы со строками в Java определен класс String, который предоставляет ряд методов для манипуляции строками
        String str1 = "Java"; // Для создания новой строки мы можем использовать один из конструкторов класса String, либо напрямую присвоить строку в двойных кавычках
        String str2 = new String(); // пустая строка
        String str3 = new String(new char[] {'h', 'e', 'l', 'l', 'o'});
        String str4 = new String(new char[]{'w', 'e', 'l', 'c', 'o', 'm', 'e'}, 3, 4);//3 -начальный индекс, 4 -кол-во символов

        System.out.println(str1); // Java
        System.out.println(str2); //
        System.out.println(str3); // hello
        System.out.println(str4); // come
        System.out.println(str1.length()); // 4
        String str5 = new String(new char[] {'h', 'e', 'l', 'l', 'o'}); // с помощью метода toCharArray() можно обратно преобразовать строку в массив символов
        char[] helloArray = str5.toCharArray();
        System.out.println(helloArray); // hello

        String s = "";   // строка не указывает на объект
        if(s.length() == 0) System.out.println("String is empty"); // Строка может быть пустой.
        // Для этого ей можно присвоить пустые кавычки или удалить из стоки все символы
        if(s.isEmpty()) System.out.println("String is empty"); //Класс String имеет специальный метод, который позволяет проверить строку на пустоту - isEmpty().
        // Если строка пуста, он возвращает true
        String s2 = "i";
        if(s2.isEmpty()) System.out.println("String is empty");
        else System.out.println("i");

        // Переменная String может не указывать на какой-либо объект и иметь значение null
        String s3 = null;   // строка не указывает на объект
        if(s3 == null) System.out.println("String is null");

        // Значение null не эквивалентно пустой строке. Например, в следующем случае мы столкнемся с ошибкой выполнения
      //  String s4 = null;   // строка не указывает на объект
        // if(s4.length()==0) System.out.println("String is empty");    // ! Ошибка "java.lang.NullPointerException
                                                                                      //at Main.main(Main.java:34)"

        String s4 = null;   // строка не указывает на объект
        if(s4!=null && s4.length()==0) System.out.println("String is empty!"); //Чтобы избежать подобных ошибок, можно предварительно проверять строку на null

        String s5 = "Год " + 2020; // если в операции сложения строк используется нестроковый объект, например, число, то этот объект преобразуется к строке
        System.out.println(s5); // Год 2020
/* Фактически же при сложении строк с нестроковыми объектами будет вызываться метод valueOf() класса String.
 Данный метод имеет множество перегрузок и преобразует практически все типы данных к строке.
 Для преобразования объектов различных классов метод valueOf вызывает метод toString() этих классов
        Другой способ объединения строк представляет метод concat(): */
        String str6 = "Java";
        String str7 = "Hello";
        str7 = str7.concat(str6);
        System.out.println(str7); // HelloJava
// Метод concat() принимает строку, с которой надо объединить вызывающую строку, и возвращает соединенную строку

// Еще один метод объединения - метод join() позволяет объединить строки с учетом разделителя
        String str8 = "Java!!!";// Например, выше две строки сливались в одно слово "HelloJava", но в идеале мы бы хотели, чтобы две подстроки были разделены пробелом.
        String str9 = "Hello"; // И для этого используем метод join():
        String str10 = String.join(" ", str9, str8); // Hello Java!!!
        System.out.println(str10);
/*Метод join является статическим. Первым параметром идет разделитель, которым будут разделяться подстроки в общей строке,
  а все последующие параметры передают через запятую произвольный набор объединяемых подстрок - в данном случае две строки, хотя их может быть и больше*/

                                       // ИЗВЛЕЧЕНИЕ СИМВОЛОВ И ПОДСТРОК
        //Для извлечения символов по индексу в классе String определен метод char charAt(int index)
        String str = "Java"; //Он принимает индекс, по которому надо получить символов, и возвращает извлеченный символ:
        char c = str.charAt(2); //Как и в массивах индексация начинается с нуля.
        System.out.println(c); // v

// Если надо извлечь сразу группу символов или подстроку, то можно использовать метод getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
   // srcBegin: индекс в строке, с которого начинается извлечение символов

        String str11 = "Hello, Alexey!";
        int start = 6;
        int end = 11;// srcEnd: индекс в строке, до которого идет извлечение символов
        char[] dst=new char[end - start];// dst: массив символов, в который будут извлекаться символы
        str11.getChars(start, end, dst, 0);// dstBegin: индекс в массиве dst, с которого надо добавлять извлеченные из строки символы
        System.out.println(dst); // Alex

                                         // Сравнение строк
//Для сравнения строк используются методы equals() (с учетом регистра) и equalsIgnoreCase() (без учета регистра).
// Оба метода в качестве параметра принимают строку, с которой надо сравнить:
        String str12 = "Hello";
        String str13 = "hello";

        System.out.println(str12.equals(str13)); // false
        System.out.println(str12.equalsIgnoreCase(str13)); // true
// В отличие от сравнения числовых и других данных примитивных типов для строк не применяется знак равенства ==. Вместо него надо использовать метод equals().

/*Еще один специальный метод regionMatches() сравнивает отдельные подстроки в рамках двух строк. Он имеет следующие формы:
boolean regionMatches(int toffset, String other, int oofset, int len)
boolean regionMatches(boolean ignoreCase, int toffset, String other, int oofset, int len)
Метод принимает следующие параметры:

ignoreCase: надо ли игнорировать регистр символов при сравнении. Если значение true, регистр игнорируется

toffset: начальный индекс в вызывающей строке, с которого начнется сравнение

other: строка, с которой сравнивается вызывающая

oofset: начальный индекс в сравниваемой строке, с которого начнется сравнение

len: количество сравниваемых символов в обеих строках
* */
         //Используем метод:
        String str14 = "Hello world";
        String str15 = "I work";
        boolean result = str14.regionMatches(6, str15, 2, 3);//regionMatches() сравнивает отдельные подстроки в рамках двух строк
        //toffset: начальный индекс в вызывающей строке, с которого начнется сравнение
        //oofset: начальный индекс в сравниваемой строке, с которого начнется сравнение
        //str15: строка, с которой сравнивается вызывающая
        //len: количество сравниваемых символов в обеих строках
        System.out.println(result); // true
        // В данном случае метод сравнивает 3 символа с 6-го индекса первой строки ("wor") и 3 символа со 2-го индекса второй строки ("wor").
        // Так как эти подстроки одинаковы, то возвращается true.

/*И еще одна пара методов int compareTo(String str) и int compareToIgnoreCase(String str) также позволяют сравнить две строки,
  но при этом они также позволяют узнать больше ли одна строка, чем другая или нет.
  Если возвращаемое значение больше 0, то первая строка больше второй, если меньше нуля, то, наоборот, вторая больше первой. Если строки равны, то возвращается 0.*/

// Для определения больше или меньше одна строка, чем другая, используется лексикографический порядок.
// То есть, например, строка "A" меньше, чем строка "B", так как символ 'A' в алфавите стоит перед символом 'B'.
// Если первые символы строк равны, то в расчет берутся следующие символы. Например:
        String str16 = "hello";
        String str17 = "world";
        String str18 = "hell";

        System.out.println(str16.compareTo(str17)); // -15 - str16 меньше чем strt17
        System.out.println(str16.compareTo(str18)); // 1 - str1 больше чем str3

                   //Поиск в строке
        //Метод indexOf() находит индекс первого вхождения подстроки в строку, а метод lastIndexOf() - индекс последнего вхождения.
        // Если подстрока не будет найдена, то оба метода возвращают -1:
        String str19 = "Hello world";
        int index1 = str19.indexOf('l'); // 2
        int index2 = str19.indexOf("wo"); //6
        int index3 = str19.lastIndexOf('l'); //9
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //Метод startsWith() позволяют определить начинается ли строка с определенной подстроки,
        // а метод endsWith() позволяет определить заканчивается строка на определенную подстроку:
       // String str20 = "myfile.exe";
       // boolean start = str20.startsWith("my"); //true
       // boolean end = str20.endsWith("exe"); //true
       // System.out.println(str20); ЧЁТ НЕ ПОЛУЧИЛОСЬ, ПОЗЖЕ РАЗБЕРУСЬ
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //               Замена в строке
       // Метод replace() позволяет заменить в строке одну последовательность символов на другую:
        String str21 = "Hello world";
        String replStr1 = str21.replace('l', 'd'); // Heddo wordd
        String replStr2 = str21.replace("Hello", "Bye"); // Bye world
        System.out.println(replStr1);
        System.out.println(replStr2);

                          //Обрезка строки
        // Метод trim() позволяет удалить начальные и конечные пробелы:
        String str22 = "  hello Micha  ";
        str22 = str22.trim(); // hello Micha
        System.out.println(str22);

        //Метод substring() возвращает подстроку, начиная с определенного индекса до конца или до определенного индекса:
        String str23 = "Hello world";
        String substr1 = str23.substring(6); // world
        String substr2 = str23.substring(3,5); //lo
        System.out.println(substr1);
        System.out.println(substr2);

                         //Изменение регистра
        //Метод toLowerCase() переводит все символы строки в нижний регистр, а метод toUpperCase() - в верхний:
        String str24 = "Hello World";
        System.out.println(str24.toLowerCase()); // hello world
        System.out.println(str24.toUpperCase()); // HELLO WORLD

                   //Split
//Метод split() позволяет разбить строку на подстроки по определенному разделителю.
// Разделитель - какой-нибудь символ или набор символов передается в качестве параметра в метод. Например, разобьем текст на отдельные слова:
        String text = "FIFA will never regret it";
        String[] words = text.split(" ");
        for(String word : words){
            System.out.println(word); //В данном случае строка будет разделяться по пробелу:
            //FIFA
            //will
            //never
            //regret
            //it
        }

        
    }
}
