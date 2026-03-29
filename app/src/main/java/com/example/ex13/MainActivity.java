package com.example.ex13;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * MainActivity handles the logic for changing the background color.
 * It supports instant changes via RadioGroup or delayed changes via Button,
 * depending on the Switch state.
 *
 * @author [השם שלך כאן]
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    // הגדרת המשתנים
    private ConstraintLayout mainLayout;
    private RadioGroup colorGroup;
    private Switch actionSwitch;
    private Button applyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // קישור המשתנים ל-IDs מה-XML
        mainLayout = findViewById(R.id.main);
        colorGroup = findViewById(R.id.radioGroup);
        actionSwitch = findViewById(R.id.Sw); // ה-ID שנתת לסוויץ'
        applyButton = findViewById(R.id.btn); // ה-ID שנתת לבוטון

        // צבע התחלתי
        mainLayout.setBackgroundColor(Color.WHITE);

        /**
         * מאזין לשינויים ב-RadioGroup.
         * אם ה-Switch דולק, הרקע משתנה מיד.
         */
        colorGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (actionSwitch.isChecked()) {
                    updateBackground(checkedId);
                }
            }
        });

        /**
         * מאזין ללחיצה על הכפתור.
         * אם ה-Switch כבוי, הרקע משתנה רק בלחיצה.
         */
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!actionSwitch.isChecked()) {
                    int selectedId = colorGroup.getCheckedRadioButtonId();
                    updateBackground(selectedId);
                }
            }
        });
    }

    /**
     * פונקציית עזר לשינוי צבע הרקע.
     * @param checkedId ה-ID של ה-RadioButton שנבחר.
     */
    private void updateBackground(int checkedId) {
        if (checkedId == R.id.rB1) {
            mainLayout.setBackgroundColor(Color.RED);
        } else if (checkedId == R.id.rB2) {
            mainLayout.setBackgroundColor(Color.GREEN);
        } else if (checkedId == R.id.rB3) {
            mainLayout.setBackgroundColor(Color.BLUE);
        } else if (checkedId == R.id.rB4) {
            mainLayout.setBackgroundColor(Color.YELLOW);
        }
    }
}





