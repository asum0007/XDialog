package com.asum.xdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DialogMainActivity extends AppCompatActivity {
    private int count = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_main);

        findViewById(R.id.activity_main_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (count == 0) {
                    systemDialog();
                } else if (count == 1) {
                    customDialog1();
                } else if (count == 2) {
                    customDialog2();
                } else if (count == 3) {
                    customDialog3();
                } else if (count == 4) {
                    customDialog4();
                } else if (count == 5) {
                    customDialog5();
                }else if (count == 6) {
                    customDialog6();
                }
                count++;
            }
        });
    }

    private void systemDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogMainActivity.this);
        builder.setMessage("内容内容");

        builder.setTitle("标题");

        builder.setPositiveButton("第一个按钮", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("第二个按钮", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    private void customDialog1() {
//        XMtrBaseSimpleDialog dialog = new XMtrTwoBtnAlignRightAndHorDialog(this, new OnCustomDialogCallBack() {
//            public void click(int flag, String text, XCustomDialog dialog) {
//                if (flag == 0) {
//                    dialog.dismiss();
//                }
//            }
//        }, true).setTitle("更新提示").setContent("发现新版本，新版本将添加新功能以及修复大量BUG，建议升级").setButtonName("取消", "马上升级");
//        dialog.show();
    }

    private void customDialog2() {
//        XMtrBaseSimpleDialog dialog = new XMtrTwoBtnAlignRightAndVerDialog(this, new OnCustomDialogCallBack() {
//            public void click(int flag, String text, XCustomDialog dialog) {
//                if (flag == 0) {
//                    dialog.dismiss();
//                }
//            }
//        }, true).setTitle("更新提示").setContent("发现新版本，新版本将添加新功能以及修复大量BUG，建议升级").setButtonName("取消", "马上升级");
//        dialog.show();
    }

    private void customDialog3() {
//        XMtrBaseSimpleDialog dialog = new XMtrTwoBtnAlignCenterDialog(this, new OnCustomDialogCallBack() {
//            public void click(int flag, String text, XCustomDialog dialog) {
//                if (flag == 0) {
//                    dialog.dismiss();
//                }
//            }
//        }, true).setTitle("更新提示").setContent("发现新版本，新版本将添加新功能以及修复大量BUG，建议升级").setButtonName("取消", "马上升级");
//        dialog.show();
    }

    private void customDialog4() {
//        XHintBaseDialog dialog = new XHintTextDialog(getWindow().getContext(), new OnCustomDialogCallBack() {
//            public void click(int flag, String text, XCustomDialog dialog) {
//
//            }
//        }, true).setHint("发生了严重的错误，请重试");
//        dialog.show();
    }

    private void customDialog5() {
//        XHintBaseDialog dialog = new XHintPicAndTextDialog(getWindow().getContext(), new OnCustomDialogCallBack() {
//            public void click(int flag, String text, XCustomDialog dialog) {
//
//            }
//        }, true).setHint("发生了严重的错误，请重试").setTipPicture(R.mipmap.ic_launcher);
//        dialog.show();
    }

    private void customDialog6() {
//        BitmapFactory.Options option = new BitmapFactory.Options();
//        option.inPreferredConfig = Bitmap.Config.ARGB_8888;
//        option.inPurgeable = true;
//        option.inInputShareable = true;
//        InputStream inputStream = getResources().openRawResource(R.mipmap.ic_launcher);
//        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, option);
//
//        XImageBaseDialog dialog = new XImageSimpleDialog(getWindow().getContext(), new OnCustomDialogCallBack() {
//            public void click(int flag, String text, XCustomDialog dialog) {
//
//            }
//        }, true).setImageBitmap(bitmap);
//        dialog.show();
    }
}
