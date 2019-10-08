package com.example.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity=2;
    boolean w;
    boolean c;
    int price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view){

        quantity=quantity+1;
        display(quantity);

    }
    public void choclate(View view){
        CheckBox c2=(CheckBox)findViewById(R.id.checkBox2);
        c=c2.isChecked();
    }
    public void whipped(View view){
        CheckBox c1=(CheckBox)findViewById(R.id.checkBox);
        w=c1.isChecked();
    }
    public void decrement(View view){

        quantity=quantity-1;
        display(quantity);
    }
    public void submitOrder(View view) {
     if(w==true&&c==false)
     {
    price=(quantity*5)+(quantity*4);
     }
        if(w==false&&c==true)
        {
            price=(quantity*5)+(quantity*6);
        }
        if(w==true&&c==true)
        {
            price=(quantity*5)+(quantity*10);
        }
        if(w==false&&c==false)
        {
            price=(quantity*5);
        }

String name="Did you opted for wipped cream "+w+"\nDid you opted for choclate "+c+"\nAmount Due $"+price+"\nThank you for purchasing coffee\nYou are a valuable customer";
displayMessage(name);


    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.textView4);
        priceTextView.setText(message);
    }
    private void display(int number){
        TextView t1=(TextView)findViewById(R.id.textView2);
        t1.setText(" "+number);
    }
    private void displayPrice(int number){
        TextView t2=(TextView)findViewById(R.id.textView4);
        t2.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
