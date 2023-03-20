package by.teachmeskills.siniak.homework14;
public enum Currency {
    BYN("Белорусский рубль"),
    USD("Доллар США"),
    EUR("Евро"),
    RUB("Российский рубль"),
    GBP("Фунт стерлингов"),
    CNY("Китайский юань");

private final String nameCurrency;

    Currency(String nameCurrency) {
        this.nameCurrency = nameCurrency;
    }

    public String getNameCurrency() {
        return nameCurrency;
    }
}
