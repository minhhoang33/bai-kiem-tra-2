package BaiKiemTra_2;

import java.util.Scanner;

public class Authentication {
    private UserManager userManager;
    private Scanner scanner;

    public Authentication(UserManager userManager) {
        this.userManager = userManager;
        this.scanner = new Scanner(System.in);
    }

    // Đăng nhập
    public User login() {
        System.out.println("---- Đăng nhập ----");

        System.out.print("Nhập username: ");
        String username = scanner.nextLine();

        User user = userManager.getUserByUsername(username);
        if (user == null) {
            System.out.println("Kiểm tra lại username!");
            return null;
        }

        System.out.print("Nhập password: ");
        String password = scanner.nextLine();

        if (!user.getPassword().equals(password)) {
            System.out.println("Sai password!");
            handleWrongPassword();
            return null;
        }

        System.out.println("Chào mừng " + user.getUsername() + ", bạn có thể thực hiện các công việc sau:");
        return user;
    }

    // Xử lý khi password sai
    private void handleWrongPassword() {
        System.out.println("1 - Đăng nhập lại");
        System.out.println("2 - Quên mật khẩu");

        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 2) {
            resetPassword();
        }
    }

    // Quên mật khẩu
    private void resetPassword() {
        System.out.print("Nhập email của bạn: ");
        String email = scanner.nextLine();
        User user = userManager.getUserByEmail(email);

        if (user == null) {
            System.out.println("Email không tồn tại trong hệ thống!");
            return;
        }

        System.out.print("Nhập mật khẩu mới: ");
        String newPassword = scanner.nextLine();
        if (User.isValidPassword(newPassword)) {
            user.setPassword(newPassword);
            System.out.println("Đổi mật khẩu thành công!");
        } else {
            System.out.println("Password không hợp lệ!");
        }
    }

    // Xử lý các chức năng sau khi đăng nhập
    public void handleUserActions(User user) {
        while (true) {
            System.out.println("1 - Thay đổi username");
            System.out.println("2 - Thay đổi email");
            System.out.println("3 - Thay đổi mật khẩu");
            System.out.println("4 - Đăng xuất");
            System.out.println("0 - Thoát chương trình");

            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    changeUsername(user);
                    break;
                case 2:
                    changeEmail(user);
                    break;
                case 3:
                    changePassword(user);
                    break;
                case 4:
                    System.out.println("Đăng xuất thành công.");
                    return;
                case 0:
                    System.out.println("Chương trình kết thúc.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Thay đổi username
    private void changeUsername(User user) {
        System.out.print("Nhập username mới: ");
        String newUsername = scanner.nextLine();
        if (!userManager.isUsernameExist(newUsername)) {
            user.setUsername(newUsername);
            System.out.println("Thay đổi username thành công!");
        } else {
            System.out.println("Username đã tồn tại!");
        }
    }

    // Thay đổi email
    private void changeEmail(User user) {
        System.out.print("Nhập email mới: ");
        String newEmail = scanner.nextLine();
        if (User.isValidEmail(newEmail) && !userManager.isEmailExist(newEmail)) {
            user.setEmail(newEmail);
            System.out.println("Thay đổi email thành công!");
        } else {
            System.out.println("Email không hợp lệ hoặc đã tồn tại!");
        }
    }

    // Thay đổi mật khẩu
    private void changePassword(User user) {
        System.out.print("Nhập mật khẩu mới: ");
        String newPassword = scanner.nextLine();
        if (User.isValidPassword(newPassword)) {
            user.setPassword(newPassword);
            System.out.println("Thay đổi mật khẩu thành công!");
        } else {
            System.out.println("Password không hợp lệ!");
        }
    }
}

