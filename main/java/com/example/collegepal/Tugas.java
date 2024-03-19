package com.example.collegepal;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class Tugas extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v -> showPopup());
    }

    private void showPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.activity_popup_tugas, null);
        builder.setView(view);

        TextInputEditText namaMatkul = view.findViewById(R.id.nama_matkul_card_view).findViewById(R.id.nama_matkul_input_edit_text);
        TextInputEditText tenggatWaktu = view.findViewById(R.id.layoutTenggatWaktu).findViewById(R.id.cardTenggatWaktu).findViewById(R.id.dataTenggatWaktu);
        TextInputEditText deskripsiTugas = view.findViewById(R.id.deskripsi_card_view).findViewById(R.id.deskripsi_input_edit_text);

        List<String> listTugas = new ArrayList<>();
        ListView listView = findViewById(R.id.list_view);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listTugas);
        listView.setAdapter(listAdapter);

        ImageView calendar = view.findViewById(R.id.calendarImage);
        calendar.setOnClickListener(v -> showCalendar(tenggatWaktu));

        builder.setPositiveButton("OK", (dialog, which) -> {
            listTugas.add(Objects.requireNonNull(namaMatkul.getText()).toString());
            dialog.dismiss();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showCalendar(TextInputEditText tenggatWaktu) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(Tugas.this, (view, setYear, setMonth, setDay) -> {
            String selectedDate = getResources().getString(R.string.selected_date, setDay, setMonth + 1, setYear);
            tenggatWaktu.setText(selectedDate);
        }, year, month, day);

        datePickerDialog.show();
    }
}
