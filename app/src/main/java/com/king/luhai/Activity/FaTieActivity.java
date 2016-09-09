package com.king.luhai.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.king.luhai.R;

import java.io.File;


public class FaTieActivity extends Activity {

    TextView fatiezi_quxiao, fatiezi_fasong;
    EditText fatie_neirong;

    ImageView fatie_tupian, fatie_weizhi;
    private String[] items = new String[]{"选择本地图片", "拍照"};
    private static final String IMAGE_FILE_NAME = "rub_course_default_user_icon.png";
    private static final int IMAGE_REQUEST_CODE = 0;
    private static final int CAMERA_REQUEST_CODE = 1;
    private static final int RESULT_REQUEST_CODE = 2;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fatiezi);

        fatiezi_quxiao = (TextView) findViewById(R.id.fatiezi_quxiao);
        fatiezi_fasong = (TextView) findViewById(R.id.fatiezi_fasong);

        fatie_neirong = (EditText) findViewById(R.id.fatie_neirong);

        fatie_tupian = (ImageView) findViewById(R.id.fatie_tupian);
        fatie_weizhi = (ImageView) findViewById(R.id.fatie_weizhi);

        fatiezi_quxiao.setOnClickListener(onClickListener);
        fatiezi_fasong.setOnClickListener(onClickListener);
        fatie_tupian.setOnClickListener(onClickListener);
        fatie_weizhi.setOnClickListener(onClickListener);
        fatie_neirong.setOnClickListener(onClickListener);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.fatiezi_quxiao:
                    Intent intent = new Intent();
                    intent.setClass(FaTieActivity.this, ZhuanFaActivity.class);
                    startActivity(intent);

                    break;

                case R.id.fatiezi_fasong:
                    Toast.makeText(FaTieActivity.this, "发送成功", Toast.LENGTH_SHORT).show();

                    break;

                case R.id.fatie_tupian:

                    showDialog();
                    break;

                case R.id.fatie_weizhi:
                    Intent intent1 = new Intent();
                    intent1.setClass(FaTieActivity.this, ZhuanFaActivity.class);
                    startActivity(intent1);

                    break;

                case R.id.fatie_neirong:
                    Toast.makeText(FaTieActivity.this, "帖子内容", Toast.LENGTH_SHORT).show();
                    fatie_neirong.setHint("");

                    break;


                default:
                    break;


            }
            ;
        }
    };

    private void showDialog() {

        new AlertDialog.Builder(this)
                .setTitle("设置头像")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Intent intentFromGallery = new Intent();
                                intentFromGallery.setType("image/*"); // 设置文件类型
                                intentFromGallery
                                        .setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(intentFromGallery,
                                        IMAGE_REQUEST_CODE);
                                break;
                            case 1:
                                Intent intentFromCapture = new Intent(
                                        MediaStore.ACTION_IMAGE_CAPTURE);
                                // 判断存储卡是否可以用，可用进行存储
                              //  if (Tools.hasSdcard()) {
                                    intentFromCapture.putExtra(
                                            MediaStore.EXTRA_OUTPUT,
                                            Uri.fromFile(new File(Environment
                                                    .getExternalStorageDirectory(),
                                                    IMAGE_FILE_NAME)));
                               // }
                                startActivityForResult(intentFromCapture,
                                        CAMERA_REQUEST_CODE);
                                break;
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case IMAGE_REQUEST_CODE:
                startPhotoZoom(data.getData());
                break;
            case CAMERA_REQUEST_CODE:
               // if (Tools.hasSdcard()) {
                    File tempFile = new File(
                            Environment.getExternalStorageDirectory()
                                    + IMAGE_FILE_NAME);
                    startPhotoZoom(Uri.fromFile(tempFile));
               // } else {
                  //  Toast.makeText(FaTieActivity.this, "未找到存储卡，无法存储照片！",
                  //          Toast.LENGTH_LONG).show();
               // }
                break;
            case RESULT_REQUEST_CODE:
                if (data != null) {
                    getImageToView(data);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 320);
        intent.putExtra("outputY", 320);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 2);
    }

    private void getImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            Drawable drawable = new BitmapDrawable(photo);
            fatie_tupian.setImageDrawable(drawable);
        }
    }

/*
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "FaTie Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.king.luhai.activity/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }*/

  /*  @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "FaTie Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.king.luhai.activity/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }*/
}
