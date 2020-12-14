import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook implements Serializable {
    private String numberPhone;
    private String phonebook;
    private String name;
    private String sex;
    private String address;
    private String DateOfBirth;
    private String Email;

    public PhoneBook() {
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getPhonebook() {
        return phonebook;
    }

    public void setPhonebook(String phonebook) {
        this.phonebook = phonebook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public PhoneBook(String numberPhone, String phonebook, String name, String sex, String address, String dateOfBirth, String email) {
        this.numberPhone = numberPhone;
        this.phonebook = phonebook;
        this.name = name;
        this.sex = sex;
        this.address = address;
        DateOfBirth = dateOfBirth;
        Email = email;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "numberPhone='" + numberPhone + '\'' +
                ", Phonebook='" + phonebook + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}

