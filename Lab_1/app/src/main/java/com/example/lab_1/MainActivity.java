package com.example.lab_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int checked;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button butOK = (Button) findViewById(R.id.butOK);

        butOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

                final int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                final int num2 = Integer.parseInt(secondNumEditText.getText().toString());

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        checked = radioGroup.indexOfChild(findViewById(checkedId));
                        switch (checked) {
                            case 0:
                                result = num1 + num2;
                                break;
                            case 1:
                                result = num1 - num2;
                                break;
                            case 2:
                                result = num1 * num2;
                                break;
                            case 3:
                                result = num1 / num2;
                                break;
                            default:
                                break;
                        }
                    }
                });


                resultTextView.setText(result + "");
            }
        });
    }
}
