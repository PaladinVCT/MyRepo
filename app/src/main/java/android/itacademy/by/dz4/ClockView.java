package android.itacademy.by.dz4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.itacademy.by.menu.R;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

public class ClockView extends View {

    private Paint paint = new Paint();
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
        float[] degrees = new float[3];
        degrees[0] = (ClockActivity.NUMS[0] / (ClockActivity.NUMS[0] + ClockActivity.NUMS[1] + ClockActivity.NUMS[2])) * 360;
        degrees[1] = (ClockActivity.NUMS[1] / (ClockActivity.NUMS[0] + ClockActivity.NUMS[1] + ClockActivity.NUMS[2])) * 360;
        degrees[2] = (ClockActivity.NUMS[2] / (ClockActivity.NUMS[0] + ClockActivity.NUMS[1] + ClockActivity.NUMS[2])) * 360;
        return degrees;
    }

    public void drawDiagramLineDot(Canvas canvas, float cx, float cy, float radius) {
        paint.setAntiAlias(true);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(5);
        canvas.drawLine(cx, cy + 2 * radius, cx, cy + 2 * radius - 10, paint);
        paint.setStrokeWidth(10);
        canvas.drawPoint(cx, cy + 2 * radius - 15, paint);
    }

    public void drawDiagramText(Canvas canvas, String text, Float rotateDegrees, float cx, float cy, float radius) {
        canvas.save();
        canvas.rotate(rotateDegrees, cx, cy + 2 * radius - 15);
        canvas.drawText(text, cx + 10, cy + 2 * radius - 15, paint);
        canvas.restore();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int hour = Calendar.getInstance().get(Calendar.HOUR);
        int minute = Calendar.getInstance().get(Calendar.MINUTE);
        int seconds = Calendar.getInstance().get(Calendar.SECOND);

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

        canvas.save();
        paint.setStrokeWidth(5);
        canvas.rotate(6 * seconds, cx, cy);
        canvas.drawLine(cx, cy, cx, cy - radius + 20, paint);
        canvas.restore();


        if (ClockActivity.CHECK) {

            paint.setStyle(Paint.Style.FILL);
            rectf.left = cx - radius;
            rectf.top = cy + 2 * radius;
            rectf.right = cx + radius;
            rectf.bottom = cy + 4 * radius;

            float[] degree = calculate();

            paint.setColor(getResources().getColor(R.color.diagram1));
            canvas.drawArc(rectf, 270f - degree[1] / 2, degree[1], true, paint);

            drawDiagramLineDot(canvas, cx, cy, radius);
            drawDiagramText(canvas, Float.toString(ClockActivity.NUMS[1]), 0f, cx, cy, radius);
            canvas.rotate(degree[1] / 2, cx, cy + 3 * radius);

            paint.setColor(getResources().getColor(R.color.diagram2));
            canvas.drawArc(rectf, 270f, degree[0], true, paint);
            canvas.rotate(degree[0] / 2, cx, cy + 3 * radius);

            drawDiagramLineDot(canvas, cx, cy, radius);
            drawDiagramText(canvas, Float.toString(ClockActivity.NUMS[0]), -degree[0] / 2 - degree[1] / 2, cx, cy, radius);

            canvas.rotate(degree[0] / 2, cx, cy + 3 * radius);

            paint.setColor(getResources().getColor(R.color.diagram3));
            canvas.drawArc(rectf, 270f, degree[2], true, paint);
            canvas.rotate(degree[2] / 2, cx, cy + 3 * radius);

            drawDiagramLineDot(canvas, cx, cy, radius);
            drawDiagramText(canvas, Float.toString(ClockActivity.NUMS[2]), -degree[0] - degree[1] / 2 - degree[2] / 2, cx, cy, radius);
        }
        invalidate();
    }
}
