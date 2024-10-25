package BaiKiemTra_2;

import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    // Kiểm tra username đã tồn tại chưa
    public boolean isUsernameExist(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    // Kiểm tra email đã tồn tại chưa
    public boolean isEmailExist(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    // Thêm người dùng mới
    public boolean registerUser(String username, String email, String password) {
        if (isUsernameExist(username) || !User.isValidEmail(email) || isEmailExist(email) || !User.isValidPassword(password)) {
            return false;
        }
        users.add(new User(username, email, password));
        return true;
    }

    // Lấy User bằng username
    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // Lấy User bằng email
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}

