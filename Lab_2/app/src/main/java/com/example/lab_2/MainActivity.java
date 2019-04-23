package com.example.lab_2;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Info.OnFragmentInteractionListener, Calculator.OnFragmentInteractionListener {

    int checked;
    float result;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Info"));
        tabLayout.addTab(tabLayout.newTab().setText("Calculator"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                final RadioGroup radioGroup = findViewById(R.id.radioGroup);
                final EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                final EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                final TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
                Button butOK = (Button) findViewById(R.id.butOK);

                butOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String num_1 = firstNumEditText.getText().toString();
                        String num_2 = secondNumEditText.getText().toString();

                        if (num_1.matches("") || num_2.matches("")) {
                            openDialog();
                            return;
                        }

                        else {
                            final float num1 = Integer.parseInt(num_1);
                            final float num2 = Integer.parseInt(num_2);

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
                                            openDialog();
                                            return;
                                    }
                                }
                            });
                            resultTextView.setText(result + "");
                        }
                    }
                });
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void openDialog() {
        WarnDialog warning = new WarnDialog();
        warning.show(getSupportFragmentManager(), "Notification dialog");
    }
}
