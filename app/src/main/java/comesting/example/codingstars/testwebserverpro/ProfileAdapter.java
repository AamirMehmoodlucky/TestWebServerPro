package comesting.example.codingstars.testwebserverpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {


    private final Context mCtx;
    private final List<model> allDataList;

    public ProfileAdapter(Context mCtx, List<model> list) {
        this.mCtx = mCtx;
        this.allDataList = list;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.name_list, null);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        model list = allDataList.get(position);
        Glide.with(mCtx)
                .load(list.getImage())
                .into(holder.imageView);

        holder.tvName.setText(list.getName());
        holder.tvDes.setText(list.getShortdesc());
        holder.tvCGPA.setText("CGPA:" + list.getCgpa());
        holder.tvMobileno.setText(String.valueOf(list.getMobilenum()));

    }

    @Override
    public int getItemCount() {
        return allDataList.size();
    }

     class ProfileViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDes, tvCGPA, tvMobileno;
        CircleImageView imageView;
        //ImageView imageView;

        public ProfileViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.idtextViewName);
            tvDes = itemView.findViewById(R.id.iddescription);
            tvCGPA = itemView.findViewById(R.id.idgpa);
            tvMobileno = itemView.findViewById(R.id.idmobileno);
            imageView = itemView.findViewById(R.id.idimageset);
        }
    }
}