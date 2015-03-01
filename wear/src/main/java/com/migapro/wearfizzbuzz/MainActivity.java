package com.migapro.wearfizzbuzz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private static final int NUMBER_GAME_START = 1;

    private int number;
    private Button numberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initNumber();
    }

    private void initView() {
        numberButton = (Button) findViewById(R.id.number);
        numberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNormalNumber()) {
                    updateNumber();
                } else {
                    showGameOverDialog();
                }
            }
        });

        Button fizzButton = (Button) findViewById(R.id.fizz_button);
        fizzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFizz()) {
                    updateNumber();
                } else {
                    showGameOverDialog();
                }
            }
        });

        Button fizzBuzzButton = (Button) findViewById(R.id.fizzbuzz_button);
        fizzBuzzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFizzBuzz()) {
                    updateNumber();
                } else {
                    showGameOverDialog();
                }
            }
        });

        Button buzzButton = (Button) findViewById(R.id.buzz_button);
        buzzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBuzz()) {
                    updateNumber();
                } else {
                    showGameOverDialog();
                }
            }
        });
    }

    private boolean isNormalNumber() {
        return number % 5 != 0 && number % 3 != 0;
    }

    private boolean isFizz() {
        return number % 3 == 0 && number % 5 != 0;
    }

    private boolean isFizzBuzz() {
        return number % 3 == 0 && number % 5 == 0;
    }

    private boolean isBuzz() {
        return number % 5 == 0 && number % 3 != 0;
    }

    private void updateNumber() {
        number++;
        numberButton.setText(String.valueOf(number));
    }

    private void showGameOverDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.game_over_title)
                .setMessage(getString(R.string.game_over_message) + number)
                .setPositiveButton(R.string.game_over_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        initNumber();
                    }
                })
                .create().show();
    }

    private void initNumber() {
        number = NUMBER_GAME_START;
        numberButton.setText(String.valueOf(number));
    }
}
