package com.phorloop.tautreminders.controller.helpers;

import android.content.Context;

import com.phorloop.tautreminders.model.sugarorm.Acknowledgement;
import com.phorloop.tautreminders.model.sugarorm.Reminder;

/**
 * Created by philliphartin on 25/09/2014.
 */
public class AcknowledgementHelper {
    private final Context mContext;
    private final PreferencesHelper preferencesHelper;

    public AcknowledgementHelper(Context context) {
        this.mContext = context;
        preferencesHelper = new PreferencesHelper(mContext);
    }

    public void saveAcknowledgmentLogforReminder(Reminder reminder, Acknowledgement acknowledgement, boolean acknowledged) {

        if (acknowledged) {
            logReminderAsAcknowledged(reminder, acknowledgement);
        } else {
            logReminderAsMissed(reminder);
        }
    }

    public void logReminderAsAcknowledged(Reminder reminder, Acknowledgement acknowledgement) {

        boolean acknowledged = true;
        acknowledgement.setReminderId(reminder.getId());
        acknowledgement.setPatientId(preferencesHelper.getUserId());
        acknowledgement.setAcknowledgedByUser(convertBooleanToInt(acknowledged));
        acknowledgement.setSentToServer(0);
        acknowledgement.save();
    }

    public void logReminderAsMissed(Reminder reminder) {
        boolean acknowledged = false;

        Acknowledgement acknowledgement = new Acknowledgement();
        acknowledgement.setReminderId(reminder.getId());
        acknowledgement.setPatientId(preferencesHelper.getUserId());
        acknowledgement.setAcknowledgedByUser(convertBooleanToInt(acknowledged));
        acknowledgement.setTimeToAcknowledge(0);
        acknowledgement.setBatteryLevel(0);
        acknowledgement.setListenCount(0);
        acknowledgement.setSentToServer(0);

        acknowledgement.save();
    }

    private int convertBooleanToInt(Boolean bool) {
        return bool ? 1 : 0;
    }
}
