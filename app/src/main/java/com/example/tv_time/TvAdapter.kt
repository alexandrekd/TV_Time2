import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.example.tv_time.ResultTv
import com.example.tv_time.databinding.MovieLayoutBinding
import com.example.tv_time.ui.moviePage.MoviePageFragment

class TvAdapter : RecyclerView.Adapter<TvAdapter.ViewHolder>() {
    private var TvList = ArrayList<ResultTv>()
    fun setTvList(TvList: List<ResultTv>) {
        this.TvList = TvList as ArrayList<ResultTv>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: MovieLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500" + TvList[position].poster_path)
            .into(holder.binding.movieImage)
        holder.binding.movieName.text = TvList[position].name
        holder.binding.movieImage.setOnClickListener {

            Log.i("AlexInfo", "salut : " + TvList[position].id);


        }
    }


    override fun getItemCount(): Int {
        return TvList.size
    }

    }

