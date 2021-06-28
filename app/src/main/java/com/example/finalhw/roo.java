package com.example.finalhw;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class roo {

    @PrimaryKey(autoGenerate = true)
    public   int timestamp;
    @ColumnInfo(name="GUEST_NAME")
    public  String guestName;
    @ColumnInfo(name="PARTY_SIZE")
    public   String partySize;


    public roo(String guestName, String partySize) {
        this.guestName = guestName;
        this.partySize = partySize;

    }

    public String getGuestName() {

        return guestName;
    }

    public void setGuestName(String guestName) {

        this.guestName = guestName;
    }

    public String getPartySize() {

        return partySize;
    }

    public void setPartySize(String partySize) {

        this.partySize = partySize;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void zero(){
        timestamp = 0;
    }
}
