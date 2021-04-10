package com.hello.hack36;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class TrackerWin extends AppCompatActivity {
    EditText editText_input, editText_output;
    CalendarView calender;

    Button remind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker_win);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {

        }

        editText_input = findViewById(R.id.input_date);
        editText_output = findViewById(R.id.output_date);
        calender = findViewById(R.id.calendarView);
        remind= findViewById(R.id.remind);

        final String c= editText_output.getText().toString();

        calender.setOnDateChangeListener(
                new CalendarView
                        .OnDateChangeListener() {
                    @Override

                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        String Date = dayOfMonth + "-" + (month + 1) + "-" + year;

                        editText_input.setText(Date);
                        if (dayOfMonth >= 1 && dayOfMonth <= 31) {
                            int dayGap = 28;
                            int nextDate = dayOfMonth + dayGap;
                            if (nextDate > 30) {
                                int periodDate = nextDate - 30;
                                String Date_new
                                        = periodDate + "-"
                                        + (month + 2) + "-" + year;

                                editText_output.setText(Date_new);
                            } else {
                                int periodDate = nextDate;
                                String Date_new
                                        = periodDate + "-"
                                        + (month + 2) + "-" + year;

                                editText_output.setText(Date_new);

                            }

                        }
                    }

                });
        remind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message= "Hey!! may be you have your periods today.Don't forget to take proper safety materials with you." +
                        "Thank you..";
                Toast.makeText(getApplicationContext(), "Reminder set for upcoming Period date,stay tuned, Stay safe", Toast.LENGTH_SHORT).show();
//                NotificationCompat.Builder builder= new NotificationCompat.Builder(TrackerWin.this).setSmallIcon(R.drawable.bookmark).setContentTitle("Womeniya").setAutoCancel(false);
//                NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                notificationManager.notify(0,builder.build());
            }
        });

    }

}
