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
    boolean w;
    boolean c;
    int price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        if(quantity==1)
        {
            Toast.makeText(this ,"You cant order less than 1 cup of coffee",Toast.LENGTH_SHORT).show();
            return;
        }
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
        /*this edittext command is for entering the name */
        EditText edittexr=(EditText)findViewById(R.id.edittxt);
        Editable nameEditable=edittexr.getText();
        String name = nameEditable.toString();
        /*this edittext command is for entering the special suggestions */
        EditText edittxts=(EditText)findViewById(R.id.edittxt2);
        Editable nameEditable2=edittxts.getText();
        String name2=nameEditable2.toString();
String summary="My order summary is";
String nam="Customer's name "+name+"\nDid you opted for Whipped cream "+w+"\nDid you opt for chocolate "+c+"\nAmount Due  $"+price+"\nSpecial suggestions by the customer are "+name2;
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
    private void displayPrice(int number){
        TextView t2=(TextView)findViewById(R.id.textView4);
        t2.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
