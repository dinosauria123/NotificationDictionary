package com.example.android.basicnotifications;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.webkit.MimeTypeMap;

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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_layout);

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

        final String model = Build.MODEL;

        if (model.equals("KFFOWI")) {    //  Kindle File (2015)

           file1 = new File("/storage/sdcard0/Android/data/com.amazon.kindle/files/dictionaries/B005FNK020_JP-JP.mobi");
           file2 = new File("/storage/sdcard0/Android/data/com.amazon.kindle/files/dictionaries/B005FNK002_Shogakukan_EJ.mobi");
           file3 = new File("/storage/sdcard0/Android/data/com.amazon.kindle/files/Books/B00DQB1G3K/B00DQB1G3K_EBOK.prc");
           file4 = new File("/storage/sdcard0/Android/data/com.amazon.kindle/files/dictionaries/B003WUYRGI_ODE_KCP.mobi");

        }

        else if (model.equals("KFAPWA")|model.equals("KFAPWI")) {   //  Kindle File HDX 8.9inch (2013)

           file1 = new File("/storage/sdcard0/Android/data/com.amazon.kindle/files/dictionaries/Shogagkukan_JJ.mobi");
           file2 = new File("/storage/sdcard0/Android/data/com.amazon.kindle/files/dictionaries/Shogakukan_EJ.mobi");
           file3 = new File("/storage/sdcard0/Android/data/com.amazon.kindle/files/Books/B00DQB1G3K/B00DQB1G3K_EBOK.prc");
           file4 = new File("/storage/sdcard0/Android/data/com.amazon.kindle/files/dictionaries/B003WUYRGI_ODE_KCP.mobi");

        }

        else if (model.equals("KFTHWA")|model.equals("KFTHWI")) {   //  Kindle File HDX 7inch (2013)

            file1 = new File("/storage/sdcard0/Android/data/com.amazon.kindle/files/Books/B005FNK020/B005FNK020_EBOK.prc");
            file2 = new File("/storage/sdcard0/Android/data/com.amazon.kindle/files/Books/B005FNK002/B005FNK002_EBOK.prc");
            file3 = new File("/storage/sdcard0/Android/data/com.amazon.kindle/files/Books/B00DQB1G3K/B00DQB1G3K_EBOK.prc");
            file4 = new File("/storage/sdcard0/Android/data/com.amazon.kindle/files/dictionaries/B003WUYRGI_ODE_KCP.mobi");
        }

        else {

            file1 = new File("");
            file2 = new File("");
            file3 = new File("");
            file4 = new File("");

        }

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
        String mimetype =MimeTypeMap.getSingleton().getMimeTypeFromExtension(extention);

        intent1.setDataAndType(uri1,mimetype);
        intent2.setDataAndType(uri2,mimetype);
        intent3.setDataAndType(uri3,mimetype);
        intent4.setDataAndType(uri4,mimetype);

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
