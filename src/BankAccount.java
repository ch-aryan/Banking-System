//import versions.v0.Validation.BankValidationRules;
//
//import java.versions.v0.util.Scanner;
//
//public class BankAccount {
//    private Integer id;
//    private int pin;
//    private String userName;
//    private String password;
//    private Double balance;
//
//
//    public BankAccount(Integer id, String userName, String password){
//        this.id = id;
//        this.userName = userName;
//        this.password = password;
//        System.out.println(this.userName+"enter your pin");
//        setPin();
//
//    }
//    public void setPin(){
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter your pin details");
//        this.pin = in.nextInt();
//
//    }
//    public void deposit(Double amt){
//        if(BankValidationRules.validateDeposit(amt)){
//            balance = balance + amt;
//        }
//    }
//    public void withdrawl(Double amt){
//        if(BankValidationRules.validateWithdrawl(balance - amt)){
//            balance = balance - amt;
//        }
//    }
//
//    public Double getBalance(){
//        return balance;
//    }
//
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//
//}
///*
//
////    public RegisterAccount(String userName , String password){
////        this.userName = userName;
////        this.password = password;
////    }
////    public String  accountStatus(Integer id){
////        if(this.id == id){
////            return "Account successfully created";
////        }
////        return "Invalid Id credentials";
////    }
////    public String accountLogin(Integer id, String userName , String password){
////        if(
////        this.id == id &&
////        this.userName == userName &&
////        this.password == password){
////            return "Login successFul";
////        }
////        return "Unable to login Invalid Credentials";
////    }
// */
