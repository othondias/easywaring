package dandios.blogspot.com.warnigerrorconfirmation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;



public class WaringLinearLayout extends LinearLayout {
	private int local;
	private LinearLayout instance;
	private int width;
	private int height;
	private LayoutParams params;
	public LayoutParams getParams() {
		return params;
	}

	private Context context;
	private double percent;
	public void setPercent(double percent) {
		this.percent = percent;
		params = new LayoutParams(width, (int) (height*percent));
		android.view.ViewGroup.LayoutParams params =  getLayoutParams();
		params.width = width;
		params.height = (int) (height*percent);
		this.setLayoutParams(params);
	}
	private WaringLinearLayout(Context context) {
		super(context);
		percent = 0.10;
		this.context =context;
		instance=this;
		LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layoutInflater.inflate(R.layout.warnig, this);
		this.setVisibility(View.GONE);
		getScreenSize();
	}
	private void getScreenSize() {
		WindowManager windowManager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics displaymetrics = new DisplayMetrics();
		windowManager.getDefaultDisplay().getMetrics(displaymetrics);
		this.height = displaymetrics.heightPixels;
		this.width = displaymetrics.widthPixels;
		params = new LayoutParams(width, (int) (height*percent));
		params.setMargins(50, 50, 50, 50);
		this.setLayoutParams(params);
	}


	public WaringLinearLayout(ViewGroup viewGroup,View view,boolean down) {
		this(viewGroup,down);
		int[] location = new int[2];
		view.getLocationInWindow(location);
		android.view.ViewGroup.LayoutParams params =  getLayoutParams();
		continua aqui
		if (down) {
			
		}else{

		}

	}
	private int getPixels(int dipValue){ 
	     Resources r = getResources();
	     int px = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue,   r.getDisplayMetrics());
	     return px; 
	}
	public WaringLinearLayout(ViewGroup viewGroup,boolean down) {
		this(viewGroup.getContext());
		if (down) {

		}
		viewGroup.addView(this);
	}
	public void hide(){
		this.setVisibility(View.GONE);
	}
	/**
	 * Show message
	 */
	public void show() {
		this.setVisibility(View.VISIBLE);
	}

	/**
	 * Show message with time to hide.
	 * 
	 * @param sec time that the message will appear to fade
	 */
	public void show(int sec){
		this.setVisibility(View.VISIBLE);
		new CountDownTimer(sec*1000, 1000) {
			public void onTick(long millisUntilFinished) {

			}
			public void onFinish() {
				instance.setVisibility(View.GONE);
			}

		}.start();
	}
}
