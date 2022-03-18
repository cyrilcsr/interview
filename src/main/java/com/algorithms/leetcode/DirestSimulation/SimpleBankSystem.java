package com.algorithms.leetcode.DirestSimulation;

/*
Leeetcode 2043
*/
public class SimpleBankSystem {
    class Bank {

        long[] balance;
        int accountNum;
        public Bank(long[] balance) {
            this.balance = balance;
            this.accountNum = balance.length;
        }

        public boolean transfer(int account1, int account2, long money) {
            if(validAccount(account1)&&validAccount(account2)){
                if(balance[account1-1]>=money){
                    balance[account1-1]-=money;
                    balance[account2-1]+=money;
                    return true;
                }
            }
            return false;
        }

        public boolean deposit(int account, long money) {
            if(validAccount(account)){
                balance[account-1]+=money;
                return true;
            }
            return false;
        }

        public boolean withdraw(int account, long money) {
            if(validAccount(account)&&balance[account-1]>=money){
                balance[account-1]-=money;
                return true;
            }
            return false;
        }

        private boolean validAccount(int account){
            if(0<account&&account<=accountNum){
                return true;
            }
            return false;
        }
    }
}
