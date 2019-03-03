package android.itacademy.by.dz4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

public class ClockView extends View {
    private Paint paint = new Paint();
    private int hour = Calendar.getInstance().get(Calendar.HOUR);
    private int minute = Calendar.getInstance().get(Calendar.MINUTE);


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
        canvas.rotate((float)(30 * hour+minute*0.5), cx, cy);
        canvas.drawLine(cx, cy, cx, cy - radius + 100, paint);
        canvas.restore();

        paint.setStrokeWidth(10);
        canvas.rotate(6 * minute, cx, cy);
        canvas.drawLine(cx, cy, cx, cy - radius + 50, paint);


    }
}
