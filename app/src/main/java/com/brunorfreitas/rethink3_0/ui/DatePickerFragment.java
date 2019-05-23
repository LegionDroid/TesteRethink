package com.brunorfreitas.rethink3_0.ui;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;


import com.brunorfreitas.rethink3_0.R;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    public interface DataDialogCallback {
        void data(String data);
    }

    private DataDialogCallback dialogCallback;

    public void setDialogCallback(DataDialogCallback dialogCallback) {
        this.dialogCallback = dialogCallback;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_DARK, this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {

        month +=1;
        String monthFormated = String.valueOf(month);
        String dayFormated = String.valueOf(day);

        if(month < 10){
            monthFormated = "0" + month;
        }
        if(day < 10){

            dayFormated = "0" + day ;
        }

        if (dialogCallback != null) {
            dialogCallback.data(year + "-" + monthFormated + "-" + dayFormated);
        }

    }
}