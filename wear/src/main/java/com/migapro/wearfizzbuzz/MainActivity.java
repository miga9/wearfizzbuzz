package com.migapro.wearfizzbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private int number;
    private Button numberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = 1;

        initView();
    }

    private void initView() {
        numberButton = (Button) findViewById(R.id.number);
        numberButton.setText(String.valueOf(number));
        numberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNormalNumber()) {
                    updateNumber();
                }
            }
        });

        Button fizzButton = (Button) findViewById(R.id.fizz_button);
        fizzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFizz()) {
                    updateNumber();
                }
            }
        });

        Button fizzBuzzButton = (Button) findViewById(R.id.fizzbuzz_button);
        fizzBuzzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFizzBuzz()) {
                    updateNumber();
                }
            }
        });

        Button buzzButton = (Button) findViewById(R.id.buzz_button);
        buzzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBuzz()) {
                    updateNumber();
                }
            }
        });
    }

    private boolean isNormalNumber() {
        return number % 5 != 0 && number % 3 != 0;
    }

    private boolean isFizz() {
        return number % 5 == 0 && number % 3 != 0;
    }

    private boolean isFizzBuzz() {
        return number % 3 == 0 && number % 5 == 0;
    }

    private boolean isBuzz() {
        return number % 3 == 0 && number % 5 != 0;
    }

    private void updateNumber() {
        number++;
        numberButton.setText(String.valueOf(number));
    }
}
