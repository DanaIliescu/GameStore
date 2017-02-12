package game_store.ApplicationLayer.dataTypes;

/**
 * Created by Dana on 28-Apr-16.
 */
public class Receipt {
    private int receipt_id;

    public Receipt(int receipt_id) {
        this.receipt_id = receipt_id;
    }

    public int getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
    }
}
