package cloud.deadlock.order.entity;

public class User {
    private String name;
    private String email;
    private String phone;
    private String wechatId;
    private String address;

    public User() {
    }

    public User(String name, String email, String phone, String wechatId, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.wechatId = wechatId;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
