package com.google.everloser12.second;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by al-ev on 18.04.2016.
 */
public class MyDialog extends DialogFragment {


    public static MyDialog newInstance(int title) {
        MyDialog frag = new MyDialog();
        Bundle args = new Bundle();
        args.putInt("title", title);
        frag.setArguments(args);
        return frag;
    }


    public static List<String> mSelectedItems;
    public int hourX, minX, yearX, monthX, dayX;
    private static final String[] DOGS = {"Кромфорлендер", "Кувас",
            "Кури",
            "Курцхаар",
            "Курчавошёрстный ретривер",
            "Лабрадор-ретривер",
            "Лабрадудль",
            "Лаготто-романьоло",
            "Лангхаар",
            "Ландсир",
            "Ланкаширский хилер",
            "Левретка",
            "Лейкленд-терьер",
            "Леонбергер",
            "Леопардовая собака Катахулы",
            "Лопарская оленегонная собака",
            "Лхаса апсо",
            "Майоркская овчарка",
            "Малая львиная собака",
            "Малые бельгийские собаки",
            "Мальтезе",
            "Мальтийская болонка",
            "Манчестер-терьер",
            "Мареммо-абруццкая овчарка",
            "Миттельшнауцер",
            "Мопс"};



    NoticeDialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }


        @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

            int title = getArguments().getInt("title");

            switch (title) {
                case MainActivity.ALERT2: {
                    mSelectedItems = new ArrayList();  // Where we track the selected items
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    // Set the dialog title
                    builder.setTitle("Dogs")
                            .setIcon(R.drawable.ic_fish_f)
                                    // Specify the list array, the items to be selected by default (null for none),
                                    // and the listener through which to receive callbacks when items are selected
                            .setMultiChoiceItems(DOGS, null,
                                    new DialogInterface.OnMultiChoiceClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which,
                                                            boolean isChecked) {
                                            if (isChecked) {
                                                // If the user checked the item, add it to the selected items
                                                mSelectedItems.add(DOGS[which]);
                                            } else if (mSelectedItems.contains(DOGS[which])) {
                                                // Else, if the item is already in the array, remove it
                                                mSelectedItems.remove(DOGS[which]);
                                            }
                                        }
                                    })
                                    // Set the action buttons
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    // User clicked OK, so save the mSelectedItems results somewhere
                                    // or return them to the component that opened the dialog
                                    Toast.makeText(getActivity(), mSelectedItems.toString(), Toast.LENGTH_LONG).show();
                                    mListener.onDialogPositiveClick(MyDialog.this, mSelectedItems.toString());
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    return builder.create();
                }
                case MainActivity.TIMEP:
                        {
                    return new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            hourX = hourOfDay;
                            minX = minute;
                            mListener.onDialogPositiveClick(MyDialog.this, hourX + " : " + minX);
                        }
                    },

                            hourX, minX, true);
                        }

                case MainActivity.DATEP:
                        {
                            Calendar calendar = Calendar.getInstance();
                            yearX = calendar.get(Calendar.YEAR);
                            monthX = calendar.get(Calendar.MONTH);
                            dayX = calendar.get(Calendar.DAY_OF_MONTH);


                            return new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    yearX = year;
                                    monthX = monthOfYear + 1;
                                    dayX = dayOfMonth;
                                    mListener.onDialogPositiveClick(MyDialog.this, dayX + " - " + monthX + " - " + yearX);
                                }
                            }, yearX, monthX, dayX);
                        }
                default:
                    return null;
            }
    }

}
