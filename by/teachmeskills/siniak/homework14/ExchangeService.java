package by.teachmeskills.siniak.homework14;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeService {

    private static final Currency BASE_CURRENCY = Currency.BYN;
    private static final ExchangeRate BASE_RATE = new ExchangeRate(BASE_CURRENCY, BigDecimal.ONE);
    public ExchangeRate[] getTodayRates(){
    return new ExchangeRate[]{
        new ExchangeRate(Currency.USD, new BigDecimal("2.7982")),
        new ExchangeRate(Currency.EUR, new BigDecimal("2.9944")),
        new ExchangeRate(Currency.GBP, new BigDecimal("3.3742")),
        new ExchangeRate(Currency.RUB, new BigDecimal("0.037649")),
        new ExchangeRate(Currency.CNY, new BigDecimal("0.40982"))
        };
    }

    public BigDecimal exchange(Currency sourceCurrency,BigDecimal sourceMoney,Currency targetCurrency){
        if (sourceCurrency == targetCurrency) {
            return sourceMoney;
        }
        ExchangeRate[] rates = getTodayRates();

        ExchangeRate sourceRate = findCurrency(rates, sourceCurrency);
        ExchangeRate targetRate = findCurrency(rates, targetCurrency);

        BigDecimal baseMoney = sourceMoney.multiply(sourceRate.getBaseCurrencyRate());
        return baseMoney.divide(targetRate.getBaseCurrencyRate(), 2, RoundingMode.HALF_UP);

    }

    private ExchangeRate findCurrency(ExchangeRate[] rates,Currency currency ){
    if (currency==BASE_CURRENCY){
        return BASE_RATE;
    }
        for (ExchangeRate rate : rates) {
            if (rate.getCurrency() == currency) {
                return rate;
            }
        }
        throw new IllegalArgumentException("Rate does not exist");
    }
}
