package com.example.marketlist.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.marketlist.entity.Sobre;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface SobreDAO {

    @Query("SELECT * FROM  Sobre")
    public Sobre getSobre();

    @Insert(onConflict = REPLACE)
    public void insert(Sobre sobre);




}
