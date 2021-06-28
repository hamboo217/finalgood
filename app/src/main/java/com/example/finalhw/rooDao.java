package com.example.finalhw;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao    //訪問用的
public interface rooDao {
    @Insert
    void insertword(roo... words);

    @Update
    void updateword(roo...words);

    @Delete
    void deleteallword1(roo...words);

    @Query("DELETE FROM roo")
    void deleteallword();

    @Query("SELECT * FROM roo ORDER BY timestamp DESC")
    LiveData<List<roo>> getallwordLive();


}