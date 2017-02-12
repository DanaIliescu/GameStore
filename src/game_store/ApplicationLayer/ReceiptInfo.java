package game_store.ApplicationLayer;

import game_store.ApplicationLayer.dataTypes.Receipt;
import game_store.DataAccessLayer.ReceiptSQL;

import java.util.List;

/**
 * Created by Dana on 28-Apr-16.
 */
public class ReceiptInfo {
    private static List<Receipt> receipts;
    static Receipt receipt;

    public static List<Receipt> selectAllReceipts() throws Exception
    {
        receipts = ReceiptSQL.loadAllReceipts();
        return receipts;
    }

    public static void createReceipt(Receipt r)  throws Exception
    {
        receipt = r;
        ReceiptSQL.createReceipt(receipt);
    }
}
