package com.example.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity=2;
    int quantity1=2;
    int quantity2=0;
    int quantity3=0;

    boolean w;
    boolean c;
    int price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment1(View view){
        if(quantity1==100)
        {
            Toast.makeText(this ,"You cant order more than 100 cups of Iced Tea",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity1=quantity1+1;
        display1(quantity1);

    }
    public void increment2(View view){
        if(quantity2==quantity)
        {
            Toast.makeText(this ,"You cant order more toppings than cups of coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity2=quantity2+1;
        display2(quantity2);

    }
    public void increment3(View view){
        if(quantity3==quantity)
        {
            Toast.makeText(this ,"You cant order more toppings than cups of coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity3=quantity3+1;
        display3(quantity3);

    }
    public void increment(View view){
     if(quantity==100)
     {
         Toast.makeText(this ,"You cant order more than 100 cups of coffee",Toast.LENGTH_SHORT).show();
         return;
     }
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
        if((quantity+quantity1)==1)
        {
            Toast.makeText(this ,"You have to order something",Toast.LENGTH_SHORT).show();
            return;
        }
        if(quantity>0)
        {quantity=quantity-1;
        display(quantity);
    }}
    public void decrement2(View view){
        if(quantity2==0)
        {
            Toast.makeText(this ,"You cant order less than 0 topping",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity2=quantity2-1;
        display2(quantity2);
    }
    public void decrement3(View view){
        if(quantity3==0)
        {
            Toast.makeText(this ,"You cant order less than 0 toppings",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity3=quantity3-1;
        display3(quantity3);
    }
    public void decrement1(View view){
        if((quantity1+quantity)==1)
        {
            Toast.makeText(this ,"You have to order something",Toast.LENGTH_SHORT).show();
            return;
        }
        if(quantity1>0){
        quantity1=quantity1-1;
        display1(quantity1);}
    }
    public void submitOrder(View view) {
     if(w==true&&c==false)
     {
      price=(quantity*5)+(quantity2*4)+(quantity1*3);
     }
        if(w==false&&c==true)
        {
            price=(quantity*5)+(quantity3*6)+(quantity1*3);
        }
        if(w==true&&c==true)
        {
            price=(quantity*5)+(quantity2*4)+(quantity3*6)+(quantity1*3);
        }
        if(w==false&&c==false)
        {
            price=(quantity*5)+(quantity1*3);
        }
        /*this edittext command is for entering the name */
        EditText edittexr=(EditText)findViewById(R.id.edittxt);
        Editable nameEditable=edittexr.getText();
        String name = nameEditable.toString();
        /*this edittext command is for entering the special suggestions */
        EditText edittxts=(EditText)findViewById(R.id.edittxt2);
        Editable nameEditable2=edittxts.getText();
        String name2=nameEditable2.toString();
String summary="My order summary is";
String nam="Customer's name "+name+"\nNo. of cups of coffee you ordered is "+quantity+"\nNo. of cups of Iced Tea ordered is "+quantity1+"\nDid you opted for Whipped cream "+w+"\nDid you opt for chocolate "+c+"\nAmount Due  $"+price+"\nSpecial suggestions by the customer are "+name2;
displayMessage(nam);

        Intent intent=new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(intent.EXTRA_SUBJECT,summary);
        intent.putExtra(intent.EXTRA_TEXT,nam);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.textView4);
        priceTextView.setText(message);
    }
    private void display(int number){
        TextView t1=(TextView)findViewById(R.id.textView2);
        t1.setText(" "+number);
    }
    private void display2(int number){
        TextView t3=(TextView)findViewById(R.id.textView10);
        t3.setText(" "+number);
    } private void display3(int number){
        TextView t4=(TextView)findViewById(R.id.textView11);
        t4.setText(" "+number);
    }
    private void display1(int number){
        TextView t2=(TextView)findViewById(R.id.textView9);
        t2.setText(" "+number);
    }
    private void displayPrice(int number){
        TextView t2=(TextView)findViewById(R.id.textView4);
        t2.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
