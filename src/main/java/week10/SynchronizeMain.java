package week10;

import java.util.Arrays;

public class SynchronizeMain {
    public static void main(String[] args) {
        Account account = new Account();
        BankThread bt1 = new BankThread(account);
        BankThread bt2 = new BankThread(account);

        bt1.start();
        bt2.start();

        try {
            bt1.join();
            bt2.join();
            System.out.println(account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class Account {
    private int balance = 1000;
    public int getBalance(){
        return balance;
    }

    public void withdraw(int money){
        synchronized (this){
            if( balance >= money){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                balance -= money;
            }
        }

    }
}

class BankThread extends Thread{
    Account account;

    public BankThread(Account account) {
        this.account = account;
    }

    @Override
    public void run(){
        while(account.getBalance() > 0) {
            int money = (int)(Math.random() * 5 + 1) * 100;

            account.withdraw(money);
            System.out.println(account.getBalance() + " " + money);

        }
    }
}