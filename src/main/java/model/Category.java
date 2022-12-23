package model;

public class Category {
    private int idCategory;
    private String name;
    private String note;
    private int user_id;

    public Category() {
    }

    public Category(int idCategory, String name, String note, int user_id) {
        this.idCategory = idCategory;
        this.name = name;
        this.note = note;
        this.user_id = user_id;
    }

    public Category(int idCategory, String name, String note) {
        this.idCategory = idCategory;
        this.name = name;
        this.note = note;
    }

    public Category(String name, String note, int user_id) {
        this.name = name;
        this.note = note;
        this.user_id = user_id;
    }

    public Category(String name, String note) {
        this.name = name;
        this.note = note;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
