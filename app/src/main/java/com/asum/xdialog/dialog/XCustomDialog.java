package com.asum.xdialog.dialog;

import com.asum.xdialog.interfaces.OnCustomDialogCallBack;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;

/**
 * 自定义Dialog需要继承的父类
 * 
 * @author Asum
 * 
 */
public abstract class XCustomDialog extends Dialog {
	public XCustomDialog(Context context, OnCustomDialogCallBack callBack, boolean canceledOnTouchOutside) {
		super(context);
		this.setCanceledOnTouchOutside(canceledOnTouchOutside);
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		initializeContentView();
		initializeParamsAndWindows();
		initializeListener();
	}

	// 默认内容区域为一个LinearLayout，且纵向排版，背景色为透明
	private void initializeContentView() {
		LinearLayout contentLayout = new LinearLayout(getContext());
		contentLayout.setOrientation(LinearLayout.VERTICAL);
		contentLayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
		setContentView(contentLayout);
		onCreate(contentLayout);
	}

	// 默认位于左上角，各方向的Padding均为0
	@SuppressLint("RtlHardcoded")
	private void initializeParamsAndWindows() {
		LayoutParams layoutParams = this.getWindow().getAttributes();
		Window window = this.getWindow();
		window.getDecorView().setPadding(0, 0, 0, 0);
		window.setGravity(Gravity.LEFT | Gravity.TOP);

		int animStyle = animStyle();
		if (animStyle != 0) {
			window.setWindowAnimations(animStyle);
		}
		window.setAttributes(disposeParams(layoutParams, window));
	}

	private void initializeListener() {
		this.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
					boolean isQuit = clickBackKey();
					if (isQuit) {
						XCustomDialog.this.dismiss();
					}
					return true;
				} else {
					return false;
				}
			}
		});

		this.setOnCancelListener(new OnCancelListener() {
			public void onCancel(DialogInterface dialog) {
				dialogWillBeDismiss();
				dialog.dismiss();
			}
		});
	}

	/**
	 * 初始化
	 * 
	 * @param dialogLayout
	 *            呈现的View
	 */
	protected abstract void onCreate(LinearLayout dialogLayout);

	/**
	 * 提供layoutParams和windows，需要时可设置，此方法在onCreate之后执行
	 * 
	 * @param layoutParams
	 * @param windows
	 * @return
	 */
	protected abstract LayoutParams disposeParams(LayoutParams layoutParams, Window window);

	/**
	 * Dialog出现和消失的动画设置，返回0为默认动画，XDialog提供了一系列常用的动画，通过R.style查看使用
	 * 
	 * @return
	 */
	protected abstract int animStyle();

	/**
	 * 点击了返回键，根据返回值判断是否需要关闭Dialog
	 * 
	 * @return 是否关闭
	 */
	protected abstract boolean clickBackKey();

	/**
	 * Dialog即将关闭时调用
	 */
	protected abstract void dialogWillBeDismiss();
}
