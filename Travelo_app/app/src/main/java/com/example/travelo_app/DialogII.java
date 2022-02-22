package com.example.travelo_app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogII extends AppCompatDialogFragment {

    int choice ;

    RadioButton rate_radio_btn;
    DialogII.DialogLinstener listener;

    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.layout_dialog_ii , null) ;

        alertDialog.setView(view).setTitle("Sorting Hotels")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Sort", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        listener.sendChoice(choice);


                    }
                });

                 rate_radio_btn = view.findViewById(R.id.rate_radio_btn_dialog);

                 rate_radio_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                     @Override
                     public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                         if (b)
                             choice = 1 ;
                         else
                             choice = 2;
                     }
                 });




        return alertDialog.create();
}




    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            listener = (DialogII.DialogLinstener) context;
        }

        catch (ClassCastException e) {
            throw new ClassCastException( context.toString() + " must implement Dialog Listener");
        }




    }

    public interface DialogLinstener {
        void sendChoice(int choice);

    }

}
