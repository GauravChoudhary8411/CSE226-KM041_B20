package com.example.hotelmanagementsystem;

public class Home {
        private String hotelName;
        private String hotellocation;
        private int HotelImage;

        public Home(String bookName, String hotellocation, int HotelImage) {
            this.hotelName = bookName;
            this.hotellocation = hotellocation;
            this.HotelImage = HotelImage;
        }

        public String getBookName() {
            return hotelName;
        }

        public void setHotelName(String bookName) {
            this.hotelName = bookName;
        }

        public String getBookAuthor() {
            return hotellocation;
        }

        public void setHotellocation(String bookAuthor) {
            this.hotellocation = bookAuthor;
        }

        public int getHotelImage() {
            return HotelImage;
        }

        public void setBookImage(int bookImage) {
            this.HotelImage = bookImage;
        }
}