package com.asum.xdialog.dialog.hint;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.asum.xdialog.interfaces.OnCustomDialogCallBack;
import com.asum.xlayoutparams.utils.XDpArea;

/**
 * 自动关闭的弹出窗，仅仅包含文字
 * 
 * @author Asum
 * 
 */
public class XHintTextDialog extends XHintBaseDialog {
	public XHintTextDialog(Context context, OnCustomDialogCallBack callBack, boolean canceledOnTouchOutside) {
		super(context, callBack, canceledOnTouchOutside);
	}

	protected void onCreate(LinearLayout dialogLayout) {
		super.onCreate(dialogLayout);

		dialogLayout.setOrientation(LinearLayout.VERTICAL);
		tipImageView.setVisibility(View.GONE);
		tipTextView.setGravity(Gravity.CENTER);
		new XDpArea(context, tipTextView).set(XDpArea.LEFT, XDpArea.CENTER, 232, XDpArea.WRAP);
	}
}
