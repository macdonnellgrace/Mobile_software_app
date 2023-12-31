package com.gtappdevelopers.gfgroomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class ContactRVAdapter extends ListAdapter<ContactModal, ContactRVAdapter.ViewHolder> {
    //creating a variable for on item click listner.
    private OnItemClickListener listener;

    //creating a constructor class for our adapter class.
    ContactRVAdapter() {
        super(DIFF_CALLBACK);
    }

    //creating a call back for item of recycler view.
    private static final DiffUtil.ItemCallback<ContactModal> DIFF_CALLBACK = new DiffUtil.ItemCallback<ContactModal>() {
        @Override
        public boolean areItemsTheSame(ContactModal oldItem, ContactModal newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(ContactModal oldItem, ContactModal newItem) {
            //below line is to check the course name, description and course duration.
            return oldItem.getName().equals(newItem.getName()) &&
                    oldItem.getSurname().equals(newItem.getSurname()) &&
                    oldItem.getTelephone().equals(newItem.getTelephone());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //below line is use to inflate our layout file for each item of our recycler view.
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_rv_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //below line of code is use to set data to each item of our recycler view.
        ContactModal model = getCourseAt(position);
        holder.courseNameTV.setText(model.getName());
        holder.courseDescTV.setText(model.getSurname());
        holder.courseDurationTV.setText(model.getTelephone());
    }

    //creating a method to get course modal for a specific position.
    public ContactModal getCourseAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //view holder class to create a variable for each view.
        TextView courseNameTV, courseDescTV, courseDurationTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            //initializing each view of our recycler view.
            courseNameTV = itemView.findViewById(R.id.idTVName);
            courseDescTV = itemView.findViewById(R.id.idTVSurname);
            courseDurationTV = itemView.findViewById(R.id.idTVTelephone);
            //adding on click listner for each item of recycler view.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //inside on click listner we are passing position to our item of recycler view.
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(ContactModal model);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}


