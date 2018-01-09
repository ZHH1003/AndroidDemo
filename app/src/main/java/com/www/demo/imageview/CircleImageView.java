package com.www.demo.imageview;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;


/**
 * @author HH on 2018/1/8.
 */

public class CircleImageView extends AppCompatImageView {

    private Paint mPaint;
    private Bitmap mBitmap;
    private BitmapShader mShader;
    private Matrix matrix;

    public CircleImageView(Context context) {
        super(context);
        init();
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        matrix = new Matrix();

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        setMeasuredDimension(500, 500);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = getBitmap(getDrawable());
        if (bitmap != null) {
            int width = getWidth();
            int height = getHeight();
            int viewMinSize = Math.min(width, height);
            float circleWidth = viewMinSize;
            float circleHeight = viewMinSize;
            if (mShader == null || !bitmap.equals(mBitmap)) {
                mBitmap = bitmap;
                mShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            }
            if (mShader != null) {
//                matrix.setScale(circleWidth / bitmap.getWidth(), circleHeight / bitmap.getHeight());
//                mShader.setLocalMatrix(matrix);
            }

            mPaint.setShader(mShader);
            canvas.drawCircle(viewMinSize / 2, viewMinSize / 2, viewMinSize / 2, mPaint);

        } else {
            super.onDraw(canvas);
        }
    }


    public Bitmap getBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof ColorDrawable) {
            Rect rect = drawable.getBounds();
            int width = rect.right - rect.left;
            int height = rect.bottom - rect.top;
            int color = ((ColorDrawable) drawable).getColor();
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawARGB(Color.alpha(color), Color.red(color), Color.green(color), Color.blue(color));
            return bitmap;
        } else {
            return null;
        }
    }


}
