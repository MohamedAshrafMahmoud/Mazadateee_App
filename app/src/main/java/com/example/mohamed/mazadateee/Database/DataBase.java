//package com.example.mohamed.mazadateee.Database;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import com.example.mohamed.akelnyresturant.model.Favorites;
//import com.example.mohamed.akelnyresturant.model.Order;
//
//import java.util.ArrayList;
//
///**
// * Created by mohamed on 4/9/18.
// */
//
//public class DataBase extends SQLiteOpenHelper {
//
//
//    private static final int DATABASE_VERSION = 1;
//
//    private static final String DATABASE_NAME = "akelnyDB";
//
//    private static final String TABLE_ORDERS = "Orders";
//    private static final String TABLE_FAVORITES = "Favorite";
//
//
//    private static final String userPhone = "UserPhone";
//    private static final String Id = "ProductId";
//    private static final String Name = "ProductName";
//    private static final String Quantity = "Quantity";
//    private static final String Price = "Price";
//    private static final String Discount = "Discount";
//    private static final String Image = "Image";
//
//    private static final String ID = "FoodId";
//    private static final String UserPhone = "UserPhone";
//    private static final String FoodName = "FoodName";
//    private static final String FoodPrice = "FoodPrice";
//    private static final String FoodMenuId = "FoodMenuId";
//    private static final String FoodImage = "FoodImage";
//    private static final String FoodDiscount = "FoodDiscount";
//    private static final String FoodDescription = "FoodDescription";
//
//
//    public DataBase(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//        String Table_orders = "CREATE TABLE " + TABLE_ORDERS + "(" +
//                userPhone + " TEXT," + Id + " TEXT," + Name + " TEXT," + Quantity + " TEXT," + Price + " TEXT,"
//                + Discount + " TEXT," + Image + " TEXT);";
//
//        String Table_favorites = "CREATE TABLE " + TABLE_FAVORITES + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + FoodName + " TEXT,"
//                + FoodPrice + " TEXT," + FoodMenuId + " TEXT," + FoodImage + " TEXT," + FoodDiscount + " TEXT,"
//                + FoodDescription + " TEXT," + UserPhone + " TEXT);";
//
//
//        db.execSQL(Table_orders);
//        db.execSQL(Table_favorites);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITES);
//
//        onCreate(db);
//
//    }
//////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    public void addToCart(Order order) {
//        SQLiteDatabase db = getReadableDatabase();
//        String query = String.format("INSERT OR REPLACE INTO Orders (UserPhone,ProductId,ProductName,Quantity,Price,Discount,Image) VALUES ('%s','%s','%s','%s','%s','%s','%s');"
//                ,
//                order.getProductName(),
//                order.getProductId(),
//                order.getProductName(),
//                order.getQuantity(),
//                order.getPrice(),
//                order.getDiscount(),
//                order.getImage());
//        db.execSQL(query);
//
//
//    }
//////////////////////////////////////////////////////////////////////////////////////////////////////
//
////    public ArrayList<Order> getAllFromCart(String phone) {
////        SQLiteDatabase db = getReadableDatabase();
////       SQLiteQueryBuilder qp=new SQLiteQueryBuilder();
////       String [] sqlSelect={"UserPhone","ProductId","ProductName","Quantity","Price","Discount","Image"};
////       qp.setTables(TABLE_ORDERS);
////       Cursor cursor=qp.query(db,sqlSelect,"UserPhone=?",new String[]{phone},null,null,null);
////       final ArrayList<Order>result=new ArrayList<>();
////       if(cursor.moveToFirst()){
////           do{
////               result.add(new Order(
////                       cursor.getString(cursor.getColumnIndex("UserPhone")),
////                       cursor.getString(cursor.getColumnIndex("ProductId")),
////                       cursor.getString(cursor.getColumnIndex("ProductName")),
////                       cursor.getString(cursor.getColumnIndex("Quantity")),
////                       cursor.getString(cursor.getColumnIndex("Price")),
////                       cursor.getString(cursor.getColumnIndex("Discount")),
////                       cursor.getString(cursor.getColumnIndex("Image"))
////
////               ));
////           }while (cursor.moveToNext());
////       }
////       return result;
////    }
//
//    public ArrayList<Order> getAllFromCart() {
//        ArrayList<Order> contactList = new ArrayList<Order>();
//        String selectQuery = "SELECT * FROM " + TABLE_ORDERS;
//
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                Order order = new Order();
//                order.setUserPhone(cursor.getString(0));
//                order.setProductId(cursor.getString(1));
//                order.setProductName(cursor.getString(2));
//                order.setQuantity(cursor.getString(3));
//                order.setPrice(cursor.getString(4));
//                order.setDiscount(cursor.getString(5));
//                order.setImage(cursor.getString(6));
//                contactList.add(order);
//            } while (cursor.moveToNext());
//        }
//
//        return contactList;
//    }
//
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////
//    public void deleteFromCart(String phone) {
//        SQLiteDatabase db = getReadableDatabase();
//        String query = String.format("DELETE FROM Orders WHERE UserPhone='%s'", phone);
//        db.execSQL(query);
//    }
//
//    public int deleteFromCart2(String id) {
//        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//
//        String[] whereargs = {id};
//
//        int count = sqLiteDatabase.delete(TABLE_ORDERS, Id + " =? ", whereargs);
//        return count;
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////
//    public int getCountCart() {
//
//        int count = 0;
//
//        SQLiteDatabase db = getReadableDatabase();
//        String selectQuery = String.format("SELECT COUNT(*) FROM Orders ");
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                count = cursor.getInt(0);
//            } while (cursor.moveToNext());
//        }
//        return count;
//    }
//
//
////    public int getCountCart(String phone) {
////
////        int count = 0;
////
////        SQLiteDatabase db = getReadableDatabase();
////        String selectQuery = String.format("SELECT COUNT(*) FROM Orders WHERE UserPhone='%S'",phone);
////        Cursor cursor = db.rawQuery(selectQuery, null);
////
////        if (cursor.moveToFirst()) {
////            do {
////                count = cursor.getInt(0);
////            } while (cursor.moveToNext());
////        }
////        return count;
////    }
//
//
//    public int getCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_ORDERS;
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//
//        return cursor.getCount();
//    }
//////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    public void updateCart(Order order) {
//        SQLiteDatabase db = getWritableDatabase();
//        String selectQuery = String.format("UPDATE Orders SET " + Quantity + "= %s WHERE UserPhone ='%s' AND ProductId='%s' ", order.getQuantity(), order.getUserPhone(), order.getProductId());
//        db.execSQL(selectQuery);
//
//    }
//
//    //for not duplaction in cart
//    public void increaseCart(String foodId, String phone) {
//        SQLiteDatabase db = getWritableDatabase();
//        String selectQuery = String.format("UPDATE Orders SET Quantity= Quantity+1 WHERE UserPhone ='%s' AND ProductId='%s' ", phone, foodId);
//        db.execSQL(selectQuery);
//
//    }
//
//
//    public int updateCart2(String oldid, String newid) {
//        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(Id, newid);
//
//        String[] whereargs = {oldid};
//
//        int count = sqLiteDatabase.update(TABLE_ORDERS, contentValues, Id + " =? ", whereargs);
//        return count;
//    }
//    ////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    public boolean checkFoodExists(String foodId, String phone) {
//        boolean flag = false;
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = null;
//        String SQLquery = String.format("SELECT * FROM Orders WHERE UserPhone='%S' AND ProductId='%s'", phone, foodId);
//        cursor = db.rawQuery(SQLquery, null);
//        if (cursor.getCount() > 0)
//            flag = true;
//        else
//            flag = false;
//        cursor.close();
//        return flag;
//
//
//    }
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//public void addToFavorite(Favorites favorites) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = String.format("INSERT INTO Favorite (FoodId,FoodName,FoodPrice,FoodMenuId,FoodImage,FoodDiscount,FoodDescription,UserPhone) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s');",
//                favorites.getFoodId()
//                , favorites.getFoodName()
//                , favorites.getFoodPrice()
//                , favorites.getFoodMenuId()
//                , favorites.getFoodImge()
//                , favorites.getFoodDiscount()
//                , favorites.getFoodDiscription()
//                , favorites.getUserPhone());
//        db.execSQL(query);
//    }
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public boolean isFavorite(String foodId, String userPhone) {
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = String.format("SELECT * FROM Favorite Where FoodId='%s' and UserPhone='%s';", foodId, userPhone);
//
//        Cursor cursor = db.rawQuery(query, null);
//
//        if (cursor.getCount() <= 0) {
//            cursor.close();
//            return false;
//        }
//
//        cursor.close();
//        return true;
//    }
//
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public void deleteFromFavorite(String foodId, String userPhone) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = String.format("DELETE FROM Favorite Where FoodId ='%s' and UserPhone='%s';", foodId, userPhone);
//        db.execSQL(query);
//    }
//
//    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public ArrayList<Favorites> getAllFromFavorites() {
//        ArrayList<Favorites> contactList = new ArrayList<Favorites>();
//        String selectQuery = "SELECT * FROM " + TABLE_FAVORITES;
//
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//
//        if (cursor.moveToFirst()) {
//            do {
//                Favorites favorites = new Favorites();
//                favorites.setFoodId(cursor.getString(0));
//                favorites.setFoodName(cursor.getString(1));
//                favorites.setFoodPrice(cursor.getString(2));
//                favorites.setFoodMenuId(cursor.getString(3));
//                favorites.setFoodImge(cursor.getString(4));
//                favorites.setFoodDiscount(cursor.getString(5));
//                favorites.setFoodDiscription(cursor.getString(6));
//                favorites.setUserPhone(cursor.getString(7));
//
//                contactList.add(favorites);
//            } while (cursor.moveToNext());
//        }
//
//        return contactList;
//    }
//
//}
//
//
