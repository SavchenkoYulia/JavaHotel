package com.hotel.hotel.repost;

import com.hotel.hotel.models.Rooms;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomsRepository extends CrudRepository<Rooms,Long> {
    List<Rooms> findByTitleContainingIgnoreCase(String search);

}
