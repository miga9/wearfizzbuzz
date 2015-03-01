package com.migapro.wearfizzbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = 1;

        initView();
    }

    private void initView() {
        final Button numberButton = (Button) findViewById(R.id.number);
        numberButton.setText(String.valueOf(number));
        numberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number % 5 != 0 && number % 3 != 0) {
                    number++;
                    numberButton.setText(String.valueOf(number));
                }
            }
        });

        Button fizzButton = (Button) findViewById(R.id.fizz_button);
        fizzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number % 5 == 0 && number % 3 != 0) {
                    number++;
                    numberButton.setText(String.valueOf(number));
                }
            }
        });

        Button fizzBuzzButton = (Button) findViewById(R.id.fizzbuzz_button);
        fizzBuzzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number % 3 == 0 && number % 5 == 0) {
                    number++;
                    numberButton.setText(String.valueOf(number));
                }
            }
        });

        Button buzzButton = (Button) findViewById(R.id.buzz_button);
        buzzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number % 3 == 0 && number % 5 != 0) {
                    number++;
                    numberButton.setText(String.valueOf(number));
                }
            }
        });
    }
}
