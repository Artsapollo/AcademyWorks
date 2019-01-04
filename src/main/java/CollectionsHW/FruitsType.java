package CollectionsHW;

public enum FruitsType {
    APPLE("Canadian"),
    STRAWBERRY("Maldives"),
    PEAR("Ukrainian"),
    PINEAPPLE("Sweddish"),
    BLUEBERRY("Carpatian"),
    DRAGONFRUIT("Malaysian");

    private String country;

    FruitsType(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}

/*
растоппить чайную ложку масла
две столовых ложки сахара
три ст.ложки сметаны
две ст.л какао
без горки всё
*/