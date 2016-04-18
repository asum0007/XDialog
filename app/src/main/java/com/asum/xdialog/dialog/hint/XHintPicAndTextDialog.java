package com.asum.xdialog.dialog.hint;

import android.content.Context;
import android.widget.LinearLayout;

import com.asum.xdialog.interfaces.OnCustomDialogCallBack;
import com.asum.xlayoutparams.utils.XDpArea;

/**
 * 自动关闭的弹出窗，包含一个文字和一张图片
 * 
 * @author Asum
 * 
 */
public class XHintPicAndTextDialog extends XHintBaseDialog {
	public XHintPicAndTextDialog(Context context, OnCustomDialogCallBack callBack, boolean canceledOnTouchOutside) {
		super(context, callBack, canceledOnTouchOutside);
	}

	protected void onCreate(LinearLayout dialogLayout) {
		super.onCreate(dialogLayout);

		new XDpArea(context, tipImageView).set(0, XDpArea.CENTER, 48, 48);
		new XDpArea(context, tipTextView).set(24, 0, 184, XDpArea.WRAP);
	}
}
