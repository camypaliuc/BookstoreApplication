package org.bookstoreapp.model;

public class Order {
    private String FullName;
    private String DeliveryAdress;
    private String Email;
    private String PhoneNr;
    private static int accepted;
    public Order(){

    }
    public Order(String fullName, String deliveryAdress, String email, String phoneNr, int accepted) {
        FullName = fullName;
        DeliveryAdress = deliveryAdress;
        Email = email;
        PhoneNr = phoneNr;
        accepted=0;
    }
  //  public Order(String fullName, String deliveryAdress, String email, String phoneNr) {
    //    Order(fullName, deliveryAdress, email, phoneNr, 0);
   // }
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

    @Override
    public String toString() {
        return "Order{" +
                "FullName='" + FullName + '\'' +
                ", DeliveryAdress='" + DeliveryAdress + '\'' +
                ", Email='" + Email + '\'' +
                ", PhoneNr='" + PhoneNr + '\'' +
                ", accepted='" + accepted + '\'' +
                '}';
    }
}


