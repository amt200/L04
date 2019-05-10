package c346.rp.edu.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,phone,size;
RadioButton smk, nonSmk;
DatePicker date;
Button confirm, reset;
TimePicker time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.etName);
        phone = findViewById(R.id.etPH);
        size = findViewById(R.id.etGroup);
        smk = findViewById(R.id.smoke);
        nonSmk = findViewById(R.id.nonSmoke);
        date = findViewById(R.id.datePicker);
        confirm = findViewById(R.id.confirm);
        reset = findViewById(R.id.reset);
        time = findViewById(R.id.timePicker);

        confirm.setOnClickListener(new View.OnClickListener(){
            String area = "";
            public void onClick(View v){
                if(smk.isChecked()){
                    area = "Smoking area";
                }
                if(nonSmk.isChecked()){
                    area = "Non-smoking area";
                }
                int day = date.getDayOfMonth();
                int month = date.getMonth();
                int year = date.getYear();
                Integer hour = time.getCurrentHour();
                Integer min = time.getCurrentMinute();
                String reservDate = day+"/"+month+"/"+year;
                String reservTime = hour+":"+min;
                String resvDetail = "Name: "+name.getText().toString()+"\n\n"+
                                    "Phone: "+phone.getText().toString()+"\n\n"+
                                    "Group Size: "+size.getText().toString()+"\n\n"+
                                    "Area: "+area+"\n\n"+"Date: "+reservDate+"\n\n"+
                                    "Time: "+reservTime;
                Toast.makeText(MainActivity.this, resvDetail, Toast.LENGTH_SHORT);
            }
        });
        reset.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                date.updateDate(2019,5,1);
                time.setCurrentHour(7);
                time.setCurrentMinute(30);
                name.getText().clear();
                phone.getText().clear();
                size.getText().clear();
                
                if(smk.isChecked()){
                    smk.setChecked(false);
                }
                if(nonSmk.isChecked()){
                    nonSmk.setChecked(false);
                }
            }
        });


    }
}
