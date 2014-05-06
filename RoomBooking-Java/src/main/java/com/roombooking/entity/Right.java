package com.roombooking.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Right {

    private int id;
    private Boolean canBookRoom;
    private Position position;
    private RoomType roomType;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Basic
    @Column(name = "can_book_room", nullable = true, insertable = true, updatable = true)
    public Boolean getCanBookRoom() {
        return canBookRoom;
    }

    public void setCanBookRoom(Boolean canBookRoom) {
        this.canBookRoom = canBookRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Right that = (Right) o;

        if (id != that.id) return false;
        if (canBookRoom != null ? !canBookRoom.equals(that.canBookRoom) : that.canBookRoom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (canBookRoom != null ? canBookRoom.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position positionByPositionId) {
        this.position = positionByPositionId;
    }

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomTypeByRoomId) {
        this.roomType = roomTypeByRoomId;
    }

}
