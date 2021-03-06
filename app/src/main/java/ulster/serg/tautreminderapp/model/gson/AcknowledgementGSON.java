package ulster.serg.tautreminderapp.model.gson;

import ulster.serg.tautreminderapp.model.sugarorm.Acknowledgement;
import ulster.serg.tautreminderapp.model.sugarorm.Reminder;

/**
 * Created by philliphartin on 25/09/2014.
 */

//GSON Class to create single Acknowledgement logs for transmission.
public class AcknowledgementGSON {

    //ReminderData
    String format;
    String time;
    String date;
    long unixtime;
    String dayofweek;
    String type;
    String description;
    String repeatfreq;
    String createdby;
    int createdbyid;
    long audioduration;

    //AcknowledgementData
    int patientid;
    int acknowledgedbyuser;
    long timetoacknowledge;
    int batterylevel;
    int listencount;

    public AcknowledgementGSON(long acknowledgementId) {

        //Get acknowledgment object
        Acknowledgement acknowledgement = Acknowledgement.findById(Acknowledgement.class, acknowledgementId);
        //Get reminder object for acknowledgement
        Reminder reminder = Reminder.findById(Reminder.class, acknowledgement.getReminderid());

        this.format = reminder.getFormat();
        this.time = reminder.getTime();
        this.date = reminder.getDate();
        this.unixtime = reminder.getUnixtime();
        this.dayofweek = reminder.getDayofweek();
        this.type = reminder.getType();
        this.description = reminder.getDescription();
        this.repeatfreq = reminder.getRepeatfreq();
        this.createdby = reminder.getCreatedby();
        this.createdbyid = reminder.getCreatedbyid();
        this.audioduration = reminder.getAudioduration();
        this.patientid = acknowledgement.getPatientid();
        this.acknowledgedbyuser = acknowledgement.getAcknowledgedbyuser();
        this.timetoacknowledge = acknowledgement.getTimetoacknowledge();
        this.batterylevel = acknowledgement.getBatterylevel();
        this.listencount = acknowledgement.getListencount();
    }

    public AcknowledgementGSON(Acknowledgement acknowledgement) {

        //Get reminder object for acknowledgement
        Reminder reminder = Reminder.findById(Reminder.class, acknowledgement.getReminderid());

        this.format = reminder.getFormat();
        this.time = reminder.getTime();
        this.date = reminder.getDate();
        this.unixtime = reminder.getUnixtime();
        this.dayofweek = reminder.getDayofweek();
        this.type = reminder.getType();
        this.description = reminder.getDescription();
        this.repeatfreq = reminder.getRepeatfreq();
        this.createdby = reminder.getCreatedby();
        this.createdbyid = reminder.getCreatedbyid();
        this.audioduration = reminder.getAudioduration();
        this.patientid = acknowledgement.getPatientid();
        this.acknowledgedbyuser = acknowledgement.getAcknowledgedbyuser();
        this.timetoacknowledge = acknowledgement.getTimetoacknowledge();
        this.batterylevel = acknowledgement.getBatterylevel();
        this.listencount = acknowledgement.getListencount();
    }


    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(long unixtime) {
        this.unixtime = unixtime;
    }

    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRepeatfreq() {
        return repeatfreq;
    }

    public void setRepeatfreq(String repeatfreq) {
        this.repeatfreq = repeatfreq;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public int getCreatedbyid() {
        return createdbyid;
    }

    public void setCreatedbyid(int createdbyid) {
        this.createdbyid = createdbyid;
    }

    public long getAudioduration() {
        return audioduration;
    }

    public void setAudioduration(long audioduration) {
        this.audioduration = audioduration;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public int getAcknowledgedbyuser() {
        return acknowledgedbyuser;
    }

    public void setAcknowledgedbyuser(int acknowledgedbyuser) {
        this.acknowledgedbyuser = acknowledgedbyuser;
    }

    public long getTimetoacknowledge() {
        return timetoacknowledge;
    }

    public void setTimetoacknowledge(long timetoacknowledge) {
        this.timetoacknowledge = timetoacknowledge;
    }

    public int getBatterylevel() {
        return batterylevel;
    }

    public void setBatterylevel(int batterylevel) {
        this.batterylevel = batterylevel;
    }

    public int getListencount() {
        return listencount;
    }

    public void setListencount(int listencount) {
        this.listencount = listencount;
    }
}
