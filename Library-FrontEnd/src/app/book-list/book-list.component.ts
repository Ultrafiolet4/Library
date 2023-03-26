import {Component, OnInit} from '@angular/core';
import {BookShow} from "../book";
import {BookService} from "../book.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  books: BookShow[];

  constructor(private bookService: BookService,
              private router: Router) {
    this.books = [];
  }

  ngOnInit(): void {
    this.getBooks();
  }

  private getBooks(){
    this.bookService.getBooksList().subscribe(data => {
      this.books = data;
    });
  }

  bookDetails(id: number | undefined){
    this.router.navigate(['book-details', id]).then(nav => {
      console.log(nav);
    }, err => {
      console.log(err)
    });
  }

  updateBook(id: number | undefined){
    this.router.navigate(['update-book', id]).then(nav => {
      console.log(nav);
    }, err => {
      console.log(err)
    });
  }

  deleteBook(id: number | undefined){
    this.bookService.deleteBook(id).subscribe( data => {
      console.log(data);
      this.getBooks();
    })
  }
}
