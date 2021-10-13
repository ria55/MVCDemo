package application.models;

public class FunForm {

    private String name;
    private int age;
    private int favoriteNumber;

    public FunForm() {}

    public FunForm(String name, int age, int favoriteNumber) {
        this.name = name;
        this.age = age;
        this.favoriteNumber = favoriteNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(int favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

}
