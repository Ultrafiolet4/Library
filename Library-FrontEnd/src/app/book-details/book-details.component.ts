import {Component, OnInit} from '@angular/core';
import {BookShow} from "../book";
import {BookService} from "../book.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit{
  id: number
  book: BookShow
  constructor(private route: ActivatedRoute, private bookService: BookService) {
    this.id = this.route.snapshot.params['id'];
    this.book = new BookShow();
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.book = new BookShow();
    this.bookService.getBookById(this.id).subscribe( data => {
      this.book = data;
    });
  }
}
