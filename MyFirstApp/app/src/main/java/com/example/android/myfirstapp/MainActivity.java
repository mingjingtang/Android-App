package com.example.android.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int unitPrice  = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox cb = (CheckBox) findViewById(R.id.check_wippedCream);
        CheckBox cb2 = (CheckBox) findViewById(R.id.check_Chocolate);
        if(cb.isChecked()&&cb2.isChecked()){
            displayMessage(createOrderSummary()+" Add Wipped Cream and Chocolate");
        }
        else if(cb.isChecked()){
            displayMessage(createOrderSummary()+" Add Wipped Cream");
        }
        else if(cb2.isChecked()){
            displayMessage(createOrderSummary()+" Add Chocolate");
        }
        else {
            displayMessage(createOrderSummary());
        }
    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
        return quantity * unitPrice;
    }

    private String createOrderSummary(){
//        String orderString = "Name: "+ name + "\n"+ "Quantity: "+ quantity + "\n"+"Total: $"+ calculatePrice() +"\n"+ "Thank you!";
        String orderString = userName()  + "\n"+ "Quantity: "+ quantity + "\n"+"Total: $"+ calculatePrice() +"\n"+ "Thank you!";
        return orderString;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given price on the screen.
     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    public void increment(View view){
        if(quantity == 10){
            display(10);
        }
        else{
            quantity = quantity +1;
            display(quantity);
//            displayPrice(quantity*unitPrice);
        }

    }

    public void decrement(View view){
        if(quantity == 0){
            display(0);
        }
        else{
            quantity = quantity -1;
            display(quantity);
//            displayPrice(quantity*unitPrice);
        }
    }

    public void check_wippedCream(){
        CheckBox cb = (CheckBox) findViewById(R.id.check_wippedCream);
        cb.setChecked(true);
    }

    public void check_Chocolate(){
        CheckBox cb = (CheckBox) findViewById(R.id.check_Chocolate);
        cb.setChecked(true);
    }

    public String userName(){
        EditText name = (EditText)findViewById(R.id.userName);
        String finalName = String.valueOf(name.getText());
        return finalName;
    }
}
