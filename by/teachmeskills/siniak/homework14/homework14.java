package by.teachmeskills.siniak.homework14;
import java.math.BigDecimal;
import java.util.Scanner;

public class homework14 {
    public static void main(String[] args) {
            ExchangeService exchangeService = new ExchangeService();

            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    """
                            1. Курсы валют на сегодня
                            2. Калькулятор валют"""
            );
            while (true) {
                System.out.print("Номер задачи: ");
                int task = Integer.parseInt(scanner.nextLine());
                switch (task) {
                    case 1 -> {
                        ExchangeRate[] rates = exchangeService.getTodayRates();
                        System.out.printf("%-16s %-3s %s%n", "Валюта", "Код", "Курс");
                        for (ExchangeRate rate : rates) {
                            Currency currency = rate.getCurrency();
                            System.out.printf(
                                    "%-16s %3s %s%n", currency.getNameCurrency(),
                                    currency,
                                    rate.getBaseCurrencyRate()
                            );
                        }
                    }
                    case 2 -> {
                        System.out.print("Исходная валюта: ");
                        Currency sourceCurrency = Currency.valueOf(scanner.nextLine());
                        System.out.print("Исходная сумма денег: ");
                        BigDecimal sourceMoneyAmount = new BigDecimal(scanner.nextLine());
                        System.out.print("Целевая валюта: ");
                        Currency targetCurrency = Currency.valueOf(scanner.nextLine());
                        BigDecimal targetMoneyAmount = exchangeService.exchange(sourceCurrency, sourceMoneyAmount, targetCurrency);
                        System.out.println("Результат перевода: " + targetMoneyAmount);
                    }
                }
            }
        }
}