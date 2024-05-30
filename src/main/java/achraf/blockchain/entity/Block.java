package achraf.blockchain.entity;

import achraf.blockchain.controller.HashUtil;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter @Setter
public class Block {
    private int index;

    private Instant timestamp;

    private String previousHash;

    private String currentHash;

    private List<Transaction> transactions;
    private int nonce;


    public Block(int index, String previousHash, List<Transaction> transactions, int nonce) {
        this.index = index;
        this.timestamp = Instant.now();
        this.previousHash = previousHash;
        this.transactions = transactions;
        this.nonce = nonce;
        this.currentHash = calculateHash();
    }
    public String calculateHash() {
        String dataHash = index + timestamp.toString() + previousHash + transactions.toString() + nonce;
        return HashUtil.calculateSHA256(dataHash);
    }
    public static Block generateBlock(int index, String previousHash,List<Transaction> transactions, int nonce) {
        return new Block(index, previousHash, transactions, nonce);
    }
    // Validate the block by checking if the current hash matches the calculated hash
    public boolean validateBlock() {
        return this.currentHash.equals(calculateHash());
    }

    public void incrementNonce() {
        nonce++;
    }
}
