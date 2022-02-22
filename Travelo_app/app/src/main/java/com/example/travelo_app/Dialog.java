package com.example.travelo_app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialog extends AppCompatDialogFragment {

    private SeekBar seekBar ;
    private RatingBar ratingBar ;
    int seekBar_value ;
    int ratingBar_value;

    Dialog.DialogLinstener listener;



    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.layout_dialog , null) ;

        alertDialog.setView(view).setTitle("Filtering Hotels")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Filter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        listener.sendTexts(seekBar_value , ratingBar_value);



                    }
                });

        seekBar = view.findViewById(R.id.seekBar2) ;
        ratingBar = view.findViewById(R.id.ratingBar2) ;

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                seekBar_value = i ;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                ratingBar_value = (int) v ;
            }
        });

        return alertDialog.create();


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
        listener = (DialogLinstener) context;
        }

        catch (ClassCastException e) {
            throw new ClassCastException( context.toString() + " must implement Dialog Listener");
        }




    }

    public interface DialogLinstener {
        void sendTexts(int seekBar_value, int ratingBar_value);

    }
}
