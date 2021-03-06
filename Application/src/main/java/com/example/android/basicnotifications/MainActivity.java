package com.example.android.basicnotifications;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;


/**
 * The entry point to the BasicNotification sample.
 */
public class MainActivity extends Activity {
    /**
     * A numeric value that identifies the notification that we'll be sending.
     * This value needs to be unique within this app, but it doesn't need to be
     * unique system-wide.
     */
//    public static final int NOTIFICATION_ID = 1;


//    String model = Build.MODEL;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_layout);

//  ファイルディレクトリの表示
// This codes comes from http://www.codeproject.com/Articles/547636/Android-Ready-to-use-simple

        Button dirChooserButton1 = (Button) findViewById(R.id.button2);
        Button dirChooserButton2 = (Button) findViewById(R.id.button3);
        Button dirChooserButton3 = (Button) findViewById(R.id.button4);
        Button dirChooserButton4 = (Button) findViewById(R.id.button5);

        dirChooserButton1.setOnClickListener(new View.OnClickListener() {
            private String m_chosenDir1 = "";
                     private boolean m_newFolderEnabled = false;
            SharedPreferences pref = getSharedPreferences("config", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            @Override
            public void onClick(View v) {
                // Create DirectoryChooserDialog and register a callback
                DirectoryChooserDialog directoryChooserDialog =
                        new DirectoryChooserDialog(MainActivity.this,
                                new DirectoryChooserDialog.ChosenDirectoryListener() {
                                    @Override
                                    public void onChosenDir(String chosenDir) {
                                        m_chosenDir1 = chosenDir;
                                        Toast.makeText(
                                                MainActivity.this, "Chosen directory: " +
                                                        chosenDir, Toast.LENGTH_LONG).show();

                                        editor.putString("JPDicPath", m_chosenDir1);
                                        editor.commit();
                                    }

                                });

                // Toggle new folder button enabling
                directoryChooserDialog.setNewFolderEnabled(m_newFolderEnabled);
                // Load directory chooser dialog for initial 'm_chosenDir' directory.
                // The registered callback will be called upon final directory selection.
                directoryChooserDialog.chooseDirectory(m_chosenDir1);
                m_newFolderEnabled = !m_newFolderEnabled;
            }


        });

        dirChooserButton2.setOnClickListener(new View.OnClickListener() {
            private String m_chosenDir2 = "";
            private boolean m_newFolderEnabled = false;
            SharedPreferences pref = getSharedPreferences("config", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            @Override
            public void onClick(View v) {
                // Create DirectoryChooserDialog and register a callback
                DirectoryChooserDialog directoryChooserDialog =
                        new DirectoryChooserDialog(MainActivity.this,
                                new DirectoryChooserDialog.ChosenDirectoryListener() {
                                    @Override
                                    public void onChosenDir(String chosenDir) {
                                        m_chosenDir2 = chosenDir;
                                        Toast.makeText(
                                                MainActivity.this, "Chosen directory: " +
                                                        chosenDir, Toast.LENGTH_LONG).show();

                                        editor.putString("EJDicPath", m_chosenDir2);
                                        editor.commit();
                                    }

                                });

                // Toggle new folder button enabling
                directoryChooserDialog.setNewFolderEnabled(m_newFolderEnabled);
                // Load directory chooser dialog for initial 'm_chosenDir' directory.
                // The registered callback will be called upon final directory selection.
                directoryChooserDialog.chooseDirectory(m_chosenDir2);
                m_newFolderEnabled = !m_newFolderEnabled;
            }


        });

        dirChooserButton3.setOnClickListener(new View.OnClickListener() {
            private String m_chosenDir3 = "";
            private boolean m_newFolderEnabled = false;
            SharedPreferences pref = getSharedPreferences("config", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            @Override
            public void onClick(View v) {
                // Create DirectoryChooserDialog and register a callback
                DirectoryChooserDialog directoryChooserDialog =
                        new DirectoryChooserDialog(MainActivity.this,
                                new DirectoryChooserDialog.ChosenDirectoryListener() {
                                    @Override
                                    public void onChosenDir(String chosenDir) {
                                        m_chosenDir3 = chosenDir;
                                        Toast.makeText(
                                                MainActivity.this, "Chosen directory: " +
                                                        chosenDir, Toast.LENGTH_LONG).show();

                                        editor.putString("JEDicPath", m_chosenDir3);
                                        editor.commit();
                                    }

                                });

                // Toggle new folder button enabling
                directoryChooserDialog.setNewFolderEnabled(m_newFolderEnabled);
                // Load directory chooser dialog for initial 'm_chosenDir' directory.
                // The registered callback will be called upon final directory selection.
                directoryChooserDialog.chooseDirectory(m_chosenDir3);
                m_newFolderEnabled = !m_newFolderEnabled;
            }


        });

        dirChooserButton4.setOnClickListener(new View.OnClickListener() {
            private String m_chosenDir4 = "";
            private boolean m_newFolderEnabled = false;
            SharedPreferences pref = getSharedPreferences("config", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();

            @Override
            public void onClick(View v) {
                // Create DirectoryChooserDialog and register a callback
                DirectoryChooserDialog directoryChooserDialog =
                        new DirectoryChooserDialog(MainActivity.this,
                                new DirectoryChooserDialog.ChosenDirectoryListener() {
                                    @Override
                                    public void onChosenDir(String chosenDir) {
                                        m_chosenDir4 = chosenDir;
                                        Toast.makeText(
                                                MainActivity.this, "Chosen directory: " +
                                                        chosenDir, Toast.LENGTH_LONG).show();

                                        editor.putString("EEDicPath", m_chosenDir4);
                                        editor.commit();
                                    }

                                });

                // Toggle new folder button enabling
                directoryChooserDialog.setNewFolderEnabled(m_newFolderEnabled);
                // Load directory chooser dialog for initial 'm_chosenDir' directory.
                // The registered callback will be called upon final directory selection.
                directoryChooserDialog.chooseDirectory(m_chosenDir4);
                m_newFolderEnabled = !m_newFolderEnabled;
            }


        });
    }
/*  端末情報の表示

        String path = Environment.getExternalStorageDirectory().toString() + "/Android/data/com.amazon.kindle/files/dictionaries";
        File f = new File(path);
        File files[] = f.listFiles();
        String datafile = " ";

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    datafile = datafile + files[i].getName() + "\n ";
                }
            }
        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("端末情報");
        alertDialogBuilder.setMessage("Fireモデル名 " + model + "\n辞書ファイル \n" + datafile);
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
        /**
         * Send a sample notification using the NotificationCompat API.
         */

    public void sendNotification(View view) {

        // BEGIN_INCLUDE(build_action)
        /** Create an intent that will be fired when the user clicks the notification.
         * The intent needs to be packaged into a {@link android.app.PendingIntent} so that the
         * notification service can fire it on our behalf.
         */

        File file1;
        File file2;
        File file3;
        File file4;

        SharedPreferences pref = getSharedPreferences("config", Context.MODE_PRIVATE);

            file1 = new File( pref.getString("JPDicPath","") );
            file2 = new File( pref.getString("EJDicPath","") );
            file3 = new File( pref.getString("JEDicPath","") );
            file4 = new File( pref.getString("EEDicPath","") );


        Intent intent1 = new Intent();
        Intent intent2 = new Intent();
        Intent intent3 = new Intent();
        Intent intent4 = new Intent();


        intent1.setAction(Intent.ACTION_VIEW);
        intent2.setAction(Intent.ACTION_VIEW);
        intent3.setAction(Intent.ACTION_VIEW);
        intent4.setAction(Intent.ACTION_VIEW);

        Uri uri1 = Uri.fromFile(file1);
        Uri uri2 = Uri.fromFile(file2);
        Uri uri3 = Uri.fromFile(file3);
        Uri uri4 = Uri.fromFile(file4);

        //拡張子
        String extention = MimeTypeMap.getFileExtensionFromUrl("file://" + file1);
        //mime type
        String mimetype = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extention);

        intent1.setDataAndType(uri1, mimetype);
        intent2.setDataAndType(uri2, mimetype);
        intent3.setDataAndType(uri3, mimetype);
        intent4.setDataAndType(uri4, mimetype);

        PendingIntent pendingIntent1 = PendingIntent.getActivity(this, 0, intent1, 0);
        PendingIntent pendingIntent2 = PendingIntent.getActivity(this, 0, intent2, 0);
        PendingIntent pendingIntent3 = PendingIntent.getActivity(this, 0, intent3, 0);
        PendingIntent pendingIntent4 = PendingIntent.getActivity(this, 0, intent4, 0);
        // END_INCLUDE(build_action)

        // BEGIN_INCLUDE (build_notification)
        /**
         * Use NotificationCompat.Builder to set up our notification.
         */
        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(this);
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this);
        NotificationCompat.Builder builder3 = new NotificationCompat.Builder(this);
        NotificationCompat.Builder builder4 = new NotificationCompat.Builder(this);

        /** Set the icon that will appear in the notification bar. This icon also appears
         * in the lower right hand corner of the notification itself.
         *
         * Important note: although you can use any drawable as the small icon, Android
         * design guidelines state that the icon should be simple and monochrome. Full-color
         * bitmaps or busy images don't render well on smaller screens and can end up
         * confusing the user.
         */
        builder1.setSmallIcon(R.drawable.ic_stat_notification);
        builder2.setSmallIcon(R.drawable.ic_stat_notification);
        builder3.setSmallIcon(R.drawable.ic_stat_notification);
        builder4.setSmallIcon(R.drawable.ic_stat_notification);

        // Set the intent that will fire when the user taps the notification.
        builder1.setContentIntent(pendingIntent1);
        builder2.setContentIntent(pendingIntent2);
        builder3.setContentIntent(pendingIntent3);
        builder4.setContentIntent(pendingIntent4);

        // Set the notification to auto-cancel. This means that the notification will disappear
        // after the user taps it, rather than remaining until it's explicitly dismissed.
        //   builder.setAutoCancel(true);

        /**
         *Build the notification's appearance.
         * Set the large icon, which appears on the left of the notification. In this
         * sample we'll set the large icon to be the same as our app icon. The app icon is a
         * reasonable default if you don't have anything more compelling to use as an icon.
         */
        builder1.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder2.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder3.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder4.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));

        /**
         * Set the text of the notification. This sample sets the three most commononly used
         * text areas:
         * 1. The content title, which appears in large type at the top of the notification
         * 2. The content text, which appears in smaller text below the title
         * 3. The subtext, which appears under the text on newer devices. Devices running
         *    versions of Android prior to 4.2 will ignore this field, so don't use it for
         *    anything vital!
         */
        builder1.setContentTitle("小学館 デジタル大辞泉");
        builder2.setContentTitle("小学館 プログレッシブ英和中辞典");
        builder3.setContentTitle("小学館 プログレッシブ和英中辞典");
        builder4.setContentTitle("Oxford Dictionary of English");
        //   builder.setContentText("Time to learn about notifications!");
        //   builder.setSubText("Tap to view documentation about notifications.");

        // END_INCLUDE (build_notification)

        // BEGIN_INCLUDE(send_notification)
        /**
         * Send the notification. This will immediately display the notification icon in the
         * notification bar.
         */
        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder1.build());
        notificationManager.notify(2, builder2.build());
        notificationManager.notify(3, builder3.build());
        notificationManager.notify(4, builder4.build());
        // END_INCLUDE(send_notification)
        this.finish();
    }
}