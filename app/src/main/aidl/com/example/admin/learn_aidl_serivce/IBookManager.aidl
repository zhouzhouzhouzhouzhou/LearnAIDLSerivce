// BookManager.aidl
package com.example.admin.learn_aidl_serivce;

// Declare any non-default types here with import statements
import com.example.admin.learn_aidl_serivce.Book;
interface IBookManager {
    List<Book> getBooks();
    void addBook(in Book book);
}
