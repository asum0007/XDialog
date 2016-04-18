package com.asum.xdialog.dialog.hint;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.asum.xdialog.dialog.XCustomDialog;
import com.asum.xdialog.interfaces.OnCustomDialogCallBack;
import com.asum.xlayoutparams.utils.DensityUtils;
import com.asum.xlayoutparams.utils.XDpArea;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 提示弹出窗的基类，带有定时自动关闭功能
 * 
 * @author Asum
 * 
 */
public abstract class XHintBaseDialog extends XCustomDialog {
	protected Context context;
	protected String hint;
	protected int resId;

	private Timer timer;
	private Handler handler = new Handler();

	protected LinearLayout dialogLayout;
	protected ImageView tipImageView;
	protected TextView tipTextView;

	public XHintBaseDialog(Context context, OnCustomDialogCallBack callBack, boolean canceledOnTouchOutside) {
		super(context, callBack, canceledOnTouchOutside);
		this.context = context;
	}

	/**
	 * 设置内容
	 * 
	 * @param hint
	 * @return
	 */
	public XHintBaseDialog setHint(String hint) {
		this.hint = hint;
		return this;
	}

	/**
	 * 设置图片的资源ID
	 * 
	 * @param resId
	 * @return
	 */
	public XHintBaseDialog setTipPicture(int resId) {
		this.resId = resId;
		return this;
	}

	protected void onCreate(LinearLayout dialogLayout) {
		this.dialogLayout = dialogLayout;

		initializeObject();
		initializeAttribute();
		initializeEvent();
	}

	private void initializeObject() {
		tipImageView = new ImageView(context);
		tipTextView = new TextView(context);
	}

	private void initializeAttribute() {
		dialogLayout.setOrientation(LinearLayout.HORIZONTAL);
		dialogLayout.setBackgroundColor(Color.WHITE);
		dialogLayout.setPadding(DensityUtils.dip2px(context, 24), DensityUtils.dip2px(context, 24), DensityUtils.dip2px(context, 24), DensityUtils.dip2px(context, 24));
		new XDpArea(context, dialogLayout).set(0, 0, 280, XDpArea.WRAP);

		dialogLayout.addView(tipImageView);
		tipImageView.setScaleType(ScaleType.FIT_XY);
		if (resId == 0) {
			tipImageView.setBackgroundColor(Color.rgb(66, 66, 66));
		} else {
			tipImageView.setBackgroundColor(Color.argb(0, 0, 0, 0));
			tipImageView.setImageResource(resId);
		}

		dialogLayout.addView(tipTextView);
		tipTextView.setText(hint);
		tipTextView.setMaxLines(10);
		tipTextView.setLineSpacing(DensityUtils.dip2px(context, 8), 1);
		tipTextView.setEllipsize(TruncateAt.END);
		tipTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
		tipTextView.setIncludeFontPadding(false);
		tipTextView.setTextColor(Color.rgb(66, 66, 66));
	}

	private void initializeEvent() {
		tipTextView.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				XHintBaseDialog.this.dismiss();
			}
		});

		tipImageView.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				XHintBaseDialog.this.dismiss();
			}
		});

		dialogLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				XHintBaseDialog.this.dismiss();
			}
		});
	}

	protected LayoutParams disposeParams(LayoutParams layoutParams, Window window) {
		layoutParams.dimAmount = 0.5f;
		window.setGravity(Gravity.CENTER);
		return layoutParams;
	}

	protected int animStyle() {
		return 0;
	}

	protected boolean clickBackKey() {
		return true;
	}

	protected void dialogWillBeDismiss() {

	}

	/**
	 * 经过指定时间后，关闭Dialog
	 * 
	 * @return 指定时间（ms）
	 */
	protected int dismissAfterTime() {
		return 3000;
	}

	public void show() {
		super.show();
		start();
	}

	public void dismiss() {
		super.dismiss();
		if (timer != null) {
			timer.cancel();
		}
	}

	private void start() {
		if (timer != null) {
			timer.cancel();
		}
		timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				timer.cancel();
				handler.post(new Runnable() {
					public void run() {
						XHintBaseDialog.this.dismiss();
					}
				});
			}
		};
		timer.schedule(task, dismissAfterTime());
	}
}
