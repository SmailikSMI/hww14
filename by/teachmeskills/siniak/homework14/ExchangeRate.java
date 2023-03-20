package by.teachmeskills.siniak.homework14;
import java.math.BigDecimal;

public class ExchangeRate {
    private final Currency currency;
    private final BigDecimal baseCurrencyRate;

    public ExchangeRate(Currency currency, BigDecimal baseCurrencyRate) {
        if (baseCurrencyRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid base currency rate");
        }
        this.currency = currency;
        this.baseCurrencyRate = baseCurrencyRate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getBaseCurrencyRate() {
        return baseCurrencyRate;
    }
}
