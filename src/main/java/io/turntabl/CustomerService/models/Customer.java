package io.turntabl.CustomerService.models;

public class Customer {
    private String name;
    private String address;
    private String email;
    private String telephone;

    public Customer() {

    }

    public String getName() { return name;}

    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getTelephone() {return telephone;}

    public void setTelephone(String telephone) {this.telephone = telephone;}
}
