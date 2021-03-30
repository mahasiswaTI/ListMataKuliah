import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.matakuliah.R;

import java.util.ArrayList;

public class MkAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Mk> mks;

    public void setMks(ArrayList<Mk> mks) {
        this.mks = mks;
    }

    public MkAdapter(Context context) {
        this.context = context;
        mks = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mks.size();
    }

    @Override
    public Object getItem(int i) {
        return mks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_mk, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Mk mk = (Mk)getItem(i);
        viewHolder.bind(mk);
        return view;
    }

    private class ViewHolder{
        private TextView txtNama;
        private TextView txtDeskripsi;
        private ImageView imgFoto;

        ViewHolder(View view){
            txtNama = view.findViewById(R.id.txt_nama);
            txtDeskripsi = view.findViewById(R.id.txt_deskripsi);
            imgFoto = view.findViewById(R.id.img_foto);
        }

        void bind(Mk mk){
            txtNama.setText(mk.getNama());
            txtDeskripsi.setText(mk.getDeskripsi());
            imgFoto.setImageResource(mk.getFoto());
        }
    }
}
