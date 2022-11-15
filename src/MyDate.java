import java.util.Scanner;

public class MyDate {
    int year;
    int month;
    int day;
    int daysLeft;

    public MyDate() {
        System.out.println("Введите дату в формате YYYY-MM-DD или YY-MM-DD");
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();
        parseDate(date);
    }

    private void parseDate(String date) {
        try {
            String[] subStr = date.split("-");
            this.year = Integer.parseInt(subStr[0]) % 1000;
            this.month = Integer.parseInt(subStr[1]);
            this.day = Integer.parseInt(subStr[2]);
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Неправильная дата");
        }
    }

    private int getMonthDays(boolean isLeap, int month) {
        int result = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: result = 31; break;
            case 4:
            case 6:
            case 9:
            case 11: result = 30; break;
            case 2: if (isLeap) result = 29; else result = 28; break;
        }
        return result;
    }

    public void getDaysLeft() {
        boolean isLeap = (this.year % 4) == 0;
        this.daysLeft = getMonthDays(isLeap, this.month) - this.day;
        System.out.println(this.daysLeft);
    }
}
