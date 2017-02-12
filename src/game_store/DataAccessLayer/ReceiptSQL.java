package game_store.DataAccessLayer;

import game_store.ApplicationLayer.dataTypes.Receipt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Class to receive data from and write in database, receipts table

public class ReceiptSQL {
    private static ArrayList<Receipt> receipts = new ArrayList<Receipt>();

    public static List<Receipt> loadAllReceipts() throws Exception{   // receive data from database, put in array
        Connection con = MySqlConnection.getConnection();
        Statement st = con.createStatement();
        String sql = ("SELECT * FROM receipts");
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            int receipt_id = rs.getInt("receipt_id");
            receipts.add(new Receipt(receipt_id));
        }

        con.close();
        rs.close();
        st.close();

        return receipts;
    }

    public static void createReceipt(Receipt receipt) throws Exception{    // create new receipt and write in database
        Connection con = MySqlConnection.getConnection();
        Statement st = con.createStatement();
        String sql = ("INSERT INTO receipts VALUES (DEFAULT)");
        st.executeUpdate(sql);

        con.close();
        st.close();
    }
}
