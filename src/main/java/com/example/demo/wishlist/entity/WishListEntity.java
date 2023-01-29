package com.example.demo.wishlist.entity;

import com.example.demo.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListEntity extends MemoryDbEntity {

    private String title;
    private String category;
    private String address;
    private String roadaddress;
    private String homePageLink;
    private String imageLink;
    private boolean isVisit;
    private int visitCount;
    private LocalDateTime lastVisitDate;
}
