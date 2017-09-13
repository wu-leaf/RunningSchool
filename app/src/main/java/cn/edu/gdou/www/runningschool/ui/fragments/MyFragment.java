package cn.edu.gdou.www.runningschool.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.edu.gdou.www.runningschool.R;


/**
 * Created by Veyron on 2017/3/13.
 * Function：
 */

public class MyFragment extends Fragment{
    View view;
    /**
     * 标题
     */
    private final String title;
    /**
     * 内容
     */
    private final String content;
    Context mContext;
    TextView textView;

    /**
     * 得到内容
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * 得到标题
     * @return
     */
    public String getTitle() {
        return title;
    }

    public MyFragment(String title, String content){
        super();
        this.title = title;
        this.content = content;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //上下文
        mContext = getActivity();
    }

    /**
     * 创建视图
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //创建视图
        switch(getContent()){
            case "1":
                view = inflater.inflate(R.layout.layout_toutiao,null);
                initClick(view);
                break;
            case "2":
                view = inflater.inflate(R.layout.layout_baoxian,null);
                initClick(view);
                break;
            case "3":
                view = inflater.inflate(R.layout.layout_guoji,null);
                initClick(view);
                break;
            case "4":
                view = inflater.inflate(R.layout.layout_liangdi,null);
                initClick(view);
                break;
            case "5":
                view = inflater.inflate(R.layout.layout_shiyanshi,null);
                initClick(view);
                break;
        }

        return view;
    }

    private void initClick(View view) {
       /* CardView c_view1 = (CardView) view.findViewById(R.id.card_view1);
        CardView c_view2 = (CardView) view.findViewById(R.id.card_view2);
        CardView c_view3 = (CardView) view.findViewById(R.id.card_view3);
        c_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (! view.getTag().equals("0")){
                    Intent intent = new Intent(getActivity(), NewsActivity.class);
                    intent.putExtra("url",view.getTag().toString());
                    startActivity(intent);
                }
            }
        });
        c_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (! view.getTag().equals("0")){
                    Intent intent = new Intent(getActivity(), NewsActivity.class);
                    intent.putExtra("url",view.getTag().toString());
                    startActivity(intent);
                }
            }
        });
        c_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (! view.getTag().equals("0")){
                    Intent intent = new Intent(getActivity(), NewsActivity.class);
                    intent.putExtra("url",view.getTag().toString());
                    startActivity(intent);
                }
            }
        });*/
    }

    /**
     * 绑定数据
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //设置内容
        //textView.setText(content);
    }
}
