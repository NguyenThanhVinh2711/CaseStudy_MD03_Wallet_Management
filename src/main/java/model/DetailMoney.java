package model;

import java.sql.Date;

public class DetailMoney implements Comparable<DetailMoney>{
    protected int idDetail;
    protected int id_wallet;
    protected String name_wallet;
    protected int user_id;
    protected double money;
    protected int id_category;
    protected String name_category;
    protected String note;
    protected Date date;

    public DetailMoney() {
    }

    public DetailMoney(int idDetail, int id_wallet, String name_wallet, int user_id, double money, int id_category, String name_category, String note, Date date) {
        this.idDetail = idDetail;
        this.id_wallet = id_wallet;
        this.name_wallet = name_wallet;
        this.user_id = user_id;
        this.money = money;
        this.id_category = id_category;
        this.name_category = name_category;
        this.note = note;
        this.date = date;
    }

    public DetailMoney(int idDetail, int id_wallet, double money, int id_category, String note, Date date) {
        this.idDetail = idDetail;
        this.id_wallet = id_wallet;
        this.money = money;
        this.id_category = id_category;
        this.note = note;
        this.date = date;
    }

    public DetailMoney(int idDetail, int id_wallet, double money, String note, Date date) {
        this.idDetail = idDetail;
        this.id_wallet = id_wallet;
        this.money = money;
        this.note = note;
        this.date = date;
    }

    public DetailMoney(int id_wallet, double money, int id_category, String note, Date date) {
        this.id_wallet = id_wallet;
        this.money = money;
        this.id_category = id_category;
        this.note = note;
        this.date = date;
    }

    public DetailMoney(int id_wallet, double money, String note, Date date) {
        this.id_wallet = id_wallet;
        this.money = money;
        this.note = note;
        this.date = date;
    }

    public String getName_wallet() {
        return name_wallet;
    }

    public void setName_wallet(String name_wallet) {
        this.name_wallet = name_wallet;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getId_wallet() {
        return id_wallet;
    }

    public void setId_wallet(int id_wallet) {
        this.id_wallet = id_wallet;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public Date getDate() {
        return date;

    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(DetailMoney detailMoney) {
        return this.date.compareTo(detailMoney.date);
    }
}

