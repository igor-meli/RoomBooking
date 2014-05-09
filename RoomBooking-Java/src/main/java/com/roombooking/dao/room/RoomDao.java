package com.roombooking.dao.room;

import com.roombooking.dao.Dao;
import com.roombooking.entity.Room;
import com.roombooking.entity.User;

import java.util.List;

public interface RoomDao extends Dao<Room> {

    Room getRoomByIdWithUserRights(int id, User user);

    List<Room> getAllRoomsWithUserRights(User user);

}
