import java.util.*;

public class Bank {
    private Scanner in;
    private LinkedList<Account> account;
    public Bank () {
        in = new Scanner(System.in);
        account = new LinkedList<>();
    } // constructor

    private void createAcc (){
    System.out.print(" Please enter account number > ");
    String accNumber = in.nextLine();
    System.out.print("Please enter account holder name > ");
    String accHolder = in.nextLine();
    System.out.print("Please enter balance > ");
    double balance = in.nextDouble();
    System.out.println();

    try {
        Account acc = new Account(accNumber, accHolder, balance);
        account.add(acc);
        System.out.println("Account is created successfully");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }


    }
     // createAcc

    private void queryAccByNumber () {
        System.out.print("Please enter account number: ");
        String accNumber = in.nextLine();
        Account acc = findAccountByNumber(accNumber);
        if (acc != null) {
            displayAccount(acc);
        } else {
            System.out.println("You dont have an account ");
        }
    

    } // queryAcc

    private void queryAccByName () {
        System.out.print("Please enter account holder name: ");
        String name = in.nextLine(); 
      
    
            
    } // queryAcc

    private void displayAccountByNumber (String accNo) {

        Account acc = findAccountByNumber(accNo);
        if (acc != null) {
            displayAccount(acc);
        } else {
            System.out.println(" there is no account here ");
        }
    }
     // displayAccountByNumber

    private Account findAccountByNumber (String accNo) {
        for (Account acc : account) {
            if (acc.getAccNumber().equals(accNo)) {
                return acc;
            }
        return acc;
        }
        return null;
    } // findAccountByNumber

    private void displayAccountbyName (String name) {
        for (Account acc : account) {
            if (acc.getAccHolder().equalsIgnoreCase(name)) {
                System.out.println(name);
                return;
            }
        }
        System.out.println("Account not found.");
    }
        
     // displayAccountbyName

    private void displayAccount (Account acc) {
        System.out.println(acc);
    } // displayAccount

    private void doDeposit  () {
        System.out.print("Please enter  account number: ");
        String accNumber = in.nextLine();
        System.out.print("Please enter  amount to deposit: ");
        double amt = in.nextDouble();
        System.out.println();

        Account acc =findAccountByNumber(accNumber) ;
               if (acc!=null) {
                    acc.deposit(amt);
                    System.out.println("Deposit successful, new balance is >  " + acc.getBalance());
        } else {
            System.out.println("Could not find the account");
        }
    
   
    }
     // doDeposit

    private void doWithdraw() throws Exception {
        System.out.print("Please enter  account number: ");
        String accNumber = in.nextLine();
        System.out.print("Please enter  amount to deposit: ");
        double amt = in.nextDouble();
        System.out.println();

        Account acc =findAccountByNumber(accNumber) ;
               if (acc!=null) {
                    acc.withdraw(amt);
                    System.out.println("Withdrawl was  successful, new balance is >  " + acc.getBalance());
        } else {
            System.out.println("Could not find the account");
        }
    } // doWithdraw

    private void listAll () {
        System.out.println(account);
    } // listAll

    private void runTests () {
        // Test account creation
        Account acc = new Account("123-TEST-456", "T. Ester", 100.00);
        System.out.println(acc);

        // Test withdrawals and deposits
        try {
            acc.withdraw(50.00);
        }
        catch (Exception exc) {
            System.err.println("Invalid withdrawal!");
        }
        System.out.println(acc);
        acc.deposit(10.00);
        System.out.println(acc);
        try {
            acc.withdraw(61.00);
        }
        catch (Exception exc) {
            System.out.println("Withdrawal not permitted.");
        }
        System.out.println(acc);

        // Test lookup function
        try {
            account.add(acc);
        }
        catch (Exception exc) {
            System.err.println("Account addition failed.");
        }
        Account a = findAccountByNumber(acc.getAccNumber());
        if (a != acc)
            System.err.println("Accounts are not the same!");
        a = findAccountByNumber("##random non-account number@@"); // Should fail
        if (a != null)
            System.err.println("Found non-existent account!");
        else
            System.out.println("Non-existent account not found.");
        try {
            account.add(acc); // Should throw exception
            System.err.println("Added duplicate account!");
        }
        catch (Exception exc) {
            System.out.println("Duplicate account not permitted.");
        }
        account.remove(acc); // Remove test account
    } // runTests
    
    public void doBanking () throws Exception {
        while (true) {
            System.out.println("\nWelcome to your private bank!");
            System.out.println("Menu:");
            System.out.println("C) Create account");
            System.out.println("D) Deposit");
            System.out.println("W) Withdraw");
            System.out.println("Q) Query account by number");
            System.out.println("N) Query account by name");
            System.out.println("L) List all accounts");
            System.out.println("0) Quit");
            System.out.print("Enter your option: ");
            String cmd = in.nextLine();
            switch (cmd) {
                case "0": // Quit
                    return;
                case "C": case "c":
                    createAcc();
                    break;
                case "D": case "d":
                    doDeposit();
                    break;
                case "W": case "w":
                    doWithdraw();
                    break;
                case "Q": case "q":
                    queryAccByNumber();
                    break;
                case "N": case "n":
                    queryAccByName();
                    break;
                case "L": case "l":
                    listAll();
                    break;
                default:
                    System.out.printf("Command %s not valid.  Please reenter...", cmd);
                    break;
            } // switch
        } // while
    } // doBanking

    public static void main (String[] args) throws Exception {
        Bank RUNB = new Bank();
        RUNB.runTests();
        RUNB.doBanking();
    } // main
}// class Bank