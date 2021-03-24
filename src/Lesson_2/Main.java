package Lesson_2;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] arrayNumbers = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] letterWrongArrayNumbers = {
                {"12", "0", "v", "9"},
                {"16", "29", "187", "0"},
                {"3", "741", "11", "8"},
                {"20", "7", "3", "1"}
        };

        String[][] wrongSizeArrayNumbers = {
                {"13", "25"},
                {"24", "45"}
        };

        System.out.println("Массив корректен");
        changeToIntAndSum(arrayNumbers);

        System.out.println("Массив некорректен - присутствуют буквы/символы");
        try {
            changeToIntAndSum(letterWrongArrayNumbers);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        System.out.println("Неверно задан размер массива");
        try {
            changeToIntAndSum(wrongSizeArrayNumbers);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    private static void changeToIntAndSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int numberOfSum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array.length != 4 && array[i].length != 4) {
                    throw new MyArraySizeException("Размер массива должен быть: [4][4]. Размер данного массива: [" + array.length + "][" + array[i].length + "].");
                }
                try {
                    Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в строке " + (i+1) + ", столбец " + (j+1) + " - введены неверные данные (символ/буква)");
                }
                numberOfSum += Integer.parseInt(array[j][j]);
            }
        }
        System.out.println("Сумма всех цифр в массиве составляет " + numberOfSum);
    }
}