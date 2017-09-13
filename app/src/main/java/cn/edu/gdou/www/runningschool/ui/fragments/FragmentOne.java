package cn.edu.gdou.www.runningschool.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



import java.util.ArrayList;

import cn.edu.gdou.www.runningschool.R;
import cn.edu.gdou.www.runningschool.utils.DensityUtil;


public class FragmentOne extends BaseFragment {
    private RelativeLayout evaluation_ly;
    private RelativeLayout agent_ly;
    private ArrayList<ImageView> imageViews;
    private ViewPager viewpager;
    private TextView tv_title;
    private LinearLayout ll_point_group;
    // 图片资源ID
    private final int[] imageIds = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3
            };
    /**
     * 上一次高亮显示的位置
     */
    private int prePosition = 0;
    /**
     * 是否已经滚动
     */
    private boolean isDragging = false;

    // 图片标题集合
    private final String[] imageDescriptions = {
            "Sound",
            "Simple",
            "Smart",
            "Sound",
            "Simple",
            "Smart"
    };
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            int item = viewpager.getCurrentItem() + 1;
            viewpager.setCurrentItem(item);

            //延迟发消息
            handler.sendEmptyMessageDelayed(0, 4000);
        }
    };
    private static final String TAG = FragmentOne.class.getSimpleName();//"CommonFrameFragment"
    private TextView textView;

    @Override
    protected View initView() {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View contentView = mInflater.inflate(R.layout.layout_one, null);
        viewpager = (ViewPager) contentView.findViewById(R.id.viewpager);
        tv_title = (TextView) contentView.findViewById(R.id.tv_title);
        ll_point_group = (LinearLayout) contentView.findViewById(R.id.ll_point_group);

        //ViewPager的使用
        //1.在布局文件中定义ViewPager
        //2.在代码中实例化ViewPager
        //3.准备数据
        imageViews = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {

            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundResource(imageIds[i]);

            //添加到集合中
            imageViews.add(imageView);

            //添加点-----------------------
            ImageView point = new ImageView(getContext());
            point.setBackgroundResource(R.drawable.point_selector);
//            point.setImageResource(R.drawable.point_selector);
            //在代码中设置的都是像数-问题，在所有的手机上都是8个像数
            //把8px当成是dp-->px
            int width = DensityUtil.dip2px(getContext(), 8);
            //Toast.makeText(MainActivity.this, "width==" + width, Toast.LENGTH_SHORT).show();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, width);
            if (i == 0) {
                point.setEnabled(true); //显示红色
            } else {
                point.setEnabled(false);//显示灰色
                params.leftMargin = width;
            }


            point.setLayoutParams(params);

            ll_point_group.addView(point);
        }
        //4.设置适配器(PagerAdapter)-item布局-绑定数据

        viewpager.setAdapter(new MyPagerAdapter());
        //设置监听ViewPager页面的改变
        viewpager.addOnPageChangeListener(new MyOnPageChangeListener());

        //设置中间位置
        int item = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % imageViews.size();//要保证imageViews的整数倍


        viewpager.setCurrentItem(item);

        tv_title.setText(imageDescriptions[prePosition]);

        //发消息
        handler.sendEmptyMessageDelayed(0, 3000);

        return contentView;
    }


    @Override
    protected void initData() {
        super.initData();

    }


    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /**
         * 当页面滚动了的时候回调这个方法
         *
         * @param position             当前页面的位置
         * @param positionOffset       滑动页面的百分比
         * @param positionOffsetPixels 在屏幕上滑动的像数
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        /**
         * 当某个页面被选中了的时候回调
         *
         * @param position 被选中页面的位置
         */
        @Override
        public void onPageSelected(int position) {
            int realPosition = position % imageViews.size();
            Log.e(TAG, "onPageSelected==" + realPosition);
            //设置对应页面的文本信息
            tv_title.setText(imageDescriptions[realPosition]);

            //把上一个高亮的设置默认-灰色
            ll_point_group.getChildAt(prePosition).setEnabled(false);
            //当前的设置为高亮-红色
            ll_point_group.getChildAt(realPosition).setEnabled(true);

            prePosition = realPosition;


        }

        /**
         * 当页面滚动状态变化的时候回调这个方法
         * 静止->滑动
         * 滑动-->静止
         * 静止-->拖拽
         */
        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                isDragging = true;
                handler.removeCallbacksAndMessages(null);
                Log.e(TAG, "SCROLL_STATE_DRAGGING-------------------");
            } else if (state == ViewPager.SCROLL_STATE_SETTLING) {
                Log.e(TAG, "SCROLL_STATE_SETTLING-----------------");

            } else if (state == ViewPager.SCROLL_STATE_IDLE && isDragging) {
                isDragging = false;
                Log.e(TAG, "SCROLL_STATE_IDLE------------");
                handler.removeCallbacksAndMessages(null);
                handler.sendEmptyMessageDelayed(0, 4000);
            }

        }
    }

    class MyPagerAdapter extends PagerAdapter {


        /**
         * 得到图片的总数
         *
         * @return
         */
        @Override
        public int getCount() {
//            return imageViews.size();
            return Integer.MAX_VALUE;
        }

        /**
         * 相当于getView方法
         *
         * @param container ViewPager自身
         * @param position  当前实例化页面的位置
         * @return
         */
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            int realPosition = position % imageViews.size();

            final ImageView imageView = imageViews.get(realPosition);

            //
            ViewGroup parent = (ViewGroup) imageView.getParent();
            if (parent != null) {
                parent.removeAllViews();
            }
            container.addView(imageView);//添加到ViewPager中
            //Log.e(TAG, "instantiateItem==" + realPosition + ",---imageView==" + imageView);


            imageView.setTag(position);


            return imageView;
        }
        /**
         * 比较view和object是否同一个实例
         * @param view 页面
         * @param object  这个方法instantiateItem返回的结果
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
//            if(view == object){
//                return true;
//            }else{
//                return  false;
//            }
            return view == object;
        }
        /**
         * 释放资源
         * @param container viewpager
         * @param position 要释放的位置
         * @param object 要释放的页面
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
//            Log.e(TAG, "destroyItem==" + position + ",---object==" + object);
            container.removeView((View) object);
        }
    }
}
