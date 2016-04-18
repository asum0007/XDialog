package com.asum.xdialog.interfaces;

import com.asum.xdialog.dialog.XCustomDialog;

public abstract class OnCustomDialogCallBack {
	/**
	 * Dialog上面的控件被点击，根据flag判断是什么控件
	 * 
	 * @param flag
	 * @param text
	 * @param dialog
	 */
	public abstract void click(int flag, String text, XCustomDialog dialog);

	/**
	 * 因为返回键退出
	 * 
	 * @param dialog
	 */
	public void cancelFromKey(XCustomDialog dialog) {
	}
}
