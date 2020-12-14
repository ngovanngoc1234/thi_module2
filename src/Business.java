import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Business implements DisPlay, Serializable {
    Scanner sc = new Scanner(System.in);
    private ArrayList<PhoneBook> phoneBooks = new ArrayList<>();

    public ArrayList<PhoneBook> getPhoneBooks() {
        return phoneBooks;
    }

    public void setPhoneBooks(ArrayList<PhoneBook> phoneBooks) {
        this.phoneBooks = phoneBooks;
    }

    public ArrayList<PhoneBook> readFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("listphonebook.dat");
        ObjectInputStream ojb = new ObjectInputStream(fileInputStream);
        setPhoneBooks((ArrayList<PhoneBook>) (ojb.readObject()));
        ojb.close();
        fileInputStream.close();
        return getPhoneBooks();
    }

    public void writeToFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("listphonebook.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(getPhoneBooks());
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void addInfos() throws IOException, ClassNotFoundException {
       setPhoneBooks(readFile());
        int input = 0;
        do {
            System.out.println("chọn chức năng ");
            System.out.println("1 : nhập  thông tin");
            System.out.println("2 : thoát");
            try {
                input = Integer.parseInt(sc.nextLine());
                switch (input) {
                    case 1:
                        PhoneBook phoneBook = new PhoneBook();
                        boolean check = false;
                        do {
                            System.out.println("nhập sdt");
                            String s = "^(09|01[2|6|8|9])+([0-9]{8})\\b";
                            String line = sc.nextLine();
                            Pattern pattern = Pattern.compile(s);
                            Matcher matcher = pattern.matcher(line);
                            if (matcher.find()) {
                                phoneBook.setNumberPhone(line);
                                check = true;
                            } else {
                                System.out.println("Vui Lòng Không Để Trống");
                            }
                        } while (!check);

                        System.out.println("nhập nhóm ");
                        String nhom = sc.nextLine();
                        phoneBook.setPhonebook(nhom);
                        System.out.println("nhập tên");
                        String name = sc.nextLine();
                        phoneBook.setName(name);
                        System.out.println("Nhập giới tính ");
                        String sex = sc.nextLine();
                        phoneBook.setSex(sex);
                        System.out.println("nhập địa chỉ ");
                        String address = sc.nextLine();
                        phoneBook.setAddress(address);
                        System.out.println("nhập ngày tháng năm sinh ");
                        String date = sc.nextLine();
                        phoneBook.setDateOfBirth(date);
                        boolean check1 = false;
                        do {
                            System.out.println("nhập địa chỉ email ");
                            String s = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
                            String line = sc.nextLine();
                            Pattern pattern = Pattern.compile(s);
                            Matcher matcher = pattern.matcher(line);
                            if (matcher.find()) {
                                check1 = true;
                                phoneBook.setEmail(line);
                            } else {
                                System.out.println("Vui Lòng Không Để Trống");
                            }
                        } while (!check1);
                        getPhoneBooks().add(phoneBook);
                        break;
                }
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("mời nhập lại ");
            }
        } while (input != 2);
    }

    @Override
    public void show() throws IOException, ClassNotFoundException {
        writeToFile();
        readFile();
        int n = 0;
        do {
            System.out.println("mời chọn");
            System.out.println("1: hiện thị");
            System.out.println("2: thoát");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    for (PhoneBook phoneBook : getPhoneBooks()) {
                        System.out.println(phoneBook.toString());
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("mời nhập lại");
            }
        } while (n != 2);
    }

    @Override
    public void search() {
        int n = 0;
        do {
            System.out.println("Chọn Chức Năng");
            System.out.println("1 : Tìm");
            System.out.println("2 : Thoát ");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Nhập Thông Tin Cần Tìm :");
                    String regex = sc.nextLine();
                    int index = 0;
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher;
                    for (int i = 0; i < getPhoneBooks().size(); i++) {
                        matcher = pattern.matcher(getPhoneBooks().get(i).getName());
                        if (matcher.find()) {
                            System.out.println("STT " + i + " : " + getPhoneBooks().get(i).toString());
                            index++;
                        }
                    }
                    if (index <= 0) {
                        System.out.println("Tên này không có trong danh sách\n ");
                    }
                }
            } catch (Exception e) {
                System.out.println("Nhâp vào đê ");
            }
        } while (n != 2);
    }

    @Override
    public void edit() {
        int num = 0;
        do {
            System.out.println("Nhập Thông tin cần sửa ");
            System.out.println("Chọn Chỉnh Sửa Theo ");
            System.out.println("1 : theo tên");
            System.out.println("2 : theo số điện thoại ");
            try {
                num = Integer.parseInt(sc.nextLine());
                String edit;
                int n = 0;
                switch (num) {
                    case 1:
                        System.out.println("Tên Cần Chỉnh :");
                        edit = sc.nextLine();
                        for (PhoneBook name : getPhoneBooks()) {
                            if (edit.equals(name.getName())) {
                                System.out.println("Chỉnh tên : ");
                                String add = sc.nextLine();
                                name.setName(add);
                                System.out.println("Tên sau khi chỉnh sửa " + name.getName());
                                n++;
                                break;
                            }
                        }
                        if (n == 0) {
                            System.out.println("tên không co trong danh sách");
                            break;
                        }
                    case 2:
                        System.out.println("nhập tên cần chỉnh lại số ");
                        edit = sc.nextLine();
                        for (PhoneBook numberPhone : getPhoneBooks()) {
                            if (edit.equals(numberPhone.getName())) {
                                System.out.println("chỉnh lại ");
                                String add = sc.nextLine();
                                numberPhone.setNumberPhone(add);
                                n++;
                                break;
                            }
                        }
                        if (n == 0) {
                            System.out.println("tên ko có trong danh bạ");
                            break;
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("nhập lại");
            }
        } while (num != 3);
    }

    @Override
    public void delete() {
        int n = 0;
        do {
            System.out.println("1: Xóa");
            System.out.println("2: Thoát");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Nhập tên cần xóa ");
                    String id = sc.nextLine();
                    PhoneBook phoneBook = null;
                    int size = getPhoneBooks().size();
                    for (int i = 0; i < size; i++) {
                        if (phoneBooks.get(i).getName().equals(id)) {
                            phoneBook = getPhoneBooks().get(i);
                            break;
                        }
                    }
                    if (phoneBook != null) {
                        System.out.println("Đã Xóa Tên Là : \n" + phoneBook.getName());
                        getPhoneBooks().remove(phoneBook);
                    } else {
                        System.out.println("Không Có tên Trong Danh Sách");
                    }
                }
            } catch (Exception e) {
                System.out.println("Nhập sai rồi");
            }
        } while (n != 2);
    }
}
