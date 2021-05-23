package com.home.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edntd;
    private TextView tvJp;
    private TextView tvUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private void findViews(){
        edntd = findViewById(R.id.ed_ntd);
        tvJp = findViewById(R.id.textView_jp);
        tvUs = findViewById(R.id.textView_us);

    }
    public void ntdgo(View view){
        String edns=edntd.getText().toString();

        if(edns.length()==0){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("ProBlem")
                    .setMessage("Please enter your NTD amount")
                    .setPositiveButton("OK",null).show();
        }else {

            Float ednf=Float.parseFloat(edns);
            Float us=ednf/30.9f;
            Float jp=ednf*3.90f;
            tvUs.setText(""+us);
            tvJp.setText(""+jp);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Result")
                    .setMessage("USD is "+us)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edntd.setText("");
                            tvJp.setText("None");
                            tvUs.setText("None");
                        }
                    }).show();

        }



    }
}