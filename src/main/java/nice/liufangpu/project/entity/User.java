package nice.liufangpu.project.entity;

/**
 * Created by liufangpu on 2017-9-19 17:20.
 */
public class User {
   // private Integer id;
    private String name;
    private String nickname;
    private String telephone;
    private Integer uid;
    private String amount;
    private String region;
    private String ip;
    private String hhId;
    private Integer accessTimes=0 ;

    public Integer getAccessTimes() {
        return accessTimes;
    }

    public void setAccessTimes(Integer accessTimes) {
        this.accessTimes = accessTimes;
    }

    public String getHhId() {
        return hhId;
    }

    public void setHhId(String hhId) {
        this.hhId = hhId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", uid=" + uid +
                ", amount='" + amount + '\'' +
                ", region='" + region + '\'' +
                ", ip='" + ip + '\'' +
                ", hhId='" + hhId + '\'' +
                ", accessTimes=" + accessTimes +
                '}';
    }
}
