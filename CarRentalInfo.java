import java.io.Serializable;

public class CarRentalInfo implements Serializable {

     private String name;
     private String mobile;
     private String cars;
     private String lic;
     private String time;
     private String level;
     private String total;

     // initializes an Account with provided values
     public CarRentalInfo(String name, String mobile, String cars, String lic, String time, String level,
               String total) {
          this.name = name;
          this.mobile = mobile;
          this.cars = cars;
          this.lic = lic;
          this.time = time;
          this.level = level;
          this.total = total;

     }

     public void setName(String name) {
          this.name = name;
     }

     // get account number
     public String getName() {
          return name;
     }

     public void setMobile(String mobile) {
          this.mobile = mobile;
     }

     // get account number
     public String getMobile() {
          return mobile;
     }

     public void setCars(String cars) {
          this.cars = cars;
     }

     // get account number
     public String getCars() {
          return cars;
     }

     public void setLic(String lic) {
          this.lic = lic;
     }

     // get account number
     public String getLic() {
          return lic;
     }

     public void setTime(String time) {
          this.time = time;
     }

     // get account number
     public String getTime() {
          return time;
     }

     public void setLevel(String level) {
          this.level = level;
     }

     // get account number
     public String getLevel() {
          return level;
     }

     public void setTotal(String total) {
          this.total = total;
     }

     // get account number
     public String getTotal() {
          return total;
     }
}
