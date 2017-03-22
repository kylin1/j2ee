ALTER TABLE "member";
ALTER TABLE "hotel";
ALTER TABLE "manager";
ALTER TABLE "hotel_room";
ALTER TABLE "order";
ALTER TABLE "room_guest";
ALTER TABLE "approval";
ALTER TABLE "payment";
ALTER TABLE "expenditure";

DROP TABLE "member";
DROP TABLE "hotel";
DROP TABLE "manager";
DROP TABLE "hotel_room";
DROP TABLE "order";
DROP TABLE "room_guest";
DROP TABLE "approval";
DROP TABLE "payment";
DROP TABLE "expenditure";

CREATE TABLE "member" (
"id" INTEGER NOT NULL,
"account" CHARACTER VARYING(255) NOT NULL,
"password" CHARACTER VARYING(255) NOT NULL,
"phone" CHARACTER VARYING(255) NULL,
"email" CHARACTER VARYING(255) NULL,
"status" INT NOT NULL 0,
"bankCard" CHARACTER VARYING(255) NULL,
"activatedTime" DATE NULL,
"expireTime" DATE NULL,
"consume" INT NOT NULL 0,
"balance" INT NOT NULL 0,
"level" INT NOT NULL 0,
"score" INT NOT NULL 0,
PRIMARY KEY ("id") 
);

CREATE TABLE "hotel" (
"id" INTEGER NOT NULL,
"account" CHARACTER VARYING(255) NOT NULL,
"password" CHARACTER VARYING(255) NOT NULL,
"name" CHARACTER VARYING(255) NOT NULL,
"location" CHARACTER VARYING(255) NOT NULL,
"status" CHARACTER VARYING(255) NOT NULL 0,
PRIMARY KEY ("id") 
);

CREATE TABLE "manager" (
"id" INTEGER NOT NULL,
"account" CHARACTER VARYING(255) NOT NULL,
"password" CHARACTER VARYING(255) NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "hotel_room" (
"id" INTEGER NOT NULL,
"room" CHARACTER VARYING(255) NOT NULL,
"hotelid" INTEGER NOT NULL,
"type" INT NOT NULL,
"date" DATE NOT NULL,
"status" INT NOT NULL,
"price" INT NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "order" (
"id" INTEGER NOT NULL,
"userid" INTEGER NOT NULL,
"hotelid" INTEGER NOT NULL,
"orderTime" DATE NOT NULL,
"checkIn" DATE NOT NULL,
"checkOut" DATE NOT NULL,
"roomType" INT NOT NULL,
"roomNumber" INT NOT NULL,
"price" INT NOT NULL,
"contactName" CHARACTER VARYING(255) NOT NULL,
"contactPhone" CHARACTER VARYING(255) NOT NULL,
"status" INT NOT NULL 0,
"isMember" INT NULL,
"isCash" INT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "room_guest" (
"id" INTEGER NOT NULL,
"orderid" INTEGER NOT NULL,
"date" DATE NOT NULL,
"roomid" INTEGER NOT NULL,
"name" CHARACTER VARYING(255) NOT NULL,
"idNum" CHARACTER VARYING(255) NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "approval" (
"id" INTEGER NOT NULL,
"hotelid" INTEGER NOT NULL,
"type" INT NOT NULL,
"mainContent" CHARACTER VARYING(255) NOT NULL,
"content" CHARACTER VARYING(255) NULL,
"status" CHARACTER VARYING(255) NOT NULL 0,
PRIMARY KEY ("id") 
);

CREATE TABLE "payment" (
"id" INTEGER NOT NULL,
"hotelid" INTEGER NOT NULL,
"userid" INTEGER NOT NULL,
"time" DATE NOT NULL,
"price" INT NOT NULL,
"status" CHARACTER VARYING(255) NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "expenditure" (
"id" INTEGER NOT NULL,
"hotelid" INTEGER NOT NULL,
"date" DATE NOT NULL,
"price" INT NOT NULL,
PRIMARY KEY ("id") 
);


ALTER TABLE "hotel_room" ADD CONSTRAINT "fk_hotel_room" FOREIGN KEY ("hotelid") REFERENCES "hotel" ("id");
ALTER TABLE "order" ADD CONSTRAINT "fk_order" FOREIGN KEY ("userid") REFERENCES "member" ("id");
ALTER TABLE "order" ADD CONSTRAINT "fk_order_1" FOREIGN KEY ("hotelid") REFERENCES "hotel" ("id");
ALTER TABLE "room_guest" ADD CONSTRAINT "fk_room_guest" FOREIGN KEY ("orderid") REFERENCES "order" ("id");
ALTER TABLE "room_guest" ADD CONSTRAINT "fk_room_guest_1" FOREIGN KEY ("roomid") REFERENCES "hotel_room" ("id");
ALTER TABLE "approval" ADD CONSTRAINT "fk_approval" FOREIGN KEY ("hotelid") REFERENCES "hotel" ("id");
ALTER TABLE "payment" ADD CONSTRAINT "fk_payment" FOREIGN KEY ("hotelid") REFERENCES "hotel" ("id");
ALTER TABLE "payment" ADD CONSTRAINT "fk_payment_1" FOREIGN KEY ("userid") REFERENCES "member" ("id");
ALTER TABLE "expenditure" ADD CONSTRAINT "fk_expenditure" FOREIGN KEY ("hotelid") REFERENCES "hotel" ("id");

