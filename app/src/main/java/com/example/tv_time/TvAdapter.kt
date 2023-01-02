import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tv_time.ResultTv
import com.example.tv_time.databinding.MovieLayoutBinding

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
    }

    override fun getItemCount(): Int {
        return TvList.size
    }

    }

