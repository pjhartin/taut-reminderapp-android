/*
*    This file is part of GPSLogger for Android.
*
*    GPSLogger for Android is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 2 of the License, or
*    (at your option) any later version.
*
*    GPSLogger for Android is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with GPSLogger for Android.  If not, see <http://www.gnu.org/licenses/>.
*/

package ulster.serg.tautreminderapp.controller.sensors.legacy.sensor.location.common;

import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DebugLogger {

    public static void Write(String message) {
        Thread t = new Thread(new DebugLogWriter(message));
        t.start();
    }
}

class DebugLogWriter implements Runnable {

    private final String message;

    public DebugLogWriter(String message) {
        this.message = message;
    }

    public void run() {

        if (message == null || message.length() == 0) {
            return;
        }

        try {
            File gpxFolder = new File(
                    Environment.getExternalStorageDirectory(), "TAUT/SensorLogs");

            if (!gpxFolder.exists()) {
                gpxFolder.mkdirs();
            }

            File logFile = new File(gpxFolder.getPath(), "debug.log");

            if (!logFile.exists()) {
                logFile.createNewFile();
            }

            FileOutputStream logStream = new FileOutputStream(logFile, true);
            BufferedOutputStream logOutputStream = new BufferedOutputStream(
                    logStream);
            FileLock lock = logStream.getChannel().lock();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dateString = dateFormat.format(date);

            logOutputStream.write((dateString + ":" + message + "\n").getBytes());
            logOutputStream.flush();
            lock.release();
            logOutputStream.close();
        } catch (Throwable e) {
            // Nothing
        }

    }

}