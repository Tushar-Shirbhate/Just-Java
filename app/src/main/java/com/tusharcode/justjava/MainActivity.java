package com.tusharcode.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view){
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
       // Log.v("Main Activity", "Has Whipped cream"+ hasWhippedCream);
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream);
        displayMessage(priceMessage);

    }
    private String createOrderSummary(int price, boolean hasWhippedCream){
        String message = "Name : Kaptain Agrawal\n" +"Add Whipped Cream? : " + hasWhippedCream + "\nQuantity : " + quantity + "\n" + "Total : $" + price + "\n" + "Thank you!";
        return message;
    }
    private void calculatePrice(int quantity){
        int price = quantity*5;
    }
    private void calculatePrice(int quantity, int pricePerCup){
        int price = quantity * pricePerCup;
    }
    private int calculatePrice(){
        return quantity * 5;
    }
    public void increament(View view){
        quantity =  quantity + 1 ;
        displayQuantity(quantity);
    }
    public void decreament(View view){
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    private void displayQuantity(int numberOfCoffees){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
    private void displayPrice(int number){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}