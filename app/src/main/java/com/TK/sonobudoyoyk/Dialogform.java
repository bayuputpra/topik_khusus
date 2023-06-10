package com.TK.sonobudoyoyk;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dialogform extends DialogFragment {
    String email,comment, key , pilih;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public Dialogform(String email, String comment, String key, String pilih) {
        this.email = email;
        this.comment = comment;
        this.key = key;
        this.pilih = pilih;
    }

    TextView edt_email;
    TextView edt_comment;
    Button btn_Submit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.input_form_report, container, false);

        edt_email = view.findViewById(R.id.edt_email);
        edt_comment = view.findViewById(R.id.edt_comment);

        btn_Submit = view.findViewById(R.id.btn_submit);

        edt_email.setText(email);
        edt_comment.setText(comment);

        btn_Submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = edt_email.getText().toString();
                String comment = edt_comment.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    input((EditText) edt_email, "email ");
                }else{
                    if(pilih.equals("Tambah")){
                        database.child("Report_user").push().setValue(new report_user(email, comment)).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(view.getContext(),"Data Tersimpan",Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(view.getContext(), "Data Gagal Tersimpan", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            }
        });
        return view;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    private void input(EditText txt,String s){
        txt.setError(s+ "Tidak Boleh Kosong");
        txt.requestFocus();
    }
}
