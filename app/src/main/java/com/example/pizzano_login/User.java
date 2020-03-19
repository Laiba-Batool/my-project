package com.example.pizzano_login;

public class User
{
    public String id;
    public String userName;
    public String  userAge;
    public String  contactNumber;
    public String userEmail;
    public String userPassword;

    public User( String id,String userName,String  userAge, String  contactNumber,String userEmail,String userPassword)
    {
        this.id=id;
        this.userName=userName;
        this.userAge=userAge;
        this.contactNumber=contactNumber;
        this.userEmail=userEmail;
        this.userPassword=userPassword;
    }


}
