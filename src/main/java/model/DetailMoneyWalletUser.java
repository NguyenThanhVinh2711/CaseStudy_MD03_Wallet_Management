package model;

public class DetailMoneyWalletUser {
    private int idUser ;
    private int idWallet;
    private String icon;
    private String name;
    private double finalMoney;
    private double sumMoney;

    public DetailMoneyWalletUser() {
    }

    public DetailMoneyWalletUser(int idUser, int idWallet, String icon, String name, double finalMoney, double sumMoney) {
        this.idUser = idUser;
        this.idWallet = idWallet;
        this.icon = icon;
        this.name = name;
        this.finalMoney = finalMoney;
        this.sumMoney = sumMoney;
    }

    public DetailMoneyWalletUser(int idWallet, String icon, String name, double finalMoney, double sumMoney) {
        this.idWallet = idWallet;
        this.icon = icon;
        this.name = name;
        this.finalMoney = finalMoney;
        this.sumMoney = sumMoney;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFinalMoney() {
        return finalMoney;
    }

    public void setFinalMoney(double finalMoney) {
        this.finalMoney = finalMoney;
    }

    public double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }



}
