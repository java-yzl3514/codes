package com.ba.yzl3514.domain.pre.composition;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class House {
    private String address;
    private Room[] rooms;

    public House(String address) {
        this.address = address;
        this.rooms = new Room[]{
                new Room("Living Room", 30.5),
                new Room("Kitchen", 15.0),
                new Room("Bedroom", 20.0)
        };
    }

    public void displayHouseInfo() {
        System.out.println("House at address: " + address);
        for (Room room : rooms) {
            room.printInfo();
        }
    }
}
