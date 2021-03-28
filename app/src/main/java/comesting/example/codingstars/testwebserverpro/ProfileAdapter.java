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

import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {


    private Context mCtx;
    private List<model> productList;

    public ProfileAdapter(Context mCtx, List<model> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.name_list, null);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        model product = productList.get(position);
        Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);

        holder.tvName.setText(product.getName());
        holder.tvDes.setText(product.getShortdesc());
        holder.tvCGPA.setText("CGPA:" + String.valueOf(product.getCgpa()));
        holder.tvMobileno.setText(String.valueOf(product.getMobilenum()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
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