package com.TK.sonobudoyoyk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.holder>{
    private List<report_user> mlist;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public RecycleAdapter(List<report_user> mlist, Activity activity) {
        this.mlist = mlist;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecycleAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_view,parent,false);
        return new holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.holder holder, int position) {
        final report_user dreport = mlist.get(position);
        holder.rv_email.setText("Email : "+dreport.getEmail());
        holder.rv_comment.setText("Comment : "+dreport.getComment());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class holder extends RecyclerView.ViewHolder {
        TextView rv_email;
        TextView rv_comment;

        CardView card_view;

        public holder(@NonNull View itemView) {
            super(itemView);

            rv_email = itemView.findViewById(R.id.tv_email);
            rv_comment = itemView.findViewById(R.id.tv_comment);
            card_view = itemView.findViewById(R.id.card_view);

        }
    }
}
