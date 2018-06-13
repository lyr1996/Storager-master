package com.example.dell_.storager;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name,num;
    Button save,show;
    TextView n,nu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getButton();
    }
   public void getButton(){

       name=(EditText)findViewById(R.id.name);
       num=(EditText)findViewById(R.id.num);
       save=(Button)findViewById(R.id.save);
       show=(Button)findViewById(R.id.show);
       n=(TextView)findViewById(R.id.n);
       nu=(TextView)findViewById(R.id.nu);

       save.setOnClickListener(this);
       show.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.save:
                saveit();
                break;
            case R.id.show:
                showit();
                break;
        }
    }
    public void saveit(){
       String getname=name.getText().toString();
       String getnum=num.getText().toString();
        SharedPreferences.Editor editor=getSharedPreferences("data",0).edit();
        editor.putString("name",getname);
        editor.putString("num",getnum);
        editor.apply();
    }
public void showit(){
        String name="";
        String number="";
        SharedPreferences preferences=getSharedPreferences("data",0);
        name=preferences.getString("name","");
        number=preferences.getString("num","");
        nu.setText("姓名:"+name);
        n.setText("学号:"+number);
}
}
