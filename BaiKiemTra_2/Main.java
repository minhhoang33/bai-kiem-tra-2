package BaiKiemTra_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Authentication authentication = new Authentication(userManager);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Đăng nhập");
            System.out.println("2 - Đăng ký");
            System.out.println("0 - Thoát chương trình");

            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    User user = authentication.login();
                    if (user != null) {
                        authentication.handleUserActions(user);
                    }
                    break;
                case 2:
                    handleRegistration(userManager);
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Xử lý đăng ký người dùng mới
    private static void handleRegistration(UserManager userManager) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- Đăng ký ----");
        System.out.print("Nhập username: ");
        String username = scanner.nextLine();

        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        System.out.print("Nhập password: ");
        String password = scanner.nextLine();

        if (userManager.registerUser(username, email, password)) {
            System.out.println("Đăng ký thành công!");
        } else {
            System.out.println("Đăng ký thất bại! Kiểm tra lại thông tin.");
        }
    }
}

