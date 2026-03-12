package kr.ac.kopo.minn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn;
    RadioGroup rg;
    RadioButton rbFemale, rbMale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn = findViewById(R.id.btn);
        rg = findViewById(R.id.rg);

        btn.setOnClickListener(btnListener);
        rg.setOnCheckedChangeListener(rgListener);

    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast toast = Toast.makeText(MainActivity.this, "버튼이 클릭되었습니다.", Toast.LENGTH_SHORT);
            toast.show();
        }
    };

    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
            String genderString = "";
            if(checkedId == R.id.rb_female)
                genderString = "여";
            else
                genderString = "남";

            Toast toast = Toast.makeText(MainActivity.this, genderString+"성이 체크되었습니다.", Toast.LENGTH_SHORT);
            toast.show();
        }
    };
}