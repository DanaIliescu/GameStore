package game_store.DataAccessLayer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.ResultSet;

// Class to receive data from database
// REVIEW ORDERS and SEARCH FOR GAME

public class ReviewOrders {
    //Tableview and data
    private static ObservableList<ObservableList> data;
    //Connection database
    public static TableView buildData(TableView tableview){   // builds a tableview with receipts/orders
        Connection c ;
        data = FXCollections.observableArrayList();
        try{
            c = MySqlConnection.getConnection();
            String SQL = "SELECT receipt_id, game_title, g.game_price, game_amount, total_price, customer_first_name, customer_last_name " +
                    "FROM games g JOIN orders o " +
                    "ON g.game_id = o.game_id " +
                    "JOIN customers c " +
                    "ON c.customer_id = o.customer_id "+
                    "ORDER BY receipt_id";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);
            //Building the table: how many columns should it have?
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                tableview.getColumns().addAll(col);
            }
            //Populating the table
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            //FINALLY ADDED TO TableView
            tableview.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
        return tableview;
    }

    public static TableView buildDataSearch(TableView tableview, String text){     // builds table with games on search
        Connection c ;
        data = FXCollections.observableArrayList();
        try{
            c = MySqlConnection.getConnection();
            String SQL = "SELECT * " +
                    "FROM games " +
                    "WHERE game_title REGEXP " + "\'" + text + "\'"+ " OR game_genre REGEXP " + "\'" + text + "\'";
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);
            //Building the table: how many columns should it have?
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                tableview.getColumns().addAll(col);
            }
            //Populating the table
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            //FINALLY ADDED TO TableView
            tableview.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
        return tableview;
    }
}
