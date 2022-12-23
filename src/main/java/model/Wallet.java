package model;

public class Wallet {
    protected int idWallet , idUser;
    protected String icon, nameWallet, description;

    public Wallet() {
    }

    public Wallet(int idWallet, String nameWallet) {
        this.idWallet = idWallet;
        this.nameWallet = nameWallet;
    }

    public Wallet(int idUser, String icon, String nameWallet, String description) {
        super();
        this.idUser = idUser;
        this.icon = icon;
        this.nameWallet = nameWallet;
        this.description = description;
    }

    public Wallet(int idWallet, int idUser, String icon, String nameWallet, String description) {
        this.idWallet = idWallet;
        this.idUser = idUser;
        this.icon = icon;
        this.nameWallet = nameWallet;
        this.description = description;
    }

    public int getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(int idWallet) {
        this.idWallet = idWallet;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNameWallet() {
        return nameWallet;
    }

    public void setNameWallet(String nameWallet) {
        this.nameWallet = nameWallet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
