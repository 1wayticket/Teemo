package top.teemo.kaiyan.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.ybq.parallaxviewpager.ParallaxViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import top.teemo.R;
import top.teemo.base.Video;
import top.teemo.kaiyan.mdeol.KaiYanBean;
import top.teemo.myutils.LogUtil;

/**
 * Created by Administrator on 2017/6/10.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ViewHolder> {
    private Context context;
    private KaiYanBean kaiYanBean;
    private LayoutInflater inflater;
    public static final int HEADER=0;
    public static final int BODY=1;
    public VideoListAdapter(Context ctx, KaiYanBean kaiYanBean) {
        this.context=ctx;
        if (kaiYanBean !=null) {
            this.kaiYanBean = kaiYanBean;
        }else {
            this.kaiYanBean =new KaiYanBean();
        }
        inflater=LayoutInflater.from(ctx);
    }

    @Override
    public int getItemViewType(int position) {
        if (position<6) {
            return HEADER;
        }
        return BODY;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (getItemViewType(i)) {
            case HEADER:
                break;
            case BODY:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case HEADER:
                PagerAdapter adapter = new PagerAdapter() {

                    @Override
                    public boolean isViewFromObject(View arg0, Object arg1) {
                        return arg0 == arg1;
                    }

                    @Override
                    public void destroyItem(ViewGroup container, int position,
                                            Object obj) {
                        container.removeView((View) obj);
                    }

                    @Override
                    public Object instantiateItem(ViewGroup container, int position) {
                        View view = View.inflate(container.getContext(), R.layout.pager_item, null);
                        ImageView imageView = (ImageView) view.findViewById(R.id.item_img);
                        int index=position%6;
                        Glide.with(context).load(kaiYanBean.getItemList().get(index).getData().getCover().getHomepage()).into(imageView);
                        container.addView(view, ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT);
                        return view;
                    }

                    @Override
                    public int getCount() {
                        return 6;
                    }
                };
                viewHolder.viewPager.setAdapter(adapter);
                break;
            case BODY:
                KaiYanBean.ItemListBean bean = kaiYanBean.getItemList().get(i - 6);
                Glide.with(context).load(bean.getData().getCover().getDetail()).into(viewHolder.video.thumbImageView);
                viewHolder.video.setUp(bean.getData().getPlayUrl(), JCVideoPlayer.SCREEN_LAYOUT_LIST,"");
                break;
        }
    }

    @Override
    public int getItemCount() {
        LogUtil.logI(""+ kaiYanBean.getItemList().size());
        return kaiYanBean.getItemList().size()-5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.parallax_viewpager)
        ParallaxViewPager viewPager;
        @BindView(R.id.video)
        Video video;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
