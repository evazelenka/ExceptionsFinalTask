package Attestation.Model;

public class User {
    private String[] fio;
    private String dateOfBirth;
    private long phoneNumber;
    private char sex;

    public User(String[] fio, String dateOfBirth, long phoneNumber, char sex){
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }
    public String getLastName(){
        return fio[0];
    }

    @Override
    public String toString() {
        if(fio[2] != null){
            return "ФИО " + fio[0] + " " + fio[1] + " " + fio[2] +
                    ", дата рождения:'" + dateOfBirth + '\'' +
                    ", тел." + phoneNumber +
                    ", пол:" + sex;
        }
        return "ФИО " + fio[0] + " " + fio[1] +
                ", дата рождения:'" + dateOfBirth + '\'' +
                ", тел." + phoneNumber +
                ", пол:" + sex;
    }

    public char getSex() {
        return sex;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String[] getFio() {
        return fio;
    }
}
