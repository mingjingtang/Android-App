package com.example.android.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int unitPrice  = 5;
    int whippedCreamPrice = 1;
    int chocolatePrice = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String toppingString = getString(R.string.toppings);
        CheckBox cb = (CheckBox) findViewById(R.id.check_wippedCream);
        CheckBox cb2 = (CheckBox) findViewById(R.id.check_Chocolate);
        boolean haveCream = cb.isChecked();
        boolean haveChocolate = cb2.isChecked();
        String finalPrint = createOrderSummary(haveCream,haveChocolate,quantity);

//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+ userName());
//        intent.putExtra(Intent.EXTRA_TEXT, finalPrint);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }

        displayMessage(createOrderSummary(haveCream,haveChocolate,quantity));

    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice(boolean addWippedCream, boolean addChocolate) {
        return quantity * unitPrice + judgeAdd(whippedCreamPrice,addWippedCream) + judgeAdd(chocolatePrice,addChocolate);
    }

    private String createOrderSummary(boolean cream, boolean chocolate, int quantity){
        String orderString = userName()  + "\n";
        orderString = orderString + "Add whipped cream? " + trueToYes(cream) + "\n";
        orderString = orderString + "Add chocolate? "     + trueToYes(chocolate) + "\n";
        orderString = orderString + "Quantity: "+ quantity + "\n" + "Total: $"+ calculatePrice(cream,chocolate) +"\n"+ getString(R.string.thank_you);
        return orderString;
    }

    private int judgeAdd(int toppingPrice, boolean addTopping){
        if(addTopping == true){
            toppingPrice = toppingPrice * quantity;
        }
        else{
            toppingPrice = 0;
        }
        return toppingPrice;
    }

    private String trueToYes(boolean bo){
        String display = "";
        if(bo == true){
            display = "yes";
        }
        else{
            display = "no";
        }
        return display;
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

    public void increment(View view){
        if(quantity == 10){
            display(10);
            Toast.makeText(this,"You cannnot have more than 10 coffee", Toast.LENGTH_SHORT).show();
        }
        else{
            quantity = quantity +1;
            display(quantity);
        }

    }

    public void decrement(View view){
        if(quantity == 1){
            display(1);
            Toast.makeText(this,"You cannnot have less than 1 coffee", Toast.LENGTH_SHORT).show();
        }
        else{
            quantity = quantity -1;
            display(quantity);
        }
    }

    public String userName(){
        EditText name = (EditText)findViewById(R.id.userName);
        String finalName = String.valueOf(name.getText());
        return finalName;
    }
}
