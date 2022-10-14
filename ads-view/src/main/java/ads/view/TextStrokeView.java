package ads.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/**
 * @author QiuJie
 */
public class TextStrokeView extends View {

    private static final int DEFAULT_TEXT_SIZE = 12;

    private final TextPaint mTextPaint;
    private CharSequence text;
    private int textColor;
    private int strokeColor;


    public TextStrokeView(Context context) {
        this(context, null);
    }

    public TextStrokeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextStrokeView);
        text = a.getText(R.styleable.TextStrokeView_android_text);
        if (text == null) {
            text = "文字描边";
        }
        final float textSize = a.getDimension(R.styleable.TextStrokeView_android_textSize, -1f);
        textColor = a.getColor(R.styleable.TextStrokeView_android_textColor, Color.WHITE);

        final float strokeWidth = a.getDimension(R.styleable.TextStrokeView_strokeWidth, 1f);
        strokeColor = a.getColor(R.styleable.TextStrokeView_strokeColor, Color.BLACK);
        a.recycle();

        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);

        if (textSize == -1) {
            setTextSize(DEFAULT_TEXT_SIZE);
        }else {
            setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);
        }
        setStrokeWidth(strokeWidth);
        setText(text);
    }

    public void setText(CharSequence text) {
        this.text = text;
        invalidate();
    }

    public void setTextSize(float size) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }


    public void setTextSize(int unit, float size) {
        mTextPaint.setTextSize(TypedValue.applyDimension(unit, size, getResources().getDisplayMetrics()));
    }

    public void setTextColor(@ColorInt int color) {
        textColor = color;
    }

    public void setStrokeWidth(float strokeWidth) {
        mTextPaint.setStrokeWidth(strokeWidth);
    }

    public void setStrokeColor(@ColorInt int color) {
        strokeColor = color;
    }


    /*
     * top      ⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽
     * ascent   ⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺
     * baseline ⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽
     * descent  ⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽⎽
     * bottom   ⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺⎺
     * height = bottom - top
     */
    @Override
    protected void onDraw(Canvas canvas) {
        final float baseline = Math.abs(mTextPaint.getFontMetrics().top);
        // 先绘制描边效果文字，在绘制正常文字
        mTextPaint.setColor(strokeColor);
        mTextPaint.setStyle(Paint.Style.STROKE);
        canvas.drawText(text, 0, text.length(), 0, baseline, mTextPaint);

        mTextPaint.setColor(textColor);
        mTextPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(text, 0, text.length(), 0, baseline, mTextPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int width = getDefaultSize((int) Layout.getDesiredWidth(text, mTextPaint), widthMeasureSpec);
        final Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        final int height = getDefaultSize((int) (fontMetrics.bottom - fontMetrics.top), heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    public static int getDefaultSize(int size, int measureSpec) {
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                break;
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
        }
        return result;
    }
}
