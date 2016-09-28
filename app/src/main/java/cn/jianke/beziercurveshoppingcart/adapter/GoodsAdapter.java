package cn.jianke.beziercurveshoppingcart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import cn.jianke.beziercurveshoppingcart.R;
import cn.jianke.beziercurveshoppingcart.model.GoodsModel;

/**
 * @className: GoodsAdapter
 * @classDescription: 购物车商品适配器
 * @author: leibing
 * @createTime: 2016/09/28
 */
public class GoodsAdapter extends BaseAdapter{
    // 数据源（购物车商品图片）
    private ArrayList<GoodsModel> mData;
    // 布局
    private LayoutInflater mLayoutInflater;
    // 回调监听
    private CallBackListener mCallBackListener;

    /**
     * 构造函数
     * @author leibing
     * @createTime 2016/09/28
     * @lastModify 2016/09/28
     * @param context 上下文
     * @param mData 数据源（购物车商品图片）
     * @return
     */
    public GoodsAdapter(Context context, ArrayList<GoodsModel> mData){
        mLayoutInflater = LayoutInflater.from(context);
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size(): 0;
    }

    @Override
    public Object getItem(int i) {
        return mData != null ? mData.get(i): null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = mLayoutInflater.inflate(R.layout.adapter_shopping_cart_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            // 复用ViewHolder
            viewHolder = (ViewHolder) view.getTag();
        }

        // 更新UI
        if (i < mData.size())
            viewHolder.updateUI(mData.get(i));

        return view;
    }

    /**
     * @className: ViewHolder
     * @classDescription: 商品ViewHolder
     * @author: leibing
     * @createTime: 2016/09/28
     */
    class  ViewHolder{
        // 显示商品图片
        private ImageView mShoppingCartItemIv;
//        // 购物操作
//        private TextView mShoppingCartItemTv;

        /**
         * 构造函数
         * @author leibing
         * @createTime 2016/09/28
         * @lastModify 2016/09/28
         * @param view 视图
         * @return
         */
        public ViewHolder(View view){
            // findView
            mShoppingCartItemIv = (ImageView) view.findViewById(R.id.iv_shopping_cart_item);
            // onClick
            view.findViewById(R.id.tv_shopping_cart_item).setOnClickListener(
                    new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mShoppingCartItemIv != null && mCallBackListener != null)
                        mCallBackListener.callBackImg(mShoppingCartItemIv);
                }
            });
        }

        /**
         * 更新UI
         * @author leibing
         * @createTime 2016/09/28
         * @lastModify 2016/09/28
         * @param goods 商品实体对象
         * @return
         */
        public void updateUI(GoodsModel goods){
            if (goods != null
                    && goods.getmGoodsBitmap() != null
                    && mShoppingCartItemIv != null)
                mShoppingCartItemIv.setImageBitmap(goods.getmGoodsBitmap());
        }
    }

    /**
     * 设置回调监听
     * @author leibing
     * @createTime 2016/09/28
     * @lastModify 2016/09/28
     * @param mCallBackListener 回调监听
     * @return
     */
    public void setCallBackListener(CallBackListener mCallBackListener){
        this.mCallBackListener = mCallBackListener;
    }

    /**
     * @interfaceName: CallBackListener
     * @interfaceDescription: 回调监听
     * @author: leibing
     * @createTime: 2016/09/28
     */
    public interface CallBackListener{
        void callBackImg(ImageView goodsImg);
    }
}
