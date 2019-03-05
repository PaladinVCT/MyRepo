package android.itacademy.by.dz4;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

public class ClockView extends View {

    private Paint paint = new Paint();
    private int hour = Calendar.getInstance().get(Calendar.HOUR);
    private int minute = Calendar.getInstance().get(Calendar.MINUTE);
    private int seconds = Calendar.getInstance().get(Calendar.SECOND);
    private RectF rectf = new RectF();


    public ClockView(Context context) {
        super(context);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public float[] calculate() {
        float[] nums = new float[3];

        for (int i = 0; i < ClockActivity.NUMS.length; i++) {
            nums[i] = ClockActivity.NUMS[i];
        }
        float[] degrees = new float[3];
        degrees[0] = (nums[0] / (nums[0] + nums[1] + nums[2])) * 360;
        degrees[1] = (nums[1] / (nums[0] + nums[1] + nums[2])) * 360;
        degrees[2] = (nums[2] / (nums[0] + nums[1] + nums[2])) * 360;
        return degrees;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        float width = getWidth();
        float height = getHeight();
        float cx = width / 2;
        float cy = height / 3;
        float radius;
        if (width > height) {
            radius = height / 4;
        } else {
            radius = width / 4;
        }
        canvas.save();
        canvas.drawCircle(cx, cy, radius, paint);
        for (int i = 0; i < 12; i++) {
            canvas.rotate(30, cx, cy);
            canvas.drawLine(cx, (cy - radius - 10), cx, (cy - radius + 10), paint);
        }
        canvas.restore();

        paint.setStrokeWidth(3);
        paint.setTextSize(35f);
        canvas.drawText("12", cx - 20, (cy - radius - 10), paint);
        canvas.drawText("3", cx + radius + 15, cy + 10, paint);
        canvas.drawText("6", cx - 5, (cy + radius + 40), paint);
        canvas.drawText("9", cx - radius - 40, cy + 10, paint);

        paint.setStrokeWidth(20);
        canvas.drawPoint(cx, cy, paint);

        canvas.save();
        paint.setStrokeWidth(15);
        canvas.rotate((float) (30 * hour + minute * 0.5), cx, cy);
        canvas.drawLine(cx, cy, cx, cy - radius + 100, paint);
        canvas.restore();
        canvas.save();
        paint.setStrokeWidth(10);
        canvas.rotate(6 * minute, cx, cy);
        canvas.drawLine(cx, cy, cx, cy - radius + 50, paint);
        canvas.restore();


        paint.setStyle(Paint.Style.FILL);
        rectf.left = cx - radius;
        rectf.top = cy + 2 * radius;
        rectf.right = cx + radius;
        rectf.bottom = cy + 4 * radius;

        float[] nums = calculate();

        paint.setColor(Color.RED);
        canvas.drawArc(rectf, 270f - nums[1] / 2, nums[1], true, paint);

        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(5);
        canvas.drawLine(cx, cy + 2 * radius, cx, cy + 2 * radius - 10, paint);
        paint.setStrokeWidth(10);
        canvas.drawPoint(cx, cy + 2 * radius - 15, paint);

        canvas.rotate(nums[1] / 2, cx, cy + 3 * radius);

        paint.setColor(Color.BLUE);
        canvas.drawArc(rectf, 270f, nums[0], true, paint);
        canvas.rotate(nums[0] / 2, cx, cy + 3 * radius);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(5);
        canvas.drawLine(cx, cy + 2 * radius, cx, cy + 2 * radius - 10, paint);
        paint.setStrokeWidth(10);
        canvas.drawPoint(cx, cy + 2 * radius - 15, paint);

        canvas.rotate(nums[0] / 2, cx, cy + 3 * radius);

        paint.setColor(Color.GREEN);
        canvas.drawArc(rectf, 270f, nums[2], true, paint);
        canvas.rotate(nums[2] / 2, cx, cy + 3 * radius);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(5);
        canvas.drawLine(cx, cy + 2 * radius, cx, cy + 2 * radius - 10, paint);
        paint.setStrokeWidth(10);
        canvas.drawPoint(cx, cy + 2 * radius - 15, paint);

    }
}
