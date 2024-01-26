package com.example.ume;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {
    private List<School> schoolList;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewWebsite;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.nameTextView);
            textViewWebsite = itemView.findViewById(R.id.websiteTextView);
        }
    }

    public SchoolAdapter(Context context, List<School> schoolList) {
        this.context = context;
        this.schoolList = schoolList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_school, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        School school = schoolList.get(position);
        holder.textViewName.setText(school.getName());
        holder.textViewWebsite.setText(school.getWebsite());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite(school.getWebsite(), v.getContext());
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDeleteConfirmationDialog(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }

    private void openWebsite(String url, Context context) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    private void showDeleteConfirmationDialog(final int position) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Xác nhận xóa");
        alertDialogBuilder.setMessage("Bạn có chắc chắn muốn xóa trường này?");

        alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                removeSchool(position);
            }
        });

        alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void removeSchool(int position) {
        DatabaseReference selectedSchoolRef = FirebaseDatabase.getInstance().getReference("schools").child(schoolList.get(position).getKey());
        selectedSchoolRef.removeValue();
    }
}
