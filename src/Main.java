import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        Business business = new Business();
        int cases = 0;
        do {
            System.out.println("chương trình quản lý danh bạ ");
            System.out.println("chọn chức năng");
            System.out.println("1 : thêm mới danh bạ");
            System.out.println("2 : xem danh bạ");
            System.out.println("3 : xóa");
            System.out.println("4 : tìm kiếm ");
            System.out.println("5 : exit ");
            try {
                business.readFile();
                business.writeToFile();
                cases = Integer.parseInt(sc.nextLine());
                switch (cases) {
                    case 1:
                    business.addInfos();
                    break;
                    case 2:
                        business.show();
                        break;
                    case 3:
                        business.delete();
                        break;
                    case 4:
                        business.search();
                        break;
            }
            }catch (Exception e ){
                System.out.println("nhập lại đê ");
            }
        } while (cases != 5);
    }

}
