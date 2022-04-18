package pl.javastart.zadanie21;

public enum ProductCategory {
    FOOD("spożywcze"), AGD("AGD"), OTHER("pozostałe");

    private String translation;

    ProductCategory(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
