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

    public void addInfo() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            System.out.println("nhập sdt");
            String s = "^(09|01[2|6|8|9])+([0-9]{8})\\b";
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                check = true;
                numberPhone = line;
            } else {
                System.out.println("Vui Lòng Không Để Trống");
            }
        }while (!check);

        System.out.println("nhập nhóm ");
        phonebook = sc.nextLine();
        System.out.println("nhập tên");
        name = sc.nextLine();
        System.out.println("Nhập giới tính ");
        sex = sc.nextLine();
        System.out.println("nhập địa chỉ ");
        address = sc.nextLine();
        System.out.println("nhập ngày tháng năm sinh ");
        DateOfBirth = sc.nextLine();

        boolean check1 = false;
        do {
            System.out.println("nhập địa chỉ email ");
            String s = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                check1 = true;
                Email = line;
            } else {
                System.out.println("Vui Lòng Không Để Trống");
            }
        }while (!check1);

    }
}

