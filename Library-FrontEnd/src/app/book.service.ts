import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BookShow} from "./book";
import {BookCreating} from "./bookCreating";

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private baseURL = "http://localhost:8080/books";
  constructor(private httpClient: HttpClient) { }

  getBooksList(): Observable<BookShow[]>{
    return this.httpClient.get<BookShow[]>(`${this.baseURL}`);
  }

  createBook(book: BookCreating): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, book);
  }

  getBookById(id: number | undefined): Observable<BookShow> {
    return this.httpClient.get<BookShow>(`${this.baseURL}/${id}`);
  }

  updateBook(id: number | undefined, book: BookCreating): Observable<BookCreating>{
    return this.httpClient.get<BookCreating>(`${this.baseURL}/${id}`);
  }

  deleteBook(id: number | undefined): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/${id}`)
  }
}
