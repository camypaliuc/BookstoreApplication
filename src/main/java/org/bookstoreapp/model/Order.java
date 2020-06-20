package org.bookstoreapp.model;

public class Order {
    private String UserName;
    private String FullName;
    private String DeliveryAdress;
    private String Email;
    private String PhoneNr;
    private int accepted;
    public Order(){

    }
    public Order(String userName, String fullName, String deliveryAdress, String email, String phoneNr, int Accepted) {
        UserName = userName;
        FullName = fullName;
        DeliveryAdress = deliveryAdress;
        Email = email;
        PhoneNr = phoneNr;
        accepted= Accepted;
    }
  //  public Order(String fullName, String deliveryAdress, String email, String phoneNr) {
    //    Order(fullName, deliveryAdress, email, phoneNr, 0);
   // }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(){accepted=1;}
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getDeliveryAdress() {
        return DeliveryAdress;
    }

    public void setDeliveryAdress(String deliveryAdres) {
        DeliveryAdress = deliveryAdres;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNr() {
        return PhoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        PhoneNr = phoneNr;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }


    @Override
    public String toString() {
        return "Order{" +
                "UserName='" +UserName + '\'' +
                ",FullName='" + FullName + '\'' +
                ", DeliveryAdress='" + DeliveryAdress + '\'' +
                ", Email='" + Email + '\'' +
                ", PhoneNr='" + PhoneNr + '\'' +
                ", accepted='" + accepted + '\'' +
                '}';
    }
}


