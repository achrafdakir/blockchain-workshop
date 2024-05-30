package achraf.blockchain.entity;

import java.util.ArrayList;
import java.util.List;

public class TransactionPool {

    private final List<Transaction> pendingTransactions;

    public TransactionPool() {
        this.pendingTransactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        pendingTransactions.add(transaction);
    }

    public List<Transaction> getPendingTransactions() {
        return pendingTransactions;
    }

    public void removeTransactions(List<Transaction> transactions) {
        pendingTransactions.removeAll(transactions);
    }

    public void removeTransaction(Transaction transaction) {
        pendingTransactions.remove(transaction);
    }

}
