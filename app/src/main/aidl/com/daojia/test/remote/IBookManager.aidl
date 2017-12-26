// IBookManager.aidl
package com.daojia.test.remote;

import com.daojia.test.remote.Book;

//AIDL文件支持的数据类型
//1.基本数据类型
//2.String Char
//3.List ArrayList
//4.Map HashMap
//5.Parcelable
//6.AIDL

//除了基本数据类型 其它数据类型必须标明方法 in out inout

//AIDL中只支持方法 不支持静态常量

// Declare any non-default types here with import statements

interface IBookManager {

List<Book> getBookList();
    void addBook(in Book book);
}
